/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;


public class innehåller {

    public innehåller() {
    }
    
    int beställningarid ;
    int skorid ;
    public innehåller ( int beställningarid,int skorid){
        
    this.beställningarid=beställningarid;
    this.skorid=skorid;
    
    
    
    }

    public int getBeställningarid() {
        return beställningarid;
    }

    public void setBeställningarid(int beställningarid) {
        this.beställningarid = beställningarid;
    }

    public int getSkorid() {
        return skorid;
    }

    public void setSkorid(int skorid) {
        this.skorid = skorid;
    }
    
}
