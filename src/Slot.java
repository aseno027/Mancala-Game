
public class Slot {
	private int numOfStones;
	private int position;
	
	public int getPosition() {
		return position;
	}

	public Slot(int position) {
		this.numOfStones = 4; // initiate stone = 4
		this.position = position;
	}
	
	public boolean isEmpty() {
		if(this.numOfStones == 0) {
			return true;
		}
		return false;
	}
	
	public int getNumOfStones() {
		return this.numOfStones;
	}
	
	public void removeStones() {
		this.numOfStones = 0;
	}
	
}
