package com.td;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Cannon {
    int x, y, w, h;
    String type;
    boolean active = true;

    Cannon(String type, int x, int y){
        this.type = type;
        w = Resources.cannon.getWidth();
        h = Resources.cannon.getHeight();
        this.x = lock(x , w);
        this.y = lock(y , h);
    }

    void update(){

    }

    void draw(SpriteBatch b){
        b.draw(Resources.cannon, x, y, w, h);
    }

    int lock(int coord, int sizer){
        return coord - (coord % sizer);
    }
}
