package com.hallahan.premierTable;


import java.util.ArrayList;

public class AddMatchFunctionality {
	public static ArrayList<Team> updateTeamResults(String homeTeam, String awayTeam, 
			String homeTeamScore, String awayTeamScore, ArrayList<Team> listOfTeams) {
		int homeGoals = Integer.parseInt(homeTeamScore);
		int awayGoals = Integer.parseInt(awayTeamScore);
		
		String matchResult = matchResult(homeGoals,awayGoals);
		ArrayList<Team> LocalListOfTeams = listOfTeams;
		for (Team singleTeam : listOfTeams){
			  if (singleTeam.getTeamName().contains(homeTeam)){
			    System.out.println("Home team is : "+singleTeam.getTeamName());
			    singleTeam.incrementGamesPlayed();
			    if(matchResult.equals("HomeWin") ){
			    	singleTeam.incrementGamesWon();
			    	singleTeam.updatePoints(3);
			    }else if (matchResult.equals("Draw")) {
					singleTeam.incrementGamesDrawn();
					singleTeam.updatePoints(1);
				}else if (matchResult.equals("AwayWin") ){
					singleTeam.incrementGamesLost();
				}  
			    singleTeam.updateGoalsScored(homeGoals);
			    singleTeam.updateGoalsConceded(awayGoals);
			    singleTeam.updateGoalDifference();
			  }
			  if (singleTeam.getTeamName().contains(awayTeam)){
				    System.out.println("Away team is : "+singleTeam.getTeamName());
				    singleTeam.incrementGamesPlayed();
				    if(matchResult.equals("AwayWin") ){
				    	singleTeam.incrementGamesWon();
				    	singleTeam.updatePoints(3);
				    }else if (matchResult.equals("Draw")) {
						singleTeam.incrementGamesDrawn();
						singleTeam.updatePoints(1);
					}else if (matchResult.equals("HomeWin")){
						singleTeam.incrementGamesLost();
					}
				    singleTeam.updateGoalsScored(awayGoals);
				    singleTeam.updateGoalsConceded(homeGoals);
				  }
			}
		
		return LocalListOfTeams;

	}
	public static ArrayList<Team> updateScores(ArrayList<Team> listOfTeams) {
		ArrayList<Team> LocalListOfTeams = listOfTeams;
		// TODO Auto-generated method stub
		return LocalListOfTeams;
	}
	private static String matchResult(int homeTeamScore, int awayTeamScore){
		String result = null;
		if(homeTeamScore > awayTeamScore){
			result = "HomeWin";
		}else if (homeTeamScore < awayTeamScore) {
			result = "AwayWin";
		}else
			result = "Draw";
		return result;
	}

}
