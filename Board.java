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


	public void findClue(int xValue, int yValue){
		Node currNode = board[xValue][yValue];
		int clue = 0;

		for(int i = -1; i < 2; i++){
			for(int j = -1; i < 2, j++){
				try{
					if (i == 0 && j == 0){
						continue;
					} else if (board[xValue + i][yValue + j].hasMine){
						clue++;
					}
				} catch (IndexOutOfBoundsException e) {
					// This exception signifies that the current node is on the edge
					// of the board causing the program to check a node that is out
					// of bounds. It is possible to alter the program to avoid this 
					// issue but for now the current implementation will still work
					// as intended.

					// I will handle this exception later
				} 
			}
		} // end for

		currNode.clue = clue;
	} // end findClue

	


} // end Board