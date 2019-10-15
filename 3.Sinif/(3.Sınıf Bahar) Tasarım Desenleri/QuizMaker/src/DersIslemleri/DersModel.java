package DersIslemleri;

public class DersModel implements DersModelInterface{
	
	
	
	
	private String dersAdi;
	private int ID;

    public DersModel(String dersAdi, int ID) {
        this.dersAdi = dersAdi;
        this.ID = ID;
    }
	
	
        
        
	
	@Override
	public String getDersAdi() {
		// TODO Auto-generated method stub
		return dersAdi;
	}
	@Override
	public void setDersAdi(String dersAdi) {
		// TODO Auto-generated method stub
		this.dersAdi = dersAdi;
		
	}
	@Override
	public int getDersID() {
		// TODO Auto-generated method stub
		return ID;
	}
	@Override
	public void setDersID(int id) {
		// TODO Auto-generated method stub
		this.ID = id;
	}

    @Override
    public String toString() {
        return "ID : "+ getDersID() + "     -    Ders adi : " + getDersAdi();
    }



        
        

	
	
	
	
}
