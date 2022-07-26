package com.td;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class UI {
    static int money, life, score, wave;
    static BitmapFont font = new BitmapFont();

    static void draw(SpriteBatch b){
        font.getData().setScale(1.2f);
        font.setColor(Color.GOLD);
        font.draw(b, "Money: " + money, 15, 585);
        font.setColor(Color.LIME);
        font.draw(b, "Life: " + life, 15, 565);
        font.setColor(Color.CYAN);
        font.draw(b, "Score: " + score, 15, 545);
        font.setColor(Color.PINK);
        font.draw(b, "Wave: " + wave, 15, 525);
    }
}
