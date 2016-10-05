import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Client{
	private 
		String ip;
	public 
		Client(String ip){
			this.ip = ip;
		}
		void startWork() throws IOException{
			Socket socket = new Socket(ip, 4700);
			new GetMessage(socket).start();
			new SendMessage(socket).start();
		}
		void getFile() throws IOException{
			Socket socket = new Socket(ip, 4700);
			new GetFile(socket).start();
		}
		void sendFile() throws IOException{
			Socket socket = new Socket(ip, 4700);
			new SendFile(socket).start();
		}
	public static void main(String args[]) throws IOException{
		Client client = new Client(args[0]);
		System.out.println("Please input c(chat), s(send file) or g(get file)");
		String cmd;
		Scanner sc = new Scanner(System.in);
		cmd = sc.next();
		switch(cmd){
			case "c":{
				 client.startWork();
				 System.out.println("Typing again to confirm it.");
				 break;
			 }
			case "g":{
				client.getFile();
				//System.out.println("Typing again to confirm it.");
				break;
			}
			case "s":{
				client.sendFile();
				//System.out.println("Typing again to confirm it.");
				break;
			}
		}while(!cmd.equals("q"));
		sc.close();
	}
}
