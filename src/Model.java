import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Model {
	private ArrayList<ChangeListener> listeners;
	private int gameStatus; // 0 = ended / 1 = player1's turn / 2 = player2's turn
	private int[] pits;
	private final int p1Mancala = 7;
	private final int p2Mancala = 0;
	
	// set the initial stones/pit 3~4
	
	public Model(int stoneNum){
		listeners = new ArrayList<ChangeListener>();
		for(int i = 0; i < 14; i++) {
			if(i != p1Mancala && i != p2Mancala) { // don't put anything in p1 and p2's mancala
				pits[i] = stoneNum; // initial stone for each mancala
			}
		}
		gameStatus = 1;
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
		gameStatus = i;
		this.notifyToListeners();
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
	
	/**
	 * Mutator: change the game player
	 */
	public void changePlayer() {
		if(gameStatus == 1) {
			gameStatus = 2;
		} else if(gameStatus == 2) {
			gameStatus = 1;
		} else {	
		}		
		this.notifyToListeners();
	}
	
	
	/**
	 * Mutator: move the clicked pit's stones to counterclockwise
	 * @param pitNum
	 */
	public void moveStones(int pitNum) {
		if(pitNum == p1Mancala || pitNum == p2Mancala) {
			System.out.println("You cannot move Mancala");
			return;
		}
		int stonesInPit = pits[pitNum];
		for(int i = 0; i < stonesInPit; i++) {
			
		}
	}
	
	
	
	
	
	
	/**
	 * Accessor: stones in the pit
	 * @param	pitNumber
	 * @return	number of stones in the given pit
	 */
	public int getStonesInPit(int pitNum) {
		return pits[pitNum];
	}
	
	/**
	 * Accessor: Check whether the pit is empty or not
	 * @param pitNum
	 * @return	true	is empty
	 * 			false	is not empty
	 */
	public boolean isEmptyPit(int pitNum) {
		if(pits[pitNum] == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Accessor: get opposite pit's stones number
	 * @param currentPit
	 * @return
	 */
	public int getOppositePitStones(int currentPit) {
		int oppositePitNum;
		if(currentPit != p1Mancala && currentPit != p2Mancala) {
			oppositePitNum = 14 - currentPit;
			return pits[oppositePitNum];
		} else {
			System.out.println("getOppositePitStones() method error");
			return 0;
		}
	}
	
	/**
	 * Accessor: Game State
	 */
	public int getState() {
		return this.gameStatus;
	}
	
}
