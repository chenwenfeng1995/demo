package demo.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class LengthCalculation extends Thread{

	private Socket socket;

	public LengthCalculation(Socket socker) {
		super();
		this.socket = socker;
	}
	
	public void run() {
		try {
			OutputStream out =socket.getOutputStream();
			InputStream  in  =socket.getInputStream();
			int ch=0;
			byte[] buffer =new byte[1024];
			ch =in.read(buffer);
			String content =new String(buffer,0,ch);
			System.out.println(content);
			out.write(String.valueOf(content.length()).getBytes());
			in.close();
			out.close();
			socket.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
