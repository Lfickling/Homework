/*
 * CS3810 - Principles of Database Systems - Spring 2021
 * Instructor: Thyago Mota
 * Description: DB 02 - JobSkills
 * Student(s) Name(s): Tj Virbick, Sara White, Letitia Fickling
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.*;
        import java.sql.*;
        import java.util.*;

public class JobSkills {

    public static String DATASET = "data/job_skills.csv";

    public static void main(String[] args) throws IOException, SQLException {

        //Load database properties
        Properties prop = new Properties();
        prop.load(new FileInputStream("config.properties"));

        String server = prop.getProperty("server");
        String database = prop.getProperty("database");
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");

        String connectURL = "jdbc:mysql://" + server + "/" + database + "?user=" + user + "&password=" + password;


        //Connect to the database
        Connection conn = DriverManager.getConnection(connectURL);
        System.out.println("Connection to MySQL database " + database + " was successful!");

        // TODO: complete the data load
        try {
            Scanner sc = new Scanner(new File("data/job_skills.csv"));
            sc.useDelimiter(",");
            String job;
            String skills;

            while(sc.hasNext()){
                job = sc.next();
                skills = sc.nextLine();

                String[] jobsArray = job.split(":");
                String[] skillsArray = skills.split(";");

                try {
                    //Insert JobID and Description into the Positions table
                    Statement stmt = conn.createStatement();
                    String sql = "INSERT INTO Positions(id, positionTitle) VALUES (" + jobsArray[0] + ", " + jobsArray[1];
                    stmt.executeUpdate(sql);

                    //Fill the Skill and PositionSkills tables
                    for (int i = 0; i < skillsArray.length; i += 2) {
                        //Insert SkillID and Description into the Skills table
                        String sql1 = "INSERT INTO Skills(id, skill) VALUES (" + skillsArray[i] + ", " + skillsArray[i + 1];
                        stmt.executeUpdate(sql1);

                        //Insert PositionID and SkillID into the PositionSkills table
                        String sql2 = "INSERT INTO PositionSkills(positionID, skillID) VALUES (" + jobsArray[0] + ", " + skillsArray[i];
                        stmt.executeUpdate(sql2);
                    }
                }catch (Exception e){
                    System.out.println("SQL Error");
                    e.printStackTrace();
                }

            }

            sc.close();

        } catch (Exception e){
            System.out.println("Error Reading job_skills.sql");
            e.printStackTrace();
        }


        // closes the connection
        System.out.println("Bye!");
        conn.close();
    }
}
