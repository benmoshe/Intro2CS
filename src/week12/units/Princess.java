package week12.units;

import week12.game.Const;
import week12.game.GameBoard;

public class Princess {
	
	/*
	 * this class represent the player
	 * 
	 * a princess can have up to 4 castles, in each castle up to 3 war units
	 */
	
	
	//data
	private String name;
	private int money = 0;
	private int level = 0;
	private GameBoard board;
	
	//constructor
	public Princess(String name,int money,GameBoard board) {
		this.name = name;
		this.money = money;
		this.board = board;
		
		board.addWarior(new Castle(Warrior.TEAM_PLAYER));
		board.addWarior(new Goblin(Warrior.TEAM_PLAYER));
		
	}
	
	//functions
	public int buyUnit(int type) {
		
		Warrior warrior = null;
		if (type == Warrior.TYPE_GOBLIN) {
			warrior = new Goblin(Warrior.TEAM_PLAYER);
		}
		
		if (type == Warrior.TYPE_DRAGON) {
			warrior = new Dragon(Warrior.TEAM_PLAYER);
		}
		
		if (type == Warrior.TYPE_CASTLE) {
			warrior = new Castle(Warrior.TEAM_PLAYER);
		}
		
		int warriorPrice = warrior.getPrice();
		
		if (money < warriorPrice) { return Const.ERR_NO_MONEY;}
		
		money = money - warriorPrice;
		
		return board.addWarior(warrior);
		
		
		
	}
	

//	
//	private int addUnitToCastle(Warior warior) {
//		int price = warior.getPrice();
//		if (price > money) { return ERR_NO_MONEY;}
//		
//		for (Castle c: castles) {
//			boolean isAdded = c.addUnit(warior);
//			if (isAdded) {
//				money = money - price;
//				return ERR_OK;
//			}
//		}
//		return ERR_NO_PLACE;
//		
//	}
//	
//	public ArrayList<Castle> getCastels(){
//		return castles;
//	}
	
	public int getMoney() {
		return money;
	}
	
//	public int getFreeSlots() {
////		int sum = 0;
////		for (Castle castle: castles) {
////			sum = sum + castle.getFreeSlots();
////		}
////		return sum;
//		return board.getFreeSlots();
//	}
	
	public void nextLevel() {
		level++;
//		for (Castle castle: castles) {
//			castle.nextLevel();
//			money = money + castle.getRoundIncome();
//		}
		money = money + board.getIncome();
	}
	
//	public boolean isDead() {
//		return board.isDead();
//	}
//	
	public String toString() {
		return name+": level "+level;
	}
	

}
