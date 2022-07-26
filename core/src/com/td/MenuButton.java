package com.td;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class MenuButton {
    int x, y, w, h;
    String label;
    BitmapFont font = new BitmapFont();
    GlyphLayout layout = new GlyphLayout();

    MenuButton(String label, int x, int y, int w, int h){
        this.label = label;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        font.getData().setScale(2.f);
        layout.setText(font, label);
    }

    void draw(SpriteBatch b){
        b.draw(Resources.slate, x, y, w, h);
        font.draw(b, layout, (float) (x + w / 2) - (layout.width / 2), (float) (y + h / 2) + (layout.height / 2));
    }

    Rectangle hitbox(){
        return new Rectangle(x, y, w, h);
    }
}