package com.td;

import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;

public class Maps {
    static HashMap<String, Texture> resources = new HashMap<>();
    static HashMap<String, Integer> values = new HashMap<>();

    static void init(){
        //TODO resources
        //zombies
        resources.put("enemies_dif", Resources.zombie_dif);
        resources.put("enemies_fast", Resources.zombie_fast);
        resources.put("enemies_speedy", Resources.zombie_speedy);
        resources.put("enemies_riot", Resources.zombie_riot);
        resources.put("enemies_bigriot", Resources.zombie_bigriot);
        resources.put("enemies_brain", Resources.enemy_brain);

        //cannons
        resources.put("cannons_fire", Resources.cannon_fire);
        resources.put("cannons_super", Resources.cannon_super);
        resources.put("cannons_double", Resources.cannon_double);
        resources.put("cannons_missile", Resources.cannon_missile);
        resources.put("cannons_venom", Resources.cannon_venom);

        //bullets
        resources.put("bullets_fire", Resources.bullet_fire);
        resources.put("bullets_super", Resources.bullet_super);
        resources.put("bullets_venom", Resources.bullet_venom);

        //buttons
        resources.put("buttons_cannon", Resources.button_cannon);
        resources.put("buttons_fire", Resources.button_cannon_fire);
        resources.put("buttons_super", Resources.button_cannon_super);
        resources.put("buttons_double", Resources.button_cannon_double);
        resources.put("buttons_missile", Resources.button_cannon_missile);
        resources.put("buttons_venom", Resources.button_cannon_venom);

        //effects
        resources.put("effects_boom", Resources.boom);
        resources.put("effects_build", Resources.build);

        //TODO values
        //unlock costs
        values.put("unlock_fire", 300);
        values.put("unlock_super", 500);
        values.put("unlock_double", 250);
        values.put("unlock_missile", 300);
        values.put("unlock_venom", 250);

        //placement costs
        values.put("place_fire", 30);
        values.put("place_super", 15);
        values.put("place_double", 25);
        values.put("place_missile", 50);
        values.put("place_venom", 50);

        //animation variables
        values.put("columns_speedy", 6);
        values.put("columns_boom", 7);
        values.put("columns_build", 3);
        values.put("columns_brain", 3);
        values.put("rows_brain", 4);
    }
}
