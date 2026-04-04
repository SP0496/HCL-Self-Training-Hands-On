import java.util.*;

public class DuplicateProducts {

    public static void findDuplicates(int[] ids) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Count frequency
        for (int id : ids) {
            freqMap.put(id, freqMap.getOrDefault(id, 0) + 1);
        }

        // Find duplicates
        System.out.println("Duplicate IDs:");
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        int[] ids = {101, 102, 103, 101, 104, 102};
        findDuplicates(ids);
    }
}