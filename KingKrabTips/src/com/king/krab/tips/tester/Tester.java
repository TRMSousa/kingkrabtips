package com.king.krab.tips.tester;

import java.util.List;

import com.king.krab.tips.objects.Game;
import com.king.krab.tips.objects.Team;

public class Tester {

	public static void main(String[] args) {

//INSERIR UM NOVO PAÍS
//		Country oCountry = new Country();
//		oCountry.setName("Portugal").setAbbreviation("PT").build();
//		Country.insert(oCountry);

//		List<Country> lstCoutries = Country.getAllActive();
//		for (Country country : lstCoutries) {
//			System.out.println(country.getName());
//		}
		
		List<Team> lstTeams = Team.getByIdCountry(5);
		for (Team team: lstTeams) {
			System.out.println(team.getName());
		}

//		List<Game> lstGames = Game.getAllByRound(1);
//		for (Game game: lstGames) {
//			System.out.println(game.getNameHomeTeam());
//			System.out.println(game.getNameAwayTeam());
//		}
		
	}

}
