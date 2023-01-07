package week12.units;

public class Dragon extends Warrior{
	
	private static final int ARMOR = 10, DAMAGE = 50,RANGE = 4;
	private static final double ARMOR_NEXT = 1.2, DAMAGE_NEXT = 1.15, RANGE_NEXT = 1.25;
	private static final double LEVEL_INCREMENT = 0.25;
	public static final int PRICE = 50;
		
	
	//constructor
	public Dragon(int team) {
		super(Warrior.TYPE_DRAGON,team,ARMOR,DAMAGE,RANGE);
	}
	
	public Dragon(Dragon other) {
		super(other);
	}
	
	//functions

	public int getPrice() {
		return PRICE;
	}
	
	public Object clone() {
		return new Dragon(this);
	}

	@Override
	public void nextLevel() {
		if (super.level < 3) {
			super.level = super.level + LEVEL_INCREMENT;
			super.armor = super.armor * ARMOR_NEXT;
			super.damage = super.damage * DAMAGE_NEXT;
			super.range = super.range*RANGE_NEXT;
			super.armor = super.armorFull;
			
		}
	}
}
