package assignment3;

import java.awt.Color;

public class BlobGoal extends Goal {

	public BlobGoal(Color c) {
		super(c);
	}

	@Override
	public int score(Block board) {

		Color[][] unitCells = board.flatten();
		boolean[][] visited = new boolean[unitCells.length][unitCells[0].length];

		return undiscoveredBlobSize(0,0, unitCells, visited);

	}

	@Override
	public String description() {
		return "Create the largest connected blob of " + GameColors.colorToString(targetGoal)
				+ " blocks, anywhere within the block";
	}


	public int undiscoveredBlobSize(int i, int j, Color[][] unitCells, boolean[][] visited) {

		int size = 0;

		//Input validation
		if (unitCells.length == 0 || visited.length == 0){
			return 0;
		}

		//Base Case cell was visited or is not goal + check for out of bounds conditions
		if (i < 0 || i >= unitCells.length || j < 0 || j >= unitCells[0].length || visited[i][j] || unitCells[i][j] != this.targetGoal ) {
			return size;
		}


		//Cell was not visited and is goal
		//Count curr cell and check adjacent cells
		else {
			size = 1;

			visited[i][j] = true;

			size += this.undiscoveredBlobSize(i + 1, j, unitCells, visited);

			size += this.undiscoveredBlobSize(i - 1, j, unitCells, visited);

			size += this.undiscoveredBlobSize(i, j + 1, unitCells, visited);

			size += this.undiscoveredBlobSize(i, j - 1, unitCells, visited);

		}

		return size;
	}

}
