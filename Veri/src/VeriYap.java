import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

class Link {
    public long veri;
    public Link sonraki;
    public Link onceki;
    // -------------------------------------------------------------

    public Link(long d)
    {
        veri = d;
    }

    // -------------------------------------------------------------
    public void listele()
    {
        System.out.println("<-------->");
        System.out.print(veri + "<-----------> ");
    }
    // -------------------------------------------------------------
}

class IkiYonluListe {
    private Link ilk;
    private Link son;
    // -------------------------------------------------------------

    public IkiYonluListe()
    {
        ilk = null;
        son = null;
    }

    // -------------------------------------------------------------
    public boolean bosMu()
    {
        return ilk == null;
    }

    // -------------------------------------------------------------
    public void basaEkle(long dd)
    {
        Link yeniDugum = new Link(dd);

        if (bosMu())
            son = yeniDugum;
        else
            ilk.onceki = yeniDugum;
        yeniDugum.sonraki = ilk;
        ilk = yeniDugum;
    }

    public void sonaEkle(long dd)
    {
        Link yeniDugum = new Link(dd);
        if (bosMu())
            ilk = yeniDugum;
        else {
            son.sonraki = yeniDugum;
            yeniDugum.onceki = son;
        }
        son = yeniDugum;
    }




    public boolean arkasinaEkle(long anahtar, long dd) {
        Link aktif = ilk;
        while (aktif.veri != anahtar)
        {
            aktif = aktif.sonraki;
            if (aktif == null)
                return false;
        }
        Link yeniDugum = new Link(dd);

        if (aktif == son)
        {
            yeniDugum.sonraki = null;
            son = yeniDugum;
        } else {
            yeniDugum.sonraki = aktif.sonraki;

            aktif.sonraki.onceki = yeniDugum;
        }
        yeniDugum.onceki = aktif;
        aktif.sonraki = yeniDugum;
        return true;
    }

    public String yazdir() {
        System.out.print("Liste : ");
        Link aktif = ilk;
        while (aktif != null)
        {
            aktif.listele();
            aktif = aktif.sonraki;
        }
        System.out.println("");
        return "a";
    }
    public String yazdir2() {
        Link aktif = son;
        String s="";
        while (aktif != null)
        {
            s = " "+ aktif.veri + s;
            aktif = aktif.onceki;
        };
        return s;
    }
}

class Main extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {







        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main frame = new Main();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Main() {
        IkiYonluListe liste = new IkiYonluListe();
        String s ="";
        setTitle("\u00C7ift Y\u00F6nl\u00FC Ba\u011Fl\u0131 Liste");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 598, 371);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel add1 = new JPanel();
        add1.setBounds(10, 10, 563, 125);
        contentPane.add(add1);
        add1.setLayout(null);

        JLabel lblNewLabel = new JLabel("D\u00FC\u011F\u00FCm say\u0131s\u0131");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(10, 10, 121, 37);
        add1.add(lblNewLabel);

        JLabel lblNewLabel_3 = new JLabel();
        lblNewLabel_3.setBounds(10, 58, 543, 57);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add1.add(lblNewLabel_3);



        textField = new JTextField();
        textField.setBounds(141, 10, 195, 37);
        add1.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("Olu\u015Ftur");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Random r = new Random();
                int k=0;
                String s="";
                int a=0;
                int dugumSayi = Integer.valueOf(textField.getText());

                for (k = 0; k < dugumSayi; k++) {
                    a = r.nextInt(100);
                    liste.basaEkle(a);

                    s= " " + a+s;
                }
                lblNewLabel_3.setText(s);



            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton.setBounds(386, 10, 167, 37);
        add1.add(btnNewButton);


        JPanel add2 = new JPanel();
        add2.setBounds(10, 145, 563, 179);
        contentPane.add(add2);
        add2.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Eklenecek de\u011Fer");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(10, 10, 149, 29);
        add2.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Hangi d\u00FC\u011F\u00FCmden sonra");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(10, 49, 149, 29);
        add2.add(lblNewLabel_2);

        textField_1 = new JTextField();
        textField_1.setBounds(169, 10, 149, 29);
        add2.add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(169, 49, 149, 29);
        add2.add(textField_2);
        textField_2.setColumns(10);
        JLabel lblNewLabel_4 = new JLabel(" ");
        lblNewLabel_4.setBounds(0, 108, 564, 49);
        add2.add(lblNewLabel_4);
        JButton btnNewButton_1 = new JButton("Ekle");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                int aranan = Integer.valueOf(textField_1.getText());
                int istenen= Integer.valueOf(textField_2.getText());
                liste.arkasinaEkle(istenen,aranan);
                lblNewLabel_4.setText(liste.yazdir2());




            }
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_1.setBounds(410, 34, 143, 44);
        add2.add(btnNewButton_1);


    }
}

