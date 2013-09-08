package com.hallahan.premierTable;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

	public class TeamLabelProvider extends LabelProvider implements 
	ITableLabelProvider {
	public int counter = 0;
	@Override
	public Image getColumnImage(Object arg0, int arg1) {
		return null;
	}

	@Override
	public String getColumnText(Object element, int index) {
		Team team = (Team) element;
		switch (index) {
		case 0:
			int positionValue = ++counter;
			if(counter == 20){
				counter = 0;
			}
			return Integer.toString(positionValue);
		case 1:
			return team.getTeamName();
		case 2:
			return Integer.toString(team.getGamesPlayed());
		case 3: 
			return Integer.toString(team.getGamesWon());
		case 4:
			return Integer.toString(team.getGamesDrawn());
		case 5:
			return Integer.toString(team.getGoalsScored());
		case 6:
			return Integer.toString(team.getGoalsScored());
		case 7:
			return Integer.toString(team.getGoalsConceded());
		case 8:
			return Integer.toString(team.getGoalDifference());
		case 9:
			return Integer.toString(team.getPoints());
			default :
				return "unknown";
		}
	}

}
