package com.hallahan.premierTable;


import java.util.ArrayList;

public class AddMatchFunctionality {
	public static ArrayList<Team> updateTeamGamesPlayed(String homeTeam, String awayTeam, ArrayList<Team> listOfTeams) {
		ArrayList<Team> LocalListOfTeams = listOfTeams;
		for (Team singleTeam : listOfTeams){
			  if (singleTeam.getTeamName().contains(homeTeam)){
			    System.out.println("Home team is : "+singleTeam.getTeamName());
			    singleTeam.incrementGamesPlayed();
			  }
			  if (singleTeam.getTeamName().contains(awayTeam)){
				    System.out.println("Away team is : "+singleTeam.getTeamName());
				    singleTeam.incrementGamesPlayed();
				  }
			}
		
		return LocalListOfTeams;

	}
	public static ArrayList<Team> updateScores(ArrayList<Team> listOfTeams) {
		ArrayList<Team> LocalListOfTeams = listOfTeams;
		// TODO Auto-generated method stub
		return LocalListOfTeams;
	}

}
