package jdbc;

import static java.awt.Event.INSERT;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import static java.time.Clock.system;
import static java.util.Collections.list;
import java.util.Scanner;
import static java.util.stream.Collectors.toList;

public class Metoderjdbc {
    int index;
   int Kundid;
  int  beställningarid ;
  boolean  expedierad;
List <Boolean> expedi= new ArrayList<>();
    int id;
    ResultSet rs;
    public List<kund> getAllkundQury1() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        List<kund> kundlist = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/skor",
                "root",
                "");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select  kund.förnamn,kund.efternamn ,sum(skor.pris) as skosum\n"
                        + "from skor\n"
                        + "inner join innehåller on innehåller.skorid= skor.id\n"
                        + "inner join beställningar on beställningar.id=innehåller.beställningarid\n"
                        + "inner join kund on kund.id=beställningar.kundid\n"
                        + "group by kund.förnamn; ")) {

            while (rs.next()) {

                String förnamn = rs.getString(1);
                String efternamn = rs.getString(2);
                double sum = rs.getDouble("skosum");
                System.out.println(" " + förnamn + " " + efternamn + "   " + sum);

            }
            return kundlist;

        }
    }

    public List<skor> getAllskorperkategorier() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        List<skor> skorlist = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/skor",
                "root",
                "");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select kategorier.namn as kategoriernaaamn ,skor.märke as skomärke, ingår.skorid as count\n"
                        + "from skor \n"
                        + "inner join ingår on skor.id=ingår.skorid\n"
                        + "inner join kategorier on ingår.kategorierid=kategorier.id\n" + "where skor.id=ingår.skorid\n"
                )) {

            while (rs.next()) {

                //int id   = rs.getInt(1);
                String kategoriernamn = rs.getString("kategoriernaaamn");
                String skormärke = rs.getString("skomärke");
                int ingårskorid = rs.getInt("count");
                if (kategoriernamn.equalsIgnoreCase("damskor")) {

                    System.out.println("Damskor" + "skomärke " + skormärke + " skorid " + ingårskorid);
                } else if (kategoriernamn.equalsIgnoreCase("sandaler")) {

                    System.out.println("Sandaler" + " skomärke " + skormärke + " skorid " + ingårskorid);
                } else if (kategoriernamn.equalsIgnoreCase("snöskor")) {

                    System.out.println("snöskor" + "  skomärke " + skormärke + " skorid " + ingårskorid);
                } else if (kategoriernamn.equalsIgnoreCase("promenadskor")) {

                    System.out.println("promenadskor" + "  skomärke " + skormärke + " skorid " + ingårskorid);
                } else if (kategoriernamn.equalsIgnoreCase("herrskor")) {

                    System.out.println("herrskor" + "  skomärke " + skormärke + " skorid " + ingårskorid);
                } else if (kategoriernamn.equalsIgnoreCase("barnskor")) {

                    System.out.println("barnskor" + "  skomärke " + skormärke + " skorid " + ingårskorid);
                }
                //System.out.println(" "  + "kategoriernamn "+ kategoriernamn +"  skomärke "+ skormärke+ " skorid "+ingårskorid );

            }
            return skorlist;

        }

    }

    /**
     *
     */
    public void gränssnit() throws ClassNotFoundException, SQLException {
         ResultSet rs;
    
        Class.forName("com.mysql.jdbc.Driver");
        List<kund> kundlist = new ArrayList<>();
        List<skor> skor = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/skor",
                "root",
                "");
                Statement stmt = con.createStatement();
               ResultSet rs1 = stmt.executeQuery("select  kund.förnamn,kund.efternamn \n"
                        + "from kund\n");) {

            while (rs1.next()) {
            kund k =new kund();
                String förnamn = rs1.getString(1);
                String efternamn = rs1.getString(2);
          
                System.out.println(" " + förnamn + " " + efternamn + "   ");
            
            }
            Scanner sc = new Scanner(System.in);
            System.out.println("välje efternamn");
            String s = sc.next();
           
            kund k = new kund(s);
            Kundid= k.getId(s);
            //k.getkund(s);
            
             getAllSkor();
            Scanner scc = new Scanner(System.in);

            System.out.println(" välje ett nummer  ");
          index= scc.nextInt();

        getspecificSkor( index);
        beställningar b =new beställningar();
           List<beställningar> beställningarlist = new ArrayList<>();
    beställningarlist=    b.getbeställningar(Kundid);
   
    

   
Class.forName("com.mysql.jdbc.Driver");
          // System.out.println(Kundid);
       try (Connection con1 = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/skor",
                "root",
                "");
                Statement stmtm = con1.createStatement();
                
                ResultSet rs3 = stmtm.executeQuery("select id, expedierad from beställningar where expedierad =0" ) ;

                    ) {

            while (rs3.next()) {
 expedierad =rs3.getBoolean("expedierad");
id = rs3.getInt("id");


//System.out.println(""+ expedierad    +   id    );
            }
//            if ( expedierad=true){
//            System.exit(0);}
Scanner sc2=new Scanner (System.in);
int beställningid = sc2.nextInt();
 calladdcar( beställningid);
       
       
            


            
            
            
            
            }
            
    }}
    
    
    
    public void calladdcar( int beställningarid) throws ClassNotFoundException, SQLException{
                          
 Class.forName("com.mysql.jdbc.Driver");
     
        try (Connection con6 = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/skor",
                "root",
                "");
            CallableStatement stm4
                    = con6.prepareCall("CALL AddToCart(?,?,?,?,?)"); 
                ResultSet rs5 = stm4.executeQuery("select* from skor;")){
            stm4.setInt(1, Kundid);
            stm4.setInt(2, beställningarid );
            stm4.setInt(3, index);
            stm4.setDate(4,getCurrentDate());
            stm4.setInt(5,1);
            stm4.execute();

        }
    

              
            
    }
    
    private static java.sql.Date getCurrentDate() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}
    
    
    
    
    
    
    
    public List<skor> getAllSkor() throws ClassNotFoundException, SQLException {
        List<skor> skk = new ArrayList<>();
        skor s = new skor();
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection con1 = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/skor",
                "root",
                "");
                Statement stmt1 = con1.createStatement();
                ResultSet rs1 = stmt1.executeQuery("select id,märke,pris,färg,storlek,lagerAntal \n"
                        + "from skor\n"
                )) {
            while (rs1.next()) {
                int skorid = rs1.getInt("id");
                String märke = rs1.getString("märke");
                double pris = rs1.getDouble("pris");
                String färg = rs1.getString("färg");
                int storlek = rs1.getInt("storlek");
                int lagerAntal = rs1.getInt("lagerAntal");

                //skk.add(new skor(skorid, märke, storlek, färg, pris, lagerAntal));
               // System.out.println(skk);
               System.out.println( "  " +skorid+"  "+ märke +"  "+ storlek + "  "+  färg+"  " + pris +"  "+  lagerAntal+" ");

            }
             
         

        } catch (Exception e) {
            e.printStackTrace();
        }

        return skk;
    }

    
    
    
    
    
    
    
    
    public List<skor> getspecificSkor( int index) throws ClassNotFoundException, SQLException {
        List<skor> skk = new ArrayList<>();
        skor s = new skor();
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection con1 = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/skor",
                "root",
                "");
                Statement stmt1 = con1.createStatement();
                ResultSet rs1 = stmt1.executeQuery("select id,märke,pris,färg,storlek,lagerAntal \n"
                        + "from skor\n"
                )) {
            while (rs1.next()) {
              
                int skorid = rs1.getInt("id");
                  if (index== skorid){
                String märke = rs1.getString("märke");
                double pris = rs1.getDouble("pris");
                String färg = rs1.getString("färg");
                int storlek = rs1.getInt("storlek");
                int lagerAntal = rs1.getInt("lagerAntal");

                //skk.add(new skor(skorid, märke, storlek, färg, pris, lagerAntal));
               // System.out.println(skk);
               System.out.println(  märke +"  "+ storlek + "  "+  färg+"  " + pris +"  "+  lagerAntal+" ");

            }
             
         

        }} catch (Exception e) {
            e.printStackTrace();
        }

        return skk;
    }
    
    
    


}





