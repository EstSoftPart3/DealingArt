package com.da.common;

import java.io.FileReader;
import java.io.PrintWriter;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.HandlerInterceptor;
import com.da.util.ScriptUtils;

@Component
public class LoginInterceptor implements HandlerInterceptor {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	// 인터셉터 실행순서 : preHandle -> Controller -> postHandle -> afterCompletion

	// 컨트롤러(즉 RequestMapping이 선언된 메서드 진입) 실행 직전에 동작.

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 세션에 있는 로그인 정보 가져오기
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("mbrSq");

		if (session == null || obj == null) {
			logger.info("[preHandle]");
			logger.info("현재 로그인 상태 : 로그아웃 상태");
			logger.info("로그인이 필요한 서비스입니다.");
			return false;
		}

		logger.info("[preHandle]");
		logger.info("현재 로그인 상태 : 로그인 상태");
		logger.info("컨트롤러로 이동 : "+request.getContextPath());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
