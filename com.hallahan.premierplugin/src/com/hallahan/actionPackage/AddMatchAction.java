package com.hallahan.actionPackage;

import java.util.ArrayList;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;

import com.hallahan.premierTable.AddMatchFunctionality;
import com.hallahan.premierTable.AddMatchGui;
import com.hallahan.premierTable.AddMatchValidationCriteria;
import com.hallahan.premierTable.PremierTableView;
import com.hallahan.premierTable.Team;

public class AddMatchAction  extends Action implements ActionFactory.IWorkbenchAction {
		private final IWorkbenchWindow window;
		public final static String ID = "com.hallahan.actionPackage.AddMatch";
		TableViewer tv;
		
		public AddMatchAction(IWorkbenchWindow window) {
			this.window = window;
			setId(ID);
			setText("&Add Match...");
			setToolTipText("Add match information");
			System.out.println("AddMatchAction.AddMatchAction()");
			
		}
		public void dispose(){
			
		}


	public void run() {
		ArrayList<Team> ListOfTeams = PremierTableView.getListOfTeams();
		System.out.println("Launching add Match window");
		AddMatchGui dialog = new AddMatchGui(window.getShell());
		dialog.create();
		if (dialog.open() == Window.OK) {
			AddMatchValidationCriteria amvc = new AddMatchValidationCriteria();
			boolean selectionVerified = amvc.validateMatchInput(
					dialog.getHomeTeam(), dialog.getAwayTeam(), ListOfTeams);

			if (!selectionVerified) {
				MessageDialog.openError(window.getShell(), "Error",
						"Invalid criteria");
			} else {
				ListOfTeams = AddMatchFunctionality
						.updateTeamGamesPlayed(dialog.getHomeTeam(),
								dialog.getAwayTeam(), ListOfTeams);
				
				PremierTableView view = (PremierTableView) 
						PremierTableView.getView(window,  PremierTableView.ID);
				view.refreshTable();
	
			}

		}
	}
}
