package package01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import java.sql.*;

public class Game {

	// Player variables
	int playerHP, apples, playerCoins, score;

	// Enemy variables
	String[] enemies = {"Jimmy The Hobo", "Angry Pete", "Stinky Bill", "Silly Sally", "Fat Tony", "Big Ross"};
	String enemy;
	int maxEnemyHealth = 100;
	int enemyAttackDamage = 25;
	int enemyHealth;

	// Apples variables
	int appleHealAmount = 25;

	// Other Variables
	String weapon, position;
	Random rand = new Random();
	String username;

	//Class Instantiation
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler cHandler = new ChoiceHandler(this);
	UI ui = new UI();
	VisibilityManager vm = new VisibilityManager(ui);


	public static void main(String[] args) {
		new Game();
	}


	public Game() {
		position = "title";
		ui.createUI(cHandler);
		vm.showTitleScreen();
	}


	public void CreateGameScreen() {
		playerSetup();
		menu();
	}


	public void playerSetup() {
		apples = 3;
		playerHP = 100;
		playerCoins = 20;
		score = 0;
		weapon = "Fists";
		ui.weaponLabelName.setText(weapon);
		ui.hpLabelNumber.setText(" " + playerHP);
		ui.applesNumber.setText(" " + apples);
		ui.coinsNumber.setText(" " + playerCoins);
		ui.scoreNumber.setText(" " + score);
		menu();
	}


	public void updateStats() {
		ui.weaponLabelName.setText(weapon);
		ui.hpLabelNumber.setText(" " + playerHP);
		ui.applesNumber.setText(" " + apples);
		ui.healthBar.setValue(enemyHealth);
		ui.healthBar.setString(enemyHealth + "% ENEMY HITPOINTS");
		ui.coinsNumber.setText("" + playerCoins);
	}



	public void menu() {
		position = "menu";
		vm.titleToMain();
		ui.mainTextArea.setText("What Your Next Move?");
		ui.choice1.setText("Battle");
		ui.choice2.setText("Explore");
		ui.choice3.setText("Shop");
		ui.choice4.setText("Quit");
	}




	public void battle() {
		position = "battle";

		// Generating Random Enemy
		enemyHealth = rand.nextInt(maxEnemyHealth);
		enemy = enemies[rand.nextInt(enemies.length)];

		ui.healthBar.setValue(enemyHealth);
		ui.healthBar.setStringPainted(true);
		ui.healthBar.setString(enemyHealth + "% ENEMY HITPOINTS");
		ui.mainTextArea.setText(enemy + " has appeared!" + "\nThey have " + enemyHealth + " hitpoints!");
		ui.choice1.setText("Attack");
		ui.choice2.setText("Eat Apple");
		ui.choice3.setText("Run!");
		ui.choice4.setText("");

		vm.battleScreen();
	}




	public void battleAttack() {

		int damageDealt = 0;

		// Weapon damage generated depending on weapon type

		if(weapon.equals("Fists")){
			damageDealt = new java.util.Random().nextInt(30);
		}
		else if(weapon.equals("Stick")){
			damageDealt = new java.util.Random().nextInt(40); 
		}
		else if(weapon.equals("Bat")){
			damageDealt = new java.util.Random().nextInt(50); 
		}
		else if(weapon.equals("Knife")){
			damageDealt = new java.util.Random().nextInt(60); 
		}


		int damageTaken = rand.nextInt(enemyAttackDamage);

		enemyHealth -= damageDealt;
		playerHP -= damageTaken;
		updateStats();

		ui.mainTextArea.setText("You strike " + enemy + " for " + damageDealt + " damage." + "\nYou receieve " + damageTaken + " in retaliation!");


		if (playerHP < 1) {
			position = "playerDead";
			ui.mainTextArea.setText("You strike " + enemy + " for " + damageDealt + " damage." + "\nYou receieve " + damageTaken + " in retaliation!\n" + " You've been killed!");
			ui.choice1.setText("Start Again");
			ui.choice2.setText("");
			ui.choice3.setText("");
			ui.choice4.setText("");
			ui.enemyPanel.setVisible(false);
		}

		if (enemyHealth < 1) {
			position = "enemyDefeated";	
			int loot = rand.nextInt(20 - 5 + 1) + 20;		
			playerCoins += loot;
			score ++;
			ui.coinsNumber.setText(" " + playerCoins);
			ui.scoreNumber.setText(" " + score);
			ui.mainTextArea.setText("You strike " + enemy + " for " + damageDealt + " damage." + "\nYou receieve " + damageTaken + " in retaliation!\n" + enemy + " was defeated!\nYou loot the body for valuables and find " + loot + " coins.");
			ui.choice1.setText("Return");
			ui.choice2.setText("");
			ui.choice3.setText("");
			ui.choice4.setText("");
			ui.enemyPanel.setVisible(false);

			if (playerHP < 1) {
				position = "playerDead";
				ui.mainTextArea.setText("You strike " + enemy + " for " + damageDealt + " damage." + "\nYou receieve " + damageTaken + " in retaliation!\n" + " You've been killed!");
				ui.choice1.setText("Start Again");
				ui.choice2.setText("");
				ui.choice3.setText("");
				ui.choice4.setText("");
				ui.enemyPanel.setVisible(false);

			}

		}


	}



	public void battlePotion( ) {

		if (apples > 0) {
			playerHP += appleHealAmount;
			apples--;
			ui.mainTextArea.setText("You eat an apple, healing yourself for " + appleHealAmount
					+ "\nYou now have " + playerHP + " HP."
					+ "\nYou now have " + apples + " apples left.");
		}
		else {
			ui.mainTextArea.setText("You have no apples left!");
		}

		updateStats();
	}




	public void run( ) {

		if (rand.nextBoolean()) {
			position = "backhome";
			ui.enemyPanel.setVisible(false);
			ui.mainTextArea.setText("You manage to escape!");	
			ui.choice1.setText("Return");
			ui.choice2.setText("");
			ui.choice3.setText("");
			ui.choice4.setText("");
		} 

		else {
			int damageTaken = rand.nextInt(enemyAttackDamage);
			playerHP -= damageTaken;
			updateStats();

			ui.mainTextArea.setText("You try to escape however you slip up! \nYou receieve " + damageTaken + " damage!");


			if (playerHP < 1) {
				position = "playerDead";

				ui.mainTextArea.setText("You try to escape however you slip up! \nYou receieve " + damageTaken + " damage! \nYou have been killed!");
				ui.choice1.setText("Start Again");
				ui.choice2.setText("");
				ui.choice3.setText("");
				ui.choice4.setText("");

				ui.enemyPanel.setVisible(false);

			} 

		}

	}





	public void explore( ) {
		position = "backhome";
		int damageTaken;
		int randomNum = (rand.nextInt(4));

		switch(randomNum) {
		case 0: 
			apples++;
			ui.mainTextArea.setText("You scavenge the streets and find a apple! \nYou now have " + apples + " apples.");  
			ui.applesNumber.setText(" " + apples);
			break;

		case 1: 
			damageTaken = rand.nextInt(10 - 5 + 1) + 5;
			playerHP -= damageTaken;
			ui.mainTextArea.setText("You scavenge the streets however \nyou slip and cut yourself on glass! \nYou receieve " + damageTaken + " damage!");
			ui.hpLabelNumber.setText(" " + playerHP);



			if (playerHP < 1) {
				position = "playerDead";

				ui.mainTextArea.setText("You scavenge the streets however \nyou slip and cut yourself on glass! \nYou receieve " + damageTaken + " damage! \nYou have been killed!");

				ui.choice1.setText("Start Again");
				ui.choice2.setText("");
				ui.choice3.setText("");
				ui.choice4.setText("");
			} 
			break;

		case 2:
			playerCoins += 5;
			ui.mainTextArea.setText("You scavenge the streets and find 5 coins! \nYou now have " + playerCoins + " coins.");  
			ui.coinsNumber.setText(" " + playerCoins);
			break;

		case 3:
			damageTaken = rand.nextInt(10 - 1 + 1) + 1;
			playerHP -= damageTaken;

			ui.mainTextArea.setText("You exhaust yourself and find nothing! \nYou receieve " + damageTaken + " damage!");
			ui.hpLabelNumber.setText(" " + playerHP);



			if (playerHP < 1) {
				position = "playerDead";

				ui.mainTextArea.setText("You exhaust yourself and find nothing! \nYou receieve " + damageTaken + " damage! \nYou have been killed!");

				ui.choice1.setText("Start Again");
				ui.choice2.setText("");
				ui.choice3.setText("");
				ui.choice4.setText("");
			} 

		case 4:
			damageTaken = rand.nextInt(20 - 10 + 1) + 10;
			playerHP -= damageTaken;

			ui.mainTextArea.setText("You get spotted and jumped by a gang of youths! \nYou receieve " + damageTaken + " damage!");
			ui.hpLabelNumber.setText(" " + playerHP);



			if (playerHP < 1) {
				position = "playerDead";
				ui.mainTextArea.setText("You get spotted and jumped by a gang of youths! \nYou receieve " + damageTaken + " damage! \nYou have been killed!");
				ui.choice1.setText("Start Again");
				ui.choice2.setText("");
				ui.choice3.setText("");
				ui.choice4.setText("");
			} 

		}

		ui.choice1.setText("Return");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
	}



	public void shop() {
		position = "shop";
		vm.shopScreen();
		ui.choice1.setText("Return");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
	}



	public void purchaseItem1() {
		int item1Price = 15;

		if (playerCoins >= item1Price) {
			JOptionPane.showMessageDialog(null, "Apple Purchased!");
			playerCoins -= item1Price;
			ui.coinsNumber.setText("" + playerCoins);
			apples ++;
			ui.applesNumber.setText("" + apples);
		}
		else {
			JOptionPane.showMessageDialog(null, "Insufficient Coins!");

		}
	}


	public void purchaseItem2() {
		int item2Price = 50;	

		if (playerCoins >= item2Price) {
			JOptionPane.showMessageDialog(null, "Stick Purchased!");
			playerCoins -= item2Price;
			ui.coinsNumber.setText("" + playerCoins);
			weapon = "Stick";
			ui.weaponLabelName.setText(weapon);
		}
		else {
			JOptionPane.showMessageDialog(null, "Insufficient Coins!");
		}
	}


	public void purchaseItem3() {
		int item3Price = 100;	

		if (playerCoins >= item3Price) {
			JOptionPane.showMessageDialog(null, "Baseball Bat Purchased!");
			playerCoins -= item3Price;
			ui.coinsNumber.setText("" + playerCoins);
			weapon = "Bat";
			ui.weaponLabelName.setText(weapon);
		}
		else {
			JOptionPane.showMessageDialog(null, "Insufficient Coins!");
		}
	}


	public void purchaseItem4() {
		int item4Price = 200;	

		if (playerCoins >= item4Price) {
			JOptionPane.showMessageDialog(null, "Knife Purchased!");
			playerCoins -= item4Price;
			ui.coinsNumber.setText("" + playerCoins);
			weapon = "Knife";
			ui.weaponLabelName.setText(weapon);
		}
		else {
			JOptionPane.showMessageDialog(null, "Insufficient Coins!");

		}

	}



	public void death() {
		position = "death";
		vm.endScreen();
		ui.deathTitleLabel.setText(("SCORE: " + score));

		int rows = 10;
		int cols = 2;		    
		JTable highscoreTable = new JTable(rows, cols);
		JScrollPane sp2 =new JScrollPane(highscoreTable);  
		ui.deathPanel.add(sp2);
		DefaultTableModel model = new DefaultTableModel(new String[]{"Name", "Score"}, 0);


		//Populating Table
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			Statement st;
			st = conn.createStatement();
			String sql="SELECT * FROM `highscores` ORDER BY `highscores`.`score` DESC";
			ResultSet rs = st.executeQuery(sql);

			while(rs.next())
			{
				String d = rs.getString("user_name");
				String e = rs.getString("score");
				model.addRow(new Object[]{d, e});
			}
			highscoreTable.setModel(model);


		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Error Populating Highscore Database..... "+e);
		} 

	}



	public void submitButtonClicked() {

		new Game();

		username = ui.usernameInput.getText();


		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");

			String query = "INSERT INTO highscores values('" + username + "','" + score + "')";

			Statement sta = connection.createStatement();

			int x = sta.executeUpdate(query);
			if (x == 0) {
				JOptionPane.showMessageDialog(null, "Error adding your score!");
			} else {
				JOptionPane.showMessageDialog(null, "Your score has successfully been added!");
			}
			connection.close();
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		ui.window.dispose();
	}



	public class TitleScreenHandler implements ActionListener{

		public void actionPerformed(ActionEvent event) {
			CreateGameScreen();
		}
	}

}
