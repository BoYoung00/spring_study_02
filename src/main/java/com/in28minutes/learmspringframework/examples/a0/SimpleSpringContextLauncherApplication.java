package com.in28minutes.learmspringframework.examples.a0;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component // Bean 만들 클래스 지정
class YourBusinessClass {
	Dependency1 dependency1;
	Dependency2 dependency2;

	//@Autowired 가장 추천 (안 써도 자동 주입 됨)
	public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
		System.out.println("YourBusinessClass");
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}
//	@Autowired // Bean 자동 연결 or 자동 new 생성
//	public void setDependency1(Dependency1 dependency1) {
//		System.out.println("setDependency1");
//		this.dependency1 = dependency1;
//	}
//	@Autowired
//	public void setDependency2(Dependency2 dependency2) {
//		System.out.println("setDependency2");
//		this.dependency2 = dependency2;
//	}

	public String toString() {
		return "Using " + dependency1 + " and " + dependency2;
	}
}

@Component // Bean 만들 클래스 지정
class Dependency1 {

}

@Component // Bean 만들 클래스 지정
class Dependency2 {

}

@Configuration // Bean을 등록(사용)하려고 할 때 사용
@ComponentScan // 현재 패키지의 Bean들을 자동 스캔 해줌
public class SimpleSpringContextLauncherApplication {

	public static void main(String[] args) {
		try(var context =
					new AnnotationConfigApplicationContext
							(SimpleSpringContextLauncherApplication.class)) { // 본인 클래스 context 만듦
			Arrays.stream(context.getBeanDefinitionNames())
					.forEach(System.out::println);
			System.out.println(context.getBean(YourBusinessClass.class));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

