package Tools.Graphical_CAPTCHA;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import com.alibaba.fastjson.JSONObject;
import Tools.HttpUtils;

public class Get_Picture {

	public static Boolean get(StringBuffer verify_code_pic_path, StringBuffer verify_code_text) {
		String host = "http://ali-make-mark.showapi.com";
		String path = "/make-mark-img";
		String method = "GET";
		String appcode = "e20d3bf56b694f1599c7627891c01b7d";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", "APPCODE " + appcode);
		Map<String, String> querys = new HashMap<String, String>();
		querys.put("border", "yes");
		querys.put("border_color", "105,179,90");
		querys.put("border_thickness", "1");
		querys.put("image_height", "50");
		querys.put("image_width", "200");
		querys.put("noise_color", "black");
		querys.put("obscurificator_impl", "com.google.code.kaptcha.impl.WaterRipple");
		querys.put("textproducer_char_length", "5");
		querys.put("textproducer_char_space", "2");
		querys.put("textproducer_char_string", "abcde2345678gfynmnpwx");
		querys.put("textproducer_font_color", "black");
		querys.put("textproducer_font_names", "textproducer_font_names");
		querys.put("textproducer_font_size", "40");
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
			verify_code_text.append(obj1.getJSONObject("showapi_res_body").getString("text"));
			verify_code_pic_path.append(obj1.getJSONObject("showapi_res_body").getString("img_path_https"));
			// System.out.println(verify_code_text);
			// System.out.println(verify_code_pic_path);
			// System.out.println("---------------------------");
			// System.out.println("text:"+obj1.getJSONObject("showapi_res_body").getString("text"));
			// System.out.println("---------------------------");
			// System.out.println("img_path_https:"+obj1.getJSONObject("showapi_res_body").getString("img_path_https"));
			// System.out.println("---------------------------");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}