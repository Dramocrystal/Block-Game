package assignment3;

import java.awt.Color;

public class PerimeterGoal extends Goal{

	public PerimeterGoal(Color c) {
		super(c);
	}

	@Override
	public int score(Block board) {
		Color[][] colors = board.flatten();
		int score = 0;

		// Get the dimensions of the 2D array
		int rows = colors.length;
		int cols = colors[0].length;

		// Iterate through the perimeter of the array
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (i == 0 || i == rows-1 || j == 0 || j == cols-1) {
					if (colors[i][j] == this.targetGoal) {
						score++;
						//if on corner count twice
						if ((i == 0 || i == rows-1) && (j == 0 || j == cols-1)) {
							score ++;
						}
					}
				}
			}
		}
	return score;
	}


	@Override
	public String description() {
		return "Place the highest number of " + GameColors.colorToString(targetGoal)
		+ " unit cells along the outer perimeter of the board. Corner cell count twice toward the final score!";
	}

}
