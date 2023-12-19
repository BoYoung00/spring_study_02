package com.in28minutes.learmspringframework.examples.a1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Array;
import java.util.Arrays;

@Configuration // Bean을 등록하려고 할 때 사용
@ComponentScan // Bean으로 자동 등록해주는 역할
public class DepinjectionLauncherApplication {

	public static void main(String[] args) {
		try(var context =
					new AnnotationConfigApplicationContext
							(DepinjectionLauncherApplication.class)) { // 본인 클래스 context 만듦
			Arrays.stream(context.getBeanDefinitionNames())
					.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

