
package SoruBankasi;

import DersIslemleri.DersModel;
import Utils.DBHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SoruBankasiYonetimPresenter implements SoruBankasiYonetimPresenterInterface{

    
    List<SoruModel> sorular;
    List<DersModel> dersler;

    public SoruBankasiYonetimPresenter() {
    
        sorular = new ArrayList<>();
        dersler = new ArrayList<>();
    
    }
    
    
    
    @Override
    public void yeniSoruEkle(SoruModel soruModel) {
       
        try {
            DBHelper.getInstance().execute("INSERT INTO sorubankasi (Dersid, Soru, Zorluk, SoruTipi, A, B, C, D, DogruCevap, Puan) VALUES ('"+soruModel.getDersid()+"',"
                   
                    +"'"+soruModel.getSoru()+"',"
                    +"'"+soruModel.getZorluk()+"',"
                    +"'"+soruModel.getSoruTipi()+"',"
                    +"'"+soruModel.getA()+"',"
                    +"'"+soruModel.getB()+"',"
                    +"'"+soruModel.getC()+"',"
                    +"'"+soruModel.getD()+"',"
                    +"'"+soruModel.getDogruCevap()+"',"
                    +"'"+soruModel.getPuan()+"'"

                    
                    
                    
                    + ")");
        } catch (Exception ex) {
            Logger.getLogger(SoruBankasiYonetimPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void soruSil(String soruID) {
        try {
            DBHelper.getInstance().execute("DELETE FROM sorubankasi WHERE id = '"+soruID+"'");
        } catch (Exception ex) {
            Logger.getLogger(SoruBankasiYonetimPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void soruGuncelle(int soruid, SoruModel soruModel) {
       
        try {
            
            
             DBHelper.getInstance().execute("DELETE FROM sorubankasi WHERE id = '"+soruid+"'");
            DBHelper.getInstance().execute("INSERT INTO sorubankasi (id,Dersid, Soru, Zorluk, SoruTipi, A, B, C, D, DogruCevap, Puan) VALUES ('"+soruid+"',"
                                 
                    +"'"+soruModel.getDersid()+"',"
                    +"'"+soruModel.getSoru()+"',"
                    +"'"+soruModel.getZorluk()+"',"
                    +"'"+soruModel.getSoruTipi()+"',"
                    +"'"+soruModel.getA()+"',"
                    +"'"+soruModel.getB()+"',"
                    +"'"+soruModel.getC()+"',"
                    +"'"+soruModel.getD()+"',"
                    +"'"+soruModel.getDogruCevap()+"',"
                    +"'"+soruModel.getPuan()+"'"

                    
                    
                    
                    + ")");
        } catch (Exception ex) {
            Logger.getLogger(SoruBankasiYonetimPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void sorulariYenidenYukle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public void setSoruView(SoruBankasiYonetimView dersView) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DersModel> getDersler() {
       
        return dersler;
        
    }

    @Override
    public List<SoruModel> getSorular() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    public ResultSet getKolay(){
    
     try {
            return   DBHelper.getInstance().getResult("SELECT * FROM  sorubankasi WHERE Zorluk = 'Kolay'");
        } catch (Exception ex) {
            Logger.getLogger(SoruBankasiYonetimPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
      public ResultSet getOrta(){
    
     try {
            return   DBHelper.getInstance().getResult("SELECT * FROM  sorubankasi WHERE Zorluk = 'Orta'");
        } catch (Exception ex) {
            Logger.getLogger(SoruBankasiYonetimPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
        public ResultSet getZor(){
    
     try {
            return   DBHelper.getInstance().getResult("SELECT * FROM  sorubankasi WHERE Zorluk = 'Zor'");
        } catch (Exception ex) {
            Logger.getLogger(SoruBankasiYonetimPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ResultSet getSorularAsResultSet(){
        try {
            return   DBHelper.getInstance().getResult("SELECT * FROM  sorubankasi");
        } catch (Exception ex) {
            Logger.getLogger(SoruBankasiYonetimPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public void reloadDersler() {

        ResultSet result=null; 
            
        
         try {

                result = DBHelper.getInstance().getResult("SELECT * FROM derssecimi");
                
                 dersler.clear();
                
                while(result.next()){
                   dersler.add(new DersModel(result.getString("Ders"), result.getInt("Dersid")));
                }
                
                
            } catch (Exception ex) {
             System.err.println("Yükleme başarısız");
            }
                
        
                
           }
    
}
