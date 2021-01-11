/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web_java;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author JD
 */
@ManagedBean( name="validationBean" )
    public class ValidationBean implements Serializable
       {
          private String fName;
          private String lName;
          private String email;
          private String phone;
          private Long age;
          
          // return the name String
          public String getNameF()
          {
             return fName;
          } // end method getName
          
          // set the name String
          public void setNameF( String name )
          {
             this.fName = name;
          } // end method setName
          
          public String getNameL()
          {
             return lName;
          } // end method getName
          
          // set the name String
          public void setNameL( String name )
          {
             this.lName = name;
          } // end method setName
          
          // return the email String
          public String getEmail()
          {
             return email;
          } // end method getEmail
          
          // set the email String
          public void setEmail( String email )
          {
             this.email = email;
          } // end method setEmail
          
          // return the phone String
          public String getPhone()
          {
             return phone;
          } // end method getPhone
          
          // set the phone String
          public void setPhone( String phone )
          {
             this.phone = phone;
          } // end method setPhone
          
           public Long getAge()
          {
             return age;
          } // end method getName
          
          // set the name String
          public void setAge( Long age )
          {
             this.age = age;
          } // end method setName
          
          // returns result for rendering on the client
          public String getResult()
          {
             if ( fName != null && lName != null && email != null && phone != null && age != null )
                return "<p style=\"background-color:yellow;width:200px;" +
                   "padding:5px\">Imie: " + getNameF() + "<br/>E-Mail: " + getNameL() + "<br/>E-Mail: " +
                   getEmail() + "<br/>Telefon: " + getPhone() + "<br/>Wiek: " + getAge() + "</p>";
             else
                return ""; // request has not yet been made
          } // end method getResult
       } // end class ValidationBean
