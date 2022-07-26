package com.td;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

public class Resources {
    //zombies
    static final Texture zombie = new Texture(Gdx.files.internal("Zombies.png"));
    static final Texture zombie_dif = new Texture(Gdx.files.internal("DifZombies.png"));
    static final Texture zombie_fast = new Texture(Gdx.files.internal("Fastzombies.png"));
    static final Texture zombie_speedy = new Texture(Gdx.files.internal("speedy_zombie.png"));
    static final Texture zombie_riot = new Texture(Gdx.files.internal("riotzombie.png"));
    static final Texture zombie_bigriot = new Texture(Gdx.files.internal("riotzombieBIG.png"));
    static final Texture enemy_brain = new Texture(Gdx.files.internal("brain.png"));

    //cannons
    static final Texture cannon = new Texture(Gdx.files.internal("Cannon.png"));
    static final Texture cannon_fire = new Texture(Gdx.files.internal("Firecannon.png"));
    static final Texture cannon_super = new Texture(Gdx.files.internal("SuperCannon.png"));
    static final Texture cannon_double = new Texture(Gdx.files.internal("doubleCannon.png"));
    static final Texture cannon_missile = new Texture(Gdx.files.internal("cannon_missile.png"));
    static final Texture cannon_venom = new Texture(Gdx.files.internal("venomcannon.png"));

    //bullets
    static final Texture bullet = new Texture(Gdx.files.internal("Bullet.png"));
    static final Texture bullet_fire = new Texture(Gdx.files.internal("firebullet.png"));
    static final Texture bullet_super = new Texture(Gdx.files.internal("superbullet.png"));
    static final Texture bullet_venom = new Texture(Gdx.files.internal("venombullet.png"));

    //buttons
    static final Texture selected = new Texture(Gdx.files.internal("border.png"));
    static final Texture locked = new Texture(Gdx.files.internal("locked.png"));
    static final Texture button_cannon = new Texture(Gdx.files.internal("CannonIcon.png"));
    static final Texture button_cannon_fire = new Texture(Gdx.files.internal("FireCannonIcon.png"));
    static final Texture button_cannon_super = new Texture(Gdx.files.internal("SuperCannonIcon.png"));
    static final Texture button_cannon_double = new Texture(Gdx.files.internal("doubleCannonIcon.png"));
    static final Texture button_cannon_missile = new Texture(Gdx.files.internal("cannon_missile_icon.png"));
    static final Texture button_cannon_venom = new Texture(Gdx.files.internal("venomcannon_icon.png"));

    //effects
    static final Texture damaged = new Texture(Gdx.files.internal("damaged.png"));
    static final Texture boom = new Texture(Gdx.files.internal("boom.png"));
    static final Texture build = new Texture(Gdx.files.internal("build.png"));

    //backgrounds
    static final Texture bg_lab = new Texture(Gdx.files.internal("bg_lab.png"));
    static final Texture bg_snow = new Texture(Gdx.files.internal("bg_snow.png"));
    static final Texture bg_template = new Texture(Gdx.files.internal("bg_template.png"));

    //colours
    static final Texture red = create_texture(Color.RED);
    static final Texture green = create_texture(Color.GREEN);
    static final Texture slate = create_texture(Color.SLATE);

    //methods
    static Texture create_texture(Color c){
        Pixmap p = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        p.setColor(c);
        p.fillRectangle(0, 0, 1, 1);
        Texture t = new Texture(p);
        p.dispose();
        return t;
    }

    static Color invert_color(Color c){
        return new Color(1.f - c.r, 1.f - c.g, 1.f - c.b, 1.f);
    }
}
