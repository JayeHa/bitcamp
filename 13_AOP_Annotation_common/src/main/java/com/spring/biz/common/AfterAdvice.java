package com.spring.biz.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

//(실습) @Aspect, @Pointcut, @After 적용
@Service
@Aspect
public class AfterAdvice {
	
	@After("PointcutCommon.getPointcut()")
	public void afterLog() {
		System.out.println("[후처리-AfterAdvice.afterLog()]"
				+ " 비즈니스 로직 수행후 로그");
	}
}
