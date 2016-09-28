import java.io.*;
import java.net.*;
import java.util.List;
public class ServerThread extends Thread{
	private
		Socket socket;
		List<Socket> sockets;
		int clientnum;
	public 
		ServerThread(int clientnum, Socket socket, List<Socket> sockets){
			this.clientnum = clientnum;
			this.socket = socket;
			this.sockets = sockets;
		}
		public void run(){
			try {
				BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String line = is.readLine();
				PrintWriter os = null;
				while (!line.equals("bye")){
					for(int i=0; i<sockets.size(); i++){
						os = new PrintWriter(sockets.get(i).getOutputStream());
						os.println(clientnum+"say: "+line);
						os.flush();
					}
					line = is.readLine();
				}
				for(int i=0; i<sockets.size(); i++){
					os = new PrintWriter(sockets.get(i).getOutputStream());
					os.println(clientnum+"say: "+line);
					os.flush();
				}
				os.close();
				is.close();
				socket.close();
			}catch(Exception e){
				System.out.println("Error:"+e);
			}
		}
}
