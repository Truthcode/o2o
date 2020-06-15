package com.lyj.o2o.Util;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 工具类
 *
 * @author tyronchen
 * @date 2018年5月28日
 */
public class CodeUtil {

	/**
	 * 对比校验码
	 * 
	 * @param request
	 * @return
	 */
	public static boolean checkVerifyCode(HttpServletRequest request) {
		// 获取输入的校验码
		String verifyCodeActual = HttpServletRequestUtil.getString(request, "verifyCodeActual");
		// 获取图片中的校验码
		String verifyCodeExpexted = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
		// 对比
		if (verifyCodeActual == null || !verifyCodeActual.equalsIgnoreCase(verifyCodeExpexted)) {
			return false;
		}
		return true;
	}

}
