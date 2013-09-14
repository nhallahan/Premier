package com.hallahan.premierTable;
import java.util.ArrayList;

public class AddMatchValidationCriteria {

		String HomeTeam;
		String AwayTeam;
		ArrayList<Team> localListOfTeams;
		
		public boolean validateMatchInput(String HomeTeam, String AwayTeam, String homeTeamScore, String awayTeamScore
				,ArrayList<Team> ListOfTeams) {
			this.HomeTeam = HomeTeam;
			this.AwayTeam = AwayTeam;
			this.localListOfTeams = ListOfTeams;
			
			//Ensure Teams are different
			if(HomeTeam.equals(AwayTeam)){
				return false;
			}
			return true;
		}

	}
