public class Main {
    public static void main(String[] args) {


        //PART A:
        //create a students array with at least 10 test cases
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

        MergeSort sorter = new MergeSort();
        System.out.println("======PART A======");
        System.out.println("Before sorting:");

        for (StudentRecord student : students) {
            System.out.println(student);
        }

        sorter.mergeSort1(students);

        System.out.println("\nAfter sorting:");
        for (StudentRecord student : students) {
            System.out.println(student);
        }



        //PART B:
        //10 test cases
         StudentRecord[] students2 = {
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


        System.out.println("\n\n======PART B======");
        System.out.println("Before sorting:");

        for (StudentRecord student : students) {
            System.out.println(student);
        }

        //create object
        QuickSort sorter2 = new QuickSort();

        sorter2.quickSort(students);

        System.out.println("\nAfter sorting:");
        for (StudentRecord student : students) {
            System.out.println(student);
        }

    }
}
