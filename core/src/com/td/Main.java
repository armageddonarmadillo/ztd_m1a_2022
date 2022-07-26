package com.td;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.Random;

/*
* TODO: CLASS GOALS
* - Zombie Type Variety
* - Balance
* - Building APK
* - Fun stuff (tiles, tooltips)
* */

public class Main extends ApplicationAdapter {
	//Utility
	SpriteBatch batch;
	OrthographicCamera camera;

	//Scenes
	static Scene start;
	static Scene game;
	static Scene gameOver;

	//Control
	static boolean started = false, gameover = false;
	enum scene {
		START,
		GAME,
		GAMEOVER
	}
	static scene which;

	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Game.gw, Game.gh);
		start = new Start();
		game = new Game();
		gameOver = new GameOver();
		which = scene.START;
	}

	void tap(){
		if(!Gdx.input.justTouched()) return;
		Vector3 v = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
		camera.unproject(v);
		int x = (int)v.x, y = (int)v.y;

		switch(which){
			case START:
				start.tap(x, y);
				break;
			case GAME:
				game.tap(x, y);
				break;
			case GAMEOVER:
				gameOver.tap(x, y);
				break;
		}
	}



	@Override
	public void render () {
		tap();
		ScreenUtils.clear(0, 0.5f, 0.5f, 1);
		camera.update();
		batch.setProjectionMatrix(camera.combined); //This is for visual scaling
		batch.begin();

		switch(which){
			case START:
				start.draw(batch);
				break;
			case GAME:
				game.draw(batch);
				break;
			case GAMEOVER:
				gameOver.draw(batch);
				break;
		}

		batch.end();
	}


	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
