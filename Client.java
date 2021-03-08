import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client extends JFrame {

    public static void main(String[] args) {
        new Client();


    }

    public Client() {
        Windows();

        Socket socket;
        PrintWriter writer;
        BufferedReader reader;

        final String IP_ADRESS = "localhost";
        final int PORT = 8181;


        try {
            socket = new Socket(IP_ADRESS, PORT);
            writer = new PrintWriter(socket.getOutputStream());
            InputStreamReader in = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(in);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            Scanner sc1 = new Scanner(System.in);
                            String str = sc1.nextLine();
                            writer.println(str);
                            writer.flush();
                            if (str.equalsIgnoreCase("/end")) break;
                        }
                    }
                    finally {
                        try {
                            socket.close();
                            System.exit(0);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String str2 = reader.readLine();
                            System.out.println("Server: " + str2);

                        }
                    } catch (IOException e) {
                        e.printStackTrace();

                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static String text="";


    public void Windows() {
        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 200, 600, 600);



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

                    text = text.concat("  " + field.getText()+"\n");

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

                    text = text.concat("  " + field.getText()+"\n");

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
        upPanel.add(area, BorderLayout.CENTER);


        add(upPanel);
        setVisible(true);

    }








}