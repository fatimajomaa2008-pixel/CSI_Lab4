public class MergeSort {
    
    //mergeSort public method, this method is the one used in main, while the private one does the brute work
    public void mergeSort1(StudentRecord[] students){

        //check if array is empty and if it has only 1 or less elements
        if (students == null || students.length <= 1){
            return;
        }

        mergeSort2(students, 0, students.length - 1);
    }

    //private mergeSort method to do the actual sorting 
    private void mergeSort2(StudentRecord[] students, int left, int right){

        //base case: if there is only one element in array
        if (left >= right){
            return;
        }
        
        // Divide
        int middle = (left + right) / 2;

        // Conquer
        mergeSort2(students, left, middle);
        mergeSort2(students, middle + 1, right);

        // Combine
        merge(students, left, middle, right);

    }

    //merge the two sorted halves
    public void merge(StudentRecord[] students, int left, int middle, int right){

        //size of each temporary array
        int leftSize = middle - left + 1;
        int rightSize = right - middle;

        //temporary arrays
        StudentRecord[] leftArray = new StudentRecord[leftSize];
        StudentRecord[] rightArray = new StudentRecord[rightSize];

        // Copy data into temporary arrays
        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = students[left + i];
        }

        for (int j = 0; j < rightSize; j++) {
            rightArray[j] = students[middle + 1 + j];
        }

        // Merge the temporary arrays back together
        int i = 0;
        int j = 0;
        int k = left;

        while (i < leftSize && j < rightSize) {

            // Compare grades
            if (leftArray[i].getGrade() <= rightArray[j].getGrade()) {
                students[k] = leftArray[i];
                i++;
            } 
            else {
                students[k] = rightArray[j];
                j++;
            }

            k++;
        }

        // Copy any remaining elements from left array
        while (i < leftSize) {
            students[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy any remaining elements from right array
        while (j < rightSize) {
            students[k] = rightArray[j];
            j++;
            k++;
        }
    
    }
}
