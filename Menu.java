package org.rdrhakim.uas;

import javax.swing.*;
import java.awt.*;
import static java.awt.Color.blue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Toolkit;
//Kelas Menu adalah sebuah kelas yang mengextend JFrame, 
//yang berarti itu adalah sebuah jendela GUI (Graphical User Interface) di Java.
public class Menu extends JFrame {

    private static final int WIDTH = 350;
    private static final int HEIGHT = 400;

    private JButton btnPetugas;
    private JButton btnPengirim;
    private JButton btnPaket;
    private JButton btnKirim;
    private JButton btntentang;
//Konstruktor Menu yang akan menginisialisasi komponen-komponen GUI
    public Menu() {
        initComponents();
    }
//Metode initComponents() menginisialisasi komponen-komponen GUI sebagai berikut:
    private void initComponents() {
        //Membuat sebuah panel jPanel1 dengan layout BorderLayout.
        JPanel jPanel1 = new JPanel();
        jPanel1.setLayout(new BorderLayout());
//Membuat sebuah panel jPanel2 dengan background color abu-abu 
//dan menambahkan label jLabel2 dengan teks "APLIKASI PENGIRIMAN BARANG" yang di-center.
        JPanel jPanel2 = new JPanel();
        jPanel2.setBackground(new Color(226, 226, 226));
        JLabel jLabel2 = new JLabel("APLIKASI PENGIRIMAN BARANG", JLabel.CENTER);
        jLabel2.setFont(new Font("Tahoma", Font.BOLD, 18));
        jPanel2.add(jLabel2);

        jPanel1.add(jPanel2, BorderLayout.NORTH);
//Membuat empat tombol JButton dengan teks.
        btnPetugas = new JButton("FORM PETUGAS");
        btnPetugas.addActionListener(new ButtonActionListener());

        btnPengirim = new JButton("FORM PENGIRIM");
        btnPengirim.addActionListener(new ButtonActionListener());
        

        btnPaket = new JButton("FORM JENIS PAKET");
        btnPaket.addActionListener(new ButtonActionListener());

        btnKirim = new JButton("FORM PENGIRIMAN BARANG");
        btnKirim.addActionListener(new ButtonActionListener());
        
        btntentang = new JButton("FORM tentang");
        btntentang.addActionListener(new ButtonActionListener());

        JPanel buttonPanel = new JPanel(new GridLayout(6, 2, 12, 12));
        buttonPanel.add(btnPetugas);
        buttonPanel.add(btnPengirim);
        buttonPanel.add(btnPaket);
        buttonPanel.add(btnKirim);
        buttonPanel.add(btntentang);
        

        jPanel1.add(buttonPanel, BorderLayout.CENTER);

        add(jPanel1);
//Mengatur default close operation menjadi EXIT_ON_CLOSE, yang berarti aplikasi akan keluar jika jendela ini ditutup.
        setSize(WIDTH, HEIGHT);
        setResizable(false); // tidak bisa di-resize
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // set jendela tengah dekstop
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - WIDTH / 2, dim.height / 2 - HEIGHT / 2);

        setVisible(true);
    }
//Kelas ButtonActionListener
//Kelas ButtonActionListener adalah sebuah kelas inner yang mengimplementasikan interface ActionListener. 
//Metode actionPerformed() akan dipanggil ketika salah satu tombol di-klik.
    private class ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String buttonText = button.getText();

            switch (buttonText) {
                case "FORM PETUGAS":
                    Form_Petugas formPetugas = new Form_Petugas();
                    formPetugas.setVisible(true);
                    setVisible(false);
                    break;
                case "FORM PENGIRIM":
                    Form_Pengirim formPengirim = new Form_Pengirim();
                    formPengirim.setVisible(true);
                    setVisible(false);
                    break;
                case "FORM JENIS PAKET":
                    Form_Jenis_Paket formJenisPaket = new Form_Jenis_Paket();
                    formJenisPaket.setVisible(true);
                    setVisible(false);
                    break;
                case "FORM PENGIRIMAN BARANG":
                    Form_Pengiriman_Barang formPengirimanBarang = new Form_Pengiriman_Barang();
                    formPengirimanBarang.setVisible(true);
                    setVisible(false);
                    break;
                case "FORM TENTANG":
                    Form_tentang formtentang = new Form_tentang();
                    formtentang.setVisible(true);
                    setVisible(false);
                    break;
            }
        }
    }
//untuk eksekusi code
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Menu();
            }
        });
    }
}