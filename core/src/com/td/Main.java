package com.td;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.Random;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	static Random r = new Random();
	static ArrayList<Enemy> enemies = new ArrayList<>();
	static ArrayList<Cannon> cannons = new ArrayList<>();

	@Override
	public void create () {
		batch = new SpriteBatch();
	}

	void update(){
		tap();
		spawn_zombies();
		for(Enemy e : enemies) e.update();
		for(Cannon c : cannons) c.update();
		tidy();
	}

	void tap(){
		if(!Gdx.input.justTouched()) return;
		int x = Gdx.input.getX(), y = Gdx.graphics.getHeight() - Gdx.input.getY();
		cannons.add(new Cannon("cannon", x, y));
	}

	void tidy(){
		for(Enemy e : enemies) if(!e.active) { enemies.remove(e); break; }
		for(Cannon c : cannons) if(!c.active) { cannons.remove(c); break; }
	}

	void spawn_zombies(){
		if(!enemies.isEmpty()) return;
		for(int i = 0; i < 3; i++) enemies.add(new Enemy("basic", 1024 + (40 * enemies.size()), r.nextInt(550)));
	}

	@Override
	public void render () {
		update();
		ScreenUtils.clear(0, 0.5f, 0.5f, 1);
		batch.begin();
		batch.draw(new Texture("bg_lab.png"), 0, 0);
		for(Enemy e : enemies) e.draw(batch);
		for(Cannon c : cannons) c.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
