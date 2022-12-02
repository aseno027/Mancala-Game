import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.Icon;
import javax.swing.JButton;

public class RoundButton extends JButton{
	private Shape shape;
	public RoundedButton() {
		super();
		setBackground(Color.WHITE);
		setFocusable(false);
		
        Dimension size = getPreferredSize();
		size.width = size.height = Math.max(size.width, size.height);
		setPreferredSize(size);
        setContentAreaFilled(false);
    }
	
	public void setIcon(Icon newIcon) {
		super.setIcon(newIcon);
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		int width = super.getWidth();
		int height = super.getHeight();
		g.setColor(Color.WHITE);
		g.fillRoundRect(0, 0, width, height, 200, 200);
		super.paintComponent(g);
	}
	
	@Override
	public boolean contains(int x, int y) {
		if(shape == null || !shape.getBounds2D().equals(getBounds())) {
			shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
		}
		
		return shape.contains(x, y);
	}
}
