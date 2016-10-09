import java.io.*;
import java.net.*;
public class GetMessage extends Thread{
	private
		Socket socket;
	public GetMessage(Socket socket){
			this.socket = socket;
		}
		public void run(){
			try{
				BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedWriter bw = new BufferedWriter(new FileWriter("/home/nightwatcher/workspace/Chat/Chat/bin/tmp2.txt"));
				String line = is.readLine();
//				if(line.equals("c"))
//					line = is.readLine();
				while(!line.equals("bye")){
					//System.out.println(line);
					bw.write(line);
					bw.flush();
					line = is.readLine();
				}
				bw.close();
				is.close();
				System.out.println("bye");
			}catch (IOException e){
				System.out.println("Error:"+e);
			}
		}
}
