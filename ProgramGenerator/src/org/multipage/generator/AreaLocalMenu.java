/*
 * Copyright 2010-2021 (C) vakol (see attached LICENSE file for additional info)
 * 
 * Created on : 26-04-2017
 *
 */

package org.multipage.generator;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.awt.geom.*;

import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import org.multipage.gui.*;
import org.multipage.util.*;

import com.maclan.Area;

/**
 * @author
 *
 */
public class AreaLocalMenu {

	/**
	 * Constants.
	 */
	public static final int DIAGRAM = 1;
	public static final int EDITOR = 2;

	/**
	 * Listeners.
	 */
	private AreaLocalMenuListener listener =
		new AreaLocalMenuListener();
	
	/**
	 * Is favorites flag.
	 */
	public boolean isAddFavorites = true;

	/**
	 * Menu purpose.
	 */
	private int purpose = 0;
	
	/**
	 * Parent component.
	 */
	private Component parentComponent;
	
	/**
	 * Constructor.
	 * @param areaLocalMenuListener
	 */
	public AreaLocalMenu(AreaLocalMenuListener listener) {
		
		this.listener = listener;
	}

	/**
	 * Constructor.
	 * @param listener
	 * @param purpose
	 */
	public AreaLocalMenu(AreaLocalMenuListener listener, int purpose) {

		this(listener);
		
		this.purpose = purpose;
	}

	/**
	 * Add items to a popup trayMenu.
	 * @param popupMenu
	 */
	public void addTo(Component parentComponent, JPopupMenu popupMenu) {
		
		this.parentComponent = parentComponent;
		addTo(popupMenu, popupMenu.getComponentCount() + 1);
	}

	/**
	 * Add items to a popup trayMenu.
	 * @param popupMenuFavorites
	 * @param start
	 */
	public void addTo(JPopupMenu popupMenu, int start) {
		
		JMenuItem menuCopyAreaTree = new JMenuItem(
				Resources.getString("org.multipage.generator.menuCopyAreaTree"));
		menuCopyAreaTree.setIcon(Images.getIcon("org/multipage/gui/images/copy_icon.png"));
		
		JMenuItem menuPasteAreaTree = new JMenuItem(
				Resources.getString("org.multipage.generator.menuPasteAreaTree"));
		menuPasteAreaTree.setIcon(Images.getIcon("org/multipage/gui/images/paste_icon.png"));
				
		JMenuItem menuAddToFavoritesArea = new JMenuItem(
				Resources.getString("org.multipage.generator.menuAddToFavorites"));
		menuAddToFavoritesArea.setIcon(Images.getIcon("org/multipage/generator/images/favorite.png"));
		
		JMenu menuCreateAreas = new JMenu(Resources.getString("org.multipage.generator.menuCreateAreas"));
		
		JMenuItem menuExternalSources = new JMenuItem(
				Resources.getString("org.multipage.generator.menuExternalSourceCodes"));
		menuCreateAreas.add(menuExternalSources);
		
		JMenuItem menuSetHomeArea = new JMenuItem(
				Resources.getString("org.multipage.generator.menuSetHomeArea"));
		menuSetHomeArea.setIcon(Images.getIcon("org/multipage/generator/images/home_page.png"));
		
		JMenuItem menuEditAreaSlots = new JMenuItem(
				Resources.getString("org.multipage.generator.menuEditArea"));
		menuEditAreaSlots.setIcon(Images.getIcon("org/multipage/generator/images/list.png"));
		
		JMenuItem menuEditAreaResources = new JMenuItem(
				Resources.getString("org.multipage.generator.menuAreaEditResources"));
		
		JMenu menuFile = new JMenu(Resources.getString("org.multipage.generator.menuFile"));
		
		JMenuItem menuExport = new JMenuItem(
				Resources.getString("org.multipage.generator.menuFileExport"));
		menuExport.setIcon(Images.getIcon("org/multipage/generator/images/export2_icon.png"));
		
		JMenuItem menuImport = new JMenuItem(
				Resources.getString("org.multipage.generator.menuFileImport"));
		menuImport.setIcon(Images.getIcon("org/multipage/generator/images/import2_icon.png"));
		
		JMenuItem menuFocusArea = new JMenuItem(
				Resources.getString("org.multipage.generator.menuFocusArea"));
		menuFocusArea.setIcon(Images.getIcon("org/multipage/generator/images/search_icon.png"));
		
		JMenuItem menuFocusSuperArea = new JMenuItem(
				Resources.getString("org.multipage.generator.menuFocusSuperArea"));
		menuFocusSuperArea.setIcon(Images.getIcon("org/multipage/generator/images/search_parent.png"));
		menuFocusSuperArea.setAccelerator(KeyStroke.getKeyStroke("control S"));
		
		JMenuItem menuFocusNextArea = new JMenuItem(
				Resources.getString("org.multipage.generator.menuFocusNextArea"));
		menuFocusNextArea.setIcon(Images.getIcon("org/multipage/generator/images/next.png"));
		
		JMenuItem menuFocusPreviousArea = new JMenuItem(
				Resources.getString("org.multipage.generator.menuFocusPreviousArea"));
		menuFocusPreviousArea.setIcon(Images.getIcon("org/multipage/generator/images/previous.png"));
		
		JMenuItem menuFocusTabTopArea = new JMenuItem(
				Resources.getString("org.multipage.generator.menuFocusTabTopArea"));
		menuFocusTabTopArea.setIcon(Images.getIcon("org/multipage/generator/images/focus_tab.png"));

		JMenu menuEditArea = new JMenu(
				Resources.getString("org.multipage.generator.menuEditAreaResourcesList"));
		menuEditArea.setIcon(Images.getIcon("org/multipage/generator/images/edit.png"));

		JMenuItem menuCopyDescription = new JMenuItem(
				Resources.getString("org.multipage.generator.menuCopyAreaDescription"));
		menuCopyDescription.setIcon(Images.getIcon("org/multipage/gui/images/copy_icon.png"));
		
		JMenuItem menuCopyAlias = new JMenuItem(
				Resources.getString("org.multipage.generator.menuCopyAreaAlias"));
		menuCopyAlias.setIcon(Images.getIcon("org/multipage/gui/images/copy_icon.png"));
		
		JMenuItem menuAreaTrace = new JMenuItem(
				Resources.getString("org.multipage.generator.menuAreaTrace"));
		menuAreaTrace.setIcon(Images.getIcon("org/multipage/generator/images/area_trace.png"));
		
		JMenuItem menuDisplayArea = new JMenuItem(
				Resources.getString("org.multipage.generator.menuDisplayOnlineArea"));
		menuDisplayArea.setIcon(Images.getIcon("org/multipage/generator/images/display.png"));

		JMenuItem menuDisplayRenderedArea = new JMenuItem(
				Resources.getString("org.multipage.generator.menuDisplayRenderedArea"));
		menuDisplayRenderedArea.setIcon(Images.getIcon("org/multipage/generator/images/display_rendered.png"));
		
		JMenu displayMenu = new JMenu(
				Resources.getString("org.multipage.generator.menuDisplayMenu"));
		displayMenu.add(menuDisplayArea);
		displayMenu.add(menuDisplayRenderedArea);
		
		JMenuItem menuAreaHelp = new JMenuItem(
				Resources.getString("org.multipage.generator.menuAreaHelp"));
		menuAreaHelp.setIcon(Images.getIcon("org/multipage/generator/images/help_small.png"));
				
		JMenuItem menuAreaInheritedFolders = new JMenuItem(
				Resources.getString("org.multipage.generator.menuAreaInheritedFolders"));
		menuAreaInheritedFolders.setIcon(Images.getIcon("org/multipage/generator/images/folder.png"));
		
		JMenu focusMenu = new JMenu(
				Resources.getString("org.multipage.generator.menuFocus"));
		
		JMenu selectMenu = new JMenu(
				Resources.getString("org.multipage.generator.menuSelect"));
		
		JMenuItem menuSelectArea = new JMenuItem(
				Resources.getString("org.multipage.generator.menuSelectArea2"));
		menuSelectArea.setIcon(Images.getIcon("org/multipage/generator/images/selected_area.png"));
		
		JMenuItem menuSelectAreaAdd = new JMenuItem(
				Resources.getString("org.multipage.generator.menuSelectAreaAdd"));
		menuSelectAreaAdd.setIcon(Images.getIcon("org/multipage/generator/images/selected_area_add.png"));
		
		JMenuItem menuSelectAreaAndSuabreas = new JMenuItem(
				Resources.getString("org.multipage.generator.menuSelectAreaAndSubareas2"));
		menuSelectAreaAndSuabreas.setIcon(Images.getIcon("org/multipage/generator/images/selected_subareas.png"));
		
		JMenuItem menuSelectAreaAndSuabreasAdd = new JMenuItem(
				Resources.getString("org.multipage.generator.menuSelectAreaAndSubareasAdd"));
		menuSelectAreaAndSuabreasAdd.setIcon(Images.getIcon("org/multipage/generator/images/selected_subareas_add.png"));
		JMenuItem menuClearSelection = new JMenuItem(
				Resources.getString("org.multipage.generator.menuClearSelection"));
		menuClearSelection.setIcon(Images.getIcon("org/multipage/generator/images/cancel_icon.png"));
		// Add clone trayMenu item.
		JMenuItem menuCloneDiagram = new JMenuItem(Resources.getString("org.multipage.generator.menuCloneAreasDiagram"),
				Images.getIcon("org/multipage/generator/images/clone.png"));
		
		int index = start;

		popupMenu.insert(menuCopyAreaTree, index++);
		popupMenu.insert(menuPasteAreaTree, index++);
		popupMenu.addSeparator(); index++;
		
		if (isAddFavorites) {
			popupMenu.insert(menuAddToFavoritesArea, index++);
			popupMenu.addSeparator(); index++;
		}
		if ((purpose & DIAGRAM) == 0) {
			popupMenu.insert(selectMenu, index++);
		}
		popupMenu.insert(menuCreateAreas, index++);
		popupMenu.insert(menuSetHomeArea, index++);
		popupMenu.insert(menuEditArea, index++);
		popupMenu.insert(menuEditAreaSlots, index++);
		popupMenu.insert(menuEditAreaResources, index++);
		popupMenu.addSeparator(); index++;
		popupMenu.insert(menuSetHomeArea, index++);
		popupMenu.addSeparator(); index++;
		index = insertEditResourceMenuItems(popupMenu, index);
		popupMenu.insert(focusMenu, index++);
		popupMenu.insert(displayMenu, index++);
		popupMenu.insert(menuFile, index++);
		popupMenu.addSeparator(); index++;
		popupMenu.insert(menuAreaTrace, index++);
		popupMenu.insert(menuAreaInheritedFolders, index++);
		popupMenu.addSeparator(); index++;
		popupMenu.insert(menuCopyDescription, index++);
		popupMenu.insert(menuCopyAlias, index++);
		popupMenu.addSeparator(); index++;
		popupMenu.insert(menuAreaHelp, index++);
		popupMenu.addSeparator(); index++;
		popupMenu.insert(menuCloneDiagram, index++);
		
		index = 0;
		menuFile.insert(menuImport, index++);
		menuFile.insert(menuExport, index++);
				
		index = 0;
		focusMenu.insert(menuFocusArea, index++);
		focusMenu.insert(menuFocusSuperArea, index++);
		focusMenu.insert(menuFocusNextArea, index++);
		focusMenu.insert(menuFocusPreviousArea, index++);
		index = insertFocusMenuItems(focusMenu, index++);
		focusMenu.addSeparator(); index++;
		focusMenu.insert(menuFocusTabTopArea, index++);
		
		insertEditAreaMenu(menuEditArea);
		
		if ((purpose & DIAGRAM) == 0) {
			index = 0;
			selectMenu.insert(menuSelectArea, index++);
			selectMenu.insert(menuSelectAreaAdd, index++);
			selectMenu.insert(menuSelectAreaAndSuabreas, index++);
			selectMenu.insert(menuSelectAreaAndSuabreasAdd, index++);
			selectMenu.addSeparator(); index++;
			selectMenu.insert(menuClearSelection, index++);
		}

		// Add listeners.
		menuCopyAreaTree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				copyAreaTree();
			}
		});
		menuPasteAreaTree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasteAreaTree();
			}
		});
		if (isAddFavorites) {
			menuAddToFavoritesArea.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addToFavorites();
				}
			});
		}
		menuExternalSources.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createExternalSources();
			}
		});
		menuEditAreaSlots.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editArea();
			}
		});
		menuFocusArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				focusArea();
			}
		});
		menuFocusSuperArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				focusSuperArea();
			}
		});
		menuFocusNextArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				focusNextArea();
			}
		});
		menuFocusPreviousArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				focusPreviousArea();
			}
		});
		menuCopyDescription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				copyDescription();
			}
		});
		menuCopyAlias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				copyAlias();
			}
		});
		menuAreaTrace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showAreaTrace();
			}
		});
		menuAreaInheritedFolders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showAreaInheritedFolders();
			}
		});
		menuAreaHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewHelp();
			}
		});
		menuDisplayArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayOnlineArea();
			}
		});
		menuDisplayRenderedArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayRenderedArea();
			}
		});
		menuSelectArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectArea();
			}
		});
		menuSelectAreaAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectAreaAdd();
			}
		});
		menuSelectAreaAndSuabreas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectAreaAndSubareas();
			}
		});
		menuSelectAreaAndSuabreasAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectAreaAndSubareasAdd();
			}
		});
		menuClearSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearSelection();
			}
		});
		menuCloneDiagram.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cloneDiagram();
			}
		});
		menuSetHomeArea.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setHomeArea();
			}
		});
		menuFocusTabTopArea.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				focusTabTopArea();
			}
		});
		menuExport.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exportArea();
			}
		});
		menuImport.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				importArea();
			}
		});
		menuEditAreaResources.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onEditArea(AreaEditor.RESOURCES);
			}
		});
		
		// Set listeners.
		popupMenu.addPopupMenuListener(new PopupMenuListener() {
			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
				
				// Enable / disable paste area tree trayMenu item.
				menuPasteAreaTree.setEnabled(GeneratorMainFrame.getFrame().isAreaTreeDataCopy());
			}
			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
			}
			@Override
			public void popupMenuCanceled(PopupMenuEvent e) {
			}
		});
	}
	
	/**
	 * Create external sources.
	 */
	protected void createExternalSources() {
		
		Area area = listener.getCurrentArea();
		CreateAreasFromSourceCode.showDialog(parentComponent, area);
	}

	/**
	 * Insert edit trayMenu items.
	 * @param popupMenu 
	 * @param index
	 * @return
	 */
	protected int insertEditResourceMenuItems(JPopupMenu popupMenu, int index) {
		
		// Override this method.
		return index;
	}

	/**
	 * Insert focus trayMenu items.
	 * @param focusMenu
	 * @param index
	 * @return
	 */
	protected int insertFocusMenuItems(JMenu focusMenu, int index) {
		
		// Override this method.
		return index;
	}

	/**
	 * Insert edit area trayMenu.
	 * @param menuEditArea
	 * @return
	 */
	protected void insertEditAreaMenu(JMenu menuEditArea) {
		
		JMenuItem menuAreaEdit = new JMenuItem(Resources.getString("org.multipage.generator.menuAreaEdit"));
		menuAreaEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onEditArea(AreaEditor.NOT_SPECIFIED);
			}
		});
		menuEditArea.add(menuAreaEdit);
		menuEditArea.addSeparator();
		
		JMenuItem menuEditResources = new JMenuItem(Resources.getString("org.multipage.generator.menuAreaEditResources"));
		menuEditResources.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				onEditArea(AreaEditor.RESOURCES);
			}
		});
		
		menuEditArea.add(menuEditResources);
		
		JMenuItem menuEditDependencies = new JMenuItem(Resources.getString("org.multipage.generator.menuAreaEditDependencies"));
		menuEditDependencies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onEditArea(AreaEditor.DEPENDENCIES);
			}
		});
		menuEditArea.add(menuEditDependencies);
	}

	/**
	 * Display renderd area.
	 */
	protected void displayRenderedArea() {
		
		// Get selected areas.
		Area area = getAreaInformUser();
		if (area == null) {
			return;
		}
		
		GeneratorMainFrame.displayRenderedArea(area);
	}

	/**
	 * Display online area.
	 */
	protected void displayOnlineArea() {
		
		// Get selected areas.
		Area area = getAreaInformUser();
		if (area == null) {
			return;
		}
		
		GeneratorMainFrame.getFrame().displayOnlineArea(area);
	}

	/**
	 * Get area. Inform user on error.
	 * @return
	 */
	protected Area getAreaInformUser() {
		
		Area area = listener.getCurrentArea();
		if (area == null) {
			Utility.show(null, "org.multipage.generator.messageSelectSingleArea");
			return null;
		}
		return area;
	}

	/**
	 * Add to favorites.
	 */
	protected void addToFavorites() {
		
		// Get selected areas.
		Area area = getAreaInformUser();
		if (area == null) {
			return;
		}
		
		GeneratorMainFrame.getFrame().getAreaDiagramEditor().addFavorite(area);
	}

	/**
	 * Edit area.
	 */
	protected void editArea() {

		// Get selected areas.
		Area area = getAreaInformUser();
		if (area == null) {
			return;
		}
		
		// Open area editor.
		AreasPropertiesFrame.createNew(area);
	}

	/**
	 * Focus selected area.
	 */
	protected void focusArea() {

		// Get selected areas.
		Area area = getAreaInformUser();
		if (area == null) {
			return;
		}
		
		// Focus on area.
		GeneratorMainFrame.getFrame().getVisibleAreasEditor().focusArea(area.getId());
	}

	/**
	 * Focus tab top area.
	 */
	protected void focusTabTopArea() {

		Long tabAreaId = GeneratorMainFrame.getTabAreaId();
		
		Event.propagate(this, Event.focusTabArea, tabAreaId);
	}

	/**
	 * Focus super area.
	 */
	protected void focusSuperArea() {

		// Get selected areas.
		Area area = getAreaInformUser();
		if (area == null) {
			return;
		}
		
		// Get area shapes.
		AreaShapes shapes = (AreaShapes) area.getUser();
		// Get parent area.
		Rectangle2D diagramRect = GeneratorMainFrame.getFrame().getAreaDiagram().getRectInCoord();
		Area superArea = shapes.getVisibleParent(diagramRect);
		
		if (superArea != null) {
			// Focus on area.
			GeneratorMainFrame.getFrame().getVisibleAreasEditor().focusAreaNear(superArea.getId());
		}
	}

	/**
	 * Focus next area.
	 */
	protected void focusNextArea() {

		// Get selected areas.
		Area area = getAreaInformUser();
		if (area == null) {
			return;
		}
		
		// Get area shapes.
		AreaShapes shapes = (AreaShapes) area.getUser();
		// Get parent area.
		Rectangle2D diagramRect = GeneratorMainFrame.getFrame().getAreaDiagram().getRectInCoord();
		Area superArea = shapes.getVisibleParent(diagramRect);
		
		if (superArea != null) {
			
			// Get next area.
			Area nextArea = area.getNextArea(superArea);
			if (nextArea != null) {
				
				// Focus on next area.
				GeneratorMainFrame.getFrame().getVisibleAreasEditor().focusAreaNear(nextArea.getId());
			}
			else {
				Utility.show(null, "org.multipage.generator.messageIsLastArea");
			}
		}
	}

	/**
	 * Focus previous area.
	 */
	protected void focusPreviousArea() {

		// Get selected areas.
		Area area = getAreaInformUser();
		if (area == null) {
			return;
		}
		
		// Get area shapes.
		AreaShapes shapes = (AreaShapes) area.getUser();
		// Get parent area.
		Rectangle2D diagramRect = GeneratorMainFrame.getFrame().getAreaDiagram().getRectInCoord();
		Area superArea = shapes.getVisibleParent(diagramRect);
		
		if (superArea != null) {
			
			// Get previous area.
			Area previousArea = area.getPreviousArea(superArea);
			if (previousArea != null) {
				
				// Focus on previous area.
				GeneratorMainFrame.getFrame().getVisibleAreasEditor().focusAreaNear(previousArea.getId());
			}
			else {
				Utility.show(null, "org.multipage.generator.messageThisIsFirstArea");
			}
		}
	}

	/**
	 * Edit area with area editor.
	 */
	protected void onEditArea(int tabIdentifier) {
		
		// Get selected areas.
		Area area = getAreaInformUser();
		if (area == null) {
			return;
		}

		// Execute area editor.
		AreaEditor.showDialog(null, area, tabIdentifier);
	}

	/**
	 * Copy area alias.
	 */
	protected void copyAlias() {
		
		// Get selected areas.
		Area area = getAreaInformUser();
		if (area == null) {
			return;
		}
		
		StringSelection ss = new StringSelection(area.getAlias());
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	}

	/**
	 * Copy area description.
	 */
	protected void copyDescription() {
		
		// Get selected areas.
		Area area = getAreaInformUser();
		if (area == null) {
			return;
		}
		
		StringSelection ss = new StringSelection(area.getDescriptionForced());
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	}

	/**
	 * Show trace area.
	 */
	protected void showAreaTrace() {
		
		// Get selected areas.
		Area area = getAreaInformUser();
		if (area == null) {
			return;
		}
		
		AreaTraceFrame.showNewFrame(area.getId());
	}

	/**
	 * Show area inherited folders.
	 */
	protected void showAreaInheritedFolders() {
		
		// Get selected areas.
		Area area = getAreaInformUser();
		if (area == null) {
			return;
		}
		
		AreaInheritedFoldersDialog.showDialog(GeneratorMainFrame.getFrame(), area);
	}

	/**
	 * View help.
	 */
	protected void viewHelp() {
		// Get selected areas.
		Area area = getAreaInformUser();
		if (area == null) {
			return;
		}
		
		GeneratorMainFrame.getFrame().findViewAreaHelp(area);
	}
	
	/**
	 * Select area.
	 */
	protected void selectArea() {

		// Get selected areas.
		Area area = getAreaInformUser();
		if (area == null) {
			return;
		}
		
		GeneratorMainFrame.getFrame().getVisibleAreasEditor().getDiagram().selectArea(area.getId(), true);
	}

	/**
	 * Add area selection.
	 */
	protected void selectAreaAdd() {
		
		// Get selected areas.
		Area area = getAreaInformUser();
		if (area == null) {
			return;
		}
		
		GeneratorMainFrame.getFrame().getVisibleAreasEditor().getDiagram().selectArea(area.getId(), false);
	}

	/**
	 * Select area and subareas.
	 */
	protected void selectAreaAndSubareas() {
		
		// Get selected areas.
		Area area = getAreaInformUser();
		if (area == null) {
			return;
		}
		
		GeneratorMainFrame.getFrame().getVisibleAreasEditor().getDiagram().selectAreaWithSubareas(area.getId(), true);
	}
	
	/**
	 * Add area and subareas selection.
	 */
	protected void selectAreaAndSubareasAdd() {
			
		// Get selected areas.
		Area area = getAreaInformUser();
		if (area == null) {
			return;
		}
		
		GeneratorMainFrame.getFrame().getVisibleAreasEditor().getDiagram().selectAreaWithSubareas(area.getId(), false);
	}

	/**
	 * Clear selection.
	 */
	protected void clearSelection() {
		
		GeneratorMainFrame.getFrame().getVisibleAreasEditor().getDiagram().removeSelection();
	}
	
	/**
	 * Clone diagram.
	 */
	protected void cloneDiagram() {
		
		// Get selected area (can be null).
		Area area = listener.getCurrentArea();
		
		GeneratorMainFrame.getFrame().cloneAreasDiagram(area);
	}

	/**
	 * Set home area.
	 */
	protected void setHomeArea() {
		
		// Get selected areas.
		Area area = getAreaInformUser();
		if (area == null) {
			return;
		}
		
		GeneratorMainFrame.getFrame().setHomeArea(parentComponent, area);
	}

	/**
	 * Copy area tree.
	 */
	protected void copyAreaTree() {
		
		// Get selected area (can be null) and copy area tree.
		Area area = listener.getCurrentArea();
		Area parentArea = listener.getCurrentParentArea();
		
		GeneratorMainFrame.getFrame().copyAreaTree(area, parentArea);
	}

	/**
	 * Paste area tree.
	 */
	protected void pasteAreaTree() {
		
		// Get selected area and paste area tree.
		Area area = listener.getCurrentArea();
		
		GeneratorMainFrame.getFrame().pasteAreaTree(area);
	}

	/**
	 * Export area.
	 */
	protected void exportArea() {
		
		Area area = listener.getCurrentArea();
		if (area == null) {
			return;
		}
		
		Component parent = listener.getComponent();
		if (parent == null) {
			parent = GeneratorMainFrame.getFrame();
		}
		
		GeneratorMainFrame.exportArea(area, parent);
	}

	/**
	 * Import area.
	 */
	protected void importArea() {
		
		Area area = listener.getCurrentArea();
		if (area == null) {
			return;
		}
		
		Component parent = listener.getComponent();
		if (parent == null) {
			parent = GeneratorMainFrame.getFrame();
		}
		
		Long newAreaId = GeneratorMainFrame.importArea(area, parent, true, false, false);
		
		// Callback method.
		if (newAreaId != null) {
			
			Event.propagate(AreaLocalMenu.this, Event.importToArea, area.getId());
			
			SwingUtilities.invokeLater(() -> {
				listener.onNewArea(newAreaId);
			});
		}
	}
	/**
	 * Set purpose.
	 * @param purpose
	 */
	public void setHint(int purpose) {

		this.purpose = purpose;
	}
}
