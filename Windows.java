import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Windows extends JFrame {

    public static void main(String[] args){}


    static String text="";

    static String name = "Java-student";

    public Windows() {
        setTitle("Демо чат");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 200, 600, 600);

        //JScrollPane jscroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        // jscroll.setSize(new Dimension(20,100));

        JButton btnSend = new JButton("Sent");

        JTextField field = new JTextField();
        JTextArea area = new JTextArea();

        field.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getExtendedKeyCode() == 10 && !(field.getText().equals("")) ) {
                    text = text.concat(" " + name + " " + date() + ": " + field.getText() + "\n");
                    area.setText("" + text);
                    field.setText("");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

        });
        btnSend.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount()==1 && !(field.getText().equals(""))){

                    text = text.concat(" "+name+" " + date() + ": " +field.getText()+"\n");

                    area.setText(""+text);

                    field.setText("");
                }
            }
        });

        JPanel upPanel = new JPanel();
        JPanel sendPanel = new JPanel();

        upPanel.setSize(250, 250);


        upPanel.setLayout(new BorderLayout());
        sendPanel.setLayout(new BorderLayout());
        //area.add(jscroll);
//        textField.setSize(1500,500);
        btnSend.setSize(50, 20);

        sendPanel.add(field, BorderLayout.CENTER);
        sendPanel.add(btnSend, BorderLayout.EAST);



        upPanel.add(sendPanel, BorderLayout.SOUTH);
        //       upPanel.add(btn5, BorderLayout.WEST);
//        upPanel.add(jscroll, BorderLayout.EAST);
//       upPanel.add(btn4, BorderLayout.NORTH);
        upPanel.add(area, BorderLayout.CENTER);


        add(upPanel);
        setVisible(true);

    }

    private String date() {

        Date date = new Date();

        SimpleDateFormat ft =
                new SimpleDateFormat("hh:mm:ss");

        return ft.format(date);



    }

}