import java.util.Vector;

public class Restoran {
	private String adi;
	private Kullanici sahibi;
	private Vector<Masa> masalar;
	
	public Restoran(String ad, Kullanici sahip){
		
		adi = ad;
		sahibi = sahip;
		masalar = new Vector<Masa>();
	}
	
	public Restoran(String ad, Kullanici sahip, 
					int ikilikMasalar, int dortlukMasalar, int altilikMasalar){
		
		adi = ad;
		sahibi = sahip;
		masalar = new Vector<Masa>();
		int id = 0;
		for(int i = 0; i < ikilikMasalar; i++){
			Masa yeni = new Masa(id++,Masa.IKILI);
			masalar.add(yeni);
		}
		
		for(int i = 0; i < dortlukMasalar; i++){
			Masa yeni = new Masa(id++,Masa.DORTLU);
			masalar.add(yeni);
		}
		for(int i = 0; i < altilikMasalar; i++){
			Masa yeni = new Masa(id++,Masa.ALTILI);
			masalar.add(yeni);
		}
		
	}
	
	
	public boolean rezervasyonAl(Kullanici musteri){
		if(musteri == null) return false;
		
		int kisiRezervasyon = musteri.getKisiSayisi();
		
		for(int i = 0; i < masalar.size(); i++){
			Masa siradaki = masalar.get(i);
			
			if(siradaki.getKapasite() >= kisiRezervasyon){
				if(siradaki.oturanSayisi() == 0){
					siradaki.rezerveEt(musteri);
					return true;
				}
			}
		}
		
		return false;
		
	}
}
