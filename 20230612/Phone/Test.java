package Phone;

public class Test {
    public static void main(String[] args) {

        //smartPhone
        Phone phone = new SmartPhone();
        phone.sendSMS();
        phone.makeCall();
        // phone.surfInternet();
        // phone.playVideo();
        // phone.takePhoto();
        SmartPhone smartPhone = (SmartPhone)phone;
        smartPhone.surfInternet();
        smartPhone.playVideo();
        smartPhone.takePhoto();

        System.out.println("====================================");

        //commonPhone
        phone = new CommonPhone();
        phone.sendSMS();
        phone.makeCall();
        // phone.playAudio();
        CommonPhone commonPhone = (CommonPhone)phone;
        commonPhone.playAudio();

        PlayAudio playAudio = (PlayAudio)phone;
        playAudio.playAudio();
    }
}
