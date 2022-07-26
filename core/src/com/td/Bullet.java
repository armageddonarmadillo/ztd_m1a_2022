package com.td;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Bullet {
    int x, y, w, h, s, damage, limit, dist;
    float a;
    String type;
    boolean active = true;

    Bullet(String type, int x, int y){
        this.type = type;
        w = (Maps.resources.get("bullets_" + type) == null ? Resources.bullet : Maps.resources.get("bullets_" + type)).getWidth();
        h = (Maps.resources.get("bullets_" + type) == null ? Resources.bullet : Maps.resources.get("bullets_" + type)).getHeight();
        this.x = x + w / 2;
        this.y = y + h / 2;
        s = 5;
        damage = 1;
        limit = 650;
        a = calc_angle();
    }

    void update(){
        x += Math.cos(a) * s;
        y += Math.sin(a) * s;
        dist += Math.abs(Math.cos(a) * s);
        dist += Math.abs(Math.sin(a) * s);
        active = !(limit <= dist);
        collides();
    }

    void collides(){
        if(Game.enemies.isEmpty()) return;
        for(Enemy e : Game.enemies) if(e.hitbox().contains(hitbox())) { e.hp-=damage; active = false; }
    }

    float calc_angle(){
        Enemy closest = null;
        for(Enemy e : Game.enemies){
            if(closest == null) { closest = e; continue; }
            float h_closest = (float)Math.sqrt(((x - closest.x) * (x - closest.x)) + ((y - closest.y) * (y - closest.y)));
            float h_e = (float)Math.sqrt(((x - e.x) * (x - e.x)) + ((y - e.y) * (y - e.y)));
            if(h_e < h_closest) closest = e;
        }
        return (float)(Math.atan((float)(y - (closest.y + (float)closest.ch / 2)) / (x - (closest.x + (float)closest.cw / 2))) + (x >= closest.x ? Math.PI : 0));
    }

    void draw(SpriteBatch b){
        b.draw((Maps.resources.get("bullets_" + type) == null ? Resources.bullet : Maps.resources.get("bullets_" + type)), x, y, w, h);
    }

    Rectangle hitbox(){
        return new Rectangle(x, y, w, h);
    }
}
