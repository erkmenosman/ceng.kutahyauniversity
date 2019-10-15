
package SoruBankasi;

import DersIslemleri.DersIslemleriView;
import DersIslemleri.DersModel;
import java.util.List;

public interface SoruBankasiYonetimPresenterInterface {
    	public void yeniSoruEkle(SoruModel soruModel);
	
	
	public void soruSil(String dersID);
	
	
	public void soruGuncelle(int id, SoruModel soru);
	

	public void sorulariYenidenYukle();
	
        public void reloadDersler();
	
	
	
	public List<DersModel> getDersler();
	
        
        public List<SoruModel> getSorular();

	
	public void setSoruView(SoruBankasiYonetimView dersView);
	
}
