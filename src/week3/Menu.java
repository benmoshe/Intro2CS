package week3;


public class Menu {

	public static void main(String[] args)
	{
		int menu;
		do
		{
			System.out.println("Choose one of the following options:");
			System.out.println("1: Squared number");
			System.out.println("2: Draw a line of stars");
			System.out.println("3: Generate a random natural number between 0 and 9");
			System.out.println("0: Exit");
			menu = MyConsole.readInt("Please enter your choice: ");
			switch(menu)
			{
			case 1:
				int num = MyConsole.readInt("Please enter a number: ");
				System.out.println(num + "^2 = " + (num*num));
				break;
			case 2:
				int numOfStars = MyConsole.readInt("Please enter a number of stars: ");
				for(int i=0; i < numOfStars ;++i)
					System.out.print("*");
				System.out.println();
				break;
			case 3:
				System.out.println("The random number is: " + (int)(Math.random()*10));
				break;
			default:
				if(menu != 0)
					System.out.println("Please enter a valid value");
				break;
			}
			System.out.println();
		} while (menu != 0);
		
		System.out.println("Bye-Bye...");
	}
}

