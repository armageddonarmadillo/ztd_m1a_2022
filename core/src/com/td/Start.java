package com.td;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Start extends Scene{
    MenuButton b1;
    String title;

    Start(){
        title = "Zombie Defence!";
        font.getData().setScale(5.f);
        layout.setText(font, title);
        b1 = new MenuButton("Start", Game.gw / 2 - 150 / 2, 300, 150, 75);
    }

    @Override
    void tap(int x, int y) {
        if(b1.hitbox().contains(x, y)) Main.which = Main.scene.GAME;
    }

    @Override
    void draw(SpriteBatch batch) {
        font.draw(batch, layout, (float) Game.gw / 2 - layout.width / 2, 555);
        b1.draw(batch);
    }
}
