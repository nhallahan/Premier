package com.hallahan.premierplugin;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

import com.hallahan.actionPackage.AddMatchAction;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {
	private IWorkbenchAction exitAction;
	private IWorkbenchAction aboutAction;
	private IWorkbenchAction addMatchAction;
	

    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
    }

    protected void makeActions(IWorkbenchWindow window) {
    	exitAction = ActionFactory.QUIT.create(window);
    	register(exitAction);
    	aboutAction = ActionFactory.ABOUT.create(window);
    	register(aboutAction);
    	addMatchAction = new AddMatchAction(window);
    	
    }

    protected void fillMenuBar(IMenuManager menuBar) {
    	MenuManager premierMenu = new MenuManager("&Premier", "premier");
    	premierMenu.add(addMatchAction);
    	premierMenu.add(exitAction);
    	MenuManager helpMenu = new MenuManager("&Help", "help");
    	helpMenu.add(aboutAction);
    	menuBar.add(premierMenu);
    	menuBar.add(helpMenu);
    }
    
}
