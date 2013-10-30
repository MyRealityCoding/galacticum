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
package de.myreality.galacticum.core.player;

import java.io.Serializable;
import java.util.List;

import de.myreality.galacticum.core.entities.SpaceShip;
import de.myreality.galacticum.util.Observer;

/**
 * Player class which contains spaceships, statistics and resources
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 0.1
 * @version 0.1
 */
public interface Player extends Serializable, Observer<PlayerListener> {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================
	
	void addSpaceShip(SpaceShip spaceship);
	
	void removeSpaceShip(SpaceShip spaceship);
	
	List<SpaceShip> getSpaceShips();
	
	void addListener(PlayerListener listener);
	
	SpaceShip getSpaceShip(String id);
	
	
}
