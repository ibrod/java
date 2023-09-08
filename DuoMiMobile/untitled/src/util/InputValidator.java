package util;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class InputValidator {

    // 校验输入的字符串是否为规定数值大小范围内的数字（使用long）
    public static boolean isValidLong(String input, long min, long max) {
        try {
            long value = Long.parseLong(input);
            return value >= min && value <= max;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean isValidLong(String input) {
        try {
            long value = Long.parseLong(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // 校验输入的字符串是否为规定数值大小范围内的数字（使用int）
    public static boolean isValidInt(String input, int min, int max) {
        try {
            int value = Integer.parseInt(input);
            return value >= min && value <= max;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean isValidInt(String input) {
        try {
            int value = Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // 校验输入的字符串是否包含空格
    public static boolean containsWhitespace(String input) {
        return input != null && input.contains(" ");
    }

    // 校验字符串是否为正确的邮箱格式
    public static boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // 校验输入的日期是否符合规范
    public static boolean isValidDate(int year, int month, int day) {
        if (year < 0 || month < 1 || month > 12 || day < 1 || day > 31) {
            return false;
        }
        if (month == 2) {
            return day <= (isLeapYear(year) ? 29 : 28);
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return day <= 30;
        }
        return true;
    }

    // 校验输入的日期是否符合规范
    public static boolean isValidDate(String dateStr, String delimiter) {
        String[] parts = dateStr.split(Pattern.quote(delimiter));
        if (parts.length != 3) {
            return false;
        }
        try {
            int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[2]);
            return isValidDate(year, month, day);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // 校验输入的时间是否符合规范
    public static boolean isValidTime(int hour, int minute, int second) {
        return hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59 && second >= 0 && second <= 59;
    }

    // 校验输入的时间是否符合规范
    public static boolean isValidTime(String timeStr, String delimiter) {
        String[] parts = timeStr.split(Pattern.quote(delimiter));
        if (parts.length != 3) {
            return false;
        }
        try {
            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);
            int second = Integer.parseInt(parts[2]);
            return isValidTime(hour, minute, second);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // 判断是否是闰年
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // 判断输入的字符串是否为规定保留小数范围内的小数
    public static boolean isValidDecimal(String input, int maxDecimalPlaces) {
        try {
            Double value = Double.parseDouble(input);
            String[] parts = input.split("\\.");
            if (parts.length == 2 && parts[1].length() <= maxDecimalPlaces) {
                return true;
            }
            if (parts.length == 1) {
                return true; // 整数也算小数（保留0位小数）
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // 判断输入的字符串是否为小数
    public static boolean isValidDecimal(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // 判断输入的字符串是否为规定数值范围内的小数
    public static boolean isValidDecimal(String input, double min, double max) {
        try {
            double value = Double.parseDouble(input);
            return value >= min && value <= max;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // 判断输入的字符串是否为合法的分式 (格式为 x/y)
    public static boolean isValidFraction(String input) {
        String[] parts = input.split("/");
        if (parts.length != 2) {
            return false;
        }
        try {
            long numerator = Long.parseLong(parts[0]);
            long denominator = Long.parseLong(parts[1]);
            return denominator != 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // 判断两个分式的大小 (即判断不存在精度误差)
    public static int compareFractions(long num1, long den1, long num2, long den2) {
        return Long.compare(num1 * den2, num2 * den1);
    }

    // 判断输入的字符串是否为规定数值范围内的分式 (即判断不存在精度误差)
    public static boolean isValidDecimal(String input, long minNumerator, long maxNumerator, long minDenominator, long maxDenominator) {
        if (!isValidFraction(input)) {
            return false;
        }
        String[] parts = input.split("/");
        long numerator = Long.parseLong(parts[0]);
        long denominator = Long.parseLong(parts[1]);
        return numerator >= minNumerator && numerator <= maxNumerator && denominator >= minDenominator && denominator <= maxDenominator;
    }

    // 提供分式转换为小数的方法
    public static double fractionToDecimal(long numerator, long denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        return (double) numerator / denominator;
    }


}
