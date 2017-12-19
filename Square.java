public class Square{

	int xValue;
	int yValue;
	int clue;	//number that revals how many surrounding tiles have mines;
	private boolean flagged;
	private boolean revealed;
	private boolean mine;


	public Square(int xValue,int yValue){
		this.xValue = xValue;
		this.yValue = yValue;
		clue = 0;
		flagged = false;
		revealed = false;
	}

	public void toggleFlag(){
		flagged = !flagged;
	}

	public boolean isFlagged(){
		return flagged;
	}

	public void reveal(){
		revealed = true;
	}

	public boolean isRevealed(){
		return revealed;
	}

	public void setMine(boolean mine){
		this.mine = mine;
	}

	public boolean hasMine(){
		return mine;
	}
}