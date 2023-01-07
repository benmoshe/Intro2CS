package week12.game;

public class Const {
	
	/*
	 * very plain and simple class for settings
	 */

	//error while adding units
	public static final int ERR_OK = 0, ERR_NO_MONEY = 1, ERR_NO_PLACE = 2, ERR_INDEFINED = 3; ;
	
	public static final int MAX_UNITS_IN_CASTLE = 3;
	public static final int MAX_CASTLES = 4;
	
	public static final int CASTLE_BUFFER = 5;
	
	
	public static String errMsgBuyResult(int result) {
		switch (result) {
		case ERR_OK:{return "got it";}
		case ERR_NO_MONEY:{return "you don't have enouth MONEY";}
		case ERR_NO_PLACE:{return "you don't have enouth PLACE";}
		default:{return "got unknown error, call for support";}
		}
	}
	
	
}
