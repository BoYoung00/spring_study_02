package com.in28minutes.learmspringframework.examples.c1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration // Bean을 등록하려고 할 때 사용
@ComponentScan // 같은 패키지 안의 Bean을 자동 등록해주는 역할
public class RealWorldSpringLauncherApplication {

	public static void main(String[] args) {
		try(var context =
					new AnnotationConfigApplicationContext
							(RealWorldSpringLauncherApplication.class)) { // 본인 클래스 context 만듦
			Arrays.stream(context.getBeanDefinitionNames())
					.forEach(System.out::println);
			System.out.println(context.getBean(BusinessCalculationService.class).findMax());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

