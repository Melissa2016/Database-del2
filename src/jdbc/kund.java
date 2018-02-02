
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class kund {
    private int id;
    private String förnamn;
    private String efternamn ;
    private String addressnamn;
    private String ort ;

    public kund(String s ) {
        this.förnamn=s;
    }

    public kund() {
    }

    public kund(String förnamn, String efternamn, String addressnamn, String ort) {
        this.förnamn = förnamn;
        this.efternamn = efternamn;
        this.addressnamn = addressnamn;
        this.ort = ort;
    }
    
    public kund(int id ,String förnamn,String efternamn){
        this.id = id;
        this.förnamn = förnamn;
        this.efternamn=efternamn;
        this.addressnamn=addressnamn;
        this.ort =ort ;
    
    }

    public List<kund>  getkund(String s  ) throws ClassNotFoundException, SQLException {
        
        
        
         Class.forName("com.mysql.jdbc.Driver");
   List<kund> kundlist = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/skor",
                "root",
                "");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select id,förnamn,efternamn,addressnamn,ort from kund ");
                ) {

            while (rs.next()) {
            int id  = rs.getInt("id");
          String förnamn=rs.getString("förnamn");
                String efternamn=rs.getString("efternamn");
                String addressnamn=rs.getString("addressnamn");
                String ort =rs.getString("ort");
              if (efternamn.equalsIgnoreCase(s)){
                  System.out.println("kund");
                  kundlist.add(new kund(förnamn,efternamn,addressnamn,ort));
              System.out.println("  förnamn   "+ förnamn +  "   efternamn   " + efternamn+"   addressnamn   "+  addressnamn+"   ort   "+  ort);
            }
        
    }  return kundlist;}
  }

    public void setId(int id) {
        this.id = id;
    }

    public String getFörnamn() {
        return förnamn;
    }

    public int getId( String efternamn ) throws ClassNotFoundException, SQLException {
                     int idd=0 ;

         Class.forName("com.mysql.jdbc.Driver");
 
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/skor",
                "root",
                "");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select id,efternamn from kund ");
                ) {
  
  
            while (rs.next()) {
            int id = rs.getInt("id");
          
                String efternamn1=rs.getString("efternamn");
               if (efternamn1.equalsIgnoreCase(efternamn)){
                     idd=id;
                 
              System.out.println("   id  "+  idd);
            }
        
    }  }return idd ;
        
      
 }

    public void setFörnamn(String förnamn) {
        this.förnamn = förnamn;
    }

    public String getEfternamn() {
        return efternamn;
    }

    public void setEfternamn(String efternamn) {
        this.efternamn = efternamn;
    }

    public String getAddressnamn() {
        return addressnamn;
    }

    public void setAddressnamn(String addressnamn) {
        this.addressnamn = addressnamn;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }
    
   
    public void printAllNames(){
        System.out.println(förnamn +" "+ efternamn  + " ");
    }
}
