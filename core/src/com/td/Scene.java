package com.td;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Scene {
    BitmapFont font = new BitmapFont();
    GlyphLayout layout = new GlyphLayout();

    abstract void tap(int x, int y);
    abstract void draw(SpriteBatch batch);
}
