
public class Masa {
	private int tip;
	private int kapasite;
	private int no;
	private Kullanici reserveEden;
	
	public static final int IKILI = 1;
	public static final int DORTLU = 2;
	public static final int ALTILI = 3;
	
	public Masa(int no, int tip){
		this.no = no;
		this.tip = tip;
		reserveEden = null;
		
		kapasiteBelirle();
		
	}
	
	private void kapasiteBelirle(){
		switch(tip){
		case IKILI : kapasite = 2; break;
		case DORTLU : kapasite = 4; break;
		case ALTILI : kapasite = 6; break;
		default: kapasite = 0; break;
		}
	}

	public int getTip() {
		return tip;
	}

	public void setTip(int tip) {
		this.tip = tip;
	
		kapasiteBelirle();
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
	
	public int getKapasite(){return kapasite;}
	
	public String toString(){
		String s = no+" nolu "+kapasite+ " kiþilik masa";
		return s;
	}
	
	public boolean rezerveEt(Kullanici reserveEden){
		if(this.reserveEden != null) return false;
		this.reserveEden = reserveEden;
		return true;
	}
	
	public void serbestBirak(){ reserveEden = null;}
	
	public int oturanSayisi(){
		if(reserveEden == null) return 0;
		return reserveEden.getKisiSayisi();
	}
	
}
