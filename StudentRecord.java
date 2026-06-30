public class StudentRecord {
    private int studentNumber;
    private String name;
    private double grade;
    private int submissionTime; // for example, minutes after deadline or timestamp order

    // constructor
    public StudentRecord(int studentNumber, String name, double grade, int submissionTime){
        this.studentNumber = studentNumber;
        this.name = name;
        this.grade = grade;
        this.submissionTime = submissionTime;
    }

    //getters
    public int getStudentNumber(){
        return studentNumber;
    }

    public String getName(){
        return name;
    }

    public double getGrade(){
        return grade;
    }

    public int getSubmissionTime(){
        return submissionTime;
    }

    //setters
    public void setName(String name){
        this.name = name;
    }

    public void setGrade(double grade){
        this.grade = grade;
    }

    //toString method 
    public String toString(){
        return studentNumber + "->" + name + "|" + grade + "|" + submissionTime;
    }

}
