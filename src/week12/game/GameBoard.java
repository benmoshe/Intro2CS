package week12.game;

import week12.units.Castle;
import week12.units.Warrior;

public class GameBoard {
	
	/*
	 * this class represent the board of the game.
	 * 
	 * it's a 2d array filled with units, or null
	 * 
	 * we should have two "passes", one for the enemy, another for the player
	 * 
	 * the width of the board is fixed to max amount of castles * max units in caslte
	 */
	
	
	
	//data
	private Warrior[][] board;
	private int castleCounter = 0;
	private int warriorsCounter = 0;
	
	private GameWindow frame;
	
	//constructor
	
	public GameBoard (GameWindow frame) {
		this.frame = frame;
		
		int size = Const.MAX_CASTLES*Const.MAX_UNITS_IN_CASTLE;
		board = new Warrior[size][size];
	}
	
	
	//functions
	public void draw() {
		frame.drawBoard(board);
	}
	
	public void doTurn() {
		GameLogic.doStep(board,castleCounter*Const.MAX_UNITS_IN_CASTLE);
		GameLogic.resetMove(board);
		//GameLogic.cleanCorps(princess);
	}
	
	public void doWave() {
		int turnsToEnd = 0;
		print();
		System.out.println("--------------------------------------------");
		
		while (GameLogic.endOfWave(board) == false) {
			doTurn();
			frame.drawBoard(board);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			print();
			System.out.println("--------------------------------------------");
			
			turnsToEnd++;
		}
		
		System.out.println(" wave end: "+turnsToEnd);
		//princess.nextLevel();
		
	}
	

	public void fillWithEnemies(Warrior enemy,int amount) {
		//check if there is enough space
		int spaceAvailable = board.length*board[0].length-2;
		amount = Math.min(amount, spaceAvailable);
		
		fillWithEnemiesLinear(enemy,amount);
	}
	
	private void fillWithEnemiesLinear(Warrior enemy,int amount) {
		int placed = 0;
		for (int i = 0;i< board.length-2;i++) {
			for (int j = 0; j< castleCounter*3;j++) {
				if (placed == amount) {return;}
				placed++;
				board[i][j] = (Warrior)enemy.clone();
			}
		}
	}
	
	public int addWarior(Warrior warrior) {
		
		System.out.println("adding a warror: "+warrior.getType());
		
		//here we should add a warrior to first empty place, if exist
		//moreover, we should add castles to board.length-1, and other to board.length -2
		if (warrior.getType() == Warrior.TYPE_CASTLE) {
			//simple check
			if (castleCounter == Const.MAX_CASTLES) { return Const.ERR_NO_PLACE;}
						
			//check if there is a free place
			for (int j=0;j<board.length;j++) {
				if (board[board.length-1][j] == null) {
					//we found a free place, add castle
					for (int i = 0; i< Const.MAX_UNITS_IN_CASTLE;i++) {
						board[board.length-1][i+j] = warrior;
					}
					castleCounter++;
					return Const.ERR_OK;
				}
			}
			//if we are here, no free space found
			return Const.ERR_NO_PLACE;
		}
		else { //means all other units
			
			if (warriorsCounter >= castleCounter * Const.MAX_UNITS_IN_CASTLE) { return Const.ERR_NO_PLACE;}
			
			//check if there is a free place
			for (int j=0;j<board.length;j++) {
				if (board[board.length-2][j] == null) {
					//we found a free place, add warrior
					board[board.length-2][j] = warrior;
					warriorsCounter++;
					return Const.ERR_OK;
				}
			}
			//if we are here, no free space found
			return Const.ERR_NO_PLACE;
		}
	}
	
	public int getFreeSlots() {
		//int totalSlots = castleCounter*Const.MAX_UNITS_IN_CASTLE;
		//int freeSlots = totalSlots - warriorsCounter;
		//return freeSlots;
		
		return castleCounter*Const.MAX_UNITS_IN_CASTLE - warriorsCounter;
	}
	
	public int getCastlesNum() {
		return castleCounter;
	}
	
	public boolean isDead() {
		//we need to check if anyone is still alive
		
		castleCounter = 0;
		warriorsCounter = 0;
		
		for (int i = 0;i< board[0].length;i++) {
			if (board[board.length - 1][i] != null) {
				if (board[board.length - 1][i].getType() == Warrior.TYPE_CASTLE) {
					castleCounter++;
				}
				else {
					warriorsCounter++;
				}
			}
			
			if (board[board.length - 2][i] != null) {
				if (board[board.length - 2][i].getType() == Warrior.TYPE_CASTLE) {
					castleCounter++;
				}
				else {
					warriorsCounter++;
				}
			}
		}
		
		castleCounter = castleCounter / Const.MAX_UNITS_IN_CASTLE;
		
		//if (castleCounter <= 0) {return true;}
		//return false;
		return castleCounter <= 0;
	}
	
	public int getIncome() {
		//loop, with jumps of castle size
		int sum = 0;
		for (int i=0;i<board[0].length;i = i+3) {
			if (board[board.length-1][i] != null && board[board.length-1][i].getType() == Warrior.TYPE_CASTLE) {
				Castle c = (Castle)board[board.length-1][i];
				sum = sum + c.getIncome();
			}
			
		}
		return sum;
	}
	
	public void nextLevel() {
		/*
		 * there is no case that we have both enemies and player survivers
		 * so we should promote only players (or the player is lost)
		 */
		
		for (int i = 0;i< board[0].length;i++) {
			if (board[board.length - 1][i] != null) {
				board[board.length - 1][i].nextLevel();
			}
			
			if (board[board.length - 2][i] != null) {
				board[board.length - 2][i].nextLevel();
			}
		}
	}
	
//	private void fillDefendersLinear(ArrayList<Castle> castels) {
//		for (int i=0;i<castels.size();i++) {
//			for (int j=0;j<castels.get(i).getUnits().size();j++) {
//				board[board.length-2][j+i*Const.MAX_UNITS_IN_CASTLE]=castels.get(i).getUnits().get(j);
//				
//			}
//			for (int j=0;j<Const.MAX_UNITS_IN_CASTLE;j++) {
//				board[board.length-1][j+i*Const.MAX_UNITS_IN_CASTLE]=castels.get(i);//put the same object
//			}
//		}
//	}
	
//	public void fill(Warrior enemy,int amount) {
//		ArrayList<Castle> castels = princess.getCastels();
//		
//		int deep = (amount/(castels.size()*Const.MAX_UNITS_IN_CASTLE))+Const.CASTLE_BUFFER;
//		//the width of the board depends on how many castles do we have
//	//!!	board = new Warior[deep][castels.size()*Const.MAX_UNITS_IN_CASTLE];
//		
//		fillDefendersLinear(castels);
//		
//		fillWithEnemiesLinear(enemy,amount);
//		
//		
//	}
	
	public void print() {
		for (int i = 0;i< board.length;i++) {
			for (int j = 0; j< board[0].length;j++) {

				if (board[i][j] == null) {
					System.out.print(" - ");
				}
				else {
					if (board[i][j].getType() == Warrior.TYPE_CASTLE) {
						System.out.print(" C ");	
					}
					if (board[i][j].getType() == Warrior.TYPE_DRAGON) {
						System.out.print(" D ");	
					}
					if (board[i][j].getType() == Warrior.TYPE_GOBLIN) {
						System.out.print(" G ");	
					}
					if (board[i][j].getType() == Warrior.TYPE_KNIGHT) {
						System.out.print(" k ");	
					}
					
				}
			}
			System.out.println();
		}
	}

}
