package package01;

public class VisibilityManager {

	UI ui;

	public VisibilityManager(UI userInterface) {
		ui = userInterface;
	}


	public void showTitleScreen() {

		// Show Title Screen
		//ui.titleNamePanel.setVisible(true);
		ui.titleScreenBGPanel.setVisible(true);
		ui.startButtonPanel.setVisible(true);

		//Hide game screen
		ui.scorePanel.setVisible(false);
		ui.choiceButtonPanel.setVisible(false);
		ui.playerPanel.setVisible(false);
		ui.mainTextPanel.setVisible(false);
		ui.enemyPanel.setVisible(false);
		ui.shopPanel.setVisible(false);
		ui.deathTitlePanel.setVisible(false);
		ui.deathPanel.setVisible(false);
		ui.submitScorePanel.setVisible(false);
		ui.backgroundImagePanel.setVisible(false);



	}

	public void titleToMain() {

		//Hide Title Screen
		//ui.titleNamePanel.setVisible(false);
		ui.titleScreenBGPanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
		ui.shopPanel.setVisible(false);
		ui.shopBGPanel.setVisible(false);

		//Show Main Game Screen
		ui.backgroundImagePanel.setVisible(true);
		ui.mainTextPanel.setVisible(true);
		ui.scorePanel.setVisible(true);
		ui.choiceButtonPanel.setVisible(true);
		ui.playerPanel.setVisible(true);
		ui.playerBGPanel.setVisible(true);
		ui.choiceBGPanel.setVisible(true);

	}


	public void battleScreen() {

		//Show Enemy HP Bar
		ui.enemyPanel.setVisible(true);
	}

	public void shopScreen() {

		//Show Shop Panel
		ui.shopPanel.setVisible(true);
		ui.shopBGPanel.setVisible(true);

		//Hide Main Text Panel
		ui.mainTextPanel.setVisible(false);
	}


	public void endScreen() {

		// Show End Panels
		ui.deathTitlePanel.setVisible(true);
		ui.deathPanel.setVisible(true);
		ui.submitScorePanel.setVisible(true);

		// Hide Main Menu Panels
		ui.scorePanel.setVisible(false);
		ui.choiceButtonPanel.setVisible(false);
		ui.playerPanel.setVisible(false);
		ui.mainTextPanel.setVisible(false);
		ui.enemyPanel.setVisible(false);
		ui.shopPanel.setVisible(false);
		ui.playerBGPanel.setVisible(false);
		ui.choiceBGPanel.setVisible(false);

	}

}
