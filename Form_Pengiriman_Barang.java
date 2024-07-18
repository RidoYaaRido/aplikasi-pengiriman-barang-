package org.rdrhakim.uas;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.rdrhakim.uas.Menu;

public class Form_Pengiriman_Barang extends javax.swing.JFrame {
private Connection con;
private Statement st;
private ResultSet rskirim;
private ResultSet rspetugas;
private ResultSet rspaket;
private ResultSet rspengirim;
private String sql="";
private String resi,tujuan,idpetugas,nopengirim,penerima,alamat,telepon,pakettype,isipaket;
private int berat,biaya,asuransi;
    private String
            generateNoResi() {
// Get the current timestamp
        long timestamp = System.currentTimeMillis();
// Convert the timestamp to a string
        String noResi
                = "pb"
                + timestamp;
        return noResi;
    }
    public Form_Pengiriman_Barang() {
        initComponents();
        koneksikan();
        daftarpetugas();
        daftarpengirim();
        daftarpaket();
        tampildata("select * from pengiriman_barang");
        
         setResizable(false);
        setLocationRelativeTo(null);
        
        txtresi.setText(generateNoResi());
    txtresi.setEditable(
false
);
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
     DefaultTableModel datalist= new DefaultTableModel();
    datalist.addColumn("No");
    datalist.addColumn("NO Resi");
    datalist.addColumn("Tujuan");
    datalist.addColumn("ID Petugas" );
    datalist.addColumn( "NO Pengirim");
    datalist.addColumn("Penerima");
    datalist.addColumn( "Alamat");
    datalist.addColumn("Telepon");
    datalist.addColumn("Paket");
    datalist.addColumn("Berat");
    datalist.addColumn("Biaya" );
    datalist.addColumn("Asuransi");
    datalist.addColumn("Isi Paket");

    try (Statement st = con.createStatement(); ResultSet rskirim = st.executeQuery(sql)) {
        int i = 1;
        while (rskirim.next()) {
            datalist.addRow(
                    new Object[]{
                        (""+ i++), rskirim.getString( "no_resi"),
                        rskirim.getString("kota_tujuan" ),
                        rskirim.getString("id_petugas"),
                        rskirim.getString( "no_pengirim"),
                        rskirim.getString("penerima" ),
                        rskirim.getString( "alamat"),
                        rskirim.getString("telepon"),
                        rskirim.getString( "paket_type"),
                        rskirim.getInt("berat"),
                        rskirim.getInt( "biaya"),
                        rskirim.getInt( "asuransi" ),
                        rskirim.getString("isi_paket")
                    });
        }
        gridpengiriman.setModel(datalist);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Gagal Tampil \n"+e.getMessage());        
    }
}
private void kosongkan(){
        txtresi.setText(generateNoResi());
        txtkotatujuan.setText("");
        txtidpetugas.setSelectedItem("-pilih-");
        txtnopengirim.setSelectedItem("-pilih-");
        txtpenerima.setText("");
        txtalamatpenerima.setText("");
        txttelepon.setText("");
        txtpakettype.setSelectedItem("-pilih-");
        txtberat.setText("");
        txtbiaya.setText("");
        txtasuransi.setText("");
        txtisipaket.setText("");
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
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtnamapetugas = new javax.swing.JTextField();
        txtjabatan = new javax.swing.JTextField();
        txtbiaya = new javax.swing.JTextField();
        txtasuransi = new javax.swing.JTextField();
        txtberat = new javax.swing.JTextField();
        txtpakettype = new javax.swing.JComboBox<>();
        txtidpetugas = new javax.swing.JComboBox<>();
        txtkotatujuan = new javax.swing.JTextField();
        txtnamapengirim = new javax.swing.JTextField();
        txtpenerima = new javax.swing.JTextField();
        txttelepon = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtalamatpengirim = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtisipaket = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtalamatpenerima = new javax.swing.JTextArea();
        btnbatal = new javax.swing.JButton();
        btnkeluar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        gridpengiriman = new javax.swing.JTable();
        txtresi = new javax.swing.JTextField();
        txtsimpan = new javax.swing.JButton();
        txtnopengirim = new javax.swing.JComboBox<>();
        btnhapus = new javax.swing.JButton();
        Back = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("NO Resi");

        jLabel2.setText("Alamat");

        jLabel3.setText("Nama");

        jLabel5.setText("ID Petugas");

        jLabel6.setText("Penerima");

        jLabel7.setText("Isi Paket");

        jLabel8.setText("Nama Petugas");

        jLabel9.setText("Jabatan");

        jLabel10.setText("Paket Type");

        jLabel11.setText("Biaya");

        jLabel12.setText("Asuransi");

        jLabel13.setText("Berat");

        jLabel15.setText("Kota Tujuan");

        jLabel16.setText("NO Pengirim");

        jLabel17.setText("Alamat");

        jLabel18.setText("Telepon");

        txtjabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjabatanActionPerformed(evt);
            }
        });

        txtasuransi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtasuransiActionPerformed(evt);
            }
        });

        txtberat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtberatActionPerformed(evt);
            }
        });

        txtpakettype.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtpakettypeItemStateChanged(evt);
            }
        });
        txtpakettype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpakettypeActionPerformed(evt);
            }
        });

        txtidpetugas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtidpetugasItemStateChanged(evt);
            }
        });
        txtidpetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidpetugasActionPerformed(evt);
            }
        });

        txtalamatpengirim.setColumns(20);
        txtalamatpengirim.setRows(5);
        jScrollPane1.setViewportView(txtalamatpengirim);

        txtisipaket.setColumns(20);
        txtisipaket.setRows(5);
        jScrollPane2.setViewportView(txtisipaket);

        txtalamatpenerima.setColumns(20);
        txtalamatpenerima.setRows(5);
        jScrollPane3.setViewportView(txtalamatpenerima);

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

        gridpengiriman.setModel(new javax.swing.table.DefaultTableModel(
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
        gridpengiriman.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                gridpengirimanAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                gridpengirimanAncestorRemoved(evt);
            }
        });
        gridpengiriman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gridpengirimanMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(gridpengiriman);

        txtsimpan.setText("Simpan");
        txtsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsimpanActionPerformed(evt);
            }
        });

        txtnopengirim.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtnopengirimItemStateChanged(evt);
            }
        });

        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        Back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackMouseClicked(evt);
            }
        });

        jLabel4.setText("Kurir");

        jLabel14.setText("Penerima Paket");

        jLabel20.setText("Pengirim Paket/barang");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 153, 153));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("PENGIRIMAN BARANG");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Back)
                        .addGap(238, 238, 238)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtnopengirim, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(37, 37, 37)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(43, 43, 43)
                                    .addComponent(txtnamapengirim, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(jLabel20)))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel13))
                                        .addGap(38, 38, 38))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtjabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtasuransi, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtberat, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtresi, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtidpetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtbiaya, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtpakettype, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtnamapetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4))
                                                    .addGap(59, 59, 59)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel18)
                                                        .addComponent(jLabel17)
                                                        .addComponent(jLabel15)
                                                        .addComponent(jLabel6))))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(27, 27, 27)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(txtkotatujuan, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txtpenerima, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addGap(3, 3, 3)
                                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel14)
                                                    .addGap(68, 68, 68))))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtsimpan)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnbatal, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(26, 26, 26)
                                            .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(22, 22, 22)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(btnkeluar)
                                                .addComponent(txttelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 924, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Back)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel20)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtpenerima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtkotatujuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtresi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(txtnopengirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(txtidpetugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(34, 34, 34)
                                                    .addComponent(jLabel9))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(28, 28, 28)
                                                    .addComponent(jLabel2)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(txtnamapetugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel8))
                                                .addGap(18, 18, 18)
                                                .addComponent(txtjabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel10)
                                            .addComponent(txtpakettype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtnamapengirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtbiaya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtasuransi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtberat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addGap(33, 33, 33))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(79, 79, 79)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtsimpan)
                            .addComponent(btnbatal)
                            .addComponent(btnhapus)
                            .addComponent(btnkeluar))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)))
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        txtbiaya.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt){
                char c = evt.getKeyChar();
                if(!Character.isDigit(c)) {
                    evt.consume();
                    // ignore event
                    JOptionPane.showMessageDialog(null,"Hanya boleh memasukkan angka"
                    );
                }
            }
        });
        txtasuransi.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt){
                char c = evt.getKeyChar();
                if(!Character.isDigit(c)) {
                    evt.consume();
                    // ignore event
                    JOptionPane.showMessageDialog(null,"Hanya boleh memasukkan angka"
                    );
                }
            }
        });
        txtberat.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt){
                char c = evt.getKeyChar();
                if(!Character.isDigit(c)) {
                    evt.consume();
                    // ignore event
                    JOptionPane.showMessageDialog(null,"Hanya boleh memasukkan angka"
                    );
                }
            }
        });
        txttelepon.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt){
                char c = evt.getKeyChar();
                if(!Character.isDigit(c)) {
                    evt.consume();
                    // ignore event
                    JOptionPane.showMessageDialog(null,"Hanya boleh memasukkan angka"
                    );
                }
            }
        });

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsimpanActionPerformed

        resi = String.valueOf(txtresi.getText());
        tujuan = String.valueOf(txtkotatujuan.getText());
        idpetugas = txtidpetugas.getItemAt(txtidpetugas.getSelectedIndex()).toString();
        nopengirim = txtnopengirim.getItemAt(txtnopengirim.getSelectedIndex()).toString();
        penerima = String.valueOf(txtpenerima.getText());
        alamat = String.valueOf(txtalamatpenerima.getText());
        telepon = String.valueOf(txttelepon.getText());
        pakettype = txtpakettype.getItemAt(txtpakettype.getSelectedIndex()).toString();
        berat = Integer.parseInt(txtberat.getText());
        biaya = Integer.parseInt(txtbiaya.getText());
        asuransi = Integer.parseInt(txtasuransi.getText());
        isipaket = String.valueOf(txtisipaket.getText());
 
        if (resi.isEmpty() || tujuan.isEmpty() || idpetugas.equals("Pilih" ) || nopengirim.equals( "Pilih") || penerima.isEmpty()
                || alamat.isEmpty() || telepon.isEmpty() || pakettype.equals("Pilih")|| txtberat.getText().isEmpty()
                || txtbiaya.getText().isEmpty() || txtasuransi.getText().isEmpty() || isipaket.isEmpty()) {JOptionPane.showMessageDialog(
                    null,
                     "Isi semua data!",
                     "Peringatan",
                     JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            berat = Integer.parseInt(txtberat.getText());
            biaya = Integer.parseInt(txtbiaya.getText());
            asuransi = Integer.parseInt(txtasuransi.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    null,
                     "Berat, Biaya, dan Asuransi harus berupa angka!","Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(
                this,
                 "Apakah Anda yakin ingin menyimpan data ini?",
                 "Konfirmasi",
                 JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    sql
                            = "SELECT id_paket FROM jenis_paket WHERE paket_type = ?";
                    PreparedStatement stmt = con.prepareStatement(sql);
                    stmt.setString(1,pakettype);
                    ResultSet rsPaket = stmt.executeQuery();
                if (rsPaket.next()) {
                    int idPaket = rsPaket.getInt("id_paket");
                    sql = "INSERT INTO pengiriman_barang(no_resi, kota_tujuan, id_petugas, no_pengirim, penerima, alamat, telepon, paket_type, berat, biaya, asuransi, isi_paket, id_paket) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement insertStmt = con.prepareStatement(sql);
                    insertStmt.setString(1, resi);
                    insertStmt.setString(2, tujuan);
                    insertStmt.setString(3, idpetugas);
                    insertStmt.setString(4, nopengirim);
                    insertStmt.setString(5, penerima);
                    insertStmt.setString(6, alamat);
                    insertStmt.setString(7, telepon);
                    insertStmt.setString(8, pakettype);
                    insertStmt.setInt(9, berat);
                    insertStmt.setInt(10, biaya);
                    insertStmt.setInt(11, asuransi);
                    insertStmt.setString(12, isipaket);
                    insertStmt.setInt(13, idPaket);
                    insertStmt.executeUpdate();

                    // Update the table view
                    tampildata("select * from pengiriman_barang");
                } else {
                    JOptionPane.showMessageDialog(null, "Paket type not found in database.");
                }
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data gagal diubah \n" + e.getMessage());
            }
            kosongkan();
        }
    }//GEN-LAST:event_txtsimpanActionPerformed

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed
        kosongkan();
    }//GEN-LAST:event_btnbatalActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        resi=String.valueOf(txtresi.getText());
        if (JOptionPane.showConfirmDialog(this,"Apakah anda yakin menghapus data ini","Konfirmasi",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==
                JOptionPane.YES_OPTION)
        {
           try {
               sql="delete from pengiriman_barang where no_resi='"+resi+"'";
               st=con.createStatement();
               st.execute(sql);
                tampildata("select * from pengiriman_barang");
                kosongkan();
           } catch (Exception e) {
               JOptionPane.showMessageDialog(null,"data gagal di hapus\n"+e.getMessage());
           }   
       }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btnkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkeluarActionPerformed
        this.setVisible(false); // tutup jendela saat ini
        new Menu().setVisible(true); // buka jendela menu utama
    }//GEN-LAST:event_btnkeluarActionPerformed

    private void gridpengirimanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gridpengirimanMouseClicked
        int selectedRow = gridpengiriman.getSelectedRow();
        txtresi.setText(gridpengiriman.getValueAt(selectedRow,1).toString());
        txtkotatujuan.setText(gridpengiriman.getValueAt(selectedRow,2).toString());
        txtidpetugas.setSelectedItem(gridpengiriman.getValueAt(selectedRow, 3).toString());
        txtnopengirim.setSelectedItem(gridpengiriman.getValueAt(selectedRow, 4).toString());
        txtpenerima.setText(gridpengiriman.getValueAt(selectedRow,5 ).toString());
        txtalamatpenerima.setText(gridpengiriman.getValueAt(selectedRow,6).toString());
        txttelepon.setText(gridpengiriman.getValueAt(selectedRow, 7).toString());
        txtpakettype.setSelectedItem(gridpengiriman.getValueAt(selectedRow,8).toString());
        txtberat.setText(gridpengiriman.getValueAt(selectedRow,9).toString());
        txtbiaya.setText(gridpengiriman.getValueAt(selectedRow,10).toString());
        txtasuransi.setText(gridpengiriman.getValueAt(selectedRow,11).toString());
        txtisipaket.setText(gridpengiriman.getValueAt(selectedRow,12).toString());
    }//GEN-LAST:event_gridpengirimanMouseClicked

    private void txtidpetugasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtidpetugasItemStateChanged
         try {
                sql="select * from petugas where "
                        + "id_petugas='" +txtidpetugas.getSelectedItem()+ "'";
                st=con.createStatement();
                rspetugas=st.executeQuery(sql);
                while (rspetugas.next()) {
                    txtnamapetugas.setText(rspetugas.getString(2));
                    txtjabatan.setText(rspetugas.getString(3));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Gagal Tampil \n"+e.getMessage());
        }
    }//GEN-LAST:event_txtidpetugasItemStateChanged

    private void daftarpetugas(){
        txtidpetugas.removeAllItems();
        txtidpetugas.addItem("Pilih");
        try {
            String Sql="select * from petugas";
            Statement st=con.createStatement();
            rspetugas=st.executeQuery(Sql);
            while(rspetugas.next()){
                String aliasid=rspetugas.getString("id_petugas");
                txtidpetugas.addItem(aliasid);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Gagal Menampilkan ID Petugas \n"+e.getMessage());                  
        }
}    
    
    private void txtnopengirimItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtnopengirimItemStateChanged
        try {
                sql="select * from pengirim where "
                        + "no_pengirim='" +txtnopengirim.getSelectedItem()+ "'";
                st=con.createStatement();
                rspengirim=st.executeQuery(sql);
                while (rspengirim.next()) {
                    txtnamapengirim.setText(rspengirim.getString(2));
                    txtalamatpengirim.setText(rspengirim.getString(3));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Gagal Tampil \n"+e.getMessage());
        }        
    }//GEN-LAST:event_txtnopengirimItemStateChanged

    private void daftarpengirim(){
        txtnopengirim.removeAllItems();
        txtnopengirim.addItem("Pilih");
        try {
            String sql ="select * from pengirim";
            Statement st=con.createStatement();
            rspengirim=st.executeQuery(sql);
            while(rspengirim.next()) {
                String aliasid=rspengirim.getString("no_pengirim");
                txtnopengirim.addItem(aliasid);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Gagal Tampil \n"+e.getMessage());
        }
    }
    
    private void txtpakettypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtpakettypeItemStateChanged
        try {
                sql="select * from jenis_paket where "
                        + "paket_type='" +txtpakettype.getSelectedItem()+ "'";
                st=con.createStatement();
                rspaket=st.executeQuery(sql);
                while (rspaket.next()) {
                    txtbiaya.setText(rspaket.getString(3));
                    txtasuransi.setText(rspaket.getString(4));
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Gagal Tampil \n"+e.getMessage());
        }
    }//GEN-LAST:event_txtpakettypeItemStateChanged

    private void daftarpaket(){
        txtpakettype.removeAllItems();
        txtpakettype.addItem("Pilih");
            try {
                String sql ="select * from jenis_paket";
                Statement st=con.createStatement();
                rspaket=st.executeQuery(sql);
                while (rspaket.next()) {
                    String aliasid=rspaket.getString("paket_type");
                   txtpakettype.addItem(aliasid);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Gagal Tampil \n"+e.getMessage());
            }
    }
    
    private void txtidpetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidpetugasActionPerformed
    }//GEN-LAST:event_txtidpetugasActionPerformed

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        Menu a=new Menu();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_BackMouseClicked

    private void gridpengirimanAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_gridpengirimanAncestorRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_gridpengirimanAncestorRemoved

    private void txtpakettypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpakettypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpakettypeActionPerformed

    private void gridpengirimanAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_gridpengirimanAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_gridpengirimanAncestorAdded

    private void txtjabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjabatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjabatanActionPerformed

    private void txtasuransiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtasuransiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtasuransiActionPerformed

    private void txtberatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtberatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtberatActionPerformed
    

    
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
            java.util.logging.Logger.getLogger(Form_Pengiriman_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Pengiriman_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Pengiriman_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Pengiriman_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Pengiriman_Barang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Back;
    private javax.swing.JButton btnbatal;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnkeluar;
    private javax.swing.JTable gridpengiriman;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea txtalamatpenerima;
    private javax.swing.JTextArea txtalamatpengirim;
    private javax.swing.JTextField txtasuransi;
    private javax.swing.JTextField txtberat;
    private javax.swing.JTextField txtbiaya;
    private javax.swing.JComboBox<String> txtidpetugas;
    private javax.swing.JTextArea txtisipaket;
    private javax.swing.JTextField txtjabatan;
    private javax.swing.JTextField txtkotatujuan;
    private javax.swing.JTextField txtnamapengirim;
    private javax.swing.JTextField txtnamapetugas;
    private javax.swing.JComboBox<String> txtnopengirim;
    private javax.swing.JComboBox<String> txtpakettype;
    private javax.swing.JTextField txtpenerima;
    private javax.swing.JTextField txtresi;
    private javax.swing.JButton txtsimpan;
    private javax.swing.JTextField txttelepon;
    // End of variables declaration//GEN-END:variables

}