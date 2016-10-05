import java.io.*;
import java.net.*;
public class SendMessage extends Thread{
	private
		Socket socket;
	public SendMessage(Socket socket){
			this.socket = socket;
		}
	public void run(){
		try{
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			String line = sin.readLine();
//			boolean flag1 = true;
//			String flag2 = "c";
			while(!line.equals("bye")){
//				if(flag1){
//					os.println(flag2);
//					os.flush();
//					flag1 = false;
//				}
				os.println(line);
				os.flush();
				line = sin.readLine();
			}
			os.println(line);
			os.flush();
			os.close();
			sin.close();
			socket.close();
		}catch(IOException e){
			System.out.println("Error:"+e);
		}
	}
}
