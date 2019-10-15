
public class SoruBankasi {

	private String Sorular;
	private int Zorluk;
	private int Cevap;
	private int SoruPuani;
	private int Index;
	
	public static final int SORU = 1;
	
	public SoruBankasi(String Sorular){
		this.Sorular = Sorular;
		Index = SORU;
	}

	public String getSorular() {
		return Sorular;
	}

	public void setSorular(String Sorular) {
		this.Sorular = Sorular;
	}

	public int getIndex() {
		return Index;
	}

	public void setIndex(int Index) {
		this.Index = Index;
	}
	
	public String toString(){
		String a ="";
		if(Index == SORU)
			a +="";
		a += Sorular;
		return a;
	}

	public int getZorluk() {
		return Zorluk;
	}

	public void setZorluk(int zorluk) {
		this.Zorluk = zorluk;
	}

	public int getCevap() {
		return Cevap;
	}

	public void setCevap(int cevap) {
		Cevap = cevap;
	}

	public int getSoruPuani() {
		return SoruPuani;
	}

	public void setSoruPuani(int soruPuani) {
		SoruPuani = soruPuani;
	}

}
