package simpackage;

import service.CallService;
import service.NetService;
import service.SendService;

public class ServicePackage implements CallService, NetService, SendService {

    double realTalkTime;
    double realSMSCount;
    double realFlow;

    public double price;//套餐月资费

    public double getConsumAmount() {
        return price + call(0) + net(0) + send(0);
    }


    public ServicePackage() {
        this.realTalkTime = 0;
        this.realSMSCount = 0;
        this.realFlow = 0;
        this.price = 0;
    }

    public double getRealTalkTime() {
        return realTalkTime;
    }

    public double getRealSMSCount() {
        return realSMSCount;
    }

    public double getRealFlow() {
        return realFlow;
    }

    public String getPackageKind() {
        return "普通话费套餐";
    }

    public void showInfo() {
        System.out.println("套餐类型：" + this.getPackageKind());
        System.out.println("通话时长：" + getRealTalkTime() + "分钟,套餐外产生费用：" + call(0) + "元");
        System.out.println("短信条数：" + getRealSMSCount() + "条,套餐外产生费用：" + send(0) + "元");
        System.out.println("上网流量：" + getRealFlow() + "MB,套餐外产生费用：" + net(0) + "元");
        System.out.println("套餐月资费：" + price + "元");
        System.out.println("产生费用总计：" + getConsumAmount() + "元");
    }

    @Override
    public double call(double value) {
        realTalkTime += value;
        return 0.2 * realTalkTime;//0.2元/分钟
    }

    @Override
    public double net(double value) {
        realFlow+= value;
        return 0.1* realFlow;//0.1元/MB
    }

    @Override
    public double send(double value) {
        realSMSCount += value;
        return 0.1* realSMSCount;//0.1元/条
    }
}
