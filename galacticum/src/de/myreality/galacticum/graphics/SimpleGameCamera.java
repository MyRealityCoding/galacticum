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
package de.myreality.galacticum.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import de.myreality.galacticum.core.entities.Entity;
import de.myreality.galacticum.core.entities.SimpleShape;

/**
 * Adapts libgdx camera to {@see GameCamera}
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 0.1
 * @version 0.1
 */
public class SimpleGameCamera extends SimpleShape implements GameCamera {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private OrthographicCamera camera;

	private Entity target;

	private Vector2 velocity;

	// ===========================================================
	// Constructors
	// ===========================================================

	public SimpleGameCamera(float viewportWidth, float viewportHeight) {
		super(viewportWidth, viewportHeight);
		camera = new OrthographicCamera(viewportWidth, viewportHeight);
		velocity = new Vector2();
		camera.setToOrtho(true);
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
	 * @see de.myreality.galacticum.graphics.GameCamera#shake(float, int)
	 */
	@Override
	public void shake(float factor, int miliseconds) {
		// TODO
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.myreality.galacticum.graphics.GameCamera#setTarget(de.myreality.galacticum
	 * .core.entities.Entity)
	 */
	@Override
	public void focus(Entity entity) {
		this.target = entity;
		moveToTarget();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.myreality.galacticum.graphics.GameCamera#setPosition(float,
	 * float)
	 */
	@Override
	public void setPosition(float x, float y) {

		float deltaX = x - getX();
		float deltaY = y - getY();

		camera.translate(deltaX, deltaY);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.myreality.galacticum.graphics.GameCamera#getX()
	 */
	@Override
	public float getX() {
		return camera.position.x - getWidth() / 2f;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.myreality.galacticum.graphics.GameCamera#getY()
	 */
	@Override
	public float getY() {
		return camera.position.y - getHeight() / 2f;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.myreality.galacticum.graphics.GameCamera#setX(float)
	 */
	@Override
	public void setX(float x) {
		setPosition(x, getX());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.myreality.galacticum.graphics.GameCamera#setY(float)
	 */
	@Override
	public void setY(float y) {
		setPosition(getX(), y);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.myreality.galacticum.graphics.GameCamera#getWidth()
	 */
	@Override
	public float getWidth() {
		return camera.viewportWidth;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.myreality.galacticum.graphics.GameCamera#getHeight()
	 */
	@Override
	public float getHeight() {
		return camera.viewportHeight;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.myreality.galacticum.graphics.GameCamera#update(float,
	 * com.badlogic.gdx.graphics.g2d.SpriteBatch)
	 */
	@Override
	public void update(float delta, SpriteBatch batch) {

		if (Gdx.graphics.getWidth() != camera.viewportWidth
				|| Gdx.graphics.getHeight() != camera.viewportHeight) {
			float x = getX();
			float y = getY();
			camera.setToOrtho(true, Gdx.graphics.getWidth(),
					Gdx.graphics.getHeight());
			setX(x);
			setY(y);
			
			moveToTarget();
		}
		
		updateFocus(delta);

		camera.update();
		batch.setProjectionMatrix(camera.combined);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.myreality.galacticum.graphics.GameCamera#begin()
	 */
	@Override
	public void begin() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.myreality.galacticum.graphics.GameCamera#end()
	 */
	@Override
	public void end() {
		// TODO Auto-generated method stub

	}

	void moveToTarget() {
		camera.position.x = target.getX() + target.getWidth() / 2f;
		camera.position.y = target.getY() + target.getHeight() / 2f;
	}

	private void updateFocus(float delta) {
		if (target != null) {

			// Create a direction vector
			velocity.x = (float) (target.getX()
					+ Math.floor(target.getWidth() / 2.0f) - (getX() + Math
					.floor(getWidth() / 2.0f)));
			velocity.y = (float) (target.getY()
					+ Math.floor(target.getHeight() / 2.0f) - (getY() + Math
					.floor(getHeight() / 2.0f)));

			float distance = velocity.len();
			velocity = velocity.nor();
			
			if (distance <= 1.0f) {
				moveToTarget();
			} else {
				double speed = ((10 + delta) * distance) / (getWidth() / 10.0);

				// Round it up to prevent camera shaking
				float newXPos = (float) (getX() + velocity.x * speed);
				float newYPos = (float) (getY() + velocity.y * speed);
				// setPosition(newXPos, newYPos);
				setPosition((float) Math.ceil(newXPos),
						(float) Math.ceil(newYPos));
			}
		}
	}
	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

}
