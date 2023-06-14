package Phone;

public class SmartPhone extends Phone implements SurfInternet, TakePhoto, PlayVideo {

    // @Override
    // public void sendSMS() {
    //     System.out.println("SmartPhone sendSMS");
    // }

    // @Override
    // public void makeCall() {
    //     System.out.println("SmartPhone makeCall");
    // }
    
    public void surfInternet(){
        System.out.println("SmartPhone surfInternet");
    }

    public void playVideo(){
        System.out.println("SmartPhone playVideo");
    }

    public void takePhoto(){
        System.out.println("SmartPhone takePhoto");
    }

}
