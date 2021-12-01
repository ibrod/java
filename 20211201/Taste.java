public class Taste{

    public static void taste(int tp) throws DrinkNotFoundException {
        switch (tp) {
            case 1:
                System.out.println("咖啡：苦");
                break;
            case 2:
                System.out.println("啤酒：微苦");
                break;
            case 3:
                System.out.println("牛奶：甜");
                break;
            default:
                throw new DrinkNotFoundException("对不起！没有您输入的饮料类型。");
        }
    }

}