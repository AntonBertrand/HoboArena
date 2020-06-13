package package01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoiceHandler implements ActionListener{

	Game game;

	public ChoiceHandler(Game g) {
		game = g;
	}

	public void actionPerformed(ActionEvent event) {

		String yourChoice = event.getActionCommand();

		switch(game.position) {
		case "menu":
			switch(yourChoice) {
			case "c1": game.battle(); break;
			case "c2": game.explore(); break;
			case "c3": game.shop(); break;
			case "c4": game.death(); break;
			}
			break;

		case "battle":
			switch(yourChoice) {
			case "c1": game.battleAttack(); break;
			case "c2": game.battlePotion(); break;
			case "c3": game.run(); break;
			}
			break;

		case "enemyDefeated":
			switch(yourChoice) {
			case "c1": game.menu(); break;
			}
			break;

		case "playerDead":
			switch(yourChoice) {
			case "c1": game.death(); break;
			}
			break;

		case "backhome":
			switch(yourChoice) {
			case "c1": game.menu(); break;
			}
			break;	 


		case "shop":
			switch(yourChoice) {
			case "c1": game.menu();  break;
			case "a1": game.purchaseItem1(); break;
			case "a2": game.purchaseItem2(); break;
			case "a3": game.purchaseItem3(); break;
			case "a4": game.purchaseItem4(); break;
			}
			break;	

		case "title":
			switch(yourChoice) {
			case "c1": game.CreateGameScreen(); break;
			}
			break;

		case "death":
			switch(yourChoice) {
			case "c1": game.submitButtonClicked(); break;
			}
			break;
		}


	}
}


