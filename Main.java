/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echoservermadimadi;
import java.net.*;
import java.io.*;


/**
 *
 * @author DoomPs21
 */
public class Main {
       public static final int SOCKET_PORT = 7879;
     public static void main(String args[]) throws IOException {
         EchoServermadimadi EchoClass=new EchoServermadimadi();
        // My server socket
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(SOCKET_PORT);
        } catch (IOException ioe) {
            System.out.println(EchoClass.getDate() + " Error finding port");
            System.exit(1);
        }
        System.out.println(EchoClass.getDate() + " Ready for new HTTP connection on port " + SOCKET_PORT + " ...");
        try {
            Socket soc=null;
            boolean ex = true;
            while (ex) {
                soc = ss.accept(); // Once read -> start up a thread
                 System.out.println(EchoClass.getDate() + " Connection accepted at :" + soc);
                // EchoServermadimadi thread = new EchoServermadimadi(soc);
               // thread.start();
            }
           

        } catch (IOException ioe) {
            System.out.println(EchoClass.getDate() + "Server failed to accept");
            System.exit(1); // shutdown programme cause connection is impossible
        }

    }
    
    
}
