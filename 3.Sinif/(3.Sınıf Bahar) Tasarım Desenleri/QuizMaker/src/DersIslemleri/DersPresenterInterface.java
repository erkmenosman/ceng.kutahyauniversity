package DersIslemleri;


import java.util.List;

import DersIslemleri.DersModel;

public interface DersPresenterInterface {

	
	
	
	
	
	public void addNewDers(String dersAdi);
	
	
	public void deleteDers(String dersID);
	
	
	public void updateDers(int dersId, String yeniDersAdi);
	

	public void reloadDersler();
	
	
	
	
	public List<DersModel> getDersler();

	
	public void setDersView(DersIslemleriView dersView);
	

}
