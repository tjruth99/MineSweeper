import java.util.Scanner;

public class MinesweeperTextTest {
	
	public void printBoard(/*Square[] board*/){
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				System.out.printf("| %c ", board[i][j].testCharacter());
			}
			System.out.print("|\n");
		}
	}

	public static void main(String[] args){
		Board game = new Board(10,10,10);
		Scanner s = new Scanner(System.in);

		int inX, inY;

		game.printBoard();

		System.out.println("Enter x:");
		inX = s.nextInt();

		System.out.println("Enter y:");
		inY = s.nextInt();

		game.setMines(inX,inY);
		game.onPush(inX,inY);

		game.printBoard();

	}
}