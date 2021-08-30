/**
 * Report.java
 * @author Letitia Fickling
 * @since 3/9/20
 * This class inputs quiz scores and generates a report detailing the scores, average scores, and grades
 */
import java.util.Scanner;

class Report {
    private static Scanner scanner = new Scanner(System.in);
    private String reportName;
    private int[] quizzesArr = new int[5];
    private int quizTotal = 0;
    private double quizAverage;
    private double quizPercentageAverage;

    //this constructor creates a new report of name newName
    public Report(String newName) {
        reportName = newName;
    }

    //this method enters quiz scores into the quizzes array. @newScore must be between 0 and 25
    public void enterQuizScores() {
        int newScore;
        for (int i =1; i<=5; i++) {
            System.out.print("Please enter " + reportName + "'s score out of 25 for quiz #" + i + ": ");
            newScore = scanner.nextInt();
            while (newScore>25 || newScore<0){
                System.out.println("\nThat score isn't between 0 and 25. Please try again.");
                System.out.print("Enter" + reportName + "'s score out of 25 for quiz #" + i + ": ");
                newScore = scanner.nextInt();
                }
            quizzesArr[i-1] = newScore;
            quizTotal += newScore;
        }
        System.out.println("generating report ...\n");
    }

    //method returns the average quiz score
    public Double getAverage() {
        quizAverage = quizTotal / 5.0;
        return quizAverage;
    }

    //method returns the average quiz score as a percentage
    public Double getPercentageAverage() {
        quizPercentageAverage = (quizTotal * 100.0)/ 125.0;
        return quizPercentageAverage;
    }

    //method returns the letter grade equivalent and a motivational message
    public String getGrade() {
        String quizGrade;
        if (quizPercentageAverage >= 90) {
            quizGrade = "A";
            return quizGrade + "\nGreat Job!";
        }
        else if (quizPercentageAverage >= 80) {
            quizGrade = "B";
            return quizGrade + "\nGood job!";
        }
        else if (quizPercentageAverage >= 70) {
            quizGrade = "C";
            return quizGrade + "\nYou did okay";
        }
        else if (quizPercentageAverage >= 60) {
            quizGrade = "D";
            return quizGrade + "\nYou passed, but only barely!";
        }
        else {
            quizGrade = "F";
            return quizGrade + "\nLook over your quizes to see where you can improve";
        }
    }

    //method prints the report of the quizzes
    public void printReport() {
        System.out.println("Quiz report for " + reportName + "\n");
        for (int i =1; i<=5; i++) {
            System.out.println("quiz #" + i + ": " + quizzesArr[i-1]);
        }
        System.out.println("\nquiz average: " + getAverage() + " = " + getPercentageAverage() + "%");
        System.out.println("quiz grade: " + this.getGrade());
    }


public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    //introduces program and asks who the report is for (newName)
    System.out.print("Time to generate a new quiz report for quizzes one through five. \nWho is this report for? (enter name): ");
    String newName = scanner.next();

    //creates new report for a person with name newName
    Report report1 = new Report(newName);
    report1.enterQuizScores(); //enter quiz scores for report1
    report1.printReport(); //prints the report for report1

    //sees if the user wants to enter another report
    System.out.print("\nWould you like to start another report? (y/n): ");
    String anotherReport = scanner.next();
    if (anotherReport.equals("y")) {
        main(null);
    }
    else {
        System.out.println("\nGoodbye!");
        scanner.close();
    }
}
}


