package jdbc;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import static java.util.stream.Collectors.toList;

//Try with resources saves a lot of closing...
public class JDBC {

    public JDBC() throws InterruptedException, ClassNotFoundException, SQLException {

        Metoderjdbc r = new Metoderjdbc();
        skor rq = new skor();
        String s = null;
//       System.out.println("-- Alla skor per kategorier\n ");
//     System.out.println(r.getAllskorperkategorier().stream().map((skor) -> skor.getFärge()).collect(toList()));
//      System.exit(0);
//       System.out.println(" -- get all kunds som finns i databasen med deras beställningar pris \n");
//      System.out.println(r.getAllkundQury1().stream().map((kund) -> kund.getFörnamn()).collect(toList()));
//       System.exit(0);//

        System.out.println("gränsnitt to AddToCart procedure \n");
        r.gränssnit();
       // r.getAllSkor().stream().map((skor) -> skor.getFärge()).collect(toList());

    }


    public static void main(String[] args) throws ClassNotFoundException, InterruptedException, SQLException {
        JDBC a = new JDBC();

    }
}
