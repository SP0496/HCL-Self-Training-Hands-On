import java.util.*;

public class LogAnalyzer {

    public static void analyzeLogs(String[] logs) {
        Map<String, Integer> freqMap = new HashMap<>();

        // Count frequency
        for (String log : logs) {
            freqMap.put(log, freqMap.getOrDefault(log, 0) + 1);
        }

        // Find most common
        String mostCommon = "";
        int max = 0;

        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                mostCommon = entry.getKey();
            }
        }

        // Print results
        System.out.println("Frequencies: " + freqMap);
        System.out.println("Most Common Event: " + mostCommon);
    }

    public static void main(String[] args) {
        String[] logs = {"INFO", "ERROR", "WARN", "INFO", "ERROR", "INFO"};
        analyzeLogs(logs);
    }
}
