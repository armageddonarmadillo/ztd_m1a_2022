package com.td;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;

public class Game extends Scene {
    static int gw = 1024, gh = 600;
    static Random r = new Random();
    static String type = "cannon";
    static ArrayList<Enemy> enemies = new ArrayList<>();
    static ArrayList<Cannon> cannons = new ArrayList<>();
    static ArrayList<Bullet> bullets = new ArrayList<>();
    static ArrayList<Button> buttons = new ArrayList<>();
    static ArrayList<Effect> effects = new ArrayList<>();

    Game(){
        Maps.init();
        setup();
    }

    void update(){
        spawn_zombies();
        for(Enemy e : enemies) e.update();
        for(Cannon c : cannons) c.update();
        for(Bullet b : bullets) b.update();
        tidy();
    }

    boolean buildable(int x, int y){
        for(Cannon c : cannons) if(c.hitbox().contains(x, y)) return false;
        return (((y > 0 && y < 200) || (y > 300 && y < 500)) && (x < 1000));
    }

    void deselect(){
        for (Button b : buttons) b.selected = false;
    }

    void tidy(){
        for(Enemy e : enemies) if(!e.active) { effects.add(new Effect("boom", e.x + e.cw / 2, e.y + e.ch / 2)); enemies.remove(e); break; }
        for(Cannon c : cannons) if(!c.active) { cannons.remove(c); break; }
        for(Bullet b : bullets) if(!b.active) { bullets.remove(b); break; }
        for(Effect e : effects) if(!e.active) { effects.remove(e); break; }
    }

    String[] types = { "basic", "dif", "riot", "fast", "bigriot", "speedy", "brain" };
    void spawn_zombies(){
        if(!enemies.isEmpty()) return;
        types = new String[]{"brain"};
        UI.wave++;
        int spawns = 0;

        switch(UI.wave % 10){
            case 0:
                spawns = 10;
                break;
            case 9:
                spawns = 9;
                break;
            case 8:
                spawns = 8;
                break;
            case 7:
                spawns = 7;
                break;
            case 6:
                spawns = 6;
                break;
            case 5:
                spawns = 5;
                break;
            case 4:
                spawns = 4;
                break;
            case 3:
                spawns = 3;
                break;
            case 2:
                spawns = 2;
                break;
            case 1:
                spawns = 1;
                break;
        }

        for(int i = 0; i < spawns; i++) enemies.add(new Enemy(types[r.nextInt(999) % types.length], 1024 + (40 * enemies.size()), r.nextInt(550)));
    }

    void setup(){
        //clear lists
        enemies.clear();
        cannons.clear();
        bullets.clear();
        buttons.clear();

        //reset UI
        UI.wave = 0;
        UI.score = 0;
        UI.life = 20;
        UI.money = 10000;

        //add buttons
        buttons.add(new Button("cannon", 	225 + (buttons.size() * (50 + 25)), 525));
        buttons.get(buttons.size() - 1).locked = false;
        buttons.get(buttons.size() - 1).selected = true;
        buttons.add(new Button("fire", 	225 + (buttons.size() * (50 + 25)), 525));
        buttons.add(new Button("super", 	225 + (buttons.size() * (50 + 25)), 525));
        buttons.add(new Button("double", 	225 + (buttons.size() * (50 + 25)), 525));
        buttons.add(new Button("missile", 	225 + (buttons.size() * (50 + 25)), 525));
        buttons.add(new Button("venom", 	225 + (buttons.size() * (50 + 25)), 525));
    }

    @Override
    void tap(int x, int y) {
        for(Button b : buttons) if(b.hitbox().contains(x, y)){
            if(b.locked){
                if(UI.money >= (Maps.values.get("unlock_" + b.type) == null ? 200 : Maps.values.get("unlock_" + b.type))){
                    UI.money -= (Maps.values.get("unlock_" + b.type) == null ? 200 : Maps.values.get("unlock_" + b.type));
                    b.locked = false;
                }
            } else {
                type = b.type;
                deselect();
                b.selected = true;
            }
        }

        if(buildable(x, y)) {
            if(UI.money >= (Maps.values.get("place_" + type) == null ? 10 : Maps.values.get("place_" + type))){
                cannons.add(new Cannon(type, x, y));
                effects.add(new Effect("build", x, y));
                UI.money -= (Maps.values.get("place_" + type) == null ? 10 : Maps.values.get("place_" + type));
            }
        }
    }

    @Override
    void draw(SpriteBatch batch) {
        update();
        batch.draw(Resources.bg_template, 0, 0);
        UI.draw(batch);
        for(Enemy e : enemies) e.draw(batch);
        for(Cannon c : cannons) c.draw(batch);
        for(Bullet b : bullets) b.draw(batch);
        for(Button b : buttons) b.draw(batch);
        for(Effect e : effects) e.draw(batch);
    }
}
