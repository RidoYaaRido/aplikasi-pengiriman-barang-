package org.rdrhakim.uas;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

public class Form_Pengirim extends javax.swing.JFrame {
private Connection con;
private Statement st;
private ResultSet rspengirim;
private String sql="";
private String no,nama,alamat,kota,provinsi,kodepos,telepon;

    public Form_Pengirim() {
        initComponents();
        koneksikan();
        tampildata("select * from pengirim");
        
         setResizable(false);
        setLocationRelativeTo(null);
    }
    
    private void koneksikan() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pengiriman_barang","root","140533");
            System.out.println("Koneksi berhasil");
            JOptionPane.showMessageDialog(null, "koneksi berhasil");
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println("Koneksi Gagal \n"+e);
        }
    }

private void tampildata(String sql) {
    //// Membuat model untuk grid
    DefaultTableModel datalist= new DefaultTableModel();
    datalist.addColumn("No");
    datalist.addColumn("No Pengirim");
    datalist.addColumn("Nama Pengirim");
    datalist.addColumn("Alamat");
    datalist.addColumn("Kota");
    datalist.addColumn("Provinsi");
    datalist.addColumn("Kode Pos");
    datalist.addColumn("Telepon");
    try {
        int i = 1;
        st=con.createStatement();
        rspengirim=st.executeQuery("select * from pengirim");//// Membuat query SQL untuk menampilkan data
        //// Menampilkan data ke dalam grid
        while (rspengirim.next()) {
            datalist.addRow(new Object[]{
                (""+i++),rspengirim.getString(1),
                rspengirim.getString(2),rspengirim.getString(3),
                rspengirim.getString(4),
                rspengirim.getString(5),
                rspengirim.getString(6),
                rspengirim.getString(7)
            });
            gridpengirim.setModel(datalist);//// Mengisi grid dengan data
            }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null,"Gagal Tampil \n"+e.getMessage());        
    }
}

    private void kosongkan(){
        txtno.setText("");
        txtnama.setText("");
        txtalamat.setText("");
        txtkota.setText("");
        txtprovinsi.setText("");
        txtkodepos.setText("");
        txttelepon.setText("");  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtno = new javax.swing.JTextField();
        txtprovinsi = new javax.swing.JTextField();
        txtkodepos = new javax.swing.JTextField();
        txttelepon = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
        txtkota = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtalamat = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        gridpengirim = new javax.swing.JTable();
        btnsimpan = new javax.swing.JButton();
        btnbatal = new javax.swing.JButton();
        btnkeluar = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btnubah = new javax.swing.JButton();
        Back = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("No Pengirim");

        jLabel2.setText("Provinsi");

        jLabel3.setText("Kode Pos");

        jLabel5.setText("Telepon");

        jLabel6.setText("Nama Pengirim");

        jLabel7.setText("Alamat");

        jLabel8.setText("Kota");

        txtalamat.setColumns(20);
        txtalamat.setRows(5);
        jScrollPane1.setViewportView(txtalamat);

        gridpengirim.setModel(new javax.swing.table.DefaultTableModel(
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
        gridpengirim.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                gridpengirimAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        gridpengirim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gridpengirimMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(gridpengirim);

        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        btnbatal.setText("Batal");
        btnbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatalActionPerformed(evt);
            }
        });

        btnkeluar.setText("Keluar");
        btnkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkeluarActionPerformed(evt);
            }
        });

        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        btnubah.setText("Ubah");
        btnubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnubahActionPerformed(evt);
            }
        });

        Back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 153));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("PENGIRIM");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(Back))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtno, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtnama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(140, 179, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtkota)
                                    .addComponent(txtprovinsi)
                                    .addComponent(txtkodepos)
                                    .addComponent(txttelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnsimpan)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnubah)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnhapus)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnbatal)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnkeluar)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addComponent(txtkota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addComponent(txtprovinsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtkodepos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txttelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsimpan)
                    .addComponent(btnubah)
                    .addComponent(btnbatal)
                    .addComponent(btnkeluar)
                    .addComponent(btnhapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        //membuat sebuah listener untuk event key typed pada text field txtkodepos.
        txtkodepos.addKeyListener(new KeyAdapter() {
            // Metode ini akan dipanggil ketika pengguna mengetik karakter pada text field.
            public void keyTyped (KeyEvent evt){
                char c = evt.getKeyChar();//Mengecek Karakter yang Ditekan.
                if// mengecek apakah karakter yang ditekan adalah digit atau tidak. Jika tidak, maka akan menampilkan pesan error.
                (!Character.isDigit(c)) {
                    evt.consume();//mengkonsumsi event yang sedang diproses. Hal ini berarti bahwa event yang tidak valid tidak akan diproses lebih lanjut.
                    //Pesan error ini akan muncul ketika pengguna mencoba memasukkan karakter yang tidak valid (tidak digit).
                    JOptionPane.showMessageDialog(null, "Hanya boleh memasukkan angka");
                }
            }
            //Dengan demikian, listener ini memastikan bahwa hanya karakter digit yang dapat dipasukkan ke dalam text field txtkodepos.
            //Jika pengguna mencoba memasukkan karakter yang tidak valid, maka akan menampilkan pesan error dan mengkonsumsi event yang tidak valid.
        });
        //Membuat Listener untuk Event Key Typed:
        txttelepon.addKeyListener(new KeyAdapter() {
            public void keyTyped (KeyEvent evt){
                char c = evt.getKeyChar();
                if
                (!Character.isDigit(c)) {
                    evt.consume();
                    // ignore event
                    JOptionPane.showMessageDialog(null, "Hanya boleh memasukkan angka");
                }
            }
            //Dengan demikian, listener ini memastikan bahwa hanya karakter digit yang dapat dipasukkan
            //ke dalam text field txttelepon. Jika pengguna mencoba memasukkan karakter yang tidak valid, maka akan menampilkan pesan error dan mengkonsumsi event yang tidak valid.
        });

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
   //Mengambil Data dari Form:
   //mengambil nilai dari field
        no=String.valueOf(txtno.getText());
        nama=String.valueOf(txtnama.getText());
        alamat=String.valueOf(txtalamat.getText());
        kota=String.valueOf(txtkota.getText());
        provinsi=String.valueOf(txtprovinsi.getText());
        kodepos=String.valueOf(txtkodepos.getText());
        telepon=String.valueOf(txttelepon.getText());
        //mengecek apakah salah satu dari data tersebut masih kosong. Jika true, maka akan menampilkan pesan error.
         if (no.isEmpty() || nama.isEmpty() || alamat.isEmpty() || kota.isEmpty() || provinsi.isEmpty()|| kodepos.isEmpty()|| telepon.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Mohon isi semua data!", "Error", JOptionPane.ERROR_MESSAGE);
    } else
        try {
            //membuat query SQL untuk menambahkan data ke dalam tabel pengirim
            sql = "insert into pengirim(no_pengirim,nama_pengirim,alamat,kota,provinsi,kodepos,telepon)value ("
                    + "'"+ no +"','"+ nama +"','"+ alamat +"','"+ kota +"','"+ provinsi +"','"+ kodepos+"','"+telepon + "')";                 
            st=con.createStatement();// membuat statement SQL.
            st.execute(sql);//menjalankan query SQL.
            tampildata("select * from pengirim");
            JOptionPane.showMessageDialog(null, "data berhasil disimpan");//menampilkan pesan konfirmasi bahwa data telah disimpan
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"data gagal disimpan \n"+e.getMessage());
        }
        kosongkan();//mengkosongkan form dengan menghapus nilai dari text field dan text area.
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btnubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnubahActionPerformed
   //Mengambil Data dari Form:
   //mengambil nilai dari text field
        no=String.valueOf(txtno.getText());
        nama=String.valueOf(txtnama.getText());
        alamat=String.valueOf(txtalamat.getText());
        kota=String.valueOf(txtkota.getText());
        provinsi=String.valueOf(txtprovinsi.getText());
        kodepos=String.valueOf(txtkodepos.getText());
        telepon=String.valueOf(txttelepon.getText());
        //mengecek apakah pengguna ingin mengubah data. Jika ya, maka akan melanjutkan proses ubah data.
        if (JOptionPane.showConfirmDialog(this,"Apakah data ini mau diubah","konfirmasi",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==
                JOptionPane.YES_OPTION) {
        try {
            sql = "update pengirim set nama_pengirim='" + nama + "',"
                    + "kota='"+kota+"',alamat='"+alamat+"' where no_pengirim='"+no+"'";//membuat query SQL untuk mengubah data pengirim.
            st=con.createStatement();//membuat statement SQL.
            st.execute(sql);//menjalankan query SQL
            tampildata("select * from pengirim");//menampilkan data yang baru diubah ke dalam grid.
            JOptionPane.showMessageDialog(null, "data berhasil diubah");//menampilkan pesan konfirmasi bahwa data telah diubah.
            kosongkan();//mengkosongkan form dengan menghapus nilai dari text field dan text area.
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"data gagal diubah \n"+e.getMessage());
        }     
//Kesimpulan
//Kode ini memastikan bahwa data yang diubah ke dalam database adalah valid dan lengkap. Jika data tidak lengkap, maka akan menampilkan pesan error. 
//Setelah data diubah, maka akan menampilkan data yang baru diubah ke dalam grid dan mengkosongkan form.
        }
    }//GEN-LAST:event_btnubahActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
    //Mengambil Nomor Pengirim:   
        no=String.valueOf(txtno.getText());
        //mengecek apakah pengguna yakin menghapus data. Jika ya, maka akan melanjutkan proses hapus data.
        if (JOptionPane.showConfirmDialog(this,"Apakah anda yakin menghapus data ini","Konfirmasi",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==
                JOptionPane.YES_OPTION)
        {
            try {
                sql="delete from pengirim where no_pengirim='"+no+"'";// membuat query SQL untuk menghapus data pengirim berdasarkan nomor pengirim yang diinputkan.
                st=con.createStatement();
                st.execute(sql);
                tampildata("select * from pengirim");//menampilkan data yang baru dihapus ke dalam grid.
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                kosongkan();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Data gagal di hapus \n"+e.getMessage());
            }//Kesimpulan
//Kode ini memastikan bahwa data yang dihapus ke dalam database adalah valid dan lengkap. Jika data tidak lengkap, maka akan menampilkan pesan error. 
//Setelah data dihapus, maka akan menampilkan data yang baru dihapus ke dalam grid dan mengkosongkan form.           
        }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed
        kosongkan();//mengkosongkan form dengan menghapus nilai dari text field dan text area.
    }//GEN-LAST:event_btnbatalActionPerformed

    private void btnkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkeluarActionPerformed
        this.setVisible(false); // tutup jendela saat ini
        new Menu().setVisible(true); // buka jendela menu utama
    }//GEN-LAST:event_btnkeluarActionPerformed

    private void gridpengirimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gridpengirimMouseClicked
        txtno.setText(String.valueOf(gridpengirim.getValueAt(gridpengirim.getSelectedRow(),1)));
        txtnama.setText(String.valueOf(gridpengirim.getValueAt(gridpengirim.getSelectedRow(),2)));
        txtalamat.setText(String.valueOf(gridpengirim.getValueAt(gridpengirim.getSelectedRow(),3)));
        txtkota.setText(String.valueOf(gridpengirim.getValueAt(gridpengirim.getSelectedRow(),4)));
        txtprovinsi.setText(String.valueOf(gridpengirim.getValueAt(gridpengirim.getSelectedRow(),5)));
        txtkodepos.setText(String.valueOf(gridpengirim.getValueAt(gridpengirim.getSelectedRow(),6)));
        txttelepon.setText(String.valueOf(gridpengirim.getValueAt(gridpengirim.getSelectedRow(),8)));
    }//GEN-LAST:event_gridpengirimMouseClicked

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        Menu a=new Menu();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_BackMouseClicked

    private void gridpengirimAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_gridpengirimAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_gridpengirimAncestorAdded

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
            java.util.logging.Logger.getLogger(Form_Pengirim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Pengirim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Pengirim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Pengirim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Pengirim().setVisible(true);
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
    private javax.swing.JTable gridpengirim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtalamat;
    private javax.swing.JTextField txtkodepos;
    private javax.swing.JTextField txtkota;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtno;
    private javax.swing.JTextField txtprovinsi;
    private javax.swing.JTextField txttelepon;
    // End of variables declaration//GEN-END:variables
}
