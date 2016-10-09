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
			int length;
			DataInputStream dis = new DataInputStream(socket.getInputStream());
            FileOutputStream fos = new FileOutputStream(new File("/home/nightwatcher/workspace/Chat/Chat/bin/tmp2.txt"));
            byte inputByte[] = new byte[1024];
            System.out.println("开始接收数据...");
            while ((length = dis.read(inputByte, 0, inputByte.length)) > 0) {
                System.out.println(length);
                fos.write(inputByte, 0, length);
                fos.flush();
            }
            fos.close();
            System.out.println("完成接收");
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