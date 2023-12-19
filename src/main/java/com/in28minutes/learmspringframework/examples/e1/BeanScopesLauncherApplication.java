package com.in28minutes.learmspringframework.examples.e1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component // 기본 싱글톤
class NormalClass {

}

@Component
@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE) // 프로토타입
// @Scope : 빈이 생성되고 유지되는 시간을 관리
// Singleton : 싱글톤, 빈 생성하면 계속 같은 인스턴스 사용
// Prototype : 프로토타입, 요청할 때마다 새로운 인스턴스 사용
// Request : HTTP 요청마다 새로운 인스턴스 생성
// Session : 세션 당 하나의 인스턴스를 생성
// Global Session : 전역 세션 범위
class PrototypeClass {

}

@Configuration // Bean을 등록(사용)하려고 할 때 사용
@ComponentScan // 현재 패키지의 Bean들을 자동 스캔 해줌
public class BeanScopesLauncherApplication {
	public static void main(String[] args) {
		try(var context =
					new AnnotationConfigApplicationContext
							(BeanScopesLauncherApplication.class)) { // 본인 클래스 context 만듦
			System.out.println(context.getBean(NormalClass.class));
			System.out.println(context.getBean(NormalClass.class));

			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

