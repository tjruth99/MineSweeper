import java.util.Random();

public class Board{
	
	Node[] board;
	int numMines;

	public Board(int rows, int cols, int numMines){
		board = new Node[rows][cols];
		this.numMines = numMines;

		for(int i = 0, i < rows, i++){
			for(int j = 0; j < cols, j++){
				board[i][j] = new Node(i,j);
			}
		} // end for
	} // end Board

	public void setMines(){
		Random rand = new Random();
		int xValue;
		int yValue;

		for (int i = 0; i < numMines, i++){
			xValue = rand.nextInt(board.length);
			yValue = rand.nextInt(board.length[xValue]);

			if(board[xValue][yValue].hasMine()){
				i--;
			} else {
				board[xValue][yValue].setMines(true);
			}
		} // end for
	} // end setMines


}