package com.hallahan.premierplugin;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import com.hallahan.premierTable.PremierTableView;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(true);
		layout.addView(PremierTableView.ID, IPageLayout.LEFT, 1.0f, layout.getEditorArea());
	}
}
