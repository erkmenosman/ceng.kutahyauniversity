
package SinavOlustur;

import DersIslemleri.DersModel;
import SinavOlustur.Zorluk.Kolay;
import SinavOlustur.Zorluk.ZorlukStrategy;
import SoruBankasi.SoruBankasiYonetimPresenter;
import Utils.DBHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SinavOlusturPresenter implements SinavOlusturPresenterInterface{
    List<DersModel> dersler = new ArrayList<DersModel>();

    ZorlukStrategy zorluk;

    public void setZorluk(ZorlukStrategy zorluk) {
        this.zorluk = zorluk;
    }

    public SinavOlusturPresenter() {
        setZorluk(new Kolay());
    }
    
    
    
    
    
    @Override
    public List<DersModel> getDersler() {
        
       return dersler;
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
    
    public ResultSet getSorular( ){
    
     try {
            return   DBHelper.getInstance().getResult("SELECT * FROM  sorubankasi WHERE Zorluk = '"+zorluk.getZorluk()+"'");
        } catch (Exception ex) {
            Logger.getLogger(SoruBankasiYonetimPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
