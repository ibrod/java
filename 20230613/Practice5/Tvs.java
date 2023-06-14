package Practice5;

public class Tvs extends Goods{
    private int sz;

    public Tvs(String name, double price, int sz){
        super(name, price);
        this.sz = sz;
    }

    public String getInfo(){
        return super.getInfo()+"，电视尺寸："+this.sz;
    }

    public int getSz(){
        return this.sz;
    }

    public void setSz(int sz){
        this.sz = sz;
    }


}
