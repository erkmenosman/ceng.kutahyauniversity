
package SoruBankasi;


public class SoruModel {
    private int Id,Dersid, Puan;
    
    private String DogruCevap,Soru, A,B,C,D,SoruTipi,Zorluk;

    public SoruModel(int Id, int Dersid, int Puan, String DogruCevap, String Soru, String A, String B, String C, String D, String SoruTipi, String Zorluk) {
        this.Id = Id;
        this.Dersid = Dersid;
        this.Puan = Puan;
        this.DogruCevap = DogruCevap;
        this.Soru = Soru;
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
        this.SoruTipi = SoruTipi;
        this.Zorluk = Zorluk;
    }

    
    
    
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getDersid() {
        return Dersid;
    }

    public void setDersid(int Dersid) {
        this.Dersid = Dersid;
    }

    public int getPuan() {
        return Puan;
    }

    public void setPuan(int Puan) {
        this.Puan = Puan;
    }

    public String getDogruCevap() {
        return DogruCevap;
    }

    public void setDogruCevap(String DogruCevap) {
        this.DogruCevap = DogruCevap;
    }

    public String getSoru() {
        return Soru;
    }

    public void setSoru(String Soru) {
        this.Soru = Soru;
    }

    public String getA() {
        return A;
    }

    public void setA(String A) {
        this.A = A;
    }

    public String getB() {
        return B;
    }

    public void setB(String B) {
        this.B = B;
    }

    public String getC() {
        return C;
    }

    public void setC(String C) {
        this.C = C;
    }

    public String getD() {
        return D;
    }

    public void setD(String D) {
        this.D = D;
    }

    public String getSoruTipi() {
        return SoruTipi;
    }

    public void setSoruTipi(String SoruTipi) {
        this.SoruTipi = SoruTipi;
    }

    public String getZorluk() {
        return Zorluk;
    }

    public void setZorluk(String Zorluk) {
        this.Zorluk = Zorluk;
    }
    
    
}
