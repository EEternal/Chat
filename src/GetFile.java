import java.io.*;
import java.net.*;
public class GetFile extends Thread{
	private
		Socket socket;
	public
		GetFile(Socket socket){
			this.socket = socket;
		}
		public void run(){
			try{
				BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedWriter bw = new BufferedWriter(new FileWriter("/home/nightwatcher/workspace/Chat/bin/tmp2.txt"));
				String line = is.readLine();
				while(!(line == null)){
					bw.write(line);
					line = is.readLine();
					bw.flush();
				}
				bw.close();
			}catch (IOException e){
				System.out.println("Error:"+e);
			}
//			try{
//				BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//				String line = is.readLine();
//				BufferedWriter bw = new BufferedWriter(new FileWriter("/home/nightwatcher/workspace/Chat/bin/tmp2.txt"));
//				while(!(line == null || line.trim().length() == 0)){
//					bw.write(line);
//					line = is.readLine();
//					bw.flush();
//				}
//				bw.close();
//			}catch (IOException e){
//				System.out.println("Error:"+e);
//			}
		}
}