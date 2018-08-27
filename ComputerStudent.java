@@ -0,0 +1,29 @@
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echoservermdaimdai;

/**
 *
 * @author mdai mdai
 */
public class ComputerStudent extends Student {
    
     /**
     * My constructor that populates name, count from and to and increment
     * values..
     */
    
    public ComputerStudent(int id,String name,String dob, int counter_from, int counter_to, int counter_increment) {
        super(id,name,dob,counter_from,counter_to,counter_increment);
    }
  
            /**
     * @return Get student's name,gender,age from SUPER class
     */
    public String toString(){
        return "ComputerStudent";
    }
}
