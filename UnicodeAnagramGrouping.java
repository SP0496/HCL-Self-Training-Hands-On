import java.text.Normalizer;
import java.util.*;
import java.util.regex.Pattern;

public class UnicodeAnagramGrouping {

    // Remove accents
    public static String normalize(String s) {
        // Step 1: Normalize (NFKD)
        String normalized = Normalizer.normalize(s, Normalizer.Form.NFKD);

        // Step 2: Remove diacritics
        Pattern pattern = Pattern.compile("\\p{M}");
        normalized = pattern.matcher(normalized).replaceAll("");

        // Step 3: Case folding + remove spaces
        normalized = normalized.toLowerCase().replaceAll("\\s+", "");

        return normalized;
    }

    public static List<List<String>> groupAnagrams(String[] words) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : words) {
            String clean = normalize(word);

            // Sort characters
            char[] chars = clean.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] products = {
            "café", "face", "éfac",
            "résumé", "sérumé",
            "listen", "silent"
        };

        List<List<String>> result = groupAnagrams(products);

        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}