package com.in28minutes.game;

import org.springframework.stereotype.Component;

@Component
class PacmanGame implements GamingConsole{
    @Override
    public void up() {
        System.out.println("픽맨UP");
    }
}

