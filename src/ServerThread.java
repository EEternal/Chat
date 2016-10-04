import java.io.*;
import java.net.*;
import java.util.List;
public class ServerThread extends Thread{
	private
		Socket socket;
		List<Socket> sockets;
		int clientnum;
	public ServerThread(int clientnum, Socket socket, List<Socket> sockets){
		this.clientnum = clientnum;
		this.socket = socket;
		this.sockets = sockets;
	}
	public void run(){
		try{
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));	
			String str = is.readLine();
			if(str.equals("c"))
				chat();
			if(str.equals("f"))
				file();
			is.close();
		}catch(Exception e){
			System.out.println("Error:"+e);
		}
	}
	public void file(){
		try {
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));				
			String line = is.readLine();
			PrintWriter os = null;
			while (line!=null){
				for(int i=0; i<sockets.size(); i++){
					if(i == clientnum-1)
						continue;
					os = new PrintWriter(sockets.get(i).getOutputStream());
					os.println(line);
					os.flush();
				}
				line = is.readLine();
			}
			os.close();
			socket.close();
		}catch(Exception e){
			System.out.println("Error:"+e);
		}
	}
	public void chat(){
		try {
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));				
			String line = is.readLine();
			PrintWriter os = null;
			while (!line.equals("bye")){
				for(int i=0; i<sockets.size(); i++){
					if(i == clientnum-1)
						continue;
					os = new PrintWriter(sockets.get(i).getOutputStream());
					os.println(clientnum+"say: "+line);
					os.flush();
				}
				line = is.readLine();
			}
			os.close();
			is.close();
			socket.close();
		}catch(Exception e){
			System.out.println("Error:"+e);
		}
	}
}
