
public class Player {
	private String name;
	private int stonesInMancala;
	
	public Player(String name) {
		this.name = name;
		this.stonesInMancala = 0; // no stones when the player object is created
	}
	
	public void addStonesInMancala(int stonesToMancala) {
		this.stonesInMancala = this.stonesInMancala + stonesToMancala;
	}
	
	public int getStonesInMancala() {
		return this.stonesInMancala;
	}
	
	public String getName() {
		return this.name;
	}
}
