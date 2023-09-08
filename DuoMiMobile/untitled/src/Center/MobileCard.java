package Center;

import simpackage.ServicePackage;

public class MobileCard {
    String name;
    String cardNumber;

    String passWord;

    ServicePackage serPackage;


    public MobileCard() {
    }


    public MobileCard(String name, String cardNumber, String passWord, ServicePackage serPackage, double money) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.passWord = passWord;
        this.serPackage = serPackage;
        this.money = money;
    }

    public MobileCard(String name, String cardNumber, String passWord, ServicePackage serPackage) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.passWord = passWord;
        this.serPackage = serPackage;
    }

    double money;//月总充值金额

    public double getMoney() {
        return money;
    }

    public double getBalance(){//月内实时剩余金额
        return money-serPackage.getConsumAmount();
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public ServicePackage getSerPackage() {
        return serPackage;
    }

    public void setSerPackage(ServicePackage serPackage) {
        this.serPackage = serPackage;
    }

}
