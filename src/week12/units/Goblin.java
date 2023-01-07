package week12.units;

public class Goblin extends Warrior {
	
	//data
	private static final int ARMOR = 50, DAMAGE = 10,RANGE = 1;
	private static final double ARMOR_NEXT = 2, DAMAGE_NEXT = 1.1;
	private static final double LEVEL_INCREMENT = 0.25;
	
	public static final int PRICE = 10;
		
	
	//constructor
	public Goblin(int team) {
		super(Warrior.TYPE_GOBLIN,team,ARMOR,DAMAGE,RANGE);
	}
	
	public Goblin(Goblin other) {
		super(other);
	}
	
	//functions

	public int getPrice() {
		return PRICE;
	}
	
	public Object clone() {
		return new Goblin(this);
	}

	@Override
	public void nextLevel() {
		if (super.level < 3) {
			super.level = super.level + LEVEL_INCREMENT;
			super.armorFull = super.armorFull * ARMOR_NEXT;
			super.armor = super.armorFull;
			super.damage = super.damage * DAMAGE_NEXT;
		}
	}

}
