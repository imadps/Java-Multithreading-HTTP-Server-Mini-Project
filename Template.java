/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echoservermadimadi;

/**
 *
 * @author DoomPs21
 */
public class Template {

    private static EchoServermadimadi echo = new EchoServermadimadi(); // instanciate an object to get methods from main class - if needed.

    /**
     * String Method to return NotFound HTML code
     *
     * @return
     */
    public String NotFound() {

return ErrorHeader("404 Not Found")
           +"<br></br>"
           + "<img src='https://speckycdn-sdm.netdna-ssl.com/wp-content/uploads/2010/03/four-oh-four_08.jpg'>"
           +"<br></br>"
      +"<div class=\"container\">\n"
                +"  <div class=\"alert alert-warning\">\n"
     + "<p>Sorry, the page you are looking for is not found, please turn around and go back to where you came from </p>"
             +"  </div>\n"     +"  </div>\n"
                + "</center\n></body>\n"
                + "</html>\n";
    }

    

    /**
     * String Method to return Header HTML code
     *
     * @return
     */
    public String Header() {
        return "HTTP/1.1 200 OK\n\n"
                + "<!DOCTYPE html>\n"
                + "<html lang='en'>\n"
                + "<head>\n"
                + "<title>My Echo Server :) </title>\n"
                + "<meta charset='utf-8'>\n"
                + " <meta name='+viewport' content='width=device-width, initial-scale=1'>\n"
                + "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>\n"
                + " <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js'></script>\n"
                + "<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>\n"
                + "</head>\n"
                + "<body>\n"
                + "<div class='container'>\n"
                + "<center>"
                + " <h2>Welcome</h2>\n"   + "</center>"
                + "<div class='well well-lg'>"
                   + "<center>"
                + " <p>Greetings from EchoServer...</p>\n"
                + " <p> Today's date is : " + echo.getDate() + " </p>\n" // include time to my HTML code
                +"<a href=\"getStudent=math\" class=\"btn btn-default\" role=\"button\">&nbsp;&nbsp;&nbsp;Math Students &nbsp;&nbsp;&nbsp;</a>"+"&nbsp;"
       +"<a href=\"getStudent=computer\" class=\"btn btn-default\" role=\"button\">&nbsp;&nbsp;&nbsp;Science Students&nbsp;&nbsp;&nbsp;</a>"+"&nbsp;"
       +"<a href=\"getStudent=science\" class=\"btn btn-default\" role=\"button\">&nbsp;&nbsp;&nbsp;Computer Students&nbsp;&nbsp;&nbsp;</a>"+"&nbsp;"
  +"<a href=\"getStudent\" class=\"btn btn-default\" role=\"button\">&nbsp;&nbsp;&nbsp;All Students&nbsp;&nbsp;&nbsp;</a>"
                + "</center>\n"
                + " <table class='table table-hover'>\n"
                + " <thead>\n"
                + "   <tr>\n"
                + "   <th>ID</th>\n"
                + "   <th>Name</th>\n"
                + "     <th>Course</th>\n"
                + "     <th>DOB</th>\n"
                + "     <th>counter_from</th>\n"
                + "     <th>counter_to</th>\n"
                + "     <th>counter_increment</th>\n"
                + "   </tr>\n"
                + " </thead>\n"
                + " <tbody>\n";
    }

    /**
     * String Method to return Footer HTML code
     *
     * @return
     */
    public String Footer() {
        return "  </tbody>\n"
                + "  </table>\n"
                + "</div>\n </div>"
                + "</body>\n"
                + "</html>\n";
    }

    /**
     * String Method to return JavaError HTML code
     *
     * @return
     */
    public String JavaError(String Exception) {
             return ErrorHeader("Error in Java")
                + "<img src='http://bayna.net/uploads/img/java-600x250.png'>\n"
      +"<div class=\"container\">\n"
                +"  <div class=\"alert alert-danger\">\n"
      + "<p>\n"+ "Java error occured while excution, more details below<br> </br>"+ "</p>\n"
                + "<p>\n" + Exception + "</p>\n"//include the exception in my HTML code
                        + "<p>\n"+ "<br> Please contact your Administrator</br>"+ "</p>\n"
             +"  </div>\n"     +"  </div>\n"
                + "</center\n></body>\n"
                + "</html>\n";
    }
     public String ErrorHeader(String error) {

return "HTTP/1.1 200 OK\n\n"
                + "<!DOCTYPE html>\n"
                + "<html lang='en'>\n"
                + "<head>\n"
                + "<title>"+error+" </title>\n"
                + "<meta charset='utf-8'>\n"
                + " <meta name='+viewport' content='width=device-width, initial-scale=1'>\n"
                + "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>\n"
                + " <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js'></script>\n"
                + "<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>\n"
                + "</head>\n"
                + "<body>\n"
                     +"<center>\n";

}
}
