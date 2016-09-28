import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
public class MultiTalkServer{
	static int clientnum = 0;
	public void work() throws IOException{
		ServerSocket serverSocket = new ServerSocket(4700);
		List<Socket> sockets = new ArrayList<Socket>();
		Socket socket = null;
		boolean listening = true;
		while(listening){
			socket = serverSocket.accept();
			clientnum++;
			System.out.println("The "+clientnum+" client is connecting");
			sockets.add(socket);
			new ServerThread(clientnum, socket, sockets).start();
		}
		serverSocket.close();
	}
	public static void main(String args[]) throws IOException{
		MultiTalkServer multiTalkServer = new MultiTalkServer();
		multiTalkServer.work();
	}
}
