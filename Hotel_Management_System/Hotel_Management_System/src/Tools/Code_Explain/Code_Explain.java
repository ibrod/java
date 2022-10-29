package Tools.Code_Explain;

public class Code_Explain {
    
    public static String explain_room_status(int code) {
            switch (code) {
                case 0:
                    return "空闲";
                case 1:
                    return "预定";
                case 2:
                    return "入住";
                case 3:
                    return "到期";
                case 4:
                    return "清扫";
                case 5:
                    return "维修";
            }
            return String.valueOf(code);
    }
    public static String explain_room_type(int code) {
        switch (code) {
            case 0:
                return "未定义";
            case 1:
                return "单人间";
            case 2:
                return "双人间";
            case 3:
                return "大床房";
            case 4:
                return "豪华间";
            case 5:
                return "商务间";
        }
        return String.valueOf(code);
    }
}
