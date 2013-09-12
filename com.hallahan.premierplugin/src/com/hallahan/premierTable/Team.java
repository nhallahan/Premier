package com.hallahan.premierTable;


import java.io.Serializable;
import java.util.ArrayList;


public class Team implements Serializable{
	
		private String teamName = "";
		private int gamesPlayed = 0;
		private int gamesWon = 0;
		private int gamesDrawn = 0;
		private int gamesLost = 0;
		private int goalsScored = 0;
		private int goalsConceded = 0;
		private int goalDifference = 0;
		private int points = 0;
		
		
		public Team(String teamName){
			this.teamName = teamName;
		}

		public String getTeamName() {
			return teamName;
		}

		public void setTeamName(String teamName) {
			this.teamName = teamName;
		}

		public int getGamesPlayed() {
			return gamesPlayed;
		}

		public void setGamesPlayed(int gamesPlayed) {
			this.gamesPlayed = gamesPlayed;
		}
		public void incrementGamesPlayed(){
			gamesPlayed++;
		}

		public int getGamesWon() {
			return gamesWon;
		}

		public void setGamesWon(int gamesWon) {
			this.gamesWon = gamesWon;
		}

		public int getGamesDrawn() {
			return gamesDrawn;
		}

		public void setGamesDrawn(int gamesDrawn) {
			this.gamesDrawn = gamesDrawn;
		}

		public int getGamesLost() {
			return gamesLost;
		}

		public void setGamesLost(int gamesLost) {
			this.gamesLost = gamesLost;
		}

		public int getGoalsScored() {
			return goalsScored;
		}

		public void setGoalsScored(int goalsScored) {
			this.goalsScored = goalsScored;
		}

		public int getGoalsConceded() {
			return goalsConceded;
		}

		public void setGoalsConceded(int goalsConceded) {
			this.goalsConceded = goalsConceded;
		}

		public int getGoalDifference() {
			return goalDifference;
		}

		public void setGoalDifference(int goalDifference) {
			this.goalDifference = goalDifference;
		}

		public int getPoints() {
			return points;
		}

		public void setPoints(int points) {
			this.points = points;
		}
		
		public static ArrayList<Team> example(){
			String [] teamNames = {"Man Utd","Aston Villa","Chelsea","West Ham","Fulham"
					,"Liverpool","Southampton","Tottenham","Everton","Norwich","Man City","Crystal Palace"
					,"Stoke","Sunderland","West Brom","Cardiff","Arsenal","Hull","Swansea","Newcastle"};
			
			ArrayList<Team> listOfTeams = new ArrayList<Team>();
			
			// create an array with your list of teams and name them
			for (int i = 0; i < teamNames.length; i++) {
				Team t1 = new Team(teamNames[i]);
				listOfTeams.add(t1);
			}
			return listOfTeams;
		}
}

