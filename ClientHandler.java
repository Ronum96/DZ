package ServerSide.Service;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;

public class ClientHandler {

    private MyServer myServer;
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private String name;

    public ClientHandler(MyServer myServer, Socket socket) {
        try {
            this.myServer = myServer;
            this.socket = socket;
            this.dis = new DataInputStream(socket.getInputStream());
            this.dos = new DataOutputStream(socket.getOutputStream());
            this.name ="";

            new Thread(()->{
                try {
                    authentication();
                    readMessage();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }finally {
                    closeConnection();
                }
            }).start();
        }catch (IOException e) {
            System.out.println(" Server error, go to admin");
        }
    }

    private void authentication() throws IOException {
        while (true){
            String authStr = dis.readUTF();
            if(authStr.startsWith("/auth")){
                String [] arr = authStr.split("\\s");

                if(arr.length==3){
                    String nick = myServer
                            .getAuthService()
                            .getNickByLoginAndPassword(arr[1], arr[2]);
                    if(!nick.isEmpty()){
                        if(!myServer.isNickBusy(nick)){
                            sendMessage("/authok" + " " + nick);
                            name = nick;
                            myServer.subscribe(this);
                            myServer.sendMessageToClients(nick + " joined to chat");
                            return;
                        }else{
                            sendMessage("This user '" + name + "' alrdy in chat. ");
                        }
                    }}else {
                    sendMessage("Wrong login/password");
                }
            }
        }
    }

    public void sendMessage(String message) {
        try {
            dos.writeUTF(message);
        } catch (IOException ignored) {
        }
    }

    public String getName() {
        return name;
    }

    private void readMessage() throws IOException {
        while(true) {
            String messageFromClient = dis.readUTF();
            if (messageFromClient.equals("/q")) {
                sendMessage(messageFromClient);
                return;
            }
            if (messageFromClient.startsWith("/w")) {
                String[] incomeMessageOriginal = messageFromClient.split("\\s");
                String[] incomeMessageReworked = Arrays.copyOfRange(incomeMessageOriginal, 2, incomeMessageOriginal.length);
                String name = incomeMessageOriginal[1];
                String outputMessage = String.join(" ", incomeMessageReworked);
                myServer.sendPrivateMessage(outputMessage, name, this.getName());
            } else {
                myServer.sendMessageToClients(name + ": " + messageFromClient);
            }
        }
    }

    private void closeConnection(){
        myServer.unSubscribe(this);
        myServer.sendMessageToClients(name + " leave chat");
        try {
            dos.flush();
        } catch (IOException ignored) {
        }
        try {
            dis.close();
        } catch (IOException ignored) {
        }
        try {
            dos.close();
        } catch (IOException ignored) {
        }
        try {
            socket.close();
        } catch (IOException ignored) {
        }
    }
}