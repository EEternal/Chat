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
	public static void main(String args[]) throws IOException{
		Client client = new Client(args[0]);
		System.out.println("Please input c(chat) or f(file transfer)");
		String cmd;
		Scanner sc = new Scanner(System.in);
		cmd = sc.next();
		switch(cmd){
			case "c":
			 client.startWork();
		}while(!cmd.equals("q"));
		sc.close();
	}
}
