public class Main {
    public static void main(String[] args) {

        //create a students array with at least 10 test cases for parts A, B & C
        StudentRecord[] students = {
            new StudentRecord(1001, "Alice", 82.5, 5),
            new StudentRecord(1002, "Bob", 91.0, 2),
            new StudentRecord(1003, "Charlie", 75.5, 7),
            new StudentRecord(1004, "David", 88.0, 1),
            new StudentRecord(1005, "Emma", 69.5, 4),
            new StudentRecord(1006, "Fatima", 95.0, 3),
            new StudentRecord(1007, "George", 81.0, 6),
            new StudentRecord(1008, "Hannah", 78.5, 8),
            new StudentRecord(1009, "Ian", 86.5, 9),
            new StudentRecord(1010, "Julia", 92.0, 2)
        };

        //PART A:

        MergeSort sorter = new MergeSort();
        System.out.println("======PART A======");
        System.out.println("Before sorting:");

        for (StudentRecord student : students) {
            System.out.println(student);
        }

        sorter.mergeSort1(students);

        System.out.println("\nAfter sorting using Merge Sort:");
        for (StudentRecord student : students) {
            System.out.println(student);
        }


        //PART B:
        System.out.println("\n\n======PART B======");
        System.out.println("Before sorting:");

        for (StudentRecord student : students) {
            System.out.println(student);
        }

        //create object
        QuickSort sorter2 = new QuickSort();

        sorter2.quickSort(students);

        System.out.println("\nAfter sorting using Quick Sort:");
        for (StudentRecord student : students) {
            System.out.println(student);
        }


        //PART C:
        //create object
        HeapSort sorter3 = new HeapSort();

        System.out.println("\n\n======PART C======");
        System.out.println("Before sorting:");
        for(StudentRecord student : students) {
            System.out.println(student);
        }

        sorter3.heapSort(students);

        System.out.println("\nAfter sorting using Heap Sort:");
        for(StudentRecord student : students) {
            System.out.println(student);
        }


        //PART D: Sorting Algorithm Comparison
        System.out.println("\n\n======PART D - SORTING ALGORITHM COMPARISON======");
        
        //Test with different dataset sizes: 10, 100, 1000
        //Test at least three input cases: random order, already sorted, and reverse sorted.
        int[] dataSizes = {10, 100, 1000};
        String[] dataTypes = {"Random", "Sorted", "Reverse Sorted"};
        
        System.out.println("\nComparison Table (Execution Time in nanoseconds):\n");
        System.out.printf("%-15s %-15s %-20s %-20s %-20s %-20s%n", 
                          "Dataset Type", "Size", "Merge Sort", "Quick Sort", "Heap Sort", "Simple Sort");
        System.out.println(new String(new char[110]).replace('\0', '-'));
        
        SimpleSort simpleSort = new SimpleSort();
        MergeSort mergeSortComparison = new MergeSort();
        QuickSort quickSortComparison = new QuickSort();
        HeapSort heapSortComparison = new HeapSort();
        
        for (String dataType : dataTypes) {
            for (int size : dataSizes) {
                StudentRecord[] testData = generateTestData(size, dataType);
                
                // Test Merge Sort
                StudentRecord[] data1 = testData.clone();
                long startTime = System.nanoTime();
                mergeSortComparison.mergeSort1(data1);
                long mergeSortTime = System.nanoTime() - startTime;
                
                // Test Quick Sort
                StudentRecord[] data2 = testData.clone();
                startTime = System.nanoTime();
                quickSortComparison.quickSort(data2);
                long quickSortTime = System.nanoTime() - startTime;
                
                // Test Heap Sort
                StudentRecord[] data3 = testData.clone();
                startTime = System.nanoTime();
                heapSortComparison.heapSort(data3);
                long heapSortTime = System.nanoTime() - startTime;
                
                // Test Simple Sort (Insertion Sort)
                StudentRecord[] data4 = testData.clone();
                startTime = System.nanoTime();
                simpleSort.sortByGrade(data4);
                long simpleSortTime = System.nanoTime() - startTime;
                
                System.out.printf("%-15s %-15d %-20d %-20d %-20d %-20d%n", 
                                  dataType, size, mergeSortTime, quickSortTime, heapSortTime, simpleSortTime);
            }
        }

        // Testing sorting by different keys
        System.out.println("\n\n--- Testing Sorting by Different Keys ---");
        
        // Create fresh test data for sorting by grade
        StudentRecord[] testDataByGrade = {
            new StudentRecord(1005, "Emma", 69.5, 4),
            new StudentRecord(1001, "Alice", 82.5, 5),
            new StudentRecord(1010, "Julia", 92.0, 2),
            new StudentRecord(1003, "Charlie", 75.5, 7),
            new StudentRecord(1006, "Fatima", 95.0, 3)
        };
        
        // Create fresh test data for sorting by student number
        StudentRecord[] testDataByStudentNumber = {
            new StudentRecord(1005, "Emma", 69.5, 4),
            new StudentRecord(1001, "Alice", 82.5, 5),
            new StudentRecord(1010, "Julia", 92.0, 2),
            new StudentRecord(1003, "Charlie", 75.5, 7),
            new StudentRecord(1006, "Fatima", 95.0, 3)
        };
        
        System.out.println("\n--- Sort by Grade (ascending) ---");
        System.out.println("Before sorting by grade:");
        for (StudentRecord student : testDataByGrade) {
            System.out.println(student);
        }
        
        simpleSort.sortByGrade(testDataByGrade);
        System.out.println("\nAfter sorting by grade (using Insertion Sort):");
        for (StudentRecord student : testDataByGrade) {
            System.out.println(student);
        }
        
        System.out.println("\n--- Sort by Student Number (ascending) ---");
        System.out.println("Before sorting by student number:");
        for (StudentRecord student : testDataByStudentNumber) {
            System.out.println(student);
        }
        
        simpleSort.sortByStudentNumber(testDataByStudentNumber);
        System.out.println("\nAfter sorting by student number (using Insertion Sort):");
        for (StudentRecord student : testDataByStudentNumber) {
            System.out.println(student);
        }
        
        // PART E: String Pattern Matching
        demonstratePatternMatching();
    }

    // Helper method to generate test data
    private static StudentRecord[] generateTestData(int size, String dataType) {
        StudentRecord[] data = new StudentRecord[size];
        
        for (int i = 0; i < size; i++) {
            int studentNumber = 1000 + i;
            String name = "Student" + i;
            double grade;
            
            if ("Random".equals(dataType)) {
                grade = 50 + Math.random() * 50; // Random grades between 50-100
            } else if ("Sorted".equals(dataType)) {
                grade = 50 + (i * 50.0 / size); // Ascending order
            } else { // Reverse Sorted
                grade = 100 - (i * 50.0 / size); // Descending order
            }
            
            data[i] = new StudentRecord(studentNumber, name, grade, i);
        }
        
        return data;
    }

    // Helper method for Part E - String Pattern Matching demonstration
    private static void demonstratePatternMatching() {
        System.out.println("\n\n======PART E - STRING PATTERN MATCHING======");
        
        PatternMatcher matcher = new PatternMatcher();
        
        // Create at least 3 TextDocument objects for testing
        TextDocument doc1 = new TextDocument(1, "Computer Science", 
            "Computer science uses data structures and data algorithms");
        TextDocument doc2 = new TextDocument(2, "Java Tutorial", 
            "Learn Java programming with patterns and design patterns");
        TextDocument doc3 = new TextDocument(3, "Pattern Matching", 
            "pattern matching is a pattern recognition technique for patterns in data");
        
        // Create a document with overlapping patterns for proper testing
        TextDocument overlapDoc = new TextDocument(5, "Overlap Test", "aaaa bbbb cccc");
        
        // Array of test patterns to demonstrate different cases
        String[] testPatterns = {"data", "pattern", "xyz", "a", "data structures", "", "ing"};
        
        
        // TEST: Pattern appears with TRUE OVERLAPPING OCCURRENCES ("aa" appears 3 times in "aaaa" at positions [0, 1, 2])
        System.out.println("\n--- Testing TRUE OVERLAPPING Pattern: \"aa\" in Document \"aaaa\" ---");
        System.out.println("Document: " + overlapDoc.getContent());
        System.out.println("Pattern: \"aa\" (should find overlapping occurrences)");
        System.out.println("findFirst result: " + matcher.findFirst(overlapDoc, "aa"));
        System.out.println("findAll results: " + matcher.findAll(overlapDoc, "aa"));
        System.out.println("countOccurrences result: " + matcher.countOccurrences(overlapDoc, "aa"));
        System.out.println("Expected: findAll=[0, 1, 2], count=3");

        // TEST: Pattern appears MULTIPLE TIMES ("data" appears 2 times in doc1)
        System.out.println("\n--- Testing Pattern: \"data\" in Document 1 ---");
        System.out.println("Document: " + doc1.getContent());
        System.out.println("Pattern: \"data\"");
        System.out.println("findFirst result: " + matcher.findFirst(doc1, "data"));
        System.out.println("findAll results: " + matcher.findAll(doc1, "data"));
        System.out.println("countOccurrences result: " + matcher.countOccurrences(doc1, "data"));
        System.out.println("containsPattern result: " + matcher.containsPattern(doc1, "data"));
        
        // TEST: Pattern appears MULTIPLE TIMES ("pattern" appears 2 times in doc2)
        System.out.println("\n--- Testing Pattern: \"pattern\" in Document 2 ---");
        System.out.println("Document: " + doc2.getContent());
        System.out.println("Pattern: \"pattern\"");
        System.out.println("findFirst result: " + matcher.findFirst(doc2, "pattern"));
        System.out.println("findAll results: " + matcher.findAll(doc2, "pattern"));
        System.out.println("countOccurrences result: " + matcher.countOccurrences(doc2, "pattern"));
        System.out.println("containsPattern result: " + matcher.containsPattern(doc2, "pattern"));
        
        // TEST: Pattern appears MULTIPLE TIMES ("pattern" appears 3 times in doc3)
        System.out.println("\n--- Testing Pattern: \"pattern\" in Document 3 ---");
        System.out.println("Document: " + doc3.getContent());
        System.out.println("Pattern: \"pattern\"");
        System.out.println("findFirst result: " + matcher.findFirst(doc3, "pattern"));
        System.out.println("findAll results: " + matcher.findAll(doc3, "pattern"));
        System.out.println("countOccurrences result: " + matcher.countOccurrences(doc3, "pattern"));
        System.out.println("containsPattern result: " + matcher.containsPattern(doc3, "pattern"));
        
        // TEST: Pattern appears ONCE ("Computer" appears 1 time in doc1)
        System.out.println("\nPattern: \"Computer\" (appears once)");
        System.out.println("containsPattern result: " + matcher.containsPattern(doc1, "Computer"));
        System.out.println("countOccurrences result: " + matcher.countOccurrences(doc1, "Computer"));
        System.out.println("findFirst result: " + matcher.findFirst(doc1, "Computer"));
        System.out.println("findAll results: " + matcher.findAll(doc1, "Computer"));
        
        System.out.println("\n--- Edge Cases Testing ---");
                
        // TEST: Pattern appears NOT AT ALL ("xyz" does not appear in doc1)
        System.out.println("\nPattern: \"xyz\" (not found)");
        System.out.println("containsPattern result: " + matcher.containsPattern(doc1, "xyz"));
        System.out.println("countOccurrences result: " + matcher.countOccurrences(doc1, "xyz"));
        
        // TEST: Empty text (edge case - searching in empty document)
        TextDocument emptyDoc = new TextDocument(4, "Empty", "");
        System.out.println("\nEmpty text with pattern \"data\" (text is empty)");
        System.out.println("Document content: \"\"");
        System.out.println("findFirst result: " + matcher.findFirst(emptyDoc, "data"));
        System.out.println("countOccurrences result: " + matcher.countOccurrences(emptyDoc, "data"));
        System.out.println("findAll results: " + matcher.findAll(emptyDoc, "data"));
        
        // TEST: Empty pattern (edge case)
        System.out.println("\nPattern: \"\" (empty pattern)");
        System.out.println("findFirst result: " + matcher.findFirst(doc1, ""));
        
        // TEST: Both empty text and empty pattern (edge case)
        System.out.println("\nBoth text and pattern are empty");
        System.out.println("findFirst result: " + matcher.findFirst(emptyDoc, ""));
        System.out.println("countOccurrences result: " + matcher.countOccurrences(emptyDoc, ""));
        
        // TEST: Pattern longer than text (edge case)
        System.out.println("\nPattern: \"this pattern is very long\" (longer than text)");
        System.out.println("findFirst result: " + matcher.findFirst(doc1, "this pattern is very long"));
        
        // TEST: Pattern equal to text (edge case)
        System.out.println("\nTesting with pattern equal to text");
        System.out.println("Document: " + doc1.getContent());
        System.out.println("Pattern: \"data structures and data algorithms\"");
        System.out.println("findFirst result: " + matcher.findFirst(doc1, "data structures and data algorithms"));
        System.out.println("findAll results: " + matcher.findAll(doc1, "data structures and data algorithms"));
        System.out.println("countOccurrences result: " + matcher.countOccurrences(doc1, "data structures and data algorithms"));
        System.out.println("containsPattern result: " + matcher.containsPattern(doc1, "data structures and data algorithms"));
    }
}
