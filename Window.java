import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;


class Windows extends JFrame {

    static String text="";


    public Windows() {
        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 200, 600, 600);

        JScrollBar jscroll = new JScrollBar();

        JButton btn1 = new JButton("Enter");
        JButton btn2 = new JButton("2");
        JButton btn3 = new JButton("3");
        JButton btn4 = new JButton("4");
        JButton btn5 = new JButton("5");
        JTextField field = new JTextField();
        JTextArea area = new JTextArea();
        field.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getExtendedKeyCode() == 10) {

                    text = text.concat("  " + date() + ": " +field.getText()+"\n");

                    area.setText(""+text);

                    field.setText("");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

        });
        btn1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount()==1){

                    text = text.concat("  " + date() + ": " +field.getText()+"\n");

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

        btn1.setSize(50, 20);
        btn1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // text.concat(ln);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        sendPanel.add(field, BorderLayout.CENTER);
        sendPanel.add(btn1, BorderLayout.EAST);


        upPanel.add(sendPanel, BorderLayout.SOUTH);

        upPanel.add(jscroll, BorderLayout.EAST);

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










