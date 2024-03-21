package assignment3;

import java.awt.Color;

public class GameColors {
	public final static Color GREEN = new Color(194, 251, 210);
	public final static Color RED = new Color(255, 182, 193);
	public final static Color BLUE = new Color(134, 187, 216);
	public final static Color YELLOW = new Color(246, 174, 45);
	
	public final static Color[] BLOCK_COLORS = {RED, GREEN, BLUE, YELLOW}; // This should probably go inside the class that renders the game
	public final static Color FRAME_COLOR = Color.BLACK;
	public final static Color HIGHLIGHT_COLOR = Color.CYAN;
	
	public static final String ANSI_RESET = "\u001B[0m";
	
	public static String colorToString(Color c) {
		if (c == BLUE)
			return "BLUE";
		else if (c == GREEN)
			return "GREEN";
		else if (c == YELLOW)
			return "YELLOW";
		else if (c == RED)
			return "RED";	

		return "";
	}
	
	public static String colorToANSIColor(Color c) {
		switch(colorToString(c)) {
		case "BLUE":
			return "\u001B[34m";
		case "GREEN":
			return "\u001B[32m";
		case "YELLOW":
			return "\u001B[33m";
		case "RED":
			return "\u001B[31m";
		default:
			return ANSI_RESET;
		}
	}

}
