package com.in28minutes.learmspringframework.examples.g1;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@Component
// CDI로 대체 가능 (알아만 놓기)
@Named
class BusinessService {
	DataService dataService;

	public DataService getDataService() {
		return dataService;
	}

	// @Autowired
	@Inject
	public void setDataService(DataService dataService) {
		System.out.println("Setter Injection");
		this.dataService = dataService;
	}
}

//@Component
@Named
class DataService {

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

			System.out.println(context.getBean(BusinessService.class).
					getDataService());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

