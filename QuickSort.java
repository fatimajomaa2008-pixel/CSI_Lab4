//Pivot Strategy will be calways hoosing the last element as the pivot 
public class QuickSort {

    //public quicksort method that starts the recursion
    public void quickSort(StudentRecord[] students) {

        if (students == null || students.length <= 1)
            return;

        quickSort(students, 0, students.length - 1);
    }

    //private method that does the brunt of the work and the rest of the recursion part
    private void quickSort(StudentRecord[] students, int low, int high){

        //base case
        if (low < high){
        
            // Partition the array and get the pivot index
            int pivotIndex = partition(students, low, high);

            // Sort the left side
            quickSort(students, low, pivotIndex - 1);

            // Sort the right side
            quickSort(students, pivotIndex + 1, high);
        }


    }

    private int partition(StudentRecord[] students, int low, int high){

        // Choose the last element as the pivot
        StudentRecord pivot = students[high];

        // Index of the smaller element
        int i = low - 1;

        for (int j = low; j < high; j++) {

            // Compare grades
            if (students[j].getGrade() <= pivot.getGrade()) {

                i++;

                swap(students, i, j);
            }
        }

        // Place the pivot in its correct position
        swap(students, i + 1, high);

        return i + 1;

    }

    //method to swap 2 values
    private void swap(StudentRecord[] students, int i, int j){

        StudentRecord temp = students[i];
        students[i] = students[j];
        students[j] = temp;
    }
}
