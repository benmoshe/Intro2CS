package week12.units;

public abstract class Warrior implements Cloneable {
	
	//data
	public static final int TYPE_KNIGHT = 1, TYPE_CASTLE = 2,TYPE_DRAGON = 3,TYPE_GOBLIN = 4;
	public static final int TEAM_PLAYER = 1,TEAM_ENEMY = 2;
	
	protected int type;
	protected int team;
	protected double level;
	protected double damage;
	protected double armor;
	protected double armorFull;
	protected double range;
	protected boolean moveDone = false;
	
	//constructor
	protected Warrior(int type,int team,double armor, double damage, double range) {
		level = 1;
				
		this.type = type;
		this.team = team;
		this.damage = damage;
		this.armor = this.armorFull = armor;
		this.range = range;
	}
	
	public Warrior(Warrior other) {
		this(other.type,other.team,other.armor,other.damage,other.range);
	}
	
	public abstract void nextLevel();
	public abstract int getPrice();
	public abstract Object clone();
	
	public void refresh() {
		moveDone = false;
	}
		
	public int getType() {
		return type;
	}
	
	public int getRange() {
		return (int)Math.round(range);
	}
	
	public int getTeam() {
		return team;
	}
	
	public double getDamage() {
		return damage;
	}
	
	public double getArmorRatio() {
		return Math.max(armor/armorFull,0.1);
	}
	
	public double getArmor() {
		return armor;
	}
	
	public boolean kill(double attack) {
		armor = armor - attack;
		
		//if (armor <= 0) { return true;}
		//return false;
		return armor <= 0;
	}
	
	public boolean getMoveDone() {
		return moveDone;
	}
	
	public void setMoveDone(boolean moveDone) {
		this.moveDone = moveDone;
	}
	
	public void upgradeToLevel(int level) {
		for (int i=0;i<level;i++) {
			nextLevel();
		}
	}
	
	public String toString() {
		
		String ans = "";
		ans = ans + "Type: "+typeToName(type);
		ans = ans + " Level: "+level;
		ans = ans + " Armor: "+armor;
		ans = ans + " Damage: "+damage;
		ans = ans + " Range: "+range;
		return ans;
		
	}
	
	private String typeToName(int type) {
		if (type == TYPE_CASTLE) {return "Castle";}
		if (type == TYPE_DRAGON) {return "Dragon";}
		if (type == TYPE_GOBLIN) {return "Goblin";}
		if (type == TYPE_KNIGHT) {return "Knight";}
		return "Unknown";
	}
	
	
	

}
