package DersIslemleri;

public class DersIslemleriView extends javax.swing.JInternalFrame {


    DersPresenter dersPresenter;
    
    private static DersIslemleriView DersIslemleriInstance=null;
    
    public DersIslemleriView() {
        initComponents();
        PanelDuzenle.setVisible(false);
        GuncelleButton.setVisible(false);
        dersPresenter = new DersPresenter();
      
       DersleriGoster();
    }
   
     
     
     
     public void DersleriGoster(){
         dersPresenter.reloadDersler();
         DersSecimiCombo.removeAllItems();
         for (int i = 0; i < dersPresenter.getDersler().size(); i++) {
             DersSecimiCombo.addItem(dersPresenter.getDersler().get(i).toString());
         }
         
     }
     
     
     
 
    public static DersIslemleriView getObj(){
        if(DersIslemleriInstance==null){
            DersIslemleriInstance=new DersIslemleriView();
        }return DersIslemleriInstance;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        Dersler = new javax.swing.JLabel();
        DersSecimiCombo = new javax.swing.JComboBox();
        DuzenleButton = new javax.swing.JButton();
        PanelDuzenle = new javax.swing.JPanel();
        duzenleYeniDersAdi = new javax.swing.JTextField();
        duzenleIDText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        GuncelleButton = new javax.swing.JButton();
        PanelEkleSil = new javax.swing.JPanel();
        Dersler1 = new javax.swing.JLabel();
        DersAdi = new javax.swing.JTextField();
        EkleButton = new javax.swing.JButton();
        SilButton = new javax.swing.JButton();

        setClosable(true);
        setTitle("Ders İşlemleri");

        Dersler.setText("Güncel dersler : ");

        DuzenleButton.setText("Ders düzenlemek için tıklayınız");
        DuzenleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DuzenleButtonActionPerformed(evt);
            }
        });

        PanelDuzenle.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        duzenleYeniDersAdi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                duzenleYeniDersAdiKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                duzenleYeniDersAdiKeyTyped(evt);
            }
        });

        duzenleIDText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duzenleIDTextActionPerformed(evt);
            }
        });
        duzenleIDText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                duzenleIDTextKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                duzenleIDTextKeyTyped(evt);
            }
        });

        jLabel1.setText("Değiştirilecek dersin ID değeri : ");

        jLabel2.setText("Dersin yeni adı :");

        GuncelleButton.setText("Güncelle");
        GuncelleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuncelleButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelDuzenleLayout = new javax.swing.GroupLayout(PanelDuzenle);
        PanelDuzenle.setLayout(PanelDuzenleLayout);
        PanelDuzenleLayout.setHorizontalGroup(
            PanelDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDuzenleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(duzenleYeniDersAdi)
                    .addComponent(duzenleIDText)
                    .addGroup(PanelDuzenleLayout.createSequentialGroup()
                        .addGroup(PanelDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 72, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(PanelDuzenleLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(GuncelleButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelDuzenleLayout.setVerticalGroup(
            PanelDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDuzenleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(duzenleIDText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(duzenleYeniDersAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(GuncelleButton))
        );

        PanelEkleSil.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Dersler1.setText("İşlem yapılacak ders adını giriniz : ");

        DersAdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DersAdiActionPerformed(evt);
            }
        });

        EkleButton.setText("Ekle");
        EkleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EkleButtonActionPerformed(evt);
            }
        });

        SilButton.setText("Sil");
        SilButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SilButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelEkleSilLayout = new javax.swing.GroupLayout(PanelEkleSil);
        PanelEkleSil.setLayout(PanelEkleSilLayout);
        PanelEkleSilLayout.setHorizontalGroup(
            PanelEkleSilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEkleSilLayout.createSequentialGroup()
                .addGroup(PanelEkleSilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Dersler1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelEkleSilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(DersAdi, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelEkleSilLayout.createSequentialGroup()
                            .addComponent(EkleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(SilButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelEkleSilLayout.setVerticalGroup(
            PanelEkleSilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEkleSilLayout.createSequentialGroup()
                .addComponent(Dersler1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DersAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelEkleSilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EkleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SilButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Dersler)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DersSecimiCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelEkleSil, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DuzenleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PanelDuzenle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Dersler)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DersSecimiCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DuzenleButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelEkleSil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelDuzenle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EkleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EkleButtonActionPerformed
                 
        if(DersAdi.getText().length()>0)
        {
            dersPresenter.addNewDers(DersAdi.getText().toString());
            DersAdi.setText("");
            DersleriGoster();
            }
    }//GEN-LAST:event_EkleButtonActionPerformed

       
    private void SilButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SilButtonActionPerformed

        if(DersAdi.getText().length()>0){
     dersPresenter.deleteDers(DersAdi.getText().toString());
     DersAdi.setText("");

     DersleriGoster();
}
    }//GEN-LAST:event_SilButtonActionPerformed

    
    
    
    
    private void DuzenleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DuzenleButtonActionPerformed
        PanelEkleSil.setVisible(!PanelEkleSil.isVisible());
        PanelDuzenle.setVisible(!PanelEkleSil.isVisible());
        
        if(PanelEkleSil.isVisible()){
            DuzenleButton.setText("Ders düzenlemek için tıklayınız");
        }else{
            DuzenleButton.setText("Ders eklemek/silmek için tıklayınız");
        }
        
    }//GEN-LAST:event_DuzenleButtonActionPerformed

    private void DersAdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DersAdiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DersAdiActionPerformed

    private void duzenleIDTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duzenleIDTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_duzenleIDTextActionPerformed

    private void GuncelleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuncelleButtonActionPerformed
        // TODO add your handling code here:
        
        int id = -1;
        try{
        id = Integer.parseInt(duzenleIDText.getText().trim());
        }catch(Exception e){}
        
        if(id>-1){
            dersPresenter.updateDers(id,duzenleYeniDersAdi.getText().toString());
        }
        
        DersleriGoster();
        
        duzenleIDText.setText("");
        duzenleYeniDersAdi.setText("");
        GuncelleButton.setVisible(false);
    }//GEN-LAST:event_GuncelleButtonActionPerformed

    private void duzenleYeniDersAdiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_duzenleYeniDersAdiKeyPressed
        // TODO add your handling code here:
      
        checkForUpdateTextFileds();
    }//GEN-LAST:event_duzenleYeniDersAdiKeyPressed

    private void duzenleIDTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_duzenleIDTextKeyPressed
        
      checkForUpdateTextFileds();
    }//GEN-LAST:event_duzenleIDTextKeyPressed

    private void duzenleIDTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_duzenleIDTextKeyTyped
        // TODO add your handling code here:
        checkForUpdateTextFileds();
    }//GEN-LAST:event_duzenleIDTextKeyTyped

    private void duzenleYeniDersAdiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_duzenleYeniDersAdiKeyTyped
        // TODO add your handling code here:
        checkForUpdateTextFileds();
    }//GEN-LAST:event_duzenleYeniDersAdiKeyTyped

    private void checkForUpdateTextFileds(){
     if(duzenleIDText.getText().length()>0 && duzenleYeniDersAdi.getText().length()>0)
        {
        GuncelleButton.setVisible(true);
        }else
        {
        GuncelleButton.setVisible(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DersAdi;
    private javax.swing.JComboBox DersSecimiCombo;
    private javax.swing.JLabel Dersler;
    private javax.swing.JLabel Dersler1;
    private javax.swing.JButton DuzenleButton;
    private javax.swing.JButton EkleButton;
    private javax.swing.JButton GuncelleButton;
    private javax.swing.JPanel PanelDuzenle;
    private javax.swing.JPanel PanelEkleSil;
    private javax.swing.JButton SilButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField duzenleIDText;
    private javax.swing.JTextField duzenleYeniDersAdi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
