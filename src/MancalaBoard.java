import java.awt.Graphics2D;
	/**
	 * An interface that all board classes can implement
	 * THIS IS THE "STRATEGY" portion of the strategy pattern
	 */
	public interface MancalaBoard {
		// draw method
		void draw(Graphics2D g2);
}