package com.in28minutes.game.GameRunner;

import org.springframework.stereotype.Component;

@Component
class PacmanGame implements GamingConsole{
    @Override
    public void up() {
        System.out.println("픽맨UP");
    }
}

@Component
class GameRunner {
    GamingConsole game;

    public GameRunner(GamingConsole game) {
        this.game = game;
    }

    public void run() {
        System.out.println(game.toString() + " run");
        game.up();
    }
}