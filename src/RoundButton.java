import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;


/**
 * Extension of JButton
 * The shape of button will be seems like the
 *  
 * @author Team Bagle
 *
 */
public class RoundButton extends JButton{
	private Shape shape;
	
	/**
	 * Constructor of the RoundButton
	 * The initial background color is white, 
	 */
	public RoundButton() {
		super();
		setBackground(Color.WHITE);
        setContentAreaFilled(false);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		int width = super.getWidth();
		int height = super.getHeight();
		g.setColor(Color.WHITE);
		g.fillRoundRect(0, 0, width, height, 200, 200);
		super.paintComponent(g);
	}
	
	/**
	 * Overriden method to check whether the button clicked position
	 * is inside the shape or not.
	 */
	@Override
	public boolean contains(int x, int y) {
		if(shape == null || !shape.getBounds2D().equals(super.getBounds())) {
			shape = new Ellipse2D.Float(0, 0, super.getWidth(), super.getHeight());
		}
		return shape.contains(x, y);
	}
}
