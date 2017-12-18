public class Node{

	int xValue;
	int yValue;
	private boolean mine;


	public Node(int xValue,int yValue){
		this.xValue = xValue;
		this.yValue = yValue;
	}

	public void setMine(boolean mine){
		this.mine = mine;
	}
}