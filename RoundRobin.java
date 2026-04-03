import java.util.*;

class Process {
    int id;
    int burstTime;
    int remainingTime;

    Process(int id, int burstTime) {
        this.id = id;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
    }
}

public class RoundRobin {

    public static void roundRobinScheduling(int[] burstTimes, int quantum) {
        Queue<Process> queue = new LinkedList<>();

        // Add processes to queue
        for (int i = 0; i < burstTimes.length; i++) {
            queue.offer(new Process(i + 1, burstTimes[i]));
        }

        int time = 0;

        while (!queue.isEmpty()) {
            Process current = queue.poll();

            if (current.remainingTime > quantum) {
                time += quantum;
                current.remainingTime -= quantum;

                System.out.println("Process P" + current.id +
                        " executed for " + quantum +
                        " units. Remaining: " + current.remainingTime);

                queue.offer(current); // push back (circular behavior)
            } else {
                time += current.remainingTime;

                System.out.println("Process P" + current.id +
                        " finished at time " + time);

                current.remainingTime = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] burstTimes = {5, 3, 8};
        int quantum = 2;

        roundRobinScheduling(burstTimes, quantum);
    }
}