package com.td;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Button {
    int x, y, w, h;
    String type;
    boolean locked = true, selected;

    Button(String type, int x, int y){
        this.type = type;
        this.x = x;
        this.y = y;
        w = (Maps.resources.get("buttons_" + type) == null ? Resources.button_cannon : Maps.resources.get("buttons_" + type)).getWidth();
        h = (Maps.resources.get("buttons_" + type) == null ? Resources.button_cannon : Maps.resources.get("buttons_" + type)).getHeight();
    }

    void draw(SpriteBatch b){
        b.draw((Maps.resources.get("buttons_" + type) == null ? Resources.button_cannon : Maps.resources.get("buttons_" + type)), x, y, w, h);
        if(locked) b.draw(Resources.locked, x, y);
        if(selected) b.draw(Resources.selected, x - 7, y - 7);
    }

    Rectangle hitbox(){
        return new Rectangle(x, y, w, h);
    }
}
