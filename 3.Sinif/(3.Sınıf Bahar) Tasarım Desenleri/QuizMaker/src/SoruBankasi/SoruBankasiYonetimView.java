package SoruBankasi;
import Utils.TabloOlustur;
import Utils.DBHelper;
import java.sql.*;
import javax.swing.JOptionPane;

public class SoruBankasiYonetimView extends javax.swing.JInternalFrame {

  
    private static SoruBankasiYonetimView SoruBankasiYonetimInstance=null;
    
    SoruBankasiYonetimPresenter soruBankasiYonetimPresenter;
    
    
    private SoruBankasiYonetimView() {
        initComponents();
        
        KlasikCevapPanel.setVisible(false);
        DogruYanlisCevapPanel.setVisible(false);
        HavuzaEkleBtn.setVisible(false);
        
        soruBankasiYonetimPresenter = new SoruBankasiYonetimPresenter();
       SorListelemePanel.setVisible(false);
        soruBankasiYonetimPresenter.reloadDersler();
        dersleriDoldur();
        
        
    }

  
    
    
    
    void checkForSoruPanel(){
         if(SoruTipiCombo.getSelectedItem().equals("Çoktan Seçmeli")){
             KlasikCevapPanel.setVisible(false);
             DogruYanlisCevapPanel.setVisible(false);
             CoktanSecmeliCevapPanel.setVisible(true);
             SeceneklerPanel.setVisible(true);
         }else  if(SoruTipiCombo.getSelectedItem().equals("Klasik")){
              KlasikCevapPanel.setVisible(true);
             DogruYanlisCevapPanel.setVisible(false);
             CoktanSecmeliCevapPanel.setVisible(false);
             SeceneklerPanel.setVisible(false);
         }else{
              KlasikCevapPanel.setVisible(false);
             DogruYanlisCevapPanel.setVisible(true);
             CoktanSecmeliCevapPanel.setVisible(false);
             SeceneklerPanel.setVisible(false);
         }
    }
    
    void checkForHavuzaEkleBtn(){
        System.out.println("SoruBankasi.SoruBankasiYonetimView.checkForHavuzaEkleBtn() : " + SoruTipiCombo.getSelectedItem().toString());
        if(SoruMetniTextPanel.getText().length()<1){
            HavuzaEkleBtn.setVisible(false);
            return;
        }else{
        
            if(SoruTipiCombo.getSelectedItem().equals("Çoktan Seçmeli")){
                
                if(ATextFrield.getText().length()>1 && BTextFrield.getText().length()>1 && CTextFrield.getText().length()>1 && DTextFrield.getText().length()>1){
                    HavuzaEkleBtn.setVisible(true);
                }else{
                    HavuzaEkleBtn.setVisible(false);
                }
            }else if(SoruTipiCombo.getSelectedItem().equals("Klasik")){
            
                if(KlasikCevapText1.getText().length()>0){
                    HavuzaEkleBtn.setVisible(true);
                }else{
                    HavuzaEkleBtn.setVisible(false);
                }
            
            }else{
            
               HavuzaEkleBtn.setVisible(true);
            
            }
        
    
        
        }
        
        
        
        
        
        
    }
    
    
      public void ListelemePaneliHazirla() {
          
          ListelemeCombo.setSelectedIndex(0);
        try {

            jTable1.setModel(new TabloOlustur(soruBankasiYonetimPresenter.getSorularAsResultSet())); 

        } catch (Exception e) {
        }
}
    
    public static SoruBankasiYonetimView getObj(){
        if(SoruBankasiYonetimInstance==null){
            SoruBankasiYonetimInstance=new SoruBankasiYonetimView();
        }return SoruBankasiYonetimInstance;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    void dersleriDoldur(){
        DersSecimiCombo.removeAllItems();
        for (int i = 0; i < soruBankasiYonetimPresenter.getDersler().size(); i++) {
             DersSecimiCombo.addItem(soruBankasiYonetimPresenter.getDersler().get(i).getDersAdi());
        }
    }
    
    
    
    /*
    
    public void DersGetir(String DersAdi){
        try {
            if (DersAdi.equals("DersSecimi")) {
                while(Database.next()){
                DersSecimiCombo.addItem(Database.getString("Ders"));
                }
                baglantiKapat();
                Statement st;
                st = baglantiAc(); //veritabanına bağlanılıyor
                Database = st.executeQuery("select * from sorubankasi"); 
                TabloDoldur();
            }
            
    } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Kayıt Mevcut Değil", "Ders Seçimi Tablosu", JOptionPane.PLAIN_MESSAGE);
        }
    }
    public void KayitGetir(String ListelemeTuru) {
        try {

            if (ListelemeTuru.equals("Guncelle")) {
                
                int i = jTable1.getSelectedRow();
                i++;
                Database.absolute(i);
            }
            DersSecimiCombo.setSelectedIndex(Database.getInt("Dersid")-1);
            SoruMetniTextPanel.setText(Database.getString("Soru"));
            ZorlukCombo.setSelectedItem(Database.getString("Zorluk"));
            SoruTipiCombo.setSelectedItem(Database.getString("SoruTipi"));
            ATextFrield.setText(Database.getString("A"));
            BTextFrield.setText(Database.getString("B"));
            CTextFrield.setText(Database.getString("C"));
            DTextFrield.setText(Database.getString("D"));
            DogruCevapCombo.setSelectedItem(Database.getString("DogruCevap"));      
            puanTextFrield.setText(Database.getString("Puan"));
            TabloDoldur();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Kayıt Mevcut Değil", "Soru Tablosu", JOptionPane.PLAIN_MESSAGE);
        }

    }
    */
  
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelYonetimBtn = new javax.swing.JButton();
        SoruEkleSilPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        DersSecimiCombo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        ZorlukCombo = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        puanTextFrield = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        SoruTipiCombo = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        SoruMetniTextPanel = new javax.swing.JTextPane();
        SeceneklerPanel = new javax.swing.JPanel();
        ATextFrield = new javax.swing.JTextField();
        BTextFrield = new javax.swing.JTextField();
        CTextFrield = new javax.swing.JTextField();
        DTextFrield = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        DogruYanlisCevapPanel = new javax.swing.JPanel();
        DogruYanlisCheckBox = new javax.swing.JCheckBox();
        KlasikCevapPanel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        KlasikCevapText = new javax.swing.JScrollPane();
        KlasikCevapText1 = new javax.swing.JTextPane();
        CoktanSecmeliCevapPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        DogruCevapCombo = new javax.swing.JComboBox();
        HavuzaEkleBtn = new javax.swing.JButton();
        SorListelemePanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        GuncelleButton = new javax.swing.JButton();
        SilButton = new javax.swing.JButton();
        ListelemeCombo = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Soru Bankası Oluştur - Düzenle");

        PanelYonetimBtn.setText("Soruları listele");
        PanelYonetimBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PanelYonetimBtnActionPerformed(evt);
            }
        });

        SoruEkleSilPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Ders Seçimi :");

        jLabel5.setText("Zorluk Derecesi :");

        ZorlukCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Kolay", "Orta", "Zor" }));

        jLabel6.setText("Puan :");

        puanTextFrield.setText("20");

        jLabel3.setText("Soru Tipi :");

        SoruTipiCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Çoktan Seçmeli", "Doğru Yanlış", "Klasik" }));
        SoruTipiCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                SoruTipiComboİtemStateChanged(evt);
            }
        });
        SoruTipiCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SoruTipiComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(puanTextFrield, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DersSecimiCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(ZorlukCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(SoruTipiCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DersSecimiCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ZorlukCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(SoruTipiCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(7, 7, 7)
                .addComponent(puanTextFrield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setText("Soru Metni : ");

        SoruMetniTextPanel.setText(" ");
        SoruMetniTextPanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CTextFrieldKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(SoruMetniTextPanel);

        ATextFrield.setText(" ");
        ATextFrield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CTextFrieldKeyTyped(evt);
            }
        });

        BTextFrield.setText(" ");
        BTextFrield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CTextFrieldKeyTyped(evt);
            }
        });

        CTextFrield.setText(" ");
        CTextFrield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CTextFrieldKeyTyped(evt);
            }
        });

        DTextFrield.setText(" ");
        DTextFrield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CTextFrieldKeyTyped(evt);
            }
        });

        jLabel10.setText("D : ");

        jLabel9.setText("C : ");

        jLabel8.setText("B : ");

        jLabel7.setText("A : ");

        jLabel13.setText("Seçenekler : ");

        javax.swing.GroupLayout SeceneklerPanelLayout = new javax.swing.GroupLayout(SeceneklerPanel);
        SeceneklerPanel.setLayout(SeceneklerPanelLayout);
        SeceneklerPanelLayout.setHorizontalGroup(
            SeceneklerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SeceneklerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SeceneklerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SeceneklerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(SeceneklerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SeceneklerPanelLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ATextFrield, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SeceneklerPanelLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BTextFrield, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SeceneklerPanelLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CTextFrield, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(SeceneklerPanelLayout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(DTextFrield, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel13))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        SeceneklerPanelLayout.setVerticalGroup(
            SeceneklerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SeceneklerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addGroup(SeceneklerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(ATextFrield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SeceneklerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(BTextFrield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SeceneklerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(CTextFrield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SeceneklerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(DTextFrield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        DogruYanlisCheckBox.setText("Doğru ise işaretleyiniz");

        javax.swing.GroupLayout DogruYanlisCevapPanelLayout = new javax.swing.GroupLayout(DogruYanlisCevapPanel);
        DogruYanlisCevapPanel.setLayout(DogruYanlisCevapPanelLayout);
        DogruYanlisCevapPanelLayout.setHorizontalGroup(
            DogruYanlisCevapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DogruYanlisCevapPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DogruYanlisCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DogruYanlisCevapPanelLayout.setVerticalGroup(
            DogruYanlisCevapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DogruYanlisCevapPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DogruYanlisCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel12.setText("Cevabı buraya giriniz : ");

        KlasikCevapText1.setText(" ");
        KlasikCevapText1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                KlasikCevapText1CTextFrieldKeyTyped(evt);
            }
        });
        KlasikCevapText.setViewportView(KlasikCevapText1);

        javax.swing.GroupLayout KlasikCevapPanelLayout = new javax.swing.GroupLayout(KlasikCevapPanel);
        KlasikCevapPanel.setLayout(KlasikCevapPanelLayout);
        KlasikCevapPanelLayout.setHorizontalGroup(
            KlasikCevapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KlasikCevapPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(KlasikCevapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(KlasikCevapText, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        KlasikCevapPanelLayout.setVerticalGroup(
            KlasikCevapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KlasikCevapPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(KlasikCevapText, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel4.setText("Doğru Cevap :");

        DogruCevapCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C", "D" }));

        javax.swing.GroupLayout CoktanSecmeliCevapPanelLayout = new javax.swing.GroupLayout(CoktanSecmeliCevapPanel);
        CoktanSecmeliCevapPanel.setLayout(CoktanSecmeliCevapPanelLayout);
        CoktanSecmeliCevapPanelLayout.setHorizontalGroup(
            CoktanSecmeliCevapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CoktanSecmeliCevapPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(DogruCevapCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        CoktanSecmeliCevapPanelLayout.setVerticalGroup(
            CoktanSecmeliCevapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CoktanSecmeliCevapPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CoktanSecmeliCevapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(DogruCevapCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        HavuzaEkleBtn.setText("Havuza Ekle");
        HavuzaEkleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HavuzaEkleBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(KlasikCevapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CoktanSecmeliCevapPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(DogruYanlisCevapPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SeceneklerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(HavuzaEkleBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SeceneklerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(DogruYanlisCevapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CoktanSecmeliCevapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(KlasikCevapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HavuzaEkleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SoruEkleSilPanelLayout = new javax.swing.GroupLayout(SoruEkleSilPanel);
        SoruEkleSilPanel.setLayout(SoruEkleSilPanelLayout);
        SoruEkleSilPanelLayout.setHorizontalGroup(
            SoruEkleSilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SoruEkleSilPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );
        SoruEkleSilPanelLayout.setVerticalGroup(
            SoruEkleSilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SoruEkleSilPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(302, 302, 302))
            .addGroup(SoruEkleSilPanelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        SorListelemePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.setUpdateSelectionOnSort(false);
        jScrollPane2.setViewportView(jTable1);

        GuncelleButton.setText("GÜNCELLE");
        GuncelleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuncelleButtonActionPerformed(evt);
            }
        });

        SilButton.setText("SİL");
        SilButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SilButtonActionPerformed(evt);
            }
        });

        ListelemeCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Filtre Yok", "Sadece Kolay", "Sadece Orta", "Sadece Zor" }));
        ListelemeCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ListelemeComboItemStateChanged(evt);
            }
        });

        jLabel11.setText("Filtrele:");

        javax.swing.GroupLayout SorListelemePanelLayout = new javax.swing.GroupLayout(SorListelemePanel);
        SorListelemePanel.setLayout(SorListelemePanelLayout);
        SorListelemePanelLayout.setHorizontalGroup(
            SorListelemePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SorListelemePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SorListelemePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 859, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(SorListelemePanelLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ListelemeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SilButton, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GuncelleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SorListelemePanelLayout.setVerticalGroup(
            SorListelemePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SorListelemePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SorListelemePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(ListelemeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SilButton, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GuncelleButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SoruEkleSilPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(298, 298, 298)
                .addComponent(PanelYonetimBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SorListelemePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 871, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SoruEkleSilPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SorListelemePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelYonetimBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    int selectedItemID = -1;
    private void GuncelleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuncelleButtonActionPerformed
        
        SoruMetniTextPanel.setText(jTable1.getValueAt(jTable1.getSelectedRow(),2).toString());
        ZorlukCombo.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(),3).toString());
        SoruTipiCombo.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(),4).toString());
        ATextFrield.setText(jTable1.getValueAt(jTable1.getSelectedRow(),5).toString());
        BTextFrield.setText(jTable1.getValueAt(jTable1.getSelectedRow(),6).toString());
        CTextFrield.setText(jTable1.getValueAt(jTable1.getSelectedRow(),7).toString());
        DTextFrield.setText(jTable1.getValueAt(jTable1.getSelectedRow(),8).toString());
        
        puanTextFrield.setText(jTable1.getValueAt(jTable1.getSelectedRow(),10).toString());

        selectedItemID = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(),0).toString());
        
        if(SoruTipiCombo.getSelectedItem().equals("Çoktan Seçmeli")){
                
            DogruCevapCombo.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(),8).toString().equals("Doğru"));

             
            }else if(SoruTipiCombo.getSelectedItem().equals("Klasik")){
            
             KlasikCevapText1.setText(jTable1.getValueAt(jTable1.getSelectedRow(),9).toString());
            
            }else{
           
             DogruYanlisCheckBox.setSelected(jTable1.getValueAt(jTable1.getSelectedRow(),8).toString().equals("Doğru"));
              
            }
        
        checkForSoruPanel();
        PanelYonetimBtnActionPerformed(null);
        
    }//GEN-LAST:event_GuncelleButtonActionPerformed

    private void SilButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SilButtonActionPerformed
          String ID = jTable1.getValueAt(jTable1.getSelectedColumn(), 0).toString();
      try {
           
            soruBankasiYonetimPresenter.soruSil(ID);

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Kayıt Silinemedi", "MySQL Bağlantısı", JOptionPane.PLAIN_MESSAGE);
        }
        
      
        ListelemePaneliHazirla();
    }//GEN-LAST:event_SilButtonActionPerformed

    private void ListelemeComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ListelemeComboItemStateChanged

                System.out.println("ss : "+ListelemeCombo.getSelectedItem());

        if(ListelemeCombo.getSelectedItem().equals("Sadece Kolay")){
        try {

            jTable1.setModel(new TabloOlustur(soruBankasiYonetimPresenter.getKolay())); 

        } catch (Exception e) {
        }
            
        }else if(ListelemeCombo.getSelectedItem().equals("Sadece Orta")){
        try {

            jTable1.setModel(new TabloOlustur(soruBankasiYonetimPresenter.getOrta())); 

        } catch (Exception e) {
        }
        }
        else if(ListelemeCombo.getSelectedItem().equals("Sadece Zor")){
        try {

            jTable1.setModel(new TabloOlustur(soruBankasiYonetimPresenter.getZor())); 

        } catch (Exception e) {
        }
        }
    }//GEN-LAST:event_ListelemeComboItemStateChanged

    private void SoruTipiComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SoruTipiComboActionPerformed
        if (SoruTipiCombo.getSelectedIndex() == 0){
        ATextFrield.enable(true);
        BTextFrield.enable(true);
        CTextFrield.enable(true);
        DTextFrield.enable(true);}   
        else {
        ATextFrield.enable(false);
        BTextFrield.enable(false);
        CTextFrield.enable(false);
        DTextFrield.enable(false);}
    }//GEN-LAST:event_SoruTipiComboActionPerformed

    private void CTextFrieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CTextFrieldKeyTyped
        // TODO add your handling code here:
        
        checkForHavuzaEkleBtn();
    }//GEN-LAST:event_CTextFrieldKeyTyped

    private void SoruTipiComboİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_SoruTipiComboİtemStateChanged
        // TODO add your handling code here:
        
        checkForSoruPanel();
    }//GEN-LAST:event_SoruTipiComboİtemStateChanged

    private void KlasikCevapText1CTextFrieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KlasikCevapText1CTextFrieldKeyTyped
        // TODO add your handling code here:
        checkForHavuzaEkleBtn();
    }//GEN-LAST:event_KlasikCevapText1CTextFrieldKeyTyped

    private void PanelYonetimBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PanelYonetimBtnActionPerformed
        // TODO add your handling code here:
        SoruEkleSilPanel.setVisible(!SoruEkleSilPanel.isVisible());
                SorListelemePanel.setVisible(!SorListelemePanel.isVisible());
        
        if(!SoruEkleSilPanel.isVisible()){
        
        
            PanelYonetimBtn.setText("Soru Ekle / Sil");

            ListelemePaneliHazirla();
            
            
        }else{
            PanelYonetimBtn.setText("Soruları listele");
           
        }
    }//GEN-LAST:event_PanelYonetimBtnActionPerformed

    private void HavuzaEkleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HavuzaEkleBtnActionPerformed
        // TODO add your handling code here:
        SoruModel soru = new SoruModel(0, soruBankasiYonetimPresenter.getDersler().get(DersSecimiCombo.getSelectedIndex()).getDersID(),
                Integer.parseInt(puanTextFrield.getText()), "", SoruMetniTextPanel.getText(), ATextFrield.getText(), BTextFrield.getText(), CTextFrield.getText(),DTextFrield.getText(), SoruTipiCombo.getSelectedItem().toString(), ZorlukCombo.getSelectedItem().toString());
      
         if(SoruTipiCombo.getSelectedItem().equals("Çoktan Seçmeli")){
                
             soru.setDogruCevap(DogruCevapCombo.getSelectedItem().toString());
             
            }else if(SoruTipiCombo.getSelectedItem().equals("Klasik")){
            
               soru.setDogruCevap(KlasikCevapText1.getText());
                soru.setA("");
                soru.setB("");
                soru.setC("");
                soru.setD("");
            
            }else{
            
                soru.setA("");
                soru.setB("");
                soru.setC("");
                soru.setD("");
               
                if(DogruYanlisCheckBox.isSelected()){
                    soru.setDogruCevap("Doğru");
                }else{
                   soru.setDogruCevap("Yanlış");
                }
            }
         
         if(selectedItemID<0){
                      soruBankasiYonetimPresenter.yeniSoruEkle(soru);

         }else{
                      soruBankasiYonetimPresenter.soruGuncelle(selectedItemID,soru);

         }
         
                     JOptionPane.showConfirmDialog(null, "İşlem başarıyla tamamlandı", "Tamamlandı", JOptionPane.PLAIN_MESSAGE);

         
         
    }//GEN-LAST:event_HavuzaEkleBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ATextFrield;
    private javax.swing.JTextField BTextFrield;
    private javax.swing.JTextField CTextFrield;
    private javax.swing.JPanel CoktanSecmeliCevapPanel;
    private javax.swing.JTextField DTextFrield;
    private javax.swing.JComboBox DersSecimiCombo;
    private javax.swing.JComboBox DogruCevapCombo;
    private javax.swing.JPanel DogruYanlisCevapPanel;
    private javax.swing.JCheckBox DogruYanlisCheckBox;
    private javax.swing.JButton GuncelleButton;
    private javax.swing.JButton HavuzaEkleBtn;
    private javax.swing.JPanel KlasikCevapPanel;
    private javax.swing.JScrollPane KlasikCevapText;
    private javax.swing.JTextPane KlasikCevapText1;
    private javax.swing.JComboBox ListelemeCombo;
    private javax.swing.JButton PanelYonetimBtn;
    private javax.swing.JPanel SeceneklerPanel;
    private javax.swing.JButton SilButton;
    private javax.swing.JPanel SorListelemePanel;
    private javax.swing.JPanel SoruEkleSilPanel;
    private javax.swing.JTextPane SoruMetniTextPanel;
    private javax.swing.JComboBox SoruTipiCombo;
    private javax.swing.JComboBox ZorlukCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField puanTextFrield;
    // End of variables declaration//GEN-END:variables
}
