package UDP_Chat;

//使用UDP搭建Java聊天室APP
//服务端
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class A_User implements Runnable {
    @Override
    public void run() {
        byte[] bufrec = new byte[1024];
        try {
            DatagramSocket socket = new DatagramSocket(9999);
            while (true) {
                //用于接收数据的数据报
                DatagramPacket receivPacket = new DatagramPacket(bufrec, bufrec.length);
                socket.receive(receivPacket);
                String received = new String(receivPacket.getData(), 0, receivPacket.getLength());
                System.out.println("B说:" + received);
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
        System.out.println("我是A");
        A_User client = new A_User();
        Thread thread = new Thread(client);
        thread.start();
        byte[] bufsend = new byte[1024];
        try {
            DatagramSocket socket = new DatagramSocket();
            Scanner input = new Scanner(System.in);
           while (true) {
                System.out.println("请输入要发送的内容：");
                String message = input.nextLine();
                bufsend = message.getBytes();
                //用于发送数据的数据报
                DatagramPacket packet = new DatagramPacket(bufsend, message.length(),InetAddress.getLocalHost(), 8888);
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
