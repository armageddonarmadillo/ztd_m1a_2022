package com.td;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Cannon extends Sprite {
    int x, y, w, h, d, c, ammo, total_ammo;
    String type;
    boolean active = true;

    Cannon(String type, int x, int y){
        super(Maps.resources.get("cannons_" + type) == null ? Resources.cannon : Maps.resources.get("cannons_" + type));
        this.type = type;
        w = (Maps.resources.get("cannons_" + type) == null ? Resources.cannon : Maps.resources.get("cannons_" + type)).getWidth();
        h = (Maps.resources.get("cannons_" + type) == null ? Resources.cannon : Maps.resources.get("cannons_" + type)).getHeight();
        this.x = lock(x , w);
        this.y = lock(y , h);
        super.setPosition(this.x, this.y);
        d = 60;
        ammo = 30;
        total_ammo = ammo;
    }

    void update(){
        super.setRotation(calc_angle());
        if(c++ >= d) {
            c = 0;
            fire();
        }

        active = ammo > 0;
    }

    void fire(){
        if(Game.enemies.isEmpty()) return;
        Game.bullets.add(new Bullet(type, x + w / 2, y + h / 2));
        ammo--;
    }

    float calc_angle(){
        Enemy closest = null;
        for(Enemy e : Game.enemies){
            if(closest == null) { closest = e; continue; }
            float h_closest = (float)Math.sqrt(((x - closest.x) * (x - closest.x)) + ((y - closest.y) * (y - closest.y)));
            float h_e = (float)Math.sqrt(((x - e.x) * (x - e.x)) + ((y - e.y) * (y - e.y)));
            if(h_e < h_closest) closest = e;
        }
        return (float)Math.toDegrees(Math.atan((float)(y - closest.y) / (x - closest.x)) + (x >= closest.x ? Math.PI : 0));
    }

    void draw(SpriteBatch b){
        super.draw(b);
        b.draw(Resources.red, x, y + h + 2, w, 5);
        b.draw(Resources.green, x, y + h + 2, ammo * ((float)w / total_ammo), 5);
    }

    int lock(int coord, int sizer){
        return coord - (coord % sizer);
    }

    Rectangle hitbox(){
        return new Rectangle(x, y, w, h);
    }
}
