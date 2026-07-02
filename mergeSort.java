public class mergeSort {
    
    //mergeSort public method, this method is the one used in main, while the private one does the brute work
    public void mergeSort(StudentRecord[] students){

        //check if array is empty and if it has only 1 or less elements
        if (students == null || students.length <= 1){
            return;
        }

        mergeSort(students, 0, students.length - 1);
    }

    //private mergeSort method to do the actual sorting 
    private void mergeSort(studentRecord[] students, int left, int right){

        //base case: if there is only one element in array
        if (left <= right){
            return;
        }
        

    }

    //merge method
    public void merge(){

    }
}
