public class Square{

	int xValue;
	int yValue;
	private int clue;	//number that revals how many surrounding tiles have mines;
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

	public void setClue(int clue){
		this.clue = clue;
	}

	public int getClue(){
		return clue;
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

	public char testCharacter(){
		if(!revealed){
			return 'X';
		} else {
			return (char)clue;
		}
	}

}