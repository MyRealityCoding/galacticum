/* Galacticum space game for Android, PC and browser.
 * Copyright (C) 2013  Miguel Gonzalez
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.myreality.galacticum.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

import de.myreality.galacticum.GalacticumGame;
import de.myreality.galacticum.Resources;

/**
 * Screen which displays configuration to create a new universe. Additionally
 * you can select between multiple existing universes.
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 0.1
 * @version 0.1
 */
public class CreationScreen implements Screen {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================
	
	private GalacticumGame game;
	
	private Texture background;
	
	private SpriteBatch batch;
	
	private Stage stage;
	
	private Label lblCaption;

	// ===========================================================
	// Constructors
	// ===========================================================
	
	public CreationScreen(GalacticumGame game) {
		this.game = game;
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#render(float)
	 */
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		stage.act(delta);
		
		batch.begin();
		batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.end();
		
		stage.draw();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#resize(int, int)
	 */
	@Override
	public void resize(int width, int height) {
		if (stage == null) {
			stage = new Stage(width, height, false);
			initGUI();
			alignGUI();
		} else {
			stage.setViewport(width, height, false);
			alignGUI();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#show()
	 */
	@Override
	public void show() {
		background = Resources.BACKGROUND_MAIN;
		batch = new SpriteBatch();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#hide()
	 */
	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#pause()
	 */
	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#resume()
	 */
	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#dispose()
	 */
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	// ===========================================================
	// Methods
	// ===========================================================
	
	private void initGUI() {
		LabelStyle lblStyle = new LabelStyle();
		lblStyle.font = Resources.FONT_REGULAR;
		lblStyle.fontColor = Resources.COLOR_MAIN_GREEN;		
		lblCaption= new Label("Create new universe", lblStyle);
		stage.addActor(lblCaption);
	}
	
	private void alignGUI() {
		lblCaption.setX(Gdx.graphics.getWidth() / 2f - lblCaption.getWidth() / 2f);
		lblCaption.setY(Gdx.graphics.getHeight() - lblCaption.getHeight());
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

}
