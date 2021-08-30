package LetitiaFickling_05;

public class Assignment {
    //student name, assignment name and grade.

    private String studentName;
    private String assignmentName;
    private int assignmentScore;

    public Assignment() {
        this.studentName = "default name";
        this.assignmentName = "default assignment";
        this.assignmentScore = 100;
    }

    public Assignment(String name, String assignment, int score) {
        this.studentName = name;
        this.assignmentName = assignment;
        this.assignmentScore = score;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public String getAssignmentName() {
        return this.assignmentName;
    }

    public int getScore() {
        return this.assignmentScore;
    }
}
