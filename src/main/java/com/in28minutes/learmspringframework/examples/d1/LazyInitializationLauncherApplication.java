package com.in28minutes.learmspringframework.examples.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {

}

@Component
@Lazy // 실제로 해당 빈이 필요한 시점에 초기화하여 사용. (메모리 절약용)
class ClassB {
	private ClassA classA;
	public ClassB(ClassA classA) {
		//Logic
		System.out.println("Some Initialization logic");
		this.classA = classA;
	}

	public void doSomething() {
		System.out.println("Do Something");
	}
}

@Configuration // Bean을 등록(사용)하려고 할 때 사용
@ComponentScan // 현재 패키지의 Bean들을 자동 스캔 해줌
public class LazyInitializationLauncherApplication {

	public static void main(String[] args) {
		try(var context =
					new AnnotationConfigApplicationContext
							(LazyInitializationLauncherApplication.class)) { // 본인 클래스 context 만듦
			System.out.println("comp");
			context.getBean(ClassB.class).doSomething();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

