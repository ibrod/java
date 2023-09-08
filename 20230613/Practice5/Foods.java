package Practice5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Foods extends Goods{
    private LocalDate date;

    public Foods(String name, double price, LocalDate date){
        super(name, price);
        this.date = date;
    }

    public String getInfo(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        return super.getInfo()+"，保质期："+this.date.format(formatter);
    }

    public LocalDate getDate(){
        return this.date;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }
}
