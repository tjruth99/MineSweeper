import java.util.Random;

public class Board{
	
	Square[][] board;
	int rows;
	int cols;
	int numMines;
	int numRevealed;	
	int winCondition;	// Player wins when numRevealed equals winCondition

	public Board(int rows, int cols, int numMines){
		board = new Square[rows][cols];
		this.rows = rows;
		this.cols = cols;
		this.numMines = numMines;
		numRevealed = 0;
		winCondition = (rows*cols)-numMines;

		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				board[i][j] = new Square(i,j);
			}
		} // end for
	} // end Board


	public void setMines(int xValue, int yValue){
		Random rand = new Random();
		int xRand;
		int yRand;

		for (int i = 0; i < numMines; i++){
			xRand = rand.nextInt(rows);
			yRand = rand.nextInt(cols);

			if(board[xRand][yRand].hasMine() || (xRand == xValue && yRand == yValue)){
				i--;
			} else {
				board[xRand][yRand].setMine(true);
			}
		} // end for
	} // end setMines


	public void findClue(int xValue, int yValue){
		Square currSquare = board[xValue][yValue];
		int clue = 0;

		for(int i = -1; i < 2; i++){
			for(int j = -1; i < 2; j++){
				if (i < 0 || i >= rows || j < 0 || j >= cols){
					continue;
				} else if (board[xValue + i][yValue + j].hasMine()){
					clue++;
				}
			}
		} // end for
		currSquare.setClue(clue);
	} // end findClue

	public int onPush(int xValue, int yValue){
		Square currSquare = board[xValue][yValue];
		findClue(xValue,yValue);

		currSquare.reveal();
		numRevealed++;

		if(currSquare.hasMine()){
			return -1; // Game ends, player loses
		} else if(currSquare.getClue() == 0){
			//@TODO Add functionality to check the surrounding squares if they are blank
			for (int i = -1; i < 2; i++){
				for (int j = -1; j < 2; j++){
					if (i < 0 || i >= rows || j < 0 || j >= cols){
						continue;
					} else {
						recursiveReveal(xValue + i, yValue + j);
					}
				}
			}
		} else if(numRevealed == winCondition) {
			return 1; // Player wins
		}
		return 0; // Game continues as normal
	} // end onPush

	public void recursiveReveal(int xValue, int yValue){
		Square currSquare = board[xValue][yValue];
		findClue(xValue,yValue);

		if (currSquare.isRevealed() || currSquare.hasMine() || currSquare.getClue() > 0){
			return;
		} else {
			currSquare.reveal();
			numRevealed++;

			for (int i = -1; i < 2; i++){
				for (int j = -1; j < 2; j++){
					if (i < 0 || i >= rows || j < 0 || j >= cols){
						continue;
					} else {
						recursiveReveal(xValue+i, yValue+j);
					}
				}
			} // end for 
		}
	}// end recursiveReveal
} // end Board