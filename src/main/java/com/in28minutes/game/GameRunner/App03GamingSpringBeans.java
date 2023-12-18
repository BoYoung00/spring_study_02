package com.in28minutes.game.GameRunner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
class GamingConfiguration {

}

@Configuration // Bean을 등록하려고 할 때 사용
@ComponentScan("com.in28minutes.game.GameRunner") // Bean으로 자동 등록해주는 역할
public class App03GamingSpringBeans {
//    @Bean
//    public GamingConsole game() {
//        var game = new PacmanGame();
//        return game;
//    }
//
//    @Bean
//    public GameRunner gameRunner(GamingConsole game) {
//        var gameRunner = new GameRunner(game);
//        return gameRunner;
//    }
    // @ComponentScan을 이용하여 Bean을 생성하는 코드를 생략 가능

    public static void main(String[] args) {
        try(var context =
                    new AnnotationConfigApplicationContext
                            (App03GamingSpringBeans.class)) { // 본인 클래스 context 만듦
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
