/*
 * Copyright 2010-2021 (C) vakol (see attached LICENSE file for additional info)
 * 
 * Created on : 26-04-2017
 *
 */

package org.multipage.generator;

import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

import javax.swing.*;

import org.multipage.gui.*;
import org.multipage.util.*;

import com.maclan.*;


/**
 * @author
 *
 */
public class ElementProperties extends JPanel {

	/**
	 * Version.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Maximized width.
	 */
	private static final int maxWidth = 300;
	
	/**
	 * Get maximized width.
	 */
	public static int getMaxWidth() {
		return maxWidth;
	}

	/**
	 * MessagePanel panel.
	 */
	private MessagePanel message = new MessagePanel();

	/**
	 * Areas editor.
	 */
	private AreasPropertiesBase areaEditor;
	
	/**
	 * Constructor.
	 */
	public ElementProperties() {
		
		areaEditor = newAreasProperties(true);
		
		setLayout(new BorderLayout());
				
		// Initialize.
		setNoArea();
		
		// Set listener.
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getDefaultCursor());
			}
		});
	}
	
	/**
	 * Create new area properties object.
	 * @param isPropertiesPanel
	 * @return
	 */
	protected AreasPropertiesBase newAreasProperties(boolean isPropertiesPanel) {
		
		return ProgramGenerator.newAreasProperties(isPropertiesPanel);
	}

	/**
	 * Edit areas.
	 */
	public void setAreas(LinkedList<Area> areas) {

		// Delegate call.
		areaEditor.setAreas(areas);
		viewAreaEditor();
	}

	/**
	 * Set no area.
	 */
	public void setNoArea() {
		
		// Delegate call.
		areaEditor.setSaveChanges();
		
		// Set message.
		message.setText(Resources.getString("org.multipage.generator.textNoAreaSelected"));
		viewMessage();
	}

	/**
	 * View message.
	 */
	private void viewMessage() {

		removeAll();
		add(message, BorderLayout.CENTER);
		
		revalidate();
		Utility.repaintLater(this);
	}

	/**
	 * View area editor.
	 */
	private void viewAreaEditor() {
	
		removeAll();
		add(areaEditor, BorderLayout.CENTER);
		
		revalidate();
		Utility.repaintLater(this);
	}

	/**
	 * @return the areaEditor
	 */
	public AreasPropertiesBase getAreaEditor() {
		return areaEditor;
	}

	/**
	 * Dispose.
	 */
	public void dispose() {

		areaEditor.dispose();
	}
}
