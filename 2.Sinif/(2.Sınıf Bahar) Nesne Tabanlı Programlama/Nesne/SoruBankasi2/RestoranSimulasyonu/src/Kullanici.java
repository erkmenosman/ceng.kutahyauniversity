
public class Kullanici {

	private String isim;
	private int kisiSayisi;
	private int tip;
	
	public static final int SAHIP = 1;
	public static final int MUSTERI = 2;
	
	public Kullanici(String isim){
		this.isim = isim;
		kisiSayisi = 1;
		tip = MUSTERI;
	}
	
	public Kullanici(String isim, int tip){
		this.isim = isim;
		this.tip = tip;
		
		if(tip == MUSTERI) kisiSayisi = 1;
		else kisiSayisi = 0;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public int getKisiSayisi() {
		return kisiSayisi;
	}

	public void setKisiSayisi(int kisiSayisi) {
		this.kisiSayisi = kisiSayisi;
	}

	public int getTip() {
		return tip;
	}

	public void setTip(int tip) {

		this.tip = tip;

		if(tip == MUSTERI) kisiSayisi = 1;
		else kisiSayisi = 0;

	}
	
	public String toString(){
		
		String s ="";
		if(tip == MUSTERI)
			s +="Müþteri ";
		else s += "Restoran Sahibi ";
		
		s += isim;
		
		return s;
	}
}
