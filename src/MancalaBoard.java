
import javax.swing.JButton;

/**
 * An interface that all board classes can implement
 * STRATEGY portion of the strategy pattern
 * @author Team Bagle
 */
public interface MancalaBoard {
	
	/**
	 * Method that initialize the board
	 */
	void generateBoard();
	
	/**
	 * Method that returns the button array where the pit buttons are stored in.
	 * @return	Pit buttons
	 */
	JButton[] getPitButtons();
	
	/**
	 * Method that set the initial number of stones with the given parameter.
	 *  
	 * @param num	number of initial stones
	 */
	void initialNumStone(int num);
	
	/**
	 * Method that pass the undoButton
	 * @return	JButton undoButton
	 */
	JButton getUndoButtons();
	
	/**
	 * Method that sets game status message.
	 * @param s		Message for the game status.
	 */
	void setMessage(String s);
	
}
