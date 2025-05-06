public class PracticeProblem {

	public static void main(String args[]) {

	}

	public static int searchMazeMoves(String[][] arr) {
		int row = arr.length - 1;
		int col = 0;
		int move = 0;

		move = mazeHelper(arr, row, col, move);
		
		return move;
	}

	public static int mazeHelper(String[][] arr, int row, int col, int move) {
		if (row == -1 || col == -1 || row == arr.length || col == arr[row].length || arr[row][col].equals("*")) {
			return -1;
		}

		if (arr[row][col].equals("F")) {
			return move;
		}

		String tempSpace = arr[row][col];
		arr[row][col] = "*";
		move++;

		int up = mazeHelper(arr, row, col + 1, move);
		int down = mazeHelper(arr, row, col - 1, move);
		int right = mazeHelper(arr, row + 1, col, move);
		int left = mazeHelper(arr, row - 1, col, move);

		if (up != -1) {
			if (up > left && left != -1) {
				up = left;
			}
		} else {
			up = left;
		}

		if (down != -1) {
			if (down > right && right != -1) {
				down = right;
			}
		} else {
			down = right;
		}

		if (down != -1) {
			if (down > up && up != -1) {
				down = up;
			}
		} else {
			down = up;
		}
		move = down;
		arr[row][col] = tempSpace;
		return move;
	}
}