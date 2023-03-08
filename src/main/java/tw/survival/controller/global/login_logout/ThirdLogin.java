package tw.survival.controller.global.login_logout;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import net.sf.json.JSONObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ThirdLogin {
	private static String client_id = "78352890381-mng41n2ucnm5hsan9vg7ri4rfpgmqucc.apps.googleusercontent.com";
	private static String client_secret = "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";
	private static String scope = "https://www.googleapis.com/auth/drive.metadata.readonly";
	private static String redirect_url = "http://gntina.iok.la/GoogleUserInfo";
	private static String code_url = "https://accounts.google.com/o/oauth2/v2/auth";
	private static String token_url = "https://www.googleapis.com/oauth2/v4/token";
	private static String user_url = "https://www.googleapis.com/oauth2/v2/userinfo";
	private static String verify_url = "https://www.googleapis.com/oauth2/v3/tokeninfo";

	@RequestMapping(value = "/login")
	public String toIndex(HttpServletRequest request) {
		return "google";
	}
	/**
	 * @Title: Login
	 * @Description: google登入驗證後會重定向到此地址，並附帶訪問授權碼，不能為公開的ip地址
	 * @author 此方法是用帶回的code換取accessToken，然後用accessToken換取使用者資訊，這個地址就是在建立應用時定義的重定向地址
	 * @return Object
	 * @date Mar 23, 2017 10:37:38 AM
	 * @throws
	 */
//	@RequestMapping(value = "/GoogleUserInfo")
//	@ResponseBody
//	public static Object Login(HttpServletRequest request) {
//		String code = request.getParameter("code");
//		System.out.println(code);
//		
////		String idToken = getGoogleAccessToken(code);
////		System.out.println(idToken);
////		JSONObject verifyToken = verifyToken(idToken);
////		System.out.println(verifyToken);
//		
//		String accessToken = getGoogleAccessToken(code);
//		System.out.println(accessToken);
//		JSONObject userInfo = getUserInfo(accessToken);
//		System.out.println(userInfo);
//		return userInfo;
//	}
	/**
	 * @throws Exception
	 * @throws IOException
	 * @Title: sendRedirect
	 * @Description:傳送授權請求
	 * @author 第二步，在google.jsp中使用者登入成功以後回跳轉到這個路徑，傳送請求讓使用者授權，授權成功後重定向到/GoogleUserInfo，也就是建立應用時定義的重定向地址
	 * @return String
	 * @date Mar 24, 2017 3:11:36 PM
	 * @throws
	 */
//	@RequestMapping(value = "/sendRedirect")
//	public void sendRedirect(HttpServletResponse response) throws Exception {
//		// 隨機字串，防止csrf攻擊
//		String state = UUID.randomUUID() + "";
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("client_id", client_id);
//		params.put("redirect_uri", redirect_url);
//		params.put("response_type", "code");
//		params.put("scope", scope);
//		params.put("access_type", "offline");
//		params.put("state", state);
//		params.put("include_granted_scopes", "true");
//		String url = HttpClientUtil.getUrl(code_url, params);
//		response.sendRedirect(url);
//	}
	/**
	 * @Title: getGoogleAccessToken
	 * @Description: 獲取accessToken
	 * @author 第三步，用重定向帶回來的code換取accessToken
	 * @return String
	 * @date Mar 25, 2017 10:25:00 AM
	 * @throws
	 */
//	public static String getGoogleAccessToken(String code) {
//		HashMap<String, String> params = new HashMap<String, String>();
//		params.put("client_id", client_id);
//		params.put("redirect_uri", redirect_url);
//		params.put("client_secret", client_secret);
//		params.put("grant_type", "authorization_code");
//		params.put("code", code);
//		String[] responseResult = null;
//		String accessToken =null;
//		String idToken=null;
//		try {
//			responseResult = HttpClientUtil.getStringByPost(token_url, params,
//					null);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		if (null != responseResult && responseResult[0].equals("200")) {
//			String result = responseResult[1];
//			 JSONObject jsonObject = JSONObject.fromObject(result);
//			 accessToken = jsonObject.getString("access_token");
//			 idToken=jsonObject.getString("id_token");
//		}
//		return accessToken;
//		return idToken;
//	}
	/**
	 * @Title: getUserInfo
	 * @Description: 獲取使用者資訊
	 * @author第四步，用accessToken獲取使用者資訊
	 * @return String
	 * @date Mar 25, 2017 11:50:23 AM
	 * @throws //
	 */
//	public static JSONObject getUserInfo(String accessToken) {
//		HashMap<String, String> params = new HashMap<String,String>();
//		params.put("access_token", accessToken);
//		String[] responseResult =null;
//		JSONObject userInfo=null;
//		try {
//			responseResult = HttpClientUtil.getStringByGet(user_url, params);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		if (null != responseResult && responseResult[0].equals("200")) {
//			String result = responseResult[1];
//			userInfo =  JSONObject.fromObject(result);   
//		}
//		return userInfo;
//	}
	/**
	 * @Title: verifyToken
	 * @Description:驗證使用者token是否是來自本應用的請求，校驗aud和clientID是否相同
	 * @author第五步，驗證使用者是否來自你的應用，防刷，根據需要加到邏輯裡
	 * @return String
	 * @date Mar 25, 2017 7:36:33 PM
	 * @throws
	 */
//	public static JSONObject verifyToken(String idToken){
//		HashMap<String, String> params = new HashMap<String,String>();
//		params.put("id_token", idToken);
//		String[] responseResult =null;
//		JSONObject verifyInfo=null;
//		try {
//			responseResult = HttpClientUtil.getStringByGet(verify_url, params);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		if (null != responseResult && responseResult[0].equals("200")) {
//			String result = responseResult[1];
//			verifyInfo =  JSONObject.fromObject(result);   
//		}
//		return verifyInfo;
//	}	

}