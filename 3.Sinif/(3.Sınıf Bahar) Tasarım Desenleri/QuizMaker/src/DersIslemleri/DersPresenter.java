package DersIslemleri;

import Utils.DBHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class DersPresenter implements DersPresenterInterface{

	
	
	DersIslemleriView dersView;
	
	java.util.List<DersModel> dersler;

    public DersPresenter() {
           dersler = new ArrayList<>();
    }
	
        
	
	@Override
	public void addNewDers(String dersAdi) {
            try {
                // TODO Auto-generated method stub
           

                DBHelper.getInstance().execute("INSERT INTO derssecimi (Ders) VALUES ('"+dersAdi+"')");
            } catch (Exception ex) {
                Logger.getLogger(DersPresenter.class.getName()).log(Level.SEVERE, null, ex);
            }

	}

	@Override
	public void deleteDers(String ders) {
            try {
                // TODO Auto-generated method stub
                
                
                DBHelper.getInstance().execute("DELETE FROM derssecimi WHERE Ders = '"+ders+"'");
            } catch (Exception ex) {
                Logger.getLogger(DersPresenter.class.getName()).log(Level.SEVERE, null, ex);
            }
	}

	@Override
	public void updateDers(int dersId, String yeniDersAdi) {
		// TODO Auto-generated method stub
		  try {
                // TODO Auto-generated method stub
               
                
                DBHelper.getInstance().execute("UPDATE derssecimi SET Ders = '"+yeniDersAdi+"'  WHERE Dersid = "+dersId+"");
            } catch (Exception ex) {
                Logger.getLogger(DersPresenter.class.getName()).log(Level.SEVERE, null, ex);
            }

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


	@Override
	public java.util.List<DersModel> getDersler() {
		// TODO Auto-generated method stub
		
		return dersler;
	}

	@Override
	public void setDersView(DersIslemleriView dersView) {
		// TODO Auto-generated method stub
		//Buras� dersView setter'�d�r. Form taraf�ndan initialize edilebilir.
                this.dersView = dersView;
	}



	
}
