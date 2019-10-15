package Utils;

import Utils.Constants;
import com.sun.org.apache.bcel.internal.classfile.ConstantString;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBHelper {

	private  static DBHelper instance = null;
	
	 private Connection conn = null; //Bağlantı nesnemiz
	  
	    private ResultSet Database; // sorgulardan dönecek kayıtlar (sonuç kümesi) bu nesne içerisinde tutulacak
	    
	    
	    
	    
	
		public static DBHelper getInstance() {
			if(instance == null) instance = new DBHelper();
		
		return instance;
		}
	
	
	
	
	
	
	
	
	 public Statement baglantiAc() throws Exception {
	        Class.forName(Constants.driver).newInstance();
	        conn = DriverManager.getConnection(Constants.url + Constants.dbName, Constants.userName, Constants.password);         
	        return conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	    }
	
	 
	 public void baglantiKapat() throws Exception {
		 
	        conn.close();
	    }
	 
	 
	 
	 public ResultSet getDatabase() {
		 return Database;
	 }
	 
	 
	 public ResultSet getResult(String sqlCommand) throws Exception {
		Statement st =  baglantiAc();
		ResultSet result = st.executeQuery(sqlCommand);
		 
		 //baglantiKapat();
		return result;
		 
	 }
         
         
         
         
         public void  execute(String command) throws Exception{
             Statement st =  baglantiAc();
		st.executeUpdate(command);
                
		 
         }
	
}
