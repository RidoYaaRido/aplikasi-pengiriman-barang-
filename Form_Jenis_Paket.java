package org.rdrhakim.uas;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import org.rdrhakim.uas.Menu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Form_Jenis_Paket extends javax.swing.JFrame {
private Connection con;
private Statement st;
private ResultSet rspaket;
private String sql="";
private String id,type;
private int berat,biaya,asuransi;

    public Form_Jenis_Paket() {
        initComponents();
        koneksikan();
        tampildata("select * from jenis_paket");
        
         setResizable(false);
        setLocationRelativeTo(null);
    }
    
    private void koneksikan() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pengiriman_barang","root","140533");
            System.out.println("Koneksi berhasil");
            JOptionPane.showMessageDialog(null, "koneksi berhasil");
        } catch (Exception e) {
            System.out.println("Koneksi Gagal \n"+e);
        }
    }

private void tampildata(String sql) {
    DefaultTableModel datalist= new DefaultTableModel();// Membuat model untuk grid menggunakan kelas DefaultTableModel.
    //Menambahkan kolom ke dalam model untuk grid.
    datalist.addColumn("No");
    datalist.addColumn("ID Paket");
    datalist.addColumn("Type");
    datalist.addColumn("Biaya");
    datalist.addColumn("Asuransi");
    try {
        int i = 1;
        st=con.createStatement();
        rspaket=st.executeQuery("select * from jenis_paket");//Menjalankan query SQL untuk mengambil data dari tabel jenis_paket.
        while (rspaket.next()) {
            datalist.addRow(new Object[]{
                (""+i++),rspaket.getString(1),
                rspaket.getString(2),rspaket.getString(3),
                rspaket.getString(4),
            });//Menambahkan data ke dalam model untuk grid.
            gridjenispaket.setModel(datalist);//Mengatur model ke dalam grid sehingga data dapat ditampilkan.
            }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Gagal Tampil \n"+e.getMessage());        
    }
}

    private void kosongkan(){
        txtid.setText("");
        txttype.setSelectedItem("-pilih-");
        txtbiaya.setText("");
        txtasuransi.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtbiaya = new javax.swing.JTextField();
        txtasuransi = new javax.swing.JTextField();
        txttype = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        gridjenispaket = new javax.swing.JTable();
        btnsimpan = new javax.swing.JButton();
        btnubah = new javax.swing.JButton();
        btnbatal = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btnkeluar = new javax.swing.JButton();
        Back = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID Paket");

        jLabel2.setText("Paket Type");

        jLabel3.setText("Biaya");

        jLabel4.setText("Asuransi");

        txttype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-pilih-", "Reguler", "Kilat", "Express" }));
        txttype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttypeActionPerformed(evt);
            }
        });

        gridjenispaket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        gridjenispaket.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                gridjenispaketAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        gridjenispaket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gridjenispaketMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(gridjenispaket);

        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        btnubah.setText("Ubah");
        btnubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnubahActionPerformed(evt);
            }
        });

        btnbatal.setText("Batal");
        btnbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatalActionPerformed(evt);
            }
        });

        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        btnkeluar.setText("Keluar");
        btnkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkeluarActionPerformed(evt);
            }
        });

        Back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("JENIS PAKET");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Back)
                .addGap(143, 143, 143)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtasuransi, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtbiaya)
                    .addComponent(txttype, 0, 181, Short.MAX_VALUE)
                    .addComponent(txtid))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnsimpan)
                        .addGap(18, 18, 18)
                        .addComponent(btnubah)
                        .addGap(18, 18, 18)
                        .addComponent(btnhapus)
                        .addGap(18, 18, 18)
                        .addComponent(btnbatal)
                        .addGap(18, 18, 18)
                        .addComponent(btnkeluar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txttype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtbiaya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addComponent(jLabel1))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtasuransi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsimpan)
                    .addComponent(btnubah)
                    .addComponent(btnhapus)
                    .addComponent(btnbatal)
                    .addComponent(btnkeluar))
                .addGap(49, 49, 49))
        );

        txtid.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                JTextField field = (JTextField) input;
                if (field.getText().length() > 6) {
                    // Display showbox notification
                    JOptionPane.showMessageDialog(null,
                        "ID Paket tidak boleh lebih dari 6 karakter",
                        "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                return true;
            }
        });
        //Membuat listener untuk event keyTyped pada text field txtbiaya.
        txtbiaya.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt)// Metode ini akan dipanggil ketika pengguna mengetik karakter pada text field.
            {
                char c = evt.getKeyChar();//Mengambil karakter yang ditekan oleh pengguna.
                if(!Character.isDigit(c))// Mengecek apakah karakter yang ditekan adalah digit atau tidak. Jika tidak, maka akan menampilkan pesan error.
                {
                    evt.consume();
                    //Menampilkan pesan error
                    JOptionPane.showMessageDialog(null,"Hanya boleh memasukkan angka");
                }
            }
            // listener ini memastikan bahwa hanya karakter digit yang dapat dipasukkan ke dalam text field txtbiaya.
            //Jika pengguna mencoba memasukkan karakter yang tidak valid, maka akan menampilkan pesan error dan mengkonsumsi event yang tidak valid.
        });
        // Membuat listener untuk event keyTyped pada text field txtasuransi.
        txtasuransi.addKeyListener(new KeyAdapter() {
            public void keyTyped (KeyEvent evt)//Metode ini akan dipanggil ketika pengguna mengetik karakter pada text field.
            {
                char c = evt.getKeyChar(); //Mengambil karakter yang ditekan oleh pengguna.
                if//Mengecek apakah karakter yang ditekan adalah digit atau tidak. Jika tidak, maka akan menampilkan pesan error.
                (!Character.isDigit(c)) {
                    evt.consume();//Mengkonsumsi event yang tidak valid, sehingga event yang tidak valid tidak akan diproses lebih lanjut.
                    //Menampilkan pesan error
                    JOptionPane.showMessageDialog(null, "Hanya boleh memasukkan angka");
                }
            }
            // listener ini memastikan bahwa hanya karakter digit yang dapat dipasukkan ke dalam text field txtasuransi.
            //Jika pengguna mencoba memasukkan karakter yang tidak valid, maka akan menampilkan pesan error dan mengkonsumsi event yang tidak valid.
        });

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
//Mengecek apakah data pada text field txtid, txttype, txtbiaya, dan txtasuransi masih kosong. Jika true, maka akan menampilkan pesan error
        if (txtid.getText().isEmpty() || txttype.getSelectedItem().equals(
                "-pilih-")|| txtbiaya.getText().isEmpty() || txtasuransi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                     "Data tidak boleh kosong"
            );
            return;
        }
        //Mengambil Nilai dari Text Field:
        id=String.valueOf(txtid.getText());
        type=txttype.getItemAt(txttype.getSelectedIndex()).toString();
        biaya=Integer.parseInt(txtbiaya.getText());
        asuransi=Integer.parseInt(txtasuransi.getText());
        try {
             //Membuat query SQL untuk menambahkan data ke dalam tabel jenis_paket
            sql = "insert into jenis_paket(id_paket,paket_type,biaya,asuransi)value ("
                    + "'"+ id +"','"+ type +"','"+ biaya +"','"+ asuransi +"')";
            st=con.createStatement();//Membuat statement SQL.
            st.execute(sql);//Menjalankan query SQL.
            tampildata("select * from jenis_paket");// Menampilkan data yang baru disimpan ke dalam grid.
            JOptionPane.showMessageDialog(null, "data berhasil disimpan");//Menampilkan pesan konfirmasi bahwa data telah disimpan.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"data gagal disimpan \n"+e.getMessage());
        }
        kosongkan(); //Mengkosongkan form dengan menghapus nilai dari text field dan text area.     
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btnubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnubahActionPerformed
 //Mengambil Nilai dari Text Field:
        id=String.valueOf(txtid.getText());
        type=txttype.getItemAt(txttype.getSelectedIndex()).toString();// Mengambil nilai dari text field txttype dan mengkonversinya ke tipe data String.
        biaya=Integer.parseInt(txtbiaya.getText());
        asuransi=Integer.parseInt(txtasuransi.getText());
        //Mengecek apakah pengguna ingin mengubah data. Jika ya, maka akan melanjutkan proses ubah data.
        if (JOptionPane.showConfirmDialog(this,"Apakah data ini mau diubah","konfirmasi",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==
                JOptionPane.YES_OPTION) {
        try {
            sql = "update jenis_paket set id_paket='" + id + "',"
                    + "paket_type='"+type+"',biaya='"+biaya+"' where id_paket='"+id+"'";//Membuat query SQL untuk mengubah data dalam tabel jenis_paket.
            st=con.createStatement();//Membuat statement SQL.
            st.execute(sql);//Menjalankan query SQL.
            tampildata("select * from jenis_paket");//Menampilkan data yang baru diubah ke dalam grid.
            JOptionPane.showMessageDialog(null, "data berhasil diubah");//Menampilkan pesan konfirmasi bahwa data telah diubah
            kosongkan();//Mengkosongkan form dengan menghapus nilai dari text field dan text area.   
            
        } catch (Exception e) {
            // Menampilkan pesan error jika terjadi kesalahan saat mengubah data.
            JOptionPane.showMessageDialog(null,"data gagal diubah \n"+e.getMessage());}
        }
   // kode ini memastikan bahwa data yang diubah ke dalam tabel jenis_paket adalah valid dan lengkap. Jika data tidak lengkap, maka akan menampilkan pesan error. 
   //Setelah data diubah, maka akan menampilkan data yang baru diubah ke dalam grid dan mengkosongkan form.
    }//GEN-LAST:event_btnubahActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
    //Mengambil Nilai dari Text Field:
        id=String.valueOf(txtid.getText());
        //Mengecek apakah pengguna ingin menghapus data. Jika ya, maka akan melanjutkan proses hapus data
        if (JOptionPane.showConfirmDialog(this,"Apakah anda yakin menghapus data ini","Konfirmasi",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==
                JOptionPane.YES_OPTION)
        {
            try {
                sql="delete from jenis_paket where id_paket='"+id+"'";//Membuat query SQL untuk menghapus data dari tabel jenis_paket berdasarkan nilai id
                st=con.createStatement();//- Membuat statement SQL.
                st.execute(sql);//Menjalankan query SQL.
                tampildata("select * from jenis_paket");//Menampilkan data yang baru dihapus ke dalam grid.
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                kosongkan();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"data gagal di hapus \n"+e.getMessage());
            }
            
        }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed
        kosongkan();//Mengkosongkan form dengan menghapus nilai dari text field dan text area. 
    }//GEN-LAST:event_btnbatalActionPerformed

    private void btnkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkeluarActionPerformed
        this.setVisible(false); // tutup jendela saat ini
        new Menu().setVisible(true); // buka jendela menu utama
    }//GEN-LAST:event_btnkeluarActionPerformed

    private void gridjenispaketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gridjenispaketMouseClicked
        txtid.setText(String.valueOf(gridjenispaket.getValueAt(gridjenispaket.getSelectedRow(),1)));
        txttype.setSelectedItem(String.valueOf(gridjenispaket.getValueAt(gridjenispaket.getSelectedRow(),2)));
        txtbiaya.setText(String.valueOf(gridjenispaket.getValueAt(gridjenispaket.getSelectedRow(),3)));
        txtasuransi.setText(String.valueOf(gridjenispaket.getValueAt(gridjenispaket.getSelectedRow(),4)));
    }//GEN-LAST:event_gridjenispaketMouseClicked

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        Menu a=new Menu();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_BackMouseClicked

    private void gridjenispaketAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_gridjenispaketAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_gridjenispaketAncestorAdded

    private void txttypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttypeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form_Jenis_Paket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Jenis_Paket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Jenis_Paket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Jenis_Paket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Jenis_Paket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Back;
    private javax.swing.JButton btnbatal;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnkeluar;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btnubah;
    private javax.swing.JTable gridjenispaket;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtasuransi;
    private javax.swing.JTextField txtbiaya;
    private javax.swing.JTextField txtid;
    private javax.swing.JComboBox<String> txttype;
    // End of variables declaration//GEN-END:variables
}
