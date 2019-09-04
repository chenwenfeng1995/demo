package demo.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPClient {

	public static void main(String[] args) throws IOException {
		Socket ss=new Socket("127.0.0.1",6500);
		OutputStream out = ss.getOutputStream();
		InputStream in =ss.getInputStream();
		out.write(new String("hello world").getBytes());
		int ch=0;
		byte[] buffer =new byte[1024];
		ch=in.read(buffer);
		String content =new String(buffer,0,ch);
		System.out.println(content);
		in.close();
		out.close();
		ss.close();
	}
}
