package week12.game;

import week12.units.Warrior;

public class GameLogic {
	
	/*
	 * this class is used to manage the game
	 * 
	 * the main logic is like this:
	 * 
	 * the game has waves of attack.
	 * each attack is made of steps of the player, and enemies
	 * 
	 * the player can buy new units between the waves, and watch the defence
	 * 
	 * this class should provide one wave process
	 * 
	 */
	
	public static void doStep(Warrior[][] board,int jLimit) {
		/*
		 * how do we do one step in a wave
		 * 
		 *  first "action" the player,then the enemies
		 *  or simply start action each element from the end
		 */
		
		for (int i = board.length-1; i >= 0; i--) {
			for (int j = 0 ; j<board[0].length;j++) {
				if (board[i][j] != null) {
					//do the action !!
					
					switch (board[i][j].getType()) {
					case Warrior.TYPE_CASTLE:{
						//System.out.println("castle at "+i+" "+j);
						for (int r = i-1;r>i-board[i][j].getRange();r--) {
							int distance = i - r;
							boolean attacked = searchAndAttack(board,i,j,r,j,distance,jLimit,Warrior.TEAM_ENEMY);
							if (attacked) {break;}
						}
						break;
						}
					case Warrior.TYPE_DRAGON:{
						//System.out.println("dragon at "+i+" "+j);
						for (int r = i-1;r>i-board[i][j].getRange();r--) {
							if (inRange(board,r,j,jLimit) && board[r][j] != null && board[r][j].getTeam() == Warrior.TEAM_ENEMY) {								
								int distance = i - r;
								//System.out.println("found an enemy at "+r+" "+j + " distance "+distance);
								boolean isKilled = kill(board[i][j], board[r][j], distance);
								if (isKilled) { board[r][j] = null;}
								
								break;
							}
						}
						// no enemy, move
						modeRightOrLeft(board,i,j,jLimit);
						
						
						break;}
					case Warrior.TYPE_GOBLIN:{
						/*
						 * goblin check if there is an enemy near him (front,right,left)
						 * if do - atack
						 * else - move right or left
						 * 
						 */
						//System.out.println("goblin at "+i+" "+j);
						boolean attacked = false;
						attacked = searchAndAttackNear(board,i,j,i-1,j,jLimit,Warrior.TEAM_ENEMY);
						if (attacked) {break;}
						attacked = searchAndAttackNear(board,i,j,i+1,j,jLimit,Warrior.TEAM_ENEMY);
						if (attacked) {break;}
						attacked = searchAndAttackNear(board,i,j,i,j+1,jLimit,Warrior.TEAM_ENEMY);
						if (attacked) {break;}
						attacked = searchAndAttackNear(board,i,j,i,j-1,jLimit,Warrior.TEAM_ENEMY);
						if (attacked) {break;}
												
						//no enemy found, move right or left
						modeRightOrLeft(board,i,j,jLimit);
						
						
						
						break;}
					case Warrior.TYPE_KNIGHT:{
						//for now, assume knight are enemies
						
						//in knight there is two modes
						//moving "forward" till the end, then searching for player
						if (i < board.length-1) { //mode forward
							boolean attacked = searchAndAttackNear(board,i,j,i+1,j,jLimit,Warrior.TEAM_PLAYER);
							if (attacked) {break;}
							
							if (board[i][j].getMoveDone() == true) {break;}
							moveUnit(board,i,j,1,0,jLimit);
						}
						else { //we are at the bottom, look for all sides
							boolean attacked = false;
							attacked = searchAndAttackNear(board,i,j,i-1,j,jLimit,Warrior.TEAM_PLAYER);
							if (attacked) {break;}
							attacked = searchAndAttackNear(board,i,j,i+1,j,jLimit,Warrior.TEAM_PLAYER);
							if (attacked) {break;}
							attacked = searchAndAttackNear(board,i,j,i,j+1,jLimit,Warrior.TEAM_PLAYER);
							if (attacked) {break;}
							attacked = searchAndAttackNear(board,i,j,i,j-1,jLimit,Warrior.TEAM_PLAYER);
							if (attacked) {break;}
							
							//meaning we are at the bottom of the board, and nobody to attack
							if (board[i][j].getMoveDone() == true) {break;}
							modeRightOrLeft(board,i,j,jLimit);
						}
						
						break;}
					}
				}
			}
		}
		
		
	}
	
	public static void resetMove(Warrior[][] board) {
		for (int i = board.length-1; i >= 0; i--) {
			for (int j = 0 ; j<board[0].length;j++) {
				if (board[i][j] != null) {
					board[i][j].setMoveDone(false);
				}
			}
		}
	}
			
	public static boolean endOfWave(Warrior[][] board) {
		int countPlayer = 0;
		int countEnemies = 0;
		for (int i = board.length-1; i >= 0; i--) {
			for (int j = 0 ; j<board[0].length;j++) {
				if (board[i][j] != null) {
					if (board[i][j].getTeam() == Warrior.TEAM_PLAYER) { countPlayer++;}
					else {countEnemies++;}
				}
			}
		}
		if (countPlayer == 0 || countEnemies == 0) { return true;}
		return false;
	}
	
	private static boolean searchAndAttackNear(Warrior[][] board,int i,int j,int victim_i,int victim_j,int jLimit,int team) {
		return searchAndAttack(board,i,j,victim_i,victim_j,1,jLimit,team);
	}
	
	private static boolean searchAndAttack(Warrior[][] board,int i,int j,int victim_i,int victim_j,int distance,int jLimit , int team) {
		if (inRange(board,victim_i,victim_j,jLimit) && board[victim_i][victim_j] != null && board[victim_i][victim_j].getTeam() == team) {
			boolean isKilled = kill(board[i][j], board[victim_i][victim_j], distance);
			if (isKilled) { board[victim_i][victim_j] = null;}
			return true;//means attacked
		}
		return false;
	}
	
	private static boolean kill(Warrior attacker, Warrior victim,int distance) {
		/*
		 * a rules of the attack: 
		 * 1) any attack has to lower the live, at least by 1%
		 * 2) damage made by attack is DAMAGE
		 *    lives of the unit is ARMOR
		 *    so any attack down the armor. once it reaches 0 (or negative), the unit is dead
		 *    
		 * 
		 */
		boolean isKilled = victim.kill(attacker.getDamage()/distance); 
		
		if (isKilled) {
			System.out.println("killed "+victim + " by "+attacker);
		}
		else {
			System.out.println("damaged "+victim + " by "+attacker);
		}
		
		return isKilled;
	}
	
	//we need limit, because the board is bigger than the amounts of castles
	private static boolean inRange(Warrior[][] board,int i,int j,int jLimit) {
		if (i<0 || j < 0 || i >= board.length || j >= jLimit) {return false;}
		return true;
	}
	
	private static void modeRightOrLeft(Warrior[][] board,int i,int j,int jLimit) {
		//no enemy found, move right or left
		if (board[i][j].getMoveDone() == true) {return;}
		if (Math.random() > 0.5) {
			boolean moved = moveUnit(board,i,j,0,-1,jLimit);//move left
			if (moved == false) {
				moveUnit(board,i,j,0,1,jLimit);//move right	
			}
			
		}
		else {
			boolean moved = moveUnit(board,i,j,0,1,jLimit);//move right
			if (moved == false) {
				moveUnit(board,i,j,0,-1,jLimit);//move left	
			}
		}
	}
	
	private static boolean moveUnit(Warrior[][] board,int i,int j,int directionI,int directionJ,int jLimit) {
		if (inRange(board,i+directionI,j+directionJ,jLimit) && board[i+directionI][j+directionJ] == null) {
			board[i][j].setMoveDone(true);
			board[i+directionI][j+directionJ] = board[i][j];
			board[i][j] = null;
			return true;
		}
		return false;
	}

}
