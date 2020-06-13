package package01;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;


public class UI {
	JFrame window;
	Container con;
	JProgressBar healthBar;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, enemyPanel, shopPanel, scorePanel, backgroundImagePanel, playerBGPanel, choiceBGPanel, shopBGPanel, titleScreenBGPanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName, applesLabel, applesNumber, coinsLabel, coinsNumber, enemyHPLabel, enemyHPNumber, scoreLabel, scoreNumber, deathTitleLabel,backgroundImageLabel, playerstatBGLabel, choiceBGLabel, shopBGLabel, titleScreenBGLabel;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
	Font statsFont = new Font("Times New Roman", Font.PLAIN, 18);
	JButton startButton, choice1, choice2, choice3, choice4, shopItem1, shopItem2, shopItem3, shopItem4, submitScore;
	JTextPane mainTextArea;
	JPanel deathTitlePanel, deathPanel, submitScorePanel;
	JTextField usernameInput = new JTextField("Enter Your Name", 60);
	ImageIcon image,image2,image3,image4, image5;

	public void createUI(ChoiceHandler cHandler) {

		// WINDOW
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setVisible(true);
		con = window.getContentPane();


		//TITLE SCREEN

		/*titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("HOBO ARENA");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		titleNamePanel.setOpaque(false);
		titleNamePanel.add(titleNameLabel);
		con.add(titleNamePanel);
		con.add(titleNamePanel);*/

		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 350, 200, 100);
		startButtonPanel.setBackground(Color.black);
		startButtonPanel.setOpaque(false);

		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.addActionListener(cHandler);
		startButton.setActionCommand("c1");
		startButton.setFocusPainted(false);

		startButtonPanel.add(startButton);
		con.add(startButtonPanel);

		titleScreenBGPanel = new JPanel();
		titleScreenBGPanel.setBounds(-10,-10,800,600);
		titleScreenBGPanel.setBackground(Color.black);
		titleScreenBGLabel = new JLabel();
		//image = new ImageIcon(".//res//title4.png");
		image = new ImageIcon(getClass().getClassLoader().getResource("title4.png"));
		titleScreenBGLabel.setIcon(image);
		titleScreenBGPanel.add(titleScreenBGLabel);
		con.add(titleScreenBGPanel);


		// GAME SCREEN

		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		mainTextPanel.setOpaque(false);
		con.add(mainTextPanel);

		mainTextArea = new JTextPane();
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setOpaque(false);
		mainTextPanel.add(mainTextArea);

		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		choiceButtonPanel.setOpaque(false);

		con.add(choiceButtonPanel);

		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choiceButtonPanel.add(choice1);
		choice1.setFocusPainted(false);
		choice1.addActionListener(cHandler);
		choice1.setActionCommand("c1");
		choice1.setOpaque(false);

		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choiceButtonPanel.add(choice2);
		choice2.setFocusPainted(false);
		choice2.addActionListener(cHandler);
		choice2.setActionCommand("c2");
		choice2.setOpaque(false);


		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choiceButtonPanel.add(choice3);
		choice3.setFocusPainted(false);
		choice3.addActionListener(cHandler);
		choice3.setActionCommand("c3");
		choice3.setOpaque(false);


		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choiceButtonPanel.add(choice4);
		choice4.setFocusPainted(false);
		choice4.addActionListener(cHandler);
		choice4.setActionCommand("c4");
		choice4.setOpaque(false);


		playerPanel = new JPanel();
		playerPanel.setBounds(125, 15, 600, 50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1,6));
		playerPanel.setOpaque(false);
		con.add(playerPanel);
		hpLabel = new JLabel("HP:");
		hpLabel.setFont(statsFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(statsFont);
		hpLabelNumber.setForeground(Color.white);
		playerPanel.add(hpLabelNumber);
		weaponLabel = new JLabel("Weapon:");
		weaponLabel.setFont(statsFont);
		weaponLabel.setForeground(Color.white);
		playerPanel.add(weaponLabel);
		weaponLabelName = new JLabel();
		weaponLabelName.setFont(statsFont);
		weaponLabelName.setForeground(Color.white);
		playerPanel.add(weaponLabelName);

		applesLabel = new JLabel("Apples:");
		applesLabel.setFont(statsFont);
		applesLabel.setForeground(Color.white);
		playerPanel.add(applesLabel);

		applesNumber = new JLabel();
		applesNumber.setFont(statsFont);
		applesNumber.setForeground(Color.white);
		playerPanel.add(applesNumber);

		coinsLabel = new JLabel("Coins:");
		coinsLabel.setFont(statsFont);
		coinsLabel.setForeground(Color.white);
		playerPanel.add(coinsLabel);

		coinsNumber = new JLabel();
		coinsNumber.setFont(statsFont);
		coinsNumber.setForeground(Color.white);
		playerPanel.add(coinsNumber);


		scorePanel = new JPanel();
		scorePanel.setBounds(100, 500, 100, 50);
		scorePanel.setBackground(Color.black);
		scorePanel.setOpaque(false);
		scorePanel.setLayout(new GridLayout(1,2));
		con.add(scorePanel);

		scoreLabel = new JLabel("Score:");
		scoreLabel.setFont(statsFont);
		scoreLabel.setForeground(Color.white);
		scorePanel.add(scoreLabel);

		scoreNumber = new JLabel();
		scoreNumber.setFont(statsFont);
		scoreNumber.setForeground(Color.white);
		scorePanel.add(scoreNumber);


		// Choice Panel GUI

		choiceBGPanel = new JPanel();
		choiceBGPanel.setBounds(250, 350, 300, 150);
		choiceBGPanel.setBackground(Color.black);
		choiceBGPanel.setLayout(new GridLayout(1,0));
		choiceBGPanel.setOpaque(false);
		con.add(choiceBGPanel);

		choiceBGLabel = new JLabel();
		//image3 = new ImageIcon(".//res//choicepanel2.png");
		image3 = new ImageIcon(getClass().getClassLoader().getResource("choicepanel2.png"));
		choiceBGLabel.setIcon(image3);
		choiceBGPanel.add(choiceBGLabel);


		//Player Panel GUI

		playerBGPanel = new JPanel();
		playerBGPanel.setBounds(100, 15, 600, 50);
		playerBGPanel.setBackground(Color.black);
		playerBGPanel.setLayout(new GridLayout(1,6));
		con.add(playerBGPanel);

		playerstatBGLabel = new JLabel();
		//image2 = new ImageIcon(".//res//playerpanel3.png");
		image2 = new ImageIcon(getClass().getClassLoader().getResource("playerpanel3.png"));
		playerstatBGLabel.setIcon(image2);
		playerBGPanel.add(playerstatBGLabel);


		// BATTLE SCREEN

		UIManager.put("ProgressBar.background",Color.red);
		UIManager.put("ProgressBar.foreground",Color.green);
		UIManager.put("ProgressBar.selectionForeground",(Color.black));
		UIManager.put("ProgressBar.selectionBackground",(Color.black));
		enemyPanel = new JPanel();
		enemyPanel.setBounds(250, 290, 300, 50);
		enemyPanel.setBackground(Color.black);
		enemyPanel.setLayout(new GridLayout(1,2));
		con.add(enemyPanel);
		healthBar = new JProgressBar(0,100);
		healthBar.setPreferredSize(new Dimension(300,50));
		healthBar.setValue(100);
		enemyPanel.add(healthBar);


		// SHOP

		shopPanel= new JPanel();
		shopPanel.setBounds(100, 100, 600, 220);
		shopPanel.setBackground(Color.black);
		shopPanel.setLayout(new GridLayout(1,4));
		shopPanel.setOpaque(false);
		con.add(shopPanel);

		shopItem1 = new JButton("Buy Apple");
		shopItem1.setBackground(Color.black);
		shopItem1.setForeground(Color.white);
		shopItem1.setOpaque(false);
		shopItem1.setFont(statsFont);
		shopPanel.add(shopItem1);
		shopItem1.setFocusPainted(false);
		shopItem1.addActionListener(cHandler);
		shopItem1.setActionCommand("a1");

		shopItem2 = new JButton("Buy Stick");
		shopItem2.setBackground(Color.black);
		shopItem2.setForeground(Color.white);
		shopItem2.setOpaque(false);
		shopItem2.setFont(statsFont);
		shopPanel.add(shopItem2);
		shopItem2.setFocusPainted(false);
		shopItem2.addActionListener(cHandler);
		shopItem2.setActionCommand("a2");

		shopItem3 = new JButton("Buy Bat");
		shopItem3.setBackground(Color.black);
		shopItem3.setForeground(Color.white);
		shopItem3.setOpaque(false);
		shopItem3.setFont(statsFont);
		shopPanel.add(shopItem3);
		shopItem3.setFocusPainted(false);
		shopItem3.addActionListener(cHandler);
		shopItem3.setActionCommand("a3");

		shopItem4 = new JButton("Buy Knife");
		shopItem4.setBackground(Color.black);
		shopItem4.setForeground(Color.white);
		shopItem4.setOpaque(false);
		shopItem4.setFont(statsFont);
		shopPanel.add(shopItem4);
		shopItem4.setFocusPainted(false);
		shopItem4.addActionListener(cHandler);
		shopItem4.setActionCommand("a4");


		// SHOP PANEL GUI

		shopBGPanel = new JPanel();
		shopBGPanel.setBounds(100, 100, 600, 220);
		shopBGPanel.setBackground(Color.black);
		shopBGPanel.setLayout(new GridLayout(1,0));
		con.add(shopBGPanel);

		shopBGLabel = new JLabel();
		//image4 = new ImageIcon(".//res//shoppanel1.png");
		image4 = new ImageIcon(getClass().getClassLoader().getResource("shoppanel1.png"));
		shopBGLabel.setIcon(image4);
		shopBGPanel.add(shopBGLabel);


		//DEATH

		deathPanel = new JPanel();
		deathPanel.setBounds(100, 150, 600, 220);
		deathPanel.setBackground(Color.black);
		deathPanel.setLayout(new GridLayout(1,1));
		deathPanel.setVisible(true);

		deathTitlePanel = new JPanel();
		deathTitlePanel.setBounds(150, 25, 500, 100);
		deathTitlePanel.setBackground(Color.black);
		deathTitlePanel.setOpaque(false);
		deathTitleLabel = new JLabel("SCORE: ");
		deathTitleLabel.setForeground(Color.white);
		deathTitleLabel.setFont(titleFont);		
		deathTitlePanel.add(deathTitleLabel);

		submitScorePanel = new JPanel();
		submitScorePanel.setBounds(150, 390, 500, 150);
		submitScorePanel.setBackground(Color.green);
		submitScorePanel.setLayout(new GridLayout(2,1));
		submitScore = new JButton("Submit Score");
		submitScore.setBackground(Color.black);
		submitScore.setForeground(Color.white);
		submitScore.setFont(normalFont);
		submitScore.addActionListener(cHandler);
		submitScore.setActionCommand("c1");
		submitScore.setFocusPainted(false);

		usernameInput.setHorizontalAlignment(JTextField.CENTER);

		submitScorePanel.add(usernameInput);
		submitScorePanel.add(submitScore);

		con.add(deathTitlePanel);
		con.add(deathPanel);
		con.add(submitScorePanel);


		// Game Screen Background

		backgroundImagePanel = new JPanel();
		backgroundImagePanel.setBounds(-10,-10,800,600);
		backgroundImagePanel.setBackground(Color.black);
		backgroundImageLabel = new JLabel();
		//image5 = new ImageIcon(".//res//background1.png");
		image5 = new ImageIcon(getClass().getClassLoader().getResource("background1.png"));
		backgroundImageLabel.setIcon(image5);
		backgroundImagePanel.add(backgroundImageLabel);
		con.add(backgroundImagePanel);


	}

}
