@@ -0,0 +1,210 @@
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echoservermadimadi;

import java.net.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author DoomPs21
 */
public class EchoServermadimadi extends Thread {

    private static BufferedReader input;
    private static PrintWriter output;
    public static final int SOCKET_PORT = 7879;
    static long time;
    private String GetRequest = "";
    private static int threadsRunning = 0;
    static int closeconnection = 0;
    private  Template template = new Template();
    private static Socket soc = null;

    public static void main(String args[]) throws IOException {
        // My server socket
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(SOCKET_PORT);
        } catch (IOException ioe) {
            System.out.println(getDate() + " Error finding port");
            System.exit(1);
        }
        System.out.println(getDate() + " Ready for new HTTP connection on port " + SOCKET_PORT + " ...");
        try {
            boolean ex = true;
            while (ex) {
                soc = ss.accept(); // Once read -> start up a thread
                 System.out.println(getDate() + " Connection accepted at :" + soc);
                 EchoServermadimadi thread = new EchoServermadimadi();
                thread.start();
            }
           

        } catch (IOException ioe) {
            System.out.println(getDate() + "Server failed to accept");
            System.exit(1); // shutdown programme cause connection is impossible
        }

    }

    /**
     * GetRequest a string representation of now based on date format
     *
     * @return String
     */
    public static String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }


    public void GetRequestResponse() {
        try {
            input = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            output = new PrintWriter(soc.getOutputStream(), true); // Character stream
            String line;
            time = System.currentTimeMillis();
            // GetRequest everything that the browser sends to us and dump it into the string until we get a blank line
            while ((line = input.readLine()).length() > 0) {
                System.out.println("[" + line + "]");
                if (line.contains("GET /")) {
                    GetRequest += line;
                    GetRequest = GetRequest.replace("GET /", "");
                    GetRequest = GetRequest.replace(" HTTP/1.1", "");
                } else {//nothing.}
                }
            }

        } catch (Exception e) {
            System.out.println(getDate() + " Exception in GetResponse Method: " + e);
            String Exception = getDate() + " Exception in GetResponse Method: " + e;
            HTMLObjectWriter(template.JavaError(Exception));
            HTMLObjectCloser();
        }

    }

    public synchronized void run() {
        int StudentArraySize = 0;   // array size for getStudents request
        GetRequestResponse();  //Read respponnse and do the following if match..
        threadsRunning++; // increase number of threads as long as it a new thread comes in...
        try {
            if (GetRequest.equals("getStudent")) {
                SQL getStudents = new SQL("GetAllStudents");
                StudentArraySize = getStudents.StudentArray.size();
                for (int i = 0; i < StudentArraySize; i++) {
                    String html = "<tr>" + "    <td>" + getStudents.StudentArray.get(i).getID() + "</td>\n"
                            + "<td>" + getStudents.StudentArray.get(i).getName() + "</td>\n"
                            + "<td>" + getStudents.StudentArray.get(i) + "</td>\n"
                            + "<td>" + getStudents.StudentArray.get(i).getDOB() + "</td>\n"
                            + "<td>" + getStudents.StudentArray.get(i).getCounter_from() + "</td>\n"
                            + "<td>" + getStudents.StudentArray.get(i).getCounter_to() + "</td>\n"
                            + "<td>" + getSstudents.StudentArray.get(i).getIncrement() + "</td>\n"
                            + "   </tr>\n";
                    System.out.println("\n\n" + "** Sending back: " + html);
                     if(i==0){    HTMLObjectWriter(template.Header());}  // Write the header for now!
                        HTMLObjectWriter(html); // Write the characters of html to the socket
  
                }
            } else if (GetRequest.equals("getStudent=math")) {
                SQL getStudents = new SQL("MathStudent");
                StudentArraySize = getStudents.StudentArray.size();
                for (int i = 0; i < StudentArraySize; i++) {
                    
                        String html = "<tr>" + "    <td>" + getStudents.StudentArray.get(i).getID() + "</td>\n"
                                + "<td>" + getStudents.StudentArray.get(i).getName() + "</td>\n"
                                + "<td>" + getStudents.StudentArray.get(i) + "</td>\n"
                                + "<td>" + getStudents.StudentArray.get(i).getDOB() + "</td>\n"
                                + "<td>" + getStudents.StudentArray.get(i).getCounter_from() + "</td>\n"
                                + "<td>" + getStudents.StudentArray.get(i).getCounter_to() + "</td>\n"
                                + "<td>" + getStudents.StudentArray.get(i).getIncrement() + "</td>\n"
                                + "   </tr>\n";
                        System.out.println("\n\n" + "** Sending back: " + html);
                                    if(i==0){    HTMLObjectWriter(template.Header());}  // Write the header for now!
                            HTMLObjectWriter(html); // Write the characters of html to the socket
                }
            } else if (GetRequest.equals("getStudent=computer")) {
                SQL getStudents = new SQL("ComputerStudent");
                StudentArraySize = getStudents.StudentArray.size();
                   for (int i = 0; i < StudentArraySize; i++) {
                 
                        String html = "<tr>" + "    <td>" + getStudents.StudentArray.get(i).getID() + "</td>\n"
                                + "<td>" + getStudents.StudentArray.get(i).getName() + "</td>\n"
                                + "<td>" + getStudents.StudentArray.get(i) + "</td>\n"
                                + "<td>" + getStudents.StudentArray.get(i).getDOB() + "</td>\n"
                                + "<td>" + getStudents.StudentArray.get(i).getCounter_from() + "</td>\n"
                                + "<td>" + getStudents.StudentArray.get(i).getCounter_to() + "</td>\n"
                                + "<td>" + getStudents.StudentArray.get(i).getIncrement() + "</td>\n"
                                + "   </tr>\n";
                        System.out.println("\n\n" + "** Sending back: " + html);
                             if(i==0){   HTMLObjectWriter(template.Header());}  // Write the header for now!
                          HTMLObjectWriter(html);
                    }
                
            } else if (GetRequest.equals("getStudent=science")) {
                SQL getStudents = new SQL("ScienceStudent");
                StudentArraySize = getStudents.StudentArray.size();
                for (int i = 0; i < StudentArraySize; i++) {

                        String html = "<tr>" + "<td>" + getStudents.StudentArray.get(i).getID() + "</td>\n"
                                + "<td>" + getStudents.StudentArray.get(i).getName() + "</td>\n"
                                + "<td>" + getStudents.StudentArray.get(i) + "</td>\n"
                                + "<td>" + getStudents.StudentArray.get(i).getDOB() + "</td>\n"
                                + "<td>" + getStudents.StudentArray.get(i).getCounter_from() + "</td>\n"
                                + "<td>" + getStudents.StudentArray.get(i).getCounter_to() + "</td>\n"
                                + "<td>" + getStudents.StudentArray.get(i).getIncrement() + "</td>\n"
                                + "   </tr>\n";
                        System.out.println("\n\n" + "** Sending back: " + html);
                             if(i==0){    HTMLObjectWriter(template.Header());}  // Write the header for now!
                         HTMLObjectWriter(html);
                    }
                
            } else if(GetRequest.equals("favicon.ico")){
           HTMLObjectCloser();
            }
            
             else {
                System.out.println("\n\n" + "** Sending back: " + template.NotFound());
               HTMLObjectWriter(template.NotFound()); // Write the notFound String
               HTMLObjectCloser();
                System.out.println(getDate() + "Request processed in: " + ((System.currentTimeMillis() - time)) + " ms");
            }
            
        HTMLObjectWriter(template.Footer());
          HTMLObjectCloser();
        } catch (Exception e) {
            System.out.println(getDate() + " Exception in Thread: " + e);
            String Exception = getDate() + " Exception in Thread: " + e;
        HTMLObjectWriter(template.JavaError(Exception));
        HTMLObjectCloser();
        }
        System.out.println(getDate() + " Request processed in: " + ((System.currentTimeMillis() - time)) + " ms");
        System.out.println("My GetRequest is " + GetRequest);
    }


    public static void HTMLObjectWriter(String html) {
        try{
        output.write(html); // Write the characters of html to the socket
          output.flush();
        }
        catch(Exception e){}
    }
    
   public static void HTMLObjectCloser() {
        try{
        output.close();
     input.close();
    soc.close();   
        }
        catch(Exception e){}
    }
}
