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
			else if(str.equals("s")){
				file();
//				System.out.println("File()");
			}
			is.close();
		}catch(Exception e){
			System.out.println("Error:"+e);
		}
	}
	public void file(){
		try {
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String ID = is.readLine();
			String line = is.readLine();
//			System.out.println("here");
			if (line==null)
				System.out.println("null");
			PrintWriter os = null;
//			while (!line.equals("bye")){
			int j=Integer.parseInt(ID)-1;
			while(line!=null){
				//System.out.println(line);
				os = new PrintWriter(sockets.get(j).getOutputStream());
				os.println(line);
				os.flush();
//				for(int i=0; i<sockets.size(); i++){
//					if(i == clientnum-1)
//						continue;
//					os = new PrintWriter(sockets.get(i).getOutputStream());
//					os.println(line);
//					os.flush();
//				}
				line = is.readLine();
			}
			os.close();
			is.close();
			socket.close();
		}catch(Exception e){
			System.out.println("Error:"+e);
		}
	}
	public void chat(){
		try {
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));				
			String ID = is.readLine();
			String line = is.readLine();
			PrintWriter os = null;
			while (!line.equals("bye")){
//				for(int i=0; i<sockets.size(); i++){
//					if(i == clientnum-1)
//						continue;
//					os = new PrintWriter(sockets.get(i).getOutputStream());
//					os.println(clientnum+"say: "+line);
//					os.flush();
//				}
				int i=Integer.parseInt(ID)-1;
				os = new PrintWriter(sockets.get(i).getOutputStream());
				os.println(clientnum+"say: "+line);
				os.flush();
				ID = is.readLine();
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
