/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echoservermadimadi;

/**
 *
 * @author madi madi
 */
public class ScienceStudent extends Student {
  /**
     * My constructor that populates id, name, dob, count from and to and increment
     * values..
     */
   
      public ScienceStudent(int id,String name,String dob, int counter_from, int counter_to, int counter_increment) {
        super(id,name,dob,counter_from,counter_to,counter_increment);
      
    }
      /**
     * @return toString method ro return student type
     */
    public String toString(){
        return "ScienceStudent";
 
    }

}

    
    