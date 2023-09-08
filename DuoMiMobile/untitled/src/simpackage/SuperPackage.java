package simpackage;

public class SuperPackage extends ServicePackage{
       double MAX_CALL = 200;
       double MAX_SEND = 50;
       double MAX_FLOW = 1024;

    public SuperPackage() {
        super();
        price = 78;
    }

    @Override
    public String getPackageKind() {
        return "超人套餐";
    }

    @Override
    public void showInfo() {
        System.out.println("套餐类型：" + this.getPackageKind());
        System.out.println("通话时长：" + getRealTalkTime() + "/"+MAX_CALL+"分钟,套餐外产生费用：" + call(0) + "元");
        System.out.println("短信条数：" + getRealSMSCount() + "/"+MAX_SEND+"条,套餐外产生费用：" + send(0) + "元");
        System.out.println("上网流量：" + getRealFlow()+"/"+MAX_FLOW+ "MB,套餐外产生费用：" + net(0) + "元");
        System.out.println("套餐月资费：" + price + "元");
        System.out.println("产生费用总计：" + getConsumAmount() + "元");
    }

    @Override
    public double call(double value) {
        realTalkTime += value;
        if (realTalkTime <= MAX_CALL) {
            return 0;
        } else {
            return (realTalkTime - MAX_CALL) * 0.2;
        }
    }

    @Override
    public double net(double value) {
        realFlow+= value;
        if (realFlow <= MAX_FLOW) {
            return 0;
        } else {
            return (realFlow - MAX_FLOW) * 0.1;//0.1元/MB
        }
    }

    @Override
    public double send(double value) {
        realSMSCount += value;
        if (realSMSCount <= MAX_SEND) {
            return 0;
        } else {
            return (realSMSCount - MAX_SEND) * 0.1;
        }
    }
}
