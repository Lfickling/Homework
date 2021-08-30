package LetitiaFickling_05;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class Course {
    //(contains the course name, the professor’s name, and the grades matrix)
    private String courseName;
    private String professorName;
    public Assignment[][] gradesMatrix;
    private File report;
    private PrintWriter printWriter;

    public Course(String course, String profName, int numOfStudents, int numOfAssignments) throws FileNotFoundException {
        this.courseName = course;
        this.professorName = profName;
        this.gradesMatrix = new Assignment[numOfStudents][numOfAssignments]; //[rows][columns]
        report = new File("LetitiaFickling_Output_Report.txt");
        printWriter = new PrintWriter (report);
    }

    public Course(String course, String profName) throws FileNotFoundException {
        this.courseName = course;
        this.professorName = profName;
        this.gradesMatrix = new LetitiaFickling_05.Assignment[5][5];
        report = new File("LetitiaFickling_Output_Report.txt");
        printWriter = new PrintWriter (report);
    }

    public void printReport() { //prints full report
        //“FirstnameLastname_Output_Report.txt
        printWriter.println(courseName + " taught by " + professorName);
        printWriter.println("Report created by Letitia Fickling");
        for (int row = 0; row < gradesMatrix.length; row++) {
            printWriter.println(" ");
            assignmentGradesByStudent(row);
        }
        printWriter.println(" ");
        howManyZeros();
        printWriter.println(" ");
        assignmentsAverageGrade();
        printWriter.println(" ");
        studentGrades();
        printWriter.close();
    }

    private void assignmentGradesByStudent(int studentRowNumber) {
        //prints report of format student: assignmnet: Hello – 89%, Numbers – 73%, …
        printWriter.println("Student: " + gradesMatrix[studentRowNumber][0].getStudentName());
        printWriter.println("Assignments:");
        printWriter.print("    ");
        for (int col = 0; col < gradesMatrix[studentRowNumber].length; col++) {
            printWriter.print(gradesMatrix[studentRowNumber][col].getAssignmentName() + " – " + gradesMatrix[studentRowNumber][col].getScore() + "%");
            if (col < (gradesMatrix[studentRowNumber].length - 1)) {
                printWriter.print(", ");
            }
        }
        printWriter.println();
    }

    private void howManyZeros() { //prints out report of format 'There were <count> grades of zero.'
        int count = 0;
        for (int row = 0; row < gradesMatrix.length; row++) {
            for (int col = 0; col < gradesMatrix[0].length; col++) {
                if (gradesMatrix[row][col].getScore() == 0) {
                    count++;
                }
            }
        }
        printWriter.println("There were " + count + " grades of zero.");
    }

    private void studentGrades() { // writes students overall grades to report in format 'Sue, 74.6%, C'
        printWriter.println("Student grades:");
        for (int row = 0; row < gradesMatrix.length; row++) {
            double totalpoints = 0;
            String letterGrade;
            for (int col = 0; col < gradesMatrix[row].length; col++) {
                totalpoints += gradesMatrix[row][col].getScore();
            }
            double studentGrade = totalpoints / gradesMatrix[row].length;
            if (studentGrade >= 90) {
                letterGrade = "A";
            } else if (studentGrade >= 80) {
                letterGrade = "B";
            } else if (studentGrade >= 70) {
                letterGrade = "C";
            } else if (studentGrade >= 60) {
                letterGrade = "D";
            } else {
                letterGrade = "F";
            }
            printWriter.println("    " + gradesMatrix[row][0].getStudentName() + ", " + studentGrade + "%, " + letterGrade);
        }
    }

    private void assignmentsAverageGrade() {
        // writes assignments average grades in format Class average on each assignment:'Hello: x%'
        printWriter.println("Class average on each assignment:");
        double totalpoints;
        double assignmentGrade;
        for (int col = 0; col < gradesMatrix[0].length; col++) {
            totalpoints = 0;
            for (int row = 0; row < gradesMatrix.length; row++) {
                totalpoints += gradesMatrix[row][col].getScore();
            }
            assignmentGrade = totalpoints / gradesMatrix[0].length;
            printWriter.println("    " + gradesMatrix[0][col].getAssignmentName() + ", " + assignmentGrade + "% ");
        }
    }
}

