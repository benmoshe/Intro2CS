package week12.units;

public class Castle extends Warrior {
	
	//data
		private static final int ARMOR = 100, DAMAGE = 20, RANGE = 2, BASIC_INCOME = 50;
		private static final double ARMOR_NEXT = 1.01, DAMAGE_NEXT = 1.01,RANGE_NEXT = 1.5;
		private static final double LEVEL_INCREMENT = 0.25;
		
		public static final int PRICE = 200;
			
		//constructor
		public Castle(int team) {
			super(Warrior.TYPE_CASTLE,team,ARMOR,DAMAGE,RANGE);
		}
		
		public Castle(Castle other) {
			super(other);
		}
		
		//functions

		public int getPrice() {
			return PRICE;
		}
		
		public Object clone() {
			return new Castle(this);
		}

		@Override
		public void nextLevel() {
			if (super.level < 3) {
				super.level = super.level + LEVEL_INCREMENT;
				super.armor = super.armor * ARMOR_NEXT;
				super.damage = super.damage * DAMAGE_NEXT;
				super.range = super.range * RANGE_NEXT;
				super.armor = super.armorFull;
			}
		}
			
		public int getIncome() {
			return (int)(BASIC_INCOME * super.level);
		}
		
		
	
}
