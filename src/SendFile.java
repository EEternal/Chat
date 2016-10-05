import java.io.*;
import java.net.*;
public class SendFile extends Thread{
	private
		Socket socket;
	public
		SendFile(Socket socket){
			this.socket = socket;
		}
	public void run(){
		try {
			int length;
			byte[] sendBytes;
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			File file = new File("/home/nightwatcher/workspace/Chat/bin/tmp1.txt");
			FileInputStream fis = new FileInputStream(file);
			sendBytes = new byte[1024];
			while ((length = fis.read(sendBytes, 0, sendBytes.length)) > 0) {
				dos.write(sendBytes, 0, length);
				dos.flush();
			}
			fis.close();
			dos.close();
		}catch (Exception e) {
        	e.printStackTrace();
		}
		
		
		
//		try{
//			int n = 512, c = 0;
//			FileInputStream rf = new FileInputStream("/home/nightwatcher/workspace/Chat/bin/tmp1.txt");
//			PrintWriter os = new PrintWriter(socket.getOutputStream());
//			byte buffer[] = new byte[n];
//			while((c=rf.read(buffer, 0, n))!=-1){
//				os.println(new String(buffer, 0, c));
//				os.flush();
//			}
//			rf.close();
//		}catch(IOException e){
//			System.out.println(e);
//		}

		
		
//		try{
//			BufferedReader sin = new BufferedReader(new InputStreamReader(new FileInputStream("/home/nightwatcher/workspace/Chat/bin/tmp1.txt")));
//			PrintWriter os = new PrintWriter(socket.getOutputStream());
//			String line = sin.readLine();
//			while(!(line == null || line.trim().length() == 0)){
//				//os.println(line);
//				os.flush();
//				line = sin.readLine();
//			}
//			os.close();
//			sin.close();
//			socket.close();
//		}catch(IOException e){
//			System.out.println("Error:"+e);
//		}
	}
}