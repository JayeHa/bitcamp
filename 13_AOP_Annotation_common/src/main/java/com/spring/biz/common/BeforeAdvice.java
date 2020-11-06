package com.spring.biz.common;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.Signature;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {
	
	//어드바이스 메소드
	//어드바이스 동작시점 설정 + 포인트컷 지정
	@Before("allPointcut()")
	public void beforeLog(JoinPoint jp) {
		//Signature signature = jp.getSignature();
		//String methodName = signature.getName();
		String methodName = jp.getSignature().getName(); //실행될 메소드명
		Object[] args = jp.getArgs();
		System.out.println("args : " + Arrays.toString(args));
		
		System.out.println("[사전처리] " + methodName + "() 메소드"
				+ ", args정보 : " + args[0] + " - 비즈니스 로직 수행전 로그");
	}	
}








