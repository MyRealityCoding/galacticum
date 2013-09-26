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
package de.myreality.galacticum.io;

/**
 * Listens to a single context manager
 *
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 0.1
 * @version 0.1
 */
public interface ConfigurationListener {
	
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================
	
	/**
	 * 
	 * 
	 * @param event
	 */
	void onStart(ConfigurationEvent event);
	
	/**
	 * 
	 * 
	 * @param event
	 * @param throwable
	 */
	void onError(ConfigurationEvent event, Throwable throwable);
	
	/**
	 * 
	 * 
	 * @param event
	 */
	void onSuccess(ConfigurationEvent event);
	
	/**
	 * 
	 * 
	 * @param event
	 */
	void onLoad(ConfigurationEvent event);
	
	/**
	 * 
	 * 
	 * @param event
	 */
	void onSave(ConfigurationEvent event);
	
	/**
	 * 
	 * 
	 * @param event
	 */
	void onRemove(ConfigurationEvent event);
}