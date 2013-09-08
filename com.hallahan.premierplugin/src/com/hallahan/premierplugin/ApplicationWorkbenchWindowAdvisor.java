package com.hallahan.premierplugin;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

    public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        super(configurer);
    }

    public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
        return new ApplicationActionBarAdvisor(configurer);
    }
    
    public void preWindowOpen() {
        IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
        configurer.setInitialSize(new Point(580,490));
        configurer.setShowCoolBar(false);
        configurer.setShowStatusLine(false);
        configurer.setShowMenuBar(true);
        configurer.setTitle("Premier"); //$NON-NLS-1$
    }
    @Override
    public void postWindowCreate() {
      Shell shell = getWindowConfigurer().getWindow().getShell();
      shell.setLocation(300, 100);
      shell.setSize(new Point(580,490));
      super.postWindowCreate();
    } 
}
