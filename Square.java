public class Square{

	int xValue;
	int yValue;
	int clue;	//number that revals how many surrounding tiles have mines;
	boolean flagged;
	boolean revealed;
	private boolean mine;


	public Square(int xValue,int yValue){
		this.xValue = xValue;
		this.yValue = yValue;
		clue = 0;
		flagged = false;
		revealed = false;
	}

	public boolean toggleFlag(){
		flagged = !flagged;
		return flagged;
	}

	public void reveal(){
		revealed = true;
	}

	public void setMine(boolean mine){
		this.mine = mine;
	}

	public boolean hasMine(){
		return mine;
	}
}