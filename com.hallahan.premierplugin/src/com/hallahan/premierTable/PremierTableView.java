package com.hallahan.premierTable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.ViewPart;

public class PremierTableView extends ViewPart {
	public static final String ID = "com.hallahan.premierplugin.views.PremierTable";
	
	static ArrayList<Team> ListOfTeams;

	public PremierTableView() {
		super();
	}

	@Override
	public void createPartControl(final Composite parent) {
		final TableViewer tableViewer = new TableViewer(
				parent, SWT.SINGLE | SWT.FULL_SELECTION);
		final Table table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		String [] columnNames = new String[] {
				"Position","Team Name","Played","Win","Draw","Loss","G/S",
				"G/C","G/D","Points"};
		
		int [] columnWidths = new int [] {
				47, 100,40,35,45,45,45,45,45,45};
		int [] columnAlignments = new int[] { 
				SWT.CENTER, SWT.LEFT, SWT.CENTER, SWT.CENTER,SWT.CENTER,
				SWT.CENTER, SWT.CENTER, SWT.CENTER, SWT.CENTER,SWT.CENTER};
		
		for (int i = 0; i < columnNames.length; i++){
			TableColumn tableColumn = 
					new TableColumn(table, columnAlignments[i]);
			tableColumn.setText(columnNames[i]);
			tableColumn.setWidth(columnWidths[i]);
		}
		
		tableViewer.setLabelProvider(new TeamLabelProvider());
		tableViewer.setContentProvider(new ArrayContentProvider());
		
		//Create File Menu & Add Team
//		Menu bar = new Menu(parent);
//		parent.setMenu(bar);
//		MenuItem fileMenu = new MenuItem(bar, SWT.CASCADE);
//		fileMenu.setText("&File");
//		Menu subMenu = new Menu(parent);
//		fileMenu.setMenu(subMenu);
//		MenuItem selectItem = new MenuItem(subMenu, SWT.NULL);
//		selectItem.setText("&Add Match");
//		selectItem.addSelectionListener(new SelectionAdapter(){
//			public void widgetSelected(SelectionEvent event){
//				System.out.println("Launching add Match window");
//				AddMatchGui dialog = new AddMatchGui(parent);
//				dialog.create();
//				if (dialog.open() == Window.OK) {
//					AddMatchValidationCriteria amvc = new AddMatchValidationCriteria();
//					boolean selectionVerified = amvc.validateMatchInput(dialog.getHomeTeam(), 
//							  dialog.getAwayTeam(),ListOfTeams);
//					if(!selectionVerified){
//						MessageDialog.openError((Shell) parent, "Error", "Invalid criteria");
//					}else{
//					ListOfTeams = AddMatchFunctionality.updateTeamGamesPlayed(dialog.getHomeTeam(), 
//						dialog.getAwayTeam(), ListOfTeams);
//						tableViewer.setInput(ListOfTeams);
//					}
//				} 
//			}
//		});

//		reload previous table if a saved copy exists
				File f = new File("C:/Users/Niall/Desktop/Storage" +
						"/TeamSer.ser");
				if(f.exists()) { 
					try {
						FileInputStream fis = new FileInputStream("C:/Users/Niall/Desktop/Storage" +
						"/TeamSer.ser");
						ObjectInputStream ois = new ObjectInputStream(fis);
						ListOfTeams = (ArrayList<Team>) ois.readObject();
						tableViewer.setInput(ListOfTeams);
					} catch (Exception e) {
						System.out.println("PremierTableViewer.main(): Issue reading save directory");
					} 
					}else {
						ListOfTeams = Team.example();
						tableViewer.setInput(ListOfTeams);
					}
				
//				MenuItem sep = new MenuItem(subMenu, SWT.SEPARATOR);
//				MenuItem exitItem = new MenuItem(subMenu, SWT.NULL);
//				exitItem.setText("&Exit");
//				exitItem.addSelectionListener(new SelectionAdapter(){
//					public void widgetSelected(SelectionEvent event){
//						parent.dispose();
//					}
//				});
				
//				parent.open();
//				while (!parent.isDisposed()){
//					if(!display.readAndDispatch()) display.sleep();
//				}
//				try {
//					FileOutputStream fs = new FileOutputStream("C:/Users/Niall/Desktop/Storage" +
//							"/TeamSer.ser");
//					ObjectOutputStream os = new ObjectOutputStream(fs);
//					os.writeObject(ListOfTeams);
//				} catch (Exception e) {
//					System.out.println("PremierTableViewer.main(): Issue saving configuration");
//					e.printStackTrace();
//				}


	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
