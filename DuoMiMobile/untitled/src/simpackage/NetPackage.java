package simpackage;

public class NetPackage extends ServicePackage {

    double MAX_FLOW = 3 * 1024;//3GB

    public NetPackage() {
        super();
        this.price = 68;
    }

    @Override
    public String getPackageKind() {
        return "网虫套餐";
    }

    @Override
    public void showInfo() {
        System.out.println("套餐类型：" + this.getPackageKind());
        System.out.println("通话时长：" + getRealTalkTime() + "分钟,套餐外产生费用：" + call(0) + "元");
        System.out.println("短信条数：" + getRealSMSCount() + "条,套餐外产生费用：" + send(0) + "元");
        System.out.println("上网流量：" + getRealFlow()+"/"+MAX_FLOW+ "MB,套餐外产生费用：" + net(0) + "元");
        System.out.println("套餐月资费：" + price + "元");
        System.out.println("产生费用总计：" + getConsumAmount() + "元");
    }

    @Override
    public double net(double value) {
        //3GB内使用套餐余量，超出后按普通计费
        realFlow += value;
        if (realFlow <= 3 * 1024) {
            return 0;
        } else {
            return (realFlow - 3 * 1024) * 0.1;//0.1元/MB
        }
    }
}
