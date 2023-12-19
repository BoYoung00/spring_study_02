package com.in28minutes.learmspringframework.examples.h1;

import com.in28minutes.game.GameRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

@Configuration // Bean을 등록(사용)하려고 할 때 사용
@ComponentScan // 현재 패키지의 Bean들을 자동 스캔 해줌
public class XmlConfigurationContextLauncherApplication {

	public static void main(String[] args) {
		try(var context =
					new ClassPathXmlApplicationContext("contextConfiguration.xml")) { // 본인 클래스 context 만듦
			Arrays.stream(context.getBeanDefinitionNames())
					.forEach(System.out::println);
			System.out.println(context.getBean("name"));
			System.out.println(context.getBean("age"));
			context.getBean(GameRunner.class).run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

