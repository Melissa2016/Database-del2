/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import static java.util.stream.Collectors.toList;

class skor {
    
    int id ;
    String märke ;
  int storlek ;
    String färge;
    double pris ;
    int antalilager ;
    int index;

        List<skor> skor =new ArrayList<>();
    public skor() {
    }

    public skor( String märke) {
        this.märke=märke;
    }
    
    public skor( int id ,double pris){
        
        this.id=id ;
        this.pris=pris;
      
    }

    public skor(int index,String märke,int storlek, String färge, double pris, int antalilager) {
    
        this.index=index;
        this.märke = märke;
        this.storlek = storlek;
        this.färge = färge;
        this.pris = pris;
        this.antalilager = antalilager;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

         public List<skor> printAllskor(){
          index =index+1;
        System.out.println( "  " +index+"  "+ märke +"  "+ storlek + "  "+  färge+"  " + pris +"  "+  antalilager+" ");
        return skor;
    
    
    
         }
    
    
    
    

    public void setMärke(String märke) {
        this.märke = märke;
    }

    public int getStorlek() {
        return storlek;
    }

    public void setStorlek(int  storlek) {
        this.storlek = storlek;
    }

    public String getFärge() {
        return färge;
    }

    public void setFärge(String färge) {
        this.färge = färge;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public int getAntalilager() {
        return antalilager;
    }

    public void setAntalilager(int antalilager) {
        this.antalilager = antalilager;
    }
    
    
    
  
    }   
    

