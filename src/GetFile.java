import java.io.*;
import java.net.*;
public class GetFile extends Thread{
	private
		Socket socket;
	public GetFile(Socket socket){
			this.socket = socket;
		}
		public void run(){
			try{
				BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedWriter bw = new BufferedWriter(new FileWriter("/home/nightwatcher/workspace/Chat/Chat/bin/tmp2.txt"));
				String line = is.readLine();
//				if(line.equals("c"))
//					line = is.readLine();
				while(line!=null){
//				while(!line.equals("bye")){
					//System.out.println(line);
					bw.write(line);
					bw.write('\n');
					bw.flush();
					line = is.readLine();
				}
				bw.close();
				is.close();
			}catch (IOException e){
				System.out.println("Error:"+e);
			}
		}
}
