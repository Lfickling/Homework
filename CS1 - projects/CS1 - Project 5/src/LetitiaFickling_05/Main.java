package LetitiaFickling_05;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    private static int STUDENT_COUNT = 5; //maybe change to figure this out from the file?
    private static int ASSIGN_COUNT = 5; //maybe change

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("1050 - Project 05 - Input File.txt");
        Scanner scan = new Scanner(file);
        String courseName = scan.nextLine();
        String profName = scan.nextLine();
        Course course1 = new Course(courseName,profName, STUDENT_COUNT, ASSIGN_COUNT);
            for (int student = 0; student < STUDENT_COUNT; student++)  {
                for (int assign = 0; assign < ASSIGN_COUNT; assign++)  { // get one line of data
                    String tempStudentName = scan.next();
                    String tempAssignName = scan.next();
                    int tempGrade = scan.nextInt();
                    // fill working assignment object
                    Assignment tempAssign = new Assignment(tempStudentName, tempAssignName, tempGrade);
                    // place new object in array
                    course1.gradesMatrix[student][assign] = tempAssign;
                }  // end inner loop – all assignments for one student
            }  // end outer loop – all students
        scan.close();
        course1.printReport();
    }
}
