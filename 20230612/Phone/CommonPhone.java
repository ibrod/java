package Phone;

public class CommonPhone implements Phone{

    @Override
    public void sendSMS() {
       System.out.println("CommonPhone sendSMS");
    }

    @Override
    public void makeCall() {
        System.out.println("CommonPhone makeCall");
    }

    public void playAudio(){
        System.out.println("CommonPhone playAudio");
    }
    
}
