import java.util.ArrayList;
import java.util.List;

public class PatternMatcher {

    // Part E - String Pattern Matching
    public int findFirst(String text, String pattern) {
        if (pattern == null) {
            return -1;
        }

        if (pattern.isEmpty()) {
            return text == null ? -1 : 0;
        }

        if (text == null || pattern.length() > text.length()) {
            return -1;
        }

        for (int startIndex = 0; startIndex <= text.length() - pattern.length(); startIndex++) {
            if (matchesAt(text, pattern, startIndex)) {
                return startIndex;
            }
        }

        return -1;
    }

    // Implement a brute-force string pattern-matching algorithm
    public List<Integer> findAll(String text, String pattern) {
        List<Integer> matches = new ArrayList<>();

        if (pattern == null || text == null) {
            return matches;
        }

        if (pattern.isEmpty()) {
            return matches;
        }

        if (pattern.length() > text.length()) {
            return matches;
        }

        for (int startIndex = 0; startIndex <= text.length() - pattern.length(); startIndex++) {
            if (matchesAt(text, pattern, startIndex)) {
                matches.add(startIndex);
            }
        }

        return matches;
    }

    // Use a brute-force pattern-matching approach
    public int countOccurrences(String text, String pattern) {
        if (pattern == null || text == null) {
            return 0;
        }

        if (pattern.isEmpty() || pattern.length() > text.length()) {
            return 0;
        }

        int occurrenceCount = 0;
        for (int startIndex = 0; startIndex <= text.length() - pattern.length(); startIndex++) {
            if (matchesAt(text, pattern, startIndex)) {
                occurrenceCount++;
            }
        }

        return occurrenceCount;
    }
    
    // Search for a pattern inside the content of TextDocument objects
    // findFirst(text, pattern): Return the index of the first occurrence of the pattern, or -1 if the pattern is not found
    public int findFirst(TextDocument document, String pattern) {
        if (document == null) {
            return -1;
        }

        return findFirst(document.getContent(), pattern);
    }

    // findAll(text, pattern): Return or print all starting indices where the pattern occurs.
    public List<Integer> findAll(TextDocument document, String pattern) {
        if (document == null) {
            return new ArrayList<>();
        }

        return findAll(document.getContent(), pattern);
    }

    // countOccurrences(text, pattern): Return the number of times the pattern occurs in the text.
    public int countOccurrences(TextDocument document, String pattern) {
        if (document == null) {
            return 0;
        }

        return countOccurrences(document.getContent(), pattern);
    }

    // containsPattern(text, pattern): Return true if the pattern exists in the text, otherwise false.
    public boolean containsPattern(String text, String pattern) {
        return findFirst(text, pattern) != -1;
    }

    public boolean containsPattern(TextDocument document, String pattern) {
        if (document == null) {
            return false;
        }

        return containsPattern(document.getContent(), pattern);
    }

    private boolean matchesAt(String text, String pattern, int startIndex) {
        if (text == null || pattern == null) {
            return false;
        }

        if (startIndex < 0 || startIndex + pattern.length() > text.length()) {
            return false;
        }

        for (int patternIndex = 0; patternIndex < pattern.length(); patternIndex++) {
            if (text.charAt(startIndex + patternIndex) != pattern.charAt(patternIndex)) {
                return false;
            }
        }

        return true;
    }
}
