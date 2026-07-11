public class HeapSort {

    // Public method called from main
    public void heapSort(StudentRecord[] students) {

        if (students == null || students.length <= 1) {
            return;
        }

        int n = students.length;

        //Build max heap
        buildMaxHeap(students);


        //Repeatedly remove maximum element
        for (int i = n - 1; i > 0; i--) {

            //Move current maximum to the end
            swap(students, 0, i);

            //Restore heap property
            heapify(students, i, 0);
        }
    }


    //Build a max heap
    private void buildMaxHeap(StudentRecord[] students) {

        int n = students.length;

        //Start from last non-leaf node
        for (int i = n / 2 - 1; i >= 0; i--) {

            heapify(students, n, i);
        }
    }


    //Restore heap property
    private void heapify(StudentRecord[] students, int heapSize, int index) {

        int largest = index;

        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;


        // Check if left child is larger
        if (leftChild < heapSize &&
            students[leftChild].getGrade() > students[largest].getGrade()) {

            largest = leftChild;
        }


        // Check if right child is larger
        if (rightChild < heapSize &&
            students[rightChild].getGrade() > students[largest].getGrade()) {

            largest = rightChild;
        }


        // If largest is not the parent, swap and continue
        if (largest != index) {

            swap(students, index, largest);

            heapify(students, heapSize, largest);
        }
    }


    // Swap two StudentRecord objects
    private void swap(StudentRecord[] students, int i, int j) {

        StudentRecord temp = students[i];
        students[i] = students[j];
        students[j] = temp;
    }
}