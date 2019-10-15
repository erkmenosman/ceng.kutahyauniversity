package Utils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TabloOlustur extends AbstractTableModel{

    private int satirSayisi;
    private int kolonSayisi;
    private ResultSet resultSet;// Sql sorgusundan dönen ResultSet
    private ArrayList veri=new ArrayList();

    //Yapıcı metod parametre olarak sql'in döndürdüğü resultset'i alıyor.
    public TabloOlustur(ResultSet resultSet) throws Exception
    {
        setResultSet(resultSet);
    }

    public void setResultSet(ResultSet resultSet) throws Exception {
        this.resultSet = resultSet;
        ResultSetMetaData metaData = resultSet.getMetaData();
        satirSayisi = 0;
        kolonSayisi = metaData.getColumnCount();
        while (resultSet.next()) {
            Object[] row = new Object[kolonSayisi];
            for (int j = 0; j < kolonSayisi; j++) {
                row[j] = resultSet.getObject(j + 1);
            }
            veri.add(row);
            satirSayisi++;
        }
    }

    //Tablodaki satır sayısını döndüren metod
    public int getRowCount() {
        return satirSayisi;
    }

    //Tablodaki kolon sayısını döndüren metod
    public int getColumnCount() {
        return kolonSayisi;
    }

    //Bir hücredeki değeri döndüren metod
    public Object getValueAt(int rowIndex, int columnIndex) {
        System.out.println(" row : " +rowIndex + " col : "+columnIndex);
       Object[] row=(Object[]) veri.get(rowIndex);
       return row[columnIndex];
    }

    //index'i verilen kolonun adını döndüren fonksiyon.
    @Override
    public String getColumnName(int columnIndex) {
        try {
            ResultSetMetaData metaData = resultSet.getMetaData();
            return metaData.getColumnName(columnIndex + 1);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

}
