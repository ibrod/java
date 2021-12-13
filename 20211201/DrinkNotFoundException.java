 public class DrinkNotFoundException extends Exception{
    DrinkNotFoundException(){
        super();
    }
    DrinkNotFoundException(String msg){
        super(msg);
    }
    DrinkNotFoundException(String msg,Throwable cause){
        super(msg,cause);
    }
    DrinkNotFoundException(Throwable cause){
        super(cause);
    }
}