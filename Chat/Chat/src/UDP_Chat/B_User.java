package UDP_Chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class B_User implements Runnable {
    @Override
    public void run() {
        // 多线程的方式实现javaUDP聊天
        //服务器端
        byte[] bufrec = new byte[1024];
        try {
            DatagramSocket socket = new DatagramSocket(8888);
            while (true) {
                //用于接收数据的数据报
                DatagramPacket receivPacket = new DatagramPacket(bufrec, bufrec.length);
                socket.receive(receivPacket);
                String received = new String(receivPacket.getData(), 0, receivPacket.getLength());
                System.out.println("A说:" + received);
                if (received.equals("bye")) {
                    break;
                }
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("我是B");
        B_User server = new B_User();
        Thread thread = new Thread(server);
        thread.start();
        byte[] bufsend = new byte[1024];
        try {
            DatagramSocket socket = new DatagramSocket();
            Scanner input = new Scanner(System.in);
           while (true) {
                System.out.println("请输入要发送的内容:");
                String message = input.nextLine();
                bufsend = message.getBytes();
                //用于发送数据的数据
                DatagramPacket packet = new DatagramPacket(bufsend, message.length(),InetAddress.getLocalHost(), 9999);
                socket.send(packet);
                if (message.equals("bye")) {
                    break;
                }
           }
            socket.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
