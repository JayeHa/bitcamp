package com.spring.biz.common;

public class AfterAdvice {
	public void afterLog() {
		System.out.println("[후처리-AfterAdvice.afterLog()]"
				+ " 비즈니스 로직 수행후 로그");
	}
}
