package com.td;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Effect {
    String type;
    int x, y, w, h;
    boolean active = true;

    //Animation variables
    int rows = 1, cols;
    float time = 0f;
    TextureRegion[] frames;
    Animation<TextureRegion> ani;

    Effect(String type, int x, int y){
        this.type = type;
        cols = Maps.values.get("columns_" + type) == null ? 1 : Maps.values.get("columns_" + type);
        rows = Maps.values.get("rows_" + type) == null ? 1 : Maps.values.get("rows_" + type);
        w = (Maps.resources.get("effects_" + type) == null ? Resources.damaged : Maps.resources.get("effects_" + type)).getWidth() / cols;
        h = (Maps.resources.get("effects_" + type) == null ? Resources.damaged : Maps.resources.get("effects_" + type)).getHeight() / rows;
        this.x = x - w / 2;
        this.y = y - h / 2;
        time = .1f;
        init_animation();
    }

    void draw(SpriteBatch b){
        b.draw(ani.getKeyFrame(time+= Gdx.graphics.getDeltaTime(), false), x, y);
        active = !ani.isAnimationFinished(time);
    }

    void init_animation(){
        TextureRegion[][] sheet = TextureRegion.split((Maps.resources.get("effects_" + type) == null ? Resources.damaged : Maps.resources.get("effects_" + type)), w, h);
        frames = new TextureRegion[rows * cols];
        int index = 0;
        for(int r = 0; r < rows; r++)
            for(int c = 0; c < cols; c++)
                frames[index++] = sheet[r][c];
        ani = new Animation<>(time, frames);
    }
}
