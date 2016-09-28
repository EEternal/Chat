import java.io.*;
import java.net.*;
public class GetMessage extends Thread{
	private
		Socket socket;
	public
		GetMessage(Socket socket){
			this.socket = socket;
		}
		public void run(){
			try{
				BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String line = is.readLine();
				while(!line.equals("bye")){
					System.out.println(line);
					line = is.readLine();
				}
				System.out.println("bye");
			}catch (IOException e){
				System.out.println("Error:"+e);
			}
		}
}
