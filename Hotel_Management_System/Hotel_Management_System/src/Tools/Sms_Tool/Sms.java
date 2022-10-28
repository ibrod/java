package Tools.Sms_Tool;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import Tools.HttpUtils;

public class Sms {

	public static String send_sms(String phone) {
		System.out.println(phone);
		String dict = "0123456789";
		StringBuffer sms_code = new StringBuffer();
		for (int i = 1; i <= 6; i++) {
			int index = (int) (Math.random() * 10);
			sms_code.append(dict.charAt(index));
		}
		String host = "https://dfsns.market.alicloudapi.com";
		String path = "/data/send_sms";
		String method = "POST";
		String appcode = "e20d3bf56b694f1599c7627891c01b7d";
		Map<String, String> headers = new HashMap<String, String>();
		// 最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
		headers.put("Authorization", "APPCODE " + appcode);
		// 根据API的要求，定义相对应的Content-Type
		headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		Map<String, String> querys = new HashMap<String, String>();
		Map<String, String> bodys = new HashMap<String, String>();
		bodys.put("content", "code:" + sms_code.toString());
		bodys.put("phone_number", phone);
		bodys.put("template_id", "TPL_0000");
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
			HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
			System.out.println(response.toString());
			// 获取response的body
			System.out.println(EntityUtils.toString(response.getEntity()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sms_code.toString();
	}
}
