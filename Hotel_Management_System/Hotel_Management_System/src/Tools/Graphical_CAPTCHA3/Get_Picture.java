package Tools.Graphical_CAPTCHA3;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import com.alibaba.fastjson.JSONObject;
import Tools.HttpUtils;

public class Get_Picture {

    public static Boolean get(StringBuffer verify_code_pic_path, StringBuffer verify_code_text) {
        String host = "https://captcha.market.alicloudapi.com";
        String path = "/create";
        String method = "GET";
        String appcode = "e20d3bf56b694f1599c7627891c01b7d";
        Map<String, String> headers = new HashMap<String, String>();
        // 最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();

        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */

            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
			//System.out.println(response.toString());
			// 获取response的body
			String result = EntityUtils.toString(response.getEntity());
			JSONObject obj1 = JSONObject.parseObject(result);
			verify_code_text.append(obj1.getString("answer"));
			verify_code_pic_path.append(obj1.getString("imgdata"));
           // System.out.println(verify_code_text.toString());
            return true;
            // System.out.println(response.toString());
            // 获取response的body
           // System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
