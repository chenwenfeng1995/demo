package demo.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClient {

	public static void main(String[] args) throws Exception {
		DatagramSocket  socket =new DatagramSocket();
		byte[] buf="hello world".getBytes();
		InetAddress address= InetAddress.getByName("127.0.0.1");
		DatagramPacket packet =new DatagramPacket(buf,buf.length,address,65001);
		socket.send(packet);
		byte[]buff=new byte[1024];
		DatagramPacket receivedPacket =new DatagramPacket(buff,buff.length);
		socket.receive(receivedPacket);
		String content=new String(receivedPacket.getData(),0,receivedPacket.getLength());
		System.out.println(content);
	}
}
