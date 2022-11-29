import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Model {
	private ArrayList<ChangeListener> listeners;
	private int gameState; // 0 = ended / 1 = player1's turn / 2 = player2's turn
	private int[] pits;
	private final int p1Mancala = 0;
	private final int p2Mancala = 7;
	
	public Model(){
		listeners = new ArrayList<ChangeListener>();
		for(int i = 0; i < 14; i++) {
			if(i != p1Mancala && i != p2Mancala) { // don't put anything in p1 and p2's mancala
				pits[i] = 4; // initial stone for each mancala
			}
		}
		gameState = 1;
		this.notifyToListeners();
	}
	
	/**
	 * Attach Method
	 * @param listner
	 */
	public void addChangeListener(ChangeListener listner) {
		listeners.add(listner);
	}
	
	/**
	 * Notify method to notify state changes to the listener.
	 */
	public void notifyToListeners() {
		ChangeEvent e = new ChangeEvent(this);
		for(ChangeListener listener : listeners) {
			listener.stateChanged(e);
		}
	}
	
	/**
	 * Mutator: State Change
	 * @param i		0 = ended / 1 = player1's turn / 2 = player2's turn
	 */
	public void setState(int i) {
		gameState = i;
		this.notifyToListeners();
	}
	
	/**
	 * Accessor: Game State
	 */
	public int getState() {
		return this.gameState;
	}
	
	/**
	 * Mutator: change the game player
	 */
	public void changePlayer() {
		if(gameState == 1) {
			gameState = 2;
		} else if(gameState == 2) {
			gameState = 1;
		} else {	
		}		
		this.notifyToListeners();
	}
	
	/**
	 * Accessor: stones in the pit
	 * @param pitNumber
	 * @return
	 */
	public int getStonesInPit(int pitNum) {
		return pits[pitNum];
	}
	
	/**
	 * Mutator: remove stones from the pit
	 * @param pitNum
	 * @param stoneNum
	 */
	public void removeStones(int pitNum, int stoneNum) {
		pits[pitNum] = pits[pitNum] - stoneNum;
		this.notifyToListeners();
	}
	
	
}
