public class fac {
    public static goods getGoods(String name){
        goods gds=null;
        if(name.equals("fea")){
            gds=new fea();
        }else if(name.equals("foods")){
            gds=new foods();
        }
        return gds;
    }
}
