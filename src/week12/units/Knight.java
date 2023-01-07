package week12.units;


public class Knight extends Warrior {
	
	private static final int ARMOR = 20, DAMAGE = 20,RANGE = 1;
	private static final double ARMOR_NEXT = 1.25, DAMAGE_NEXT = 1.25;
	private static final double LEVEL_INCREMENT = 1;
	public static final int PRICE = 0;
	
	//constructor
	public Knight(int team) {
		super(Warrior.TYPE_KNIGHT,team,ARMOR,DAMAGE,RANGE);
	}
	
	public Knight(Knight other) {
		super(other);
	}
	
	//functions

	public int getPrice() {
		return PRICE;
	}
	
	public Object clone() {
		return new Knight(this);
	}

	@Override
	public void nextLevel() {
		super.level = super.level + LEVEL_INCREMENT;
		super.armor = super.armor * ARMOR_NEXT;
		super.damage = super.damage * DAMAGE_NEXT;
	}
	

	

	
}
