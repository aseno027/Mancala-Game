import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 * A component that shows a board.
 * This is the "Context" portion of the strategy pattern. 
 */
public class BoardComponent extends JComponent {
	private ArrayList<MancalaBoard> boards;
	
	public BoardComponent() {
		boards = new ArrayList<MancalaBoard>();
	}

	
	/**
	 * Adds a board to the scene.
	 * @param b the board to add
	 */
	public void add(MancalaBoard b) {
		boards.add(b);
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for (MancalaBoard b : boards) {
			b.draw(g2);
			
		}
	}
}