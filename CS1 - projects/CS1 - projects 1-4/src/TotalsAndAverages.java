/**
 Totals and Averages … (explain the program)
 @LettieFickling
 Project #4, CS 1050, Section 5 (fill in your section number)
 A vocabulary word new to you (not computer-related) and its meaning
 Inspirational quote – not religious or political – along with the source and the
 person’s year of birth [and death]
 written as, for example, (1912 – 1987) or, if the person is still alive, (b. 1949)
 */

public class TotalsAndAverages {
    import java.util.Scanner;
    import java.io.*;
    import java.util.ArrayList;
    import java.io.File;
    import java.io.FileNotFoundException;

    double totalStateQuarter1;
    double totalStateQuarter2;
    double totalFedQuarter1;
    double totalFedQuarter2;

    double totalCalcStateQuarter1;
    double totalCalcStateQuarter2;
    double totalCalcFedQuarter1;
    double totalCalcFedQuarter2;

    public class Entry {
        public int quarter;
        public String areaTitle;
        public Ownership owner;
        public double wages;

        public Entry (String inputLine) {
            int index = inputLine.indexOf(",");
            quarter = Integer.parseInt(inputLine.substring(0, index));
            inputLine = inputLine.substring(index + 1);
            index = inputLine.indexOf(",");
            areaTitle = inputLine.substring(0, index);
            inputLine = inputLine.substring(index + 1);
            index = inputLine.indexOf(",");
            String whoOwns = inputLine.substring(0, index);
            wages = Double.parseDouble(inputLine.substring(index+1));
            if areaTitle.equals("U.S. TOTAL") {

            }
            else {
                if quarter.equals("1")
            }
        }
    }

    public enum Ownership { //still need to sort this out
        Local, State, Federal
    }

    public ArrayList<Entry> entries = new ArrayList;


    public static void main(String[] args) throws IOException {

        File inputFileName = new File(“Project 04 - Input First 5.txt”);
        Scanner inputFile = new Scanner(inputFileName); //scanner for the file
        inputFile.nextLine(); //skips the first line

        //initializes totals and counters
        double totalStateQuarter1;
        double totalStateQuarter2;
        double totalFedQuarter1;
        double totalFedQuarter2;
        int rowCounter;

        while (inputFile.hasNext()) { //reads the next line of the file while there are more lines
            String inputLine = inputFile.nextLine(); //reads the next line
            entries.add(new Entry(inputLine));
            rowCounter++;

            if (!areaTitle.contains("U.S. TOTAL")) {
                if ((areaTitle.contains("Statewide"))//“Statewide” in the second field and the words “Federal Government” or “State Government” in the third field
            }
        }


        FileWriter outputFileName = new FileWriter("Project 04 - Output First 5.txt");
        PrintWriter outputFile = new PrintWriter(outputFileName);

        outputFile.println(); //print out the results

        outputFile.close();
        inputFile.close();

    }
}
