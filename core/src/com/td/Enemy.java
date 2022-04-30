package com.td;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Enemy {
    String type;
    int x, y, cw, ch, speed;
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
        speed = 10;
        cols = 4;
        cw = Resources.zombie.getWidth() / cols;
        ch = Resources.zombie.getHeight() / rows;
        init_animation();
    }

    void update(){
        x -= speed;
        active = !(x + Resources.zombie.getWidth() <= 0);
    }

    void draw(SpriteBatch b){
        b.draw(ani.getKeyFrame(time+= Gdx.graphics.getDeltaTime(), true), x, y);
    }

    void init_animation(){
        TextureRegion[][] sheet = TextureRegion.split(Resources.zombie, cw, ch);
        frames = new TextureRegion[rows * cols];
        int index = 0;
        for(int r = 0; r < rows; r++)
            for(int c = 0; c < cols; c++)
                frames[index++] = sheet[r][c];
        ani = new Animation<>(0.2f, frames);
    }
}
