import java.awt.Graphics2D;
import java.awt.geom.*;
import javax.swing.*;


//CONCRETE STRATEGY
public class SquareBoard implements MancalaBoard{
	private int x;
	private int y;
	private int width;
	private int height;

	/**
	 * Constructs a board.
	 */
	public SquareBoard(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void draw(Graphics2D g2) {
		Rectangle2D.Double pitA1 = new Rectangle2D.Double(x + 110, y + 40, height, height);	
		Rectangle2D.Double pitA2 = new Rectangle2D.Double(x + 210, y + 40, height, height);
		Rectangle2D.Double pitA3 = new Rectangle2D.Double(x + 310, y + 40, height, height);	
		Rectangle2D.Double pitA4 = new Rectangle2D.Double(x + 410, y + 40, height, height);	
		Rectangle2D.Double pitA5 = new Rectangle2D.Double(x + 510, y + 40, height, height);	
		Rectangle2D.Double pitA6 = new Rectangle2D.Double(x + 610, y + 40, height, height);	
		Rectangle2D.Double pitB1 = new Rectangle2D.Double(x + 110, y + 275, height, height);	
		Rectangle2D.Double pitB2 = new Rectangle2D.Double(x + 210, y + 275, height, height);		
		Rectangle2D.Double pitB3 = new Rectangle2D.Double(x + 310, y + 275, height, height);	
		Rectangle2D.Double pitB4 = new Rectangle2D.Double(x + 410, y + 275, height, height);	
		Rectangle2D.Double pitB5 = new Rectangle2D.Double(x + 510, y + 275, height, height);	
		Rectangle2D.Double pitB6 = new Rectangle2D.Double(x + 610, y + 275, height, height);	
		Rectangle2D.Double trenchA = new Rectangle2D.Double(x + 25, y + 40, height, height * 4.15);	
		Rectangle2D.Double trenchB = new Rectangle2D.Double(x + 700, y + 40, height, height * 4.15);
		Rectangle2D.Double board = new Rectangle2D.Double(x, y, width * 8, height * 5);
		g2.draw(pitA1);
		g2.draw(pitA2);
		g2.draw(pitA3);
		g2.draw(pitA4);
		g2.draw(pitA5);
		g2.draw(pitA6);
		g2.draw(pitB1);
		g2.draw(pitB2);
		g2.draw(pitB3);
		g2.draw(pitB4);
		g2.draw(pitB5);
		g2.draw(pitB6);
		g2.draw(trenchA);
		g2.draw(trenchB);
		g2.draw(board);
		
	}
}