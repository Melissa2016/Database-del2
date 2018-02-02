
package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class beställningar {
    int id ;
   Date datum;
   boolean expedierad;
   int kundid;

    public beställningar() {
    }
   
   
    
    public beställningar (int id ,Date datum  ,boolean  expedierad ,int kundid){
        
        this.id =id ;
        this.datum=datum;
        this.expedierad= expedierad;
        this.kundid=kundid ;
        
        
        
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public boolean isExpedierad() {
        return expedierad;
    }

    public void setExpedierad(boolean expedierad) {
        this.expedierad = expedierad;
    }

    public int getKundid() {
        return kundid;
    }

    public void setKundid(int kundid) {
        this.kundid = kundid;
    }

     
    
    
    public List<beställningar> getbeställningar(int kundid) throws ClassNotFoundException, SQLException{
             List<beställningar> beställningarlist = new ArrayList<>();
            
            
             
         Class.forName("com.mysql.jdbc.Driver");
  
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/skor",
                "root",
                "");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select id,datum,expedierad ,kundid from beställningar ");
                ) {

            while (rs.next()) {
            int id  = rs.getInt("id");
          Date datum=rs.getDate("datum");
               boolean expedirad =rs.getBoolean("expedierad");
           int kundid1=rs.getInt("kundid");
               
              if (kundid==kundid1){
                  System.out.println("kundid");
               beställningarlist.add(new beställningar(id,datum,expedirad,kundid));
              System.out.println("  beställningarid   "+ id +  "  datum   " + datum+"   expedirad  "+  expedirad+"   kundid1  "+  kundid1);
              
            }
       
        
    }  return     beställningarlist;}
  }
    
    
    
    
    
    
   
}
