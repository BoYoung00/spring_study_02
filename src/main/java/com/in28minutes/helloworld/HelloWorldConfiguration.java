package com.in28minutes.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// JDK 16 자동으로 게터 세터 메서드 생성
record Person (String name, int age, Address address) {};
record Address (String firstLine, String city) {};
@Configuration
public class HelloWorldConfiguration {
    @Bean
    public String name() {
        return "Range";
    }

    @Bean
    public int age() {
        return 15;
    }

    @Bean
    public Person person() {
        var person = new Person("Ravi", 20, new Address("address", "11-1"));
        // person.age();

        return person;
    }

    @Bean
    @Primary
    public Person person2MethodCall() {
        return new Person(name(), age(), address());
    }

    @Bean
    public Person person3Parameters(String name, int age, Address address) { // @Primary를 사용해서 기본 메서드 지정했기 때문에 오류 안 뜸
        return new Person(name, age, address);
    }

    @Bean(name = "person4Qualifier")
    public Person person4Qualifier(String name, int age, @Qualifier("address3qualifier") Address address) {
        return new Person(name, age, address);
    }

    @Bean(name = "address2")
    @Primary
    public Address address() {
        return new Address("Baker Street", "London");
    }

    @Bean(name = "address3")
    @Qualifier("address3qualifier")
    public Address address3() {
        return new Address("Baker Street", "London");
    }


}
