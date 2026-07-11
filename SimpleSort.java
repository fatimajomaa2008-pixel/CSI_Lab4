import java.util.List;

public class SimpleSort {

    // Part D - Sorting Algorithm Comparison
    // Implement or reuse a simple sorting algorithm for comparison.
    // Sort StudentRecord objects by studentNumber or grade (insertion sort).
    public void sortByStudentNumber(StudentRecord[] records) {
        if (records == null || records.length < 2) {
            return;
        }

        for (int currentIndex = 1; currentIndex < records.length; currentIndex++) {
            StudentRecord currentRecord = records[currentIndex];
            int insertionIndex = currentIndex;

            while (insertionIndex > 0 && compareByStudentNumber(records[insertionIndex - 1], currentRecord) > 0) {
                records[insertionIndex] = records[insertionIndex - 1];
                insertionIndex--;
            }

            records[insertionIndex] = currentRecord;
        }
    }

    public void sortByGrade(StudentRecord[] records) {
        if (records == null || records.length < 2) {
            return;
        }

        for (int currentIndex = 1; currentIndex < records.length; currentIndex++) {
            StudentRecord currentRecord = records[currentIndex];
            int insertionIndex = currentIndex;

            while (insertionIndex > 0 && compareByGrade(records[insertionIndex - 1], currentRecord) > 0) {
                records[insertionIndex] = records[insertionIndex - 1];
                insertionIndex--;
            }

            records[insertionIndex] = currentRecord;
        }
    }

    public void sortByStudentNumber(List<StudentRecord> records) {
        if (records == null || records.size() < 2) {
            return;
        }

        for (int currentIndex = 1; currentIndex < records.size(); currentIndex++) {
            StudentRecord currentRecord = records.get(currentIndex);
            int insertionIndex = currentIndex;

            while (insertionIndex > 0 && compareByStudentNumber(records.get(insertionIndex - 1), currentRecord) > 0) {
                records.set(insertionIndex, records.get(insertionIndex - 1));
                insertionIndex--;
            }

            records.set(insertionIndex, currentRecord);
        }
    }

    public void sortByGrade(List<StudentRecord> records) {
        if (records == null || records.size() < 2) {
            return;
        }

        for (int currentIndex = 1; currentIndex < records.size(); currentIndex++) {
            StudentRecord currentRecord = records.get(currentIndex);
            int insertionIndex = currentIndex;

            while (insertionIndex > 0 && compareByGrade(records.get(insertionIndex - 1), currentRecord) > 0) {
                records.set(insertionIndex, records.get(insertionIndex - 1));
                insertionIndex--;
            }

            records.set(insertionIndex, currentRecord);
        }
    }

    private int compareByStudentNumber(StudentRecord leftRecord, StudentRecord rightRecord) {
        if (leftRecord == null || rightRecord == null) {
            throw new IllegalArgumentException("StudentRecord instances must not be null.");
        }

        return Integer.compare(leftRecord.getStudentNumber(), rightRecord.getStudentNumber());
    }

    private int compareByGrade(StudentRecord leftRecord, StudentRecord rightRecord) {
        if (leftRecord == null || rightRecord == null) {
            throw new IllegalArgumentException("StudentRecord instances must not be null.");
        }

        return Double.compare(leftRecord.getGrade(), rightRecord.getGrade());
    }
}
