import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Model {

	private ArrayList<ChangeListener> listeners;
	private int gameStatus; // 0 = ended / 1 = player1's turn / 2 = player2's turn
	private int[] pits;
	private int[] previousPits;// used for undo
	private final int p1Mancala = 7;
	private final int p2Mancala = 0;
	private int numUndos;
	private int initialStoneNum;
	private boolean canUndo;
	private String displayMessage;
	// set the initial stones/pit 3~4

	public Model(int stoneNum) {
		listeners = new ArrayList<ChangeListener>();
		pits = new int[14];
		for (int i = 0; i < 14; i++) {
			if (i != p1Mancala && i != p2Mancala) { // don't put anything in p1 and p2's mancala
				pits[i] = stoneNum; // initial stone for each mancala
			}
		}
		gameStatus = 1;
		initialStoneNum = stoneNum;
		numUndos = 3;// player has 3 undos each turn
		canUndo = false;
		displayMessage = "Player 1 turn";
		this.notifyToListeners();
	}

	/**
	 * Attach Method
	 * 
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
		for (ChangeListener listener : listeners) {
			listener.stateChanged(e);
		}
	}

	/**
	 * Mutator: State Change
	 * 
	 * @param i 0 = ended / 1 = player1's turn / 2 = player2's turn
	 */
	public void setState(int i) {
		gameStatus = i;
		this.notifyToListeners();
	}

	/**
	 * Mutator: change the game player
	 */
	public void changePlayer() {
		if (gameStatus == 1) {
			gameStatus = 2;
		} else if (gameStatus == 2) {
			gameStatus = 1;
		} else {
		}
		canUndo = false;// player hasn't made a move yet
		numUndos = 3;// reset number of undos back to 3
		this.notifyToListeners();
	}

	/**
	 * Mutator: remove stones from the pit
	 * 
	 * @param pitNum
	 * @param stoneNum
	 */
	public void removeStones(int pitNum, int stoneNum) {
		pits[pitNum] = pits[pitNum] - stoneNum;
		this.notifyToListeners();
	}

	/**
	 * Mutator: move the clicked pit's stones to counterclockwise
	 * 
	 * @param pitNum index of pit
	 * 
	 * @return -> should I change it to Integer?(0 = error) (1 = normal ending) (2 =
	 *         last was mancala) (3 = take opposite stones)
	 */
	public int moveStones(int pitNum) {
		// error case
		if (pitNum == p1Mancala || pitNum == p2Mancala) {
			System.out.println(canUndo);
			displayMessage = "You cannot move Mancala! Try again.";
			this.notifyToListeners();
			return 0;
		}
		if (gameStatus == 1 && pitNum > 7) {
			displayMessage = "Player 1 cannot touch Player 2's pits. Try again!" ;
			this.notifyToListeners();
			return 0;
		}
		if (gameStatus == 2 && pitNum < 7) {
			displayMessage = "Player 2 cannot touch Player 1's pits. Try again!";
			this.notifyToListeners();
			return 0;
		}
		previousPits = pits.clone();// saves current board before making changes
		
		int stonesInPit = pits[pitNum];
		// picked pit will be empty
		pits[pitNum] = 0;

		// other pits will be increased
		int addedPitNum = pitNum + 1;
		while (stonesInPit > 0) {
			pits[addedPitNum % 14] = pits[addedPitNum % 14] + 1;
			addedPitNum++;
			stonesInPit--;
		}

		int lastAddedPitNum = (addedPitNum - 1)%13;
		canUndo = true;
		// if the last added pit was mancala
		if (gameStatus == 1 && lastAddedPitNum == p1Mancala) {
			displayMessage = "Player 1 cannot touch Player 2's pits! Try again." ;
			// p1 replay -> no player change
			this.notifyToListeners();
			return 2;
		}
		if (gameStatus == 2 && lastAddedPitNum == p2Mancala) {
			// p2 replay -> no player change
			this.notifyToListeners();
			return 2;
		}

		// if the last added pit was empty
		// get opposite's stone and my stone into the mancala
		if (gameStatus == 1 && lastAddedPitNum < 7 && pits[lastAddedPitNum] == 1 && pits[getOppositePit(lastAddedPitNum)] != 0) {
			pits[p1Mancala] += pits[getOppositePit(lastAddedPitNum)] + pits[lastAddedPitNum];
			pits[getOppositePit(lastAddedPitNum)] = 0;
			pits[lastAddedPitNum] = 0;
			if (numUndos == 0) {// checks if player can undo
				changePlayer();
			}
			this.notifyToListeners();
			return 3;
		} else if (gameStatus == 2 && lastAddedPitNum > 7 && pits[lastAddedPitNum] == 1 && pits[getOppositePit(lastAddedPitNum)] != 0) {
			pits[p2Mancala] += pits[getOppositePit(lastAddedPitNum)] + pits[lastAddedPitNum];
			pits[getOppositePit(lastAddedPitNum)] = 0;
			pits[lastAddedPitNum] = 0;
			if (numUndos == 0) {// checks if player can undo
				changePlayer();
			}
			this.notifyToListeners();
			return 3;
		}
		if (numUndos == 0) {// checks if player can undo
			changePlayer();
		}
		//canUndo = true;// player made a successful move so can player can undo
		// normal turn ended normally
		this.notifyToListeners();
		return 1;
	}

	public int undoMove() {// return 1 if successful and return 0 when can't undo
		if (canUndo && numUndos > 0) {// checks if player made a move
			pits = previousPits.clone();// restore changes made
			numUndos--;
			displayMessage = "Number of undo left: " + numUndos;
			canUndo = false;// cannot undo multiple times
			this.notifyToListeners();
			return 1;
		}
		return 0;
	}

	public void setInitialStoneNum(int initialStoneNum) {
		this.initialStoneNum = initialStoneNum;
		for (int i = 0; i < 14; i++) {
			if (i != p1Mancala && i != p2Mancala) { // don't put anything in p1 and p2's mancala
				pits[i] = initialStoneNum; // initial stone for each mancala
			}
		}
	}

	public int getInitialStoneNum() {
		return initialStoneNum;
	}
	
	public String getDisplayMessage() {
		return displayMessage;
	}

	/**
	 * Accessor
	 * 
	 * @return true game ended false game not ended
	 */
	public boolean gameEndIndicator() {
		boolean p1PitsEmpty = true;
		boolean p2PitsEmpty = true;

		if (gameStatus == 1) {
			for (int i = 1; i < p1Mancala; i++) {
				if (pits[i] > 0) {
					p1PitsEmpty = false;
				}
			}
		}
		if (gameStatus == 2) {
			for (int i = 8; i < 14; i++) {
				if (pits[i] > 0) {
					p2PitsEmpty = false;
				}
			}
		}

		if (p1PitsEmpty || p2PitsEmpty) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Accessor
	 * 
	 * @return 0 draw 1 p1 win 2 p2 win
	 */
	public int winnerIndicator() {
		if (pits[p1Mancala] > pits[p2Mancala]) {
			return 1;
		} else if (pits[p1Mancala] < pits[p2Mancala]) {
			return 2;
		} else {
			return 0;
		}
	}

	/**
	 * Accessor: stones in the pit
	 * 
	 * @param pitNumber
	 * @return number of stones in the given pit
	 */
	public int getStonesInPit(int pitNum) {
		return pits[pitNum];
	}

	public int getP1MancalaStones() {
		return pits[p1Mancala];
	}

	public int getP2MancalaStones() {
		return pits[p2Mancala];
	}

	public int[] getPits() {
		return pits;
	}

	/**
	 * Accessor: Check whether the pit is empty or not
	 * 
	 * @param pitNum
	 * @return true is empty false is not empty
	 */
	public boolean isEmptyPit(int pitNum) {
		if (pits[pitNum] == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Accessor: get opposite pit
	 * 
	 * @param currentPit
	 * @return
	 */
	public int getOppositePit(int currentPit) {
		int oppositePitNum;
		if (currentPit != p1Mancala && currentPit != p2Mancala) {
			oppositePitNum = 14 - currentPit;
			return oppositePitNum;
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
