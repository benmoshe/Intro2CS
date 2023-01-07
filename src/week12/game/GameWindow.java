package week12.game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import week12.units.*;

@SuppressWarnings("serial")
public class GameWindow extends JFrame implements ActionListener  {
	//data
	private final static int ICON_SIZE = 50,X_PADDING = 150;
	private Image castleIcon,coinsIcon,dragonIcon,goblinIcon,knightIcon,princessIcon;

	private JPanel drawingPanel; 

	private Warrior[][] wariors = null;
	private GameBoard board;
	private Princess p;
	private Knight k;

	private Toolkit tk;

	//simple main to start the window
	public static void main(String[] args) {
		GameWindow gameWindow = new GameWindow();
		gameWindow.setVisible(true);
		gameWindow.setupGame();// we need this to be able to draw
	}

	//constructor
	public GameWindow()  {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

		//add game buttons
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		setSize(800, 900);

		JButton button1 = new JButton("Run a wave");
		button1.addActionListener(this);
		panel.add(button1);

		JButton button2 = new JButton("Buy a Goblin for "+ Goblin.PRICE);
		button2.addActionListener(this);
		panel.add(button2);

		JButton button3 = new JButton("Buy a Dragon for "+ Dragon.PRICE);
		button3.addActionListener(this);
		panel.add(button3);

		JButton button4 = new JButton("Buy a Castle for "+Castle.PRICE);
		button4.addActionListener(this);
		panel.add(button4);

		//add drawing panel
		drawingPanel = new JPanel();
		drawingPanel.setPreferredSize( new Dimension( 800, 800 ) );
		panel.add(drawingPanel,BorderLayout.CENTER);

		tk = Toolkit.getDefaultToolkit();

		castleIcon = loadImage("castle.png");
		dragonIcon = loadImage("dragon.png");
		goblinIcon = loadImage("goblin.png");
		knightIcon = loadImage("knight.png");
	}

	//functions
	private Image loadImage(String name) {
		URL imgURL = GameWindow.class.getResource(name);
		return tk.getImage(imgURL);
	}

	public void setupGame() {
		
		drawingPanel.getGraphics().drawImage(castleIcon,100,100,50,50,this);
		drawingPanel.getGraphics().drawImage(dragonIcon,100,100,50,50,this);
		drawingPanel.getGraphics().drawImage(goblinIcon,100,100,50,50,this);
		drawingPanel.getGraphics().drawImage(knightIcon,100,100,50,50,this);
		
		board = new GameBoard(this);
		p = new Princess("SnowWhite",500,board);
		k = new Knight(Warrior.TEAM_ENEMY);
		
		System.out.println("before draw");
		board.draw();
		drawingPanel.invalidate();
		System.out.println("after draw");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		System.out.println("action is: "+cmd);

		if (cmd.startsWith("Run a wave")) {
			board.fillWithEnemies(k, 20);
			board.doWave();

			if (board.isDead()) {
				drawMsg(" Ohh, you lost: "+p);
				return;
			}

			k.nextLevel();
			p.nextLevel();
			board.nextLevel();
		}

		if (cmd.startsWith("Buy a Goblin")) {
			int result = p.buyUnit(Warrior.TYPE_GOBLIN);
			drawErr("Goblin: "+Const.errMsgBuyResult(result));
		}
		if (cmd.startsWith("Buy a Dragon")) {
			int result = p.buyUnit(Warrior.TYPE_DRAGON);
			drawErr("Dragon: "+Const.errMsgBuyResult(result));
		}
		if (cmd.startsWith("Buy a Castle")) {
			int result = p.buyUnit(Warrior.TYPE_CASTLE);
			drawErr("Castle: "+Const.errMsgBuyResult(result));
		}

		board.draw();
		
		String status = "money: " + p.getMoney() +" Castles: "+board.getCastlesNum() + " Free slots: "+board.getFreeSlots();
		drawMsg(status);
		drawingPanel.invalidate();

	}

	//------------------   drawing functions ----------------
	public void drawMsg(String msg) {
		Graphics g = drawingPanel.getGraphics();
		g.clearRect(0, drawingPanel.getHeight() - 50, drawingPanel.getWidth(), drawingPanel.getHeight());
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 
		g.drawString(msg, 10, drawingPanel.getHeight() - 10);
	}

	public void drawErr(String msg) {
		Graphics g = drawingPanel.getGraphics();
		g.clearRect(0, drawingPanel.getHeight() - 100, drawingPanel.getWidth(), drawingPanel.getHeight()-60);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 
		g.drawString(msg, 10, drawingPanel.getHeight() - 60);
	}

	public void drawBoard(Warrior[][] wariors) {
		this.wariors = wariors;
		Graphics g = drawingPanel.getGraphics();
		g.clearRect(0, 0, drawingPanel.getWidth(), drawingPanel.getHeight()-100);
		drawWariors(g);
		String status = "money: " + p.getMoney() +" Castles: "+board.getCastlesNum() + " Free slots: "+board.getFreeSlots();
		drawMsg(status);

	}

	private void drawWariors(Graphics g) {
		if (wariors == null) {
			return;
		}

		for (int i = 0; i< wariors.length;i++) {
			for (int j = 0; j < wariors[0].length;j++) {
				if (wariors[i][j] != null) {
					int size = (int)(ICON_SIZE*wariors[i][j].getArmorRatio());
					int startX = X_PADDING + j*ICON_SIZE+(ICON_SIZE-size)/2;
					int startY = i*ICON_SIZE+(ICON_SIZE-size)/2;
					switch(wariors[i][j].getType()) {
					case Warrior.TYPE_CASTLE:{
						g.drawImage(castleIcon,startX,startY,size,size,this);
						break;}
					case Warrior.TYPE_DRAGON:{
						g.drawImage(dragonIcon,startX,startY,size,size,this);
						break;}
					case Warrior.TYPE_GOBLIN:{
						g.drawImage(goblinIcon,startX,startY,size,size,this);
						break;}
					case Warrior.TYPE_KNIGHT:{
						g.drawImage(knightIcon,startX,startY,size,size,this);
						break;}
					}
				}
			}
		}
	}
}
