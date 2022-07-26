package com.td;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Enemy {
    String type;
    int x, y, cw, ch, speed, hp, total_hp;
    boolean active = true;

    //Animation variables
    int rows = 1, cols;
    float time = 0f;
    TextureRegion[] frames;
    Animation<TextureRegion> ani;

    Enemy(String type, int x, int y){
        this.type = type;
        this.x = x;
        this.y = y;
        speed = 1;
        cols = Maps.values.get("columns_" + type) == null ? 4 : Maps.values.get("columns_" + type);
        rows = Maps.values.get("rows_" + type) == null ? 1 : Maps.values.get("rows_" + type);
        hp = type.equals("riot") ? 25 : Game.r.nextInt(5) + 5;
        total_hp = hp;
        cw = (Maps.resources.get("enemies_" + type) == null ? Resources.zombie : Maps.resources.get("enemies_" + type)).getWidth() / cols;
        ch = (Maps.resources.get("enemies_" + type) == null ? Resources.zombie : Maps.resources.get("enemies_" + type)).getHeight() / rows;
        init_animation();
    }

    void update(){
        x -= speed;
        active = !(x + cw <= 0) && !(hp <= 0);
        UI.score += (hp <= 0) ? 1 : 0;
        UI.life -= (x + cw <= 0) ? 1 : 0;
    }

    void draw(SpriteBatch b){
        b.draw(ani.getKeyFrame(time+= Gdx.graphics.getDeltaTime(), true), x, y);
        b.draw(Resources.red, x, y + ch + 2, cw, 5);
        b.draw(Resources.green, x, y + ch + 2, hp * ((float)cw / total_hp), 5);
    }

    void init_animation(){
        TextureRegion[][] sheet = TextureRegion.split((Maps.resources.get("enemies_" + type) == null ? Resources.zombie : Maps.resources.get("enemies_" + type)), cw, ch);
        frames = new TextureRegion[rows * cols];
        int index = 0;
        for(int r = 0; r < rows; r++)
            for(int c = 0; c < cols; c++)
                frames[index++] = sheet[r][c];
        ani = new Animation<>(0.2f, frames);
    }

    Rectangle hitbox(){
        return new Rectangle(x, y, cw, ch);
    }
}
