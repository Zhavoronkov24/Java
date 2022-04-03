package Less6;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) throws IOException{
        serverSocket = new ServerSocket(port);
        System.out.println("Сервер запущен, ожидаем подключения...");
        clientSocket = serverSocket.accept();
        System.out.println("Клиент подключился...");
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputline;
        while ((inputline = in.readLine()) !=null){
            if (".".equals(inputline)){
                out.println("good bye");
                break;
            }
            out.println(inputline);
        }
    }

    public static void main(String[] args) throws IOException {
        EchoServer echoServer = new EchoServer();
        echoServer.start(9999);
    }
}
