public class test {
    public static void main(String[] args) {
        IUSB fan = new Usbfan();
        IUSB disk = new Udisk(); 
        
        fan.service();
        disk.service();
    }
}
