import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
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
		
		JFrame boardFrame = new JFrame();
		BorderLayout layout = new BorderLayout(-10,-10);
		boardFrame.setLayout(layout);
		
		
		JPanel aSquares = new JPanel(); //South
		JPanel bSquares = new JPanel(); //North
		JPanel squareLabels = new JPanel(); //Center
		JPanel mancalaA = new JPanel(); //East
		JPanel mancalaB = new JPanel(); //West
		
		boardFrame.add(aSquares, BorderLayout.SOUTH);
		boardFrame.add(bSquares, BorderLayout.NORTH);
		boardFrame.add(squareLabels, BorderLayout.CENTER);
		boardFrame.add(mancalaA, BorderLayout.EAST);
		boardFrame.add(mancalaB, BorderLayout.WEST);
		
		
		boardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		boardFrame.setTitle("Mancala Board");
		boardFrame.setSize(1000,500);
		boardFrame.setVisible(true);
		
		JLabel label = new JLabel("", SwingConstants.CENTER);
		label.setFont(new Font("Verdana", Font.PLAIN, 28));
		label.setText("<html><pre>B6   B5   B4   B3   B2   B1<br/><br/><br/>"
				+ "<br/><br/><br/>A1   A2   A3   A4   A5   A6<pre><html>");
		squareLabels.add(label);
		
		
		JButton pitA1 = new JButton();
		JButton pitA2 = new JButton();
		JButton pitA3 = new JButton();
		JButton pitA4 = new JButton();
		JButton pitA5 = new JButton();
		JButton pitA6 = new JButton();
		JButton pitB1 = new JButton();
		JButton pitB2 = new JButton();
		JButton pitB3 = new JButton();
		JButton pitB4 = new JButton();
		JButton pitB5 = new JButton();
		JButton pitB6 = new JButton();
		JButton trenchA = new JButton();
		JButton trenchB = new JButton();
		
		pitA1.setPreferredSize(new Dimension(75,75));
		pitA2.setPreferredSize(new Dimension(75,75));
		pitA3.setPreferredSize(new Dimension(75,75));
		pitA4.setPreferredSize(new Dimension(75,75));
		pitA5.setPreferredSize(new Dimension(75,75));
		pitA6.setPreferredSize(new Dimension(75,75));
		pitB1.setPreferredSize(new Dimension(75,75));
		pitB2.setPreferredSize(new Dimension(75,75));
		pitB3.setPreferredSize(new Dimension(75,75));
		pitB4.setPreferredSize(new Dimension(75,75));
		pitB5.setPreferredSize(new Dimension(75,75));
		pitB6.setPreferredSize(new Dimension(75,75));
		trenchA.setPreferredSize(new Dimension(75,750));
		trenchB.setPreferredSize(new Dimension(75,750));
		
		
		aSquares.add(pitA1);
		aSquares.add(pitA2);
		aSquares.add(pitA3);
		aSquares.add(pitA4);
		aSquares.add(pitA5);
		aSquares.add(pitA6);
		
		bSquares.add(pitB1);
		bSquares.add(pitB2);
		bSquares.add(pitB3);
		bSquares.add(pitB4);
		bSquares.add(pitB5);
		bSquares.add(pitB6);
		
		mancalaA.add(trenchA);
		mancalaB.add(trenchB);
	}

	public void draw(Graphics2D g2) {
//		Ellipse2D.Double pitA1 = new Ellipse2D.Double(x + 110, y + 40, height, height);	
//		Ellipse2D.Double pitA2 = new Ellipse2D.Double(x + 210, y + 40, height, height);
//		Ellipse2D.Double pitA3 = new Ellipse2D.Double(x + 310, y + 40, height, height);	
//		Ellipse2D.Double pitA4 = new Ellipse2D.Double(x + 410, y + 40, height, height);	
//		Ellipse2D.Double pitA5 = new Ellipse2D.Double(x + 510, y + 40, height, height);	
//		Ellipse2D.Double pitA6 = new Ellipse2D.Double(x + 610, y + 40, height, height);	
//		Ellipse2D.Double pitB1 = new Ellipse2D.Double(x + 110, y + 275, height, height);	
//		Ellipse2D.Double pitB2 = new Ellipse2D.Double(x + 210, y + 275, height, height);		
//		Ellipse2D.Double pitB3 = new Ellipse2D.Double(x + 310, y + 275, height, height);	
//		Ellipse2D.Double pitB4 = new Ellipse2D.Double(x + 410, y + 275, height, height);	
//		Ellipse2D.Double pitB5 = new Ellipse2D.Double(x + 510, y + 275, height, height);	
//		Ellipse2D.Double pitB6 = new Ellipse2D.Double(x + 610, y + 275, height, height);	
//		Ellipse2D.Double trenchA = new Ellipse2D.Double(x + 25, y + 40, height, height * 4);	
//		Ellipse2D.Double trenchB = new Ellipse2D.Double(x + 700, y + 40, height, height * 4);
//		Rectangle2D.Double board = new Rectangle2D.Double(x, y, width * 8, height * 5);
//		g2.draw(pitA1);
//		g2.draw(pitA2);
//		g2.draw(pitA3);
//		g2.draw(pitA4);
//		g2.draw(pitA5);
//		g2.draw(pitA6);
//		g2.draw(pitB1);
//		g2.draw(pitB2);
//		g2.draw(pitB3);
//		g2.draw(pitB4);
//		g2.draw(pitB5);
//		g2.draw(pitB6);
//		g2.draw(trenchA);
//		g2.draw(trenchB);
//		g2.draw(board);
		
	}
}
