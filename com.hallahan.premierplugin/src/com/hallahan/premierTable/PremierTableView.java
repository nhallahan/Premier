package com.hallahan.premierTable;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.part.ViewPart;

public class PremierTableView extends ViewPart{
	public static final String ID = "com.hallahan.premierplugin.views.PremierTable";
	
	
	
	static ArrayList<Team> ListOfTeams;
	TableViewer tableViewer;

	public PremierTableView() {
		super();
	}
	
	public static IViewPart getView(IWorkbenchWindow window, String viewId) {
	    IViewReference[] refs = window.getActivePage().getViewReferences();
	    for (IViewReference viewReference : refs) {
	        if (viewReference.getId().equals(viewId)) {
	            return viewReference.getView(true);
	        }
	    }
	    return null;
	}

	public void refreshTable(){
		System.out.println("PremierTableView.refreshTable()");
		tableViewer.refresh();
	}

	public static ArrayList<Team> getListOfTeams() {
		return ListOfTeams;
	}

	public static void setListOfTeams(ArrayList<Team> listOfTeams) {
		ListOfTeams = listOfTeams;
	}

	@Override
	public void createPartControl(final Composite parent) {
		tableViewer = new TableViewer(
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
