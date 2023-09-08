package util;

import java.util.Random;

public class PhoneNumberGenerator {

    // 中国手机号码前缀
    private static final String[] CHINA_PREFIXES = {"130", "131", "132", "133", "134", "135", "136", "137", "138", "139",
            "147", "150", "151", "152", "153", "155", "156", "157", "158", "159",
            "166", "171", "176", "177", "178", "181", "182", "183", "184", "185",
            "186", "187", "188", "189", "198", "199"};

    /**
     * 生成随机手机号码（中国）
     * @return 随机手机号码
     */
    public static String generateRandomChinaPhoneNumber() {
        Random random = new Random();
        // 选择一个随机前缀
        String prefix = CHINA_PREFIXES[random.nextInt(CHINA_PREFIXES.length)];

        // 生成随机的后八位数字
        StringBuilder lastEightDigits = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            lastEightDigits.append(random.nextInt(10));
        }

        return prefix + lastEightDigits.toString();
    }

}
