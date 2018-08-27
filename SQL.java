/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echoservermadimadi;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author madi madi
 * Three methods created, main method to run threads using run() method
 * DatabaseConnection() to connect to database
 * getData() which is synchronized method that reads from database. 
 */
public class SQL {
     private  Template template = new Template();
private String Exception="";
   private static Connection con = null; // Static connection to be used in different methods.
  public ArrayList<Student> StudentArray = new ArrayList<Student>(); // Array for Students.
   private static EchoServermadimadi exceptionhandler=new EchoServermadimadi();
   
    /**
     * Main method that calls all the other methods to connect to database and read data and then run threads
     * after instantiating Thread object. 
     */

   /**
    * Constructor to set student object for threads..
     * @param coursetype
     */
    public SQL(String coursetype) {

              DatabaseConnection();
        GetData(coursetype);
    }

    /**
     * synchronised run method..  
     * assinging counter from, to into variables and then use these to compare and work on the while loop
     * MyStudentCounter is for how long the students count for
     */
 
/**
 * Connect to telecom2's database using port 63006
 * 
 */
    public  synchronized void DatabaseConnection() {

        String url = "jdbc:mysql://city.ac.telecom2.net:63006/"; // The connection string
        String db = "cityuniversity";                // Which Database?
        String driver = "com.mysql.jdbc.Driver";     // Always the same for MySQL
        String user = "javastudent";                 // Username for authorisation
        String pass = "kdjf878324jkdf";              // Password
        try {
            /* Get the MySQL driver loaded. This is done at runtime */
            Class.forName(driver).newInstance();
            /* Get the connection from the DriverManager. You only need one! */
            con = DriverManager.getConnection(url + db, user, pass);
        } catch (Exception e) {
 System.out.println("ERR: " +exceptionhandler.getDate()+" "+ e);
   String Exception =template.ErrorHeader("Database Error")
                + "<img src='http://kingsolutions.org.uk/wordpress/wp-content/uploads/mm01.png'>"
              +"<div class='container'>"
                +"  <div class=\"alert alert-danger\">"
                +" <p> Unable to establish a connection to the database on Telecom's Server </p>"
           +" <p>"+e+" </p>"
                +" </div>\n" +
"</div>"
                + "</center></body>\n"
                + "</html>\n";
            exceptionhandler.HTMLObjectWriter(Exception);
              exceptionhandler.HTMLObjectCloser();
        }

    } //DatabaseConnection ends..
    /**
     * Synced method to read data from the database
     * whenever it reads a line, the student will populate based on the course name and added to an array StudentArray[]
     * 
     * @param coursetype
    */
    public synchronized  void GetData(String coursetype){
      try {
          
            ResultSet rs = null;
            Statement st = con.createStatement();
            if(coursetype.equals("GetAllStudents")){
             rs = st.executeQuery("SELECT * FROM  students"); // select all details from the database}
            } else {
             rs = st.executeQuery("SELECT * FROM  students WHERE course ='"+coursetype+"'"); // select course type students from DB
            }
          
            while (rs.next()) { 
                /*Start the while loop for each line (each student in other words */
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String dob = rs.getString("dob");
                String course = rs.getString("course");
                int counter_from = rs.getInt("counter_from");
                int counter_to = rs.getInt("counter_to");
                int counter_increment = rs.getInt("counter_increment");
                if (course.equals("MathStudent")) {
                    StudentArray.add(new MathStudent(id,name,dob, counter_from, counter_to, counter_increment));
                }
                if (course.equals("ScienceStudent")) {
                    StudentArray.add(new ScienceStudent(id,name,dob, counter_from, counter_to, counter_increment));
                }

                if (course.equals("ComputerStudent")) {
                    StudentArray.add(new ComputerStudent(id,name,dob, counter_from, counter_to, counter_increment));

                }
            }
            con.close();
        } catch (SQLException se) {
             Exception = "SQL ERR: " +exceptionhandler.getDate()+" "+ se;
            System.out.println(Exception);
             Exception =template.ErrorHeader("SQL Error")
                + "<img src='http://kingsolutions.org.uk/wordpress/wp-content/uploads/mm01.png'>\n"
                 +"<div class='container'>\n"
                +"  <div class=\"alert alert-danger\">\n"
                + "<p>" + Exception + "</p>"//include the exception in my HTML code
                +" </div>\n" 
                +"</div>\n"
                + "</center></body>\n"
                + "</html>\n";
            System.out.println(Exception);
                 exceptionhandler.HTMLObjectWriter(Exception);
                 exceptionhandler.HTMLObjectCloser();
               
        } catch (Exception e) {
            System.out.println("ERR: " + e);
            Exception ="ERR: " + e;
          exceptionhandler.HTMLObjectWriter(template.JavaError(Exception));
            exceptionhandler.HTMLObjectCloser();
        }
    } // GetData Method ends...
} // SQL class ends..
