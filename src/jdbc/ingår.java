
package jdbc;

public class ingår {
    
    int skorid;
    int kategorier;
    public ingår (int skorid ,int kategorierid){
        
        this.skorid=skorid ;
        this.kategorier =kategorierid;
        
        
    }

    public ingår() {
    }

    public int getSkorid() {
        return skorid;
    }

    public void setSkorid(int skorid) {
        this.skorid = skorid;
    }

    public int getKategorier() {
        return kategorier;
    }

    public void setKategorier(int kategorier) {
        this.kategorier = kategorier;
    }
}
