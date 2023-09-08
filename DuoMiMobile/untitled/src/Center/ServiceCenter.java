package Center;

import simpackage.NetPackage;
import simpackage.ServicePackage;
import simpackage.SuperPackage;
import simpackage.TalkPackage;
import util.InputValidator;
import util.PhoneNumberGenerator;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class ServiceCenter {
    Map<String, MobileCard> numCard = new HashMap<String, MobileCard>();
    Map<String, Vector<ConsumInfo>> consumInfos = new HashMap<String, Vector<ConsumInfo>>();
    Scanner sc = new Scanner(System.in);

    public void menu() throws IOException {
        int choice = 0;
        String input;
        while (true) {
            System.out.println("********欢迎使用嗖嗖移动业务大厅********");
            System.out.println("1.用户登录\t2.用户注册\t3.使用嗖嗖\t4.话费充值\t5.资费说明\t6.退出系统");
            System.out.print("请选择:");
            input = sc.nextLine();
            if (!InputValidator.isValidInt(input, 1, 6)) {
                System.out.println("输入有误，请重新输入！");
                continue;
            }
            choice = Integer.parseInt(input);
            switch (choice) {
                case 1:
                    if(numCard.size()==0){
                        System.out.println("当前没有用户，请先注册！");
                        continue;
                    }
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    useSoSo();
                    break;
                case 4:
                    chargeMoney();
                    break;
                case 5:
                    describe();
                    break;
                case 6:
                    System.out.println("感谢您的使用，Bye~");
                    System.exit(0);
                    break;
            }
        }
    }

    public void login() throws IOException {
        System.out.println("请输入手机号：");
        String phoneNum = sc.nextLine();
        if (!numCard.containsKey(phoneNum)) {
            System.out.println("该号码不存在！");
            return;
        }
        System.out.println("请输入密码：");
        String passWord = sc.nextLine();
        if (!numCard.get(phoneNum).passWord.equals(passWord)) {
            System.out.println("密码错误！");
            return;
        }
        System.out.println("登录成功！");
        System.out.println("号码：" + phoneNum);
        System.out.println("姓名：" + numCard.get(phoneNum).getName());
        System.out.println("当前余额：" + numCard.get(phoneNum).getBalance());
        System.out.println("套餐类型：" + numCard.get(phoneNum).getSerPackage().getPackageKind());
        System.out.println("当前已使用通话时长：" + numCard.get(phoneNum).getSerPackage().getRealTalkTime() + "分钟");
        System.out.println("当前已使用短信条数：" + numCard.get(phoneNum).getSerPackage().getRealSMSCount() + "条");
        System.out.println("当前已使用上网流量：" + numCard.get(phoneNum).getSerPackage().getRealFlow() + "MB");
        System.out.println("---------------------------------");

        String input;

        while (true){
            System.out.println("1.本月账单查询\t2.套餐余量查询\t3.打印消费详单\t4.套餐变更\t5.办理退网");
            System.out.print("输入1-5选择功能，输入其他返回上一级:");
            input = sc.nextLine();
            if (!InputValidator.isValidInt(input, 1, 5)) {
                return;
            }
            switch (input){
                case "1":
                    System.out.println("本月账单查询");
                    System.out.println("您的号码："+phoneNum);
                    System.out.println("您的姓名："+numCard.get(phoneNum).getName());
                    System.out.println("您的套餐类型："+numCard.get(phoneNum).getSerPackage().getPackageKind());
                    System.out.println("您的消费金额："+numCard.get(phoneNum).getSerPackage().getConsumAmount());
                    System.out.println("您的账户余额："+numCard.get(phoneNum).getBalance());
                    break;
                case "2":
                    System.out.println("套餐余量查询");
                    System.out.println("您的号码："+phoneNum);
                    System.out.println("您的姓名："+numCard.get(phoneNum).getName());
                    numCard.get(phoneNum).getSerPackage().showInfo();
                case "3":
                    FileWriter fw = new FileWriter(phoneNum+"_"+ LocalDate.now().toString()+"账单.txt");
                    BufferedWriter bfw = new BufferedWriter(fw);
                    bfw.write("********"+LocalDate.now().toString()+"账单********");
                    bfw.newLine();
                    bfw.write("您的号码："+phoneNum);
                    bfw.newLine();
                    bfw.write("您的姓名："+numCard.get(phoneNum).getName());
                    bfw.newLine();
                    bfw.write("您的套餐类型："+numCard.get(phoneNum).getSerPackage().getPackageKind());
                    bfw.newLine();
                    bfw.write("您的消费金额："+numCard.get(phoneNum).getSerPackage().getConsumAmount());
                    bfw.newLine();
                    bfw.write("您的账户余额："+numCard.get(phoneNum).getBalance());
                    bfw.newLine();
                    bfw.write("通话时长:"+numCard.get(phoneNum).getSerPackage().getRealTalkTime()+"分钟");
                    bfw.newLine();
                    bfw.write("短信条数:"+numCard.get(phoneNum).getSerPackage().getRealSMSCount()+"条");
                    bfw.newLine();
                    bfw.write("上网流量:"+numCard.get(phoneNum).getSerPackage().getRealFlow()+"MB");
                    bfw.newLine();
                    bfw.write("您的消费明细：");
                    bfw.newLine();
                    for(ConsumInfo ci:consumInfos.get(phoneNum)){
                        bfw.write(ci.getInform());
                        bfw.newLine();
                    }
                    bfw.flush();
                    bfw.close();
                    fw.close();
                    break;
                case "4":
                    System.out.println("套餐变更");
                    System.out.println("请在变更套餐前确定你的余额足够支付新的套餐:\n1.话痨套餐\t2.网虫套餐\t3.超人套餐");
                    System.out.println("请选择套餐类型：");
                    input = sc.nextLine();
                    if (!InputValidator.isValidInt(input, 1, 3)) {
                        System.out.println("输入有误，请重新输入！");
                        continue;
                    }
                    switch (input){
                        case "1":
                            if (numCard.get(phoneNum).getBalance()<58){
                                System.out.println("您的余额不足以支付新套餐，请充值后再试！");
                                continue;
                            }
                            numCard.get(phoneNum).setSerPackage(new TalkPackage());
                            numCard.get(phoneNum).setMoney(numCard.get(phoneNum).getMoney()-numCard.get(phoneNum).getSerPackage().getConsumAmount());
                            consumInfos.get(phoneNum).add(new ConsumInfo("套餐扣费",58));
                            break;
                        case "2":
                            if (numCard.get(phoneNum).getBalance()<68){
                                System.out.println("您的余额不足以支付新套餐，请充值后再试！");
                                continue;
                            }
                            numCard.get(phoneNum).setSerPackage(new NetPackage());
                            numCard.get(phoneNum).setMoney(numCard.get(phoneNum).getMoney()-68);
                            consumInfos.get(phoneNum).add(new ConsumInfo("套餐扣费",68));
                            break;
                        case "3":
                            if (numCard.get(phoneNum).getBalance()<78){
                                System.out.println("您的余额不足以支付新套餐，请充值后再试！");
                                continue;
                            }
                            numCard.get(phoneNum).setSerPackage(new SuperPackage());
                            numCard.get(phoneNum).setMoney(numCard.get(phoneNum).getMoney()-78);
                            consumInfos.get(phoneNum).add(new ConsumInfo("套餐扣费",78));
                            break;
                    }
                    break;
                case "5":
                    numCard.remove(phoneNum);
                    consumInfos.remove(phoneNum);
                    System.out.println("办理退网成功！");
                    return;
            }
        }

    }

    public void describe() throws IOException {
        FileReader fr = new FileReader("Description.txt");
        BufferedReader bfr = new BufferedReader(fr);
        String line = null;
        while ((line = bfr.readLine()) != null) {
            System.out.println(line);
        }
    }

    public void useSoSo(){
        System.out.println("欢迎使用嗖嗖，请输入手机号：");
        String phoneNum = sc.nextLine();
        if (!numCard.containsKey(phoneNum)) {
            System.out.println("该号码不存在！");
            return;
        }
        if(numCard.get(phoneNum).getBalance()<0){
            System.out.println("您的手机号当前已经欠费,请充值后再使用！");
            return;
        }
        System.out.println("1.上网\t2.打电话\t3.发短信");
        String input = sc.nextLine();
        if (!InputValidator.isValidInt(input, 1, 3)) {
            System.out.println("输入有误");
            return;
        }
        double consumMoney=0;
        switch (input) {
            case "1":
                System.out.println("请输入上网流量(MB)：");
                input = sc.nextLine();
                if (!InputValidator.isValidDecimal(input)) {
                    System.out.println("输入有误");
                    return;
                }
                consumMoney=numCard.get(phoneNum).getBalance();
                numCard.get(phoneNum).getSerPackage().net(Double.parseDouble(input));
                consumMoney-=numCard.get(phoneNum).getBalance();
                consumInfos.get(phoneNum).add(new ConsumInfo("上网",Double.parseDouble(input),"MB",consumMoney));
                break;
            case "2":
                System.out.println("请输入通话时间(分钟)：");
                input = sc.nextLine();
                if (!InputValidator.isValidDecimal(input)) {
                    System.out.println("输入有误");
                    return;
                }
                consumMoney=numCard.get(phoneNum).getBalance();
                numCard.get(phoneNum).getSerPackage().call(Double.parseDouble(input));
                consumMoney-=numCard.get(phoneNum).getBalance();
                consumInfos.get(phoneNum).add(new ConsumInfo("通话",Double.parseDouble(input),"分钟",consumMoney));
                break;
            case "3":
                System.out.println("请输入短信条数：");
                input = sc.nextLine();
                if (!InputValidator.isValidInt(input)) {
                    System.out.println("输入有误");
                    return;
                }
                consumMoney=numCard.get(phoneNum).getBalance();
                numCard.get(phoneNum).getSerPackage().send(Integer.parseInt(input));
                consumMoney-=numCard.get(phoneNum).getBalance();
                consumInfos.get(phoneNum).add(new ConsumInfo("短信",Integer.parseInt(input),"条",consumMoney));
                break;
            default:
                System.out.println("输入有误");
                return;
        }
    }

    public void chargeMoney(){
        System.out.println("请输入要充值的号码：");
        String phoneNum = sc.nextLine();
        if (!numCard.containsKey(phoneNum)) {
            System.out.println("该号码不存在！");
            return;
        }

        System.out.println("请输一个正整数表示要充值的金额，输入0表示返回上级菜单");
        String input = sc.nextLine();
        if (!InputValidator.isValidInt(input)||Integer.parseInt(input)<0) {
            System.out.println("输入有误，请重新输入！");
            return;
        }
        if(Integer.parseInt(input)==0){
            return;
        }

        numCard.get(phoneNum).setMoney(numCard.get(phoneNum).getMoney()+Integer.parseInt(input));

        System.out.println("充值成功！当前余额为"+numCard.get(phoneNum).getBalance()+"元");

    }

    public void register() {
        Vector<String> phoneNums = new Vector<>();
        String phoneNum = null;
        System.out.println("**************可选择的号码**************");
        while (phoneNums.size() < 9) {
            phoneNum = PhoneNumberGenerator.generateRandomChinaPhoneNumber();
            if (phoneNums.contains(phoneNum)||numCard.containsKey(phoneNum)) {
                continue;
            }else{
                phoneNums.add(phoneNum);
                System.out.println((phoneNums.size()) + "." + phoneNum);
            }
        }

        while (true){
            System.out.println("请选择号码(1~9)：");
            String input = sc.nextLine();
            if (!InputValidator.isValidInt(input, 1, 9)) {
                System.out.println("输入有误，请重新输入！");
                continue;
            }
            phoneNum = phoneNums.get(Integer.parseInt(input) - 1);
            break;
        }

        phoneNums.add(phoneNum);
        System.out.println("请输入姓名：");
        String name = sc.nextLine();
        System.out.println("请输入密码：");
        String passWord = sc.nextLine();
        MobileCard card = null;
        do {
            System.out.println("请选择号码(1.话痨卡 2.网虫卡 3.超级卡)：");
            String cardType = sc.nextLine();
            switch (cardType) {
//                case "1":
//                    card = new MobileCard(phoneNum, name, passWord, new ServicePackage());
//                    break;
                case "1":
                    card = new MobileCard(name, phoneNum, passWord, new TalkPackage());
                    break;
                case "2":
                    card = new MobileCard(name, phoneNum, passWord, new NetPackage());
                    break;
                case "3":
                    card = new MobileCard(name, phoneNum, passWord, new SuperPackage());
                    break;
                default:
                    System.out.println("输入有误，请重新输入！");
                    continue;
            }
        }while (false);

        while (true){
            System.out.println("请输入预存话费金额，您当前的套餐是"+card.getSerPackage().getPackageKind()+"，预存金额至少为"+card.getSerPackage().price+"元：");
            String money = sc.nextLine();
            if (!InputValidator.isValidInt(money)) {
                System.out.println("输入有误，请重新输入！");
                continue;
            }
            if(Integer.parseInt(money)<card.getSerPackage().price){
                System.out.println("您当前的套餐预存金额至少为"+card.getSerPackage().price+"元，请重新输入！");
                continue;
            }
            card.setMoney(Integer.parseInt(money));
            break;
        }

        consumInfos.put(phoneNum,new Vector<ConsumInfo>());
        consumInfos.get(phoneNum).add(new ConsumInfo("套餐扣费",card.getSerPackage().price));

        numCard.put(phoneNum, card);
        System.out.println("注册成功！");
        System.out.println("号码：" + phoneNum);
        System.out.println("姓名：" + name);
        System.out.println("套餐类型：" + card.getSerPackage().getPackageKind());
        System.out.println("当前余额：" + card.getBalance());
        System.out.println("---------------------------------");
    }


}
