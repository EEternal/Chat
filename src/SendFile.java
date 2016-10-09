import java.io.*;
import java.net.*;
public class SendFile extends Thread{
	private
		Socket socket;
	public SendFile(Socket socket){
			this.socket = socket;
		}
	public void run(){
		try{
//			BufferedReader br = new BufferedReader(new FileReader("/home/nightwatcher/workspace/Chat/Chat/bin/tmp1.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			String line = br.readLine();
			while(!line.equals("bye")){
				os.println(line);
				os.flush();
				line = br.readLine();
			}
			os.flush();
			os.close();
			br.close();
		}catch(IOException e){
			System.out.println("Error:"+e);
		}
	}
}
