package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id ="2016102800774389";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key ="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCD7Zwgh3Yq/aSKQkJ/ay1YxZR1VFs3DBi9r3RjmIkOGLzQJn87JCIdJnrT8VqVqj8FAo9BOMK7m2wObqgBpInB1GdzI6CSxLBCAoA+auJShnVsULW0BoimcPvzt5fR6nEYs98lSw+822KZDpyAOdaPirMkmqNWu4EN58fIcHh1/KHoVLXjRz0IkE7/fUC0Qek/sb63eRBOzQMPUD2codzhbA+fpKcQ96/jweFQrthiMxnkGeB6e9kxPqDURepGDePIN4NTr+I+eQgzzew0qrs6gljG3WkyT8g70/+BKhfOJKeNUun3qELcFrLm1NSyZZx+BNuU3RbwsmixKzZ3ez3bAgMBAAECggEAMnNdLztePxZ8I7su/tcXokj8etnlf+mKVI+SLLwaPV/MZLU0FoO83/TlJ8O2ZmGSc/IEomZ4YZIQAnzilq47V/pIDUnkj/vTg4q9TCFHp1Nv+BntQoj1HOE8GHlu/4Ft+openT5VKF2lGO7zfj2gBYh+9VKFgBd4RL8MMWSBTGzhM6PpHFqQaXCbbimz2hpVpG9eizEyKlGpqiuGTRPjzxtXhmc8wHuhKOMH0djWnKJvfsvpESDfWZ99ENrkNabKFlKpqPtSJGIMjsJvi/Sf3fW0vvbOXY6KFBlAZr0C94KHaVlipmEyGxjIWjfnJvROtmDzmzroIo+x2TctdASq8QKBgQDAFpNJcK1xIwXsdRBcHBxk/YfRka2THK0fHCQpq/kBc3x67I0VfPLPodnfC77/36S75sQ7yAcnHjzS1rryiTKqHdrbU2EJ7gOS+BsyYMwNgoFo8XNr/myFyARp6wUnMMTzCW4gzb+/3qOrV4w0yI6hxmRpMI/rp0s5UKpvNRgKvQKBgQCv0s54ZWgf+9bIIMDWQUI48rQpY1SofZJloxO4p9j1jGJd6SPqpyhN2wWvewwn9w3N0956/X5QHEs4fCoPfdJXVoMlMiAHpu8qk35H2S4B7CoDVjm96K2YbtU89tJojM+RF4x9fu/MzFk7n7TN7pW7QbuED7LFSdqwNyn82otAdwKBgQCM84PcjfwXWtXL7xK0JESJrqhtFXLC0nYOr/2xPmoXsICVSuMz813REjjnPJ1I8PjWkL1KCLuG7t8+7yZ7NkWhIwsniYVZXfftbnW2f+T7vNntAc/qXOWRPXZPqo87dMPweuj+1TtxNZPv9OwDB2/yMbwYm/PfvgCq7BBETjd4GQKBgCdlqCgoKN3J04XCeRNJSipyj9YaUNT0VkJ5+ShOS/oxe7UpUYf57rkLU8nPW5j07d3qFJcgiBYxUNWWVOJlwiUZ2IcUJUMxr7OtmwVEb9+0aHGY95VLNuLKKvPfJqSQsM4FJdDVCaytOW13ys6+IET2ZKshzWARvXPw2HK1EbDfAoGBAJ26leXPqk4u/IXld65srl1kywWAyA4atHZ9Yjrq7ZtG9uHYnt5cjOZCLa5C1Ab9PqJK1sVTdP9Tpkvlm0NEKtkOg9JPopBLPE5sqdOhigRmyfAOAhjhCqHojb0jBhQyMjlOREuoRC4Q2zHo8yl4+rFwLAgbRlNl5LJgqRb6ZqWl";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqtbDhCVmqzVrADO0yVMgchoyzBDbp2lEbl+LIpJbLapqFeg7fKw6uNp7xrC6vz/bsZhOeVX4b42REa17OOf4G5fzRFhUMnjx/OZZH4HMngpCokb/ga8l/X5DHp1yDxq6G+eCdumXoBzSoVah7ohJpP+fXc3AEzWsAqC2R24afiPVjWLUUQkxBLQHwkyXNp8HyxitqQCSyO9w+PymCCBS3KZaYW704lmSJHZbN55DjF3KmHaOC/ckWhM97miG+KO/rJbS5GMd44SDbQYsZ7V8IVk84Ja+FOwZaJtkxajNEH5xEXqUnZtHsKuMSiVX+nb+l9FAkfalrfWXsCKdehlPwQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	//public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/goods/order/return_url.action";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

