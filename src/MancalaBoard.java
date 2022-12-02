
import javax.swing.JButton;
import javax.swing.JLabel;
	/**
	 * An interface that all board classes can implement
	 * THIS IS THE "STRATEGY" portion of the strategy pattern
	 */
	public interface MancalaBoard {
		// draw method
		void generateBoard();
		JButton[] getPitButtons();
		void initialNumStone(int num);
		JButton getUndoButtons();
		void setMessage(String s);
}
