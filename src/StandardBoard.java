GVCS
#0690
CS 151 Project

GVCS — 11/12/2022 5:56 PM
That’s a great idea
bagel — 11/12/2022 6:25 PM
Yup that sounds good
GVCS — 11/17/2022 2:33 AM
Guys I have meeting from 10:30 ~ 11:00 with the Career center, so is 11:00 okay with you?
Raizen4k — 11/17/2022 9:40 AM
Yeah
GVCS — 11/17/2022 11:01 AM
I'm ready
Raizen4k
 started a call that lasted 35 minutes.
 — 11/17/2022 11:02 AM
GVCS — 11/17/2022 11:14 AM
.
Raizen4k — 11/18/2022 12:43 PM
is it my turn to be leader again?
GVCS — 11/18/2022 12:43 PM
My turn
Raizen4k — 11/18/2022 12:43 PM
okay
GVCS — 11/19/2022 1:03 AM
I'm done with my part.
please let me know once you are done
bagel — 11/19/2022 1:15 AM
done with mine
Raizen4k — 11/19/2022 1:29 AM
done
we should start meeting after every class
even if its just a short little check up
i should be done with all the drawings by tuesday so ill need to talk with you guys on what i should do next and whatnot
GVCS — 11/19/2022 1:45 AM
sure I need the lists of listeners from view also. let's done most of our structure before our next meetup
Raizen4k — 11/22/2022 10:23 AM
Can you guys meet at 10:30?
GVCS — 11/22/2022 10:27 AM
Yes
Raizen4k
 started a call that lasted 13 minutes.
 — 11/22/2022 10:33 AM
bagel — 11/22/2022 10:41 AM
Image
Raizen4k — 11/22/2022 10:43 AM
Image
Raizen4k — 11/26/2022 12:54 PM
Im working on the doc now, could you guys add your individual reports when youre ready?
bagel — 11/26/2022 12:57 PM
i dont think there's a report due today
Image
its the 5th one right?
Raizen4k — 11/26/2022 1:07 PM
bruh im so dumb
good thing i didnt waste too much time lol
ill delete it
GVCS — 11/29/2022 10:21 AM
will we meet today?
Raizen4k — 11/29/2022 10:29 AM
Yeah, can we meet at 11?
GVCS — 11/29/2022 10:30 AM
okok
GVCS
 started a call that lasted 17 minutes.
 — 11/29/2022 11:02 AM
GVCS — 11/29/2022 11:56 AM
Image
yeah we need to draw stones
GVCS — 11/29/2022 12:06 PM
and she said this format is okay, but she prefers the time of event come earlier than the event name
Image
bagel — 11/29/2022 12:06 PM
ohh gotcha thanks
Raizen4k — 11/29/2022 3:35 PM
thanks for asking man
GVCS — 11/29/2022 5:06 PM
np at all 🙂
Raizen4k — Today at 10:17 AM
Meet at 10:30?
bagel — Today at 10:19 AM
yeahh
GVCS — Today at 10:29 AM
im ready
Raizen4k
 started a call that lasted an hour.
 — Today at 10:32 AM
bagel — Today at 1:32 PM
i think i got the undo working pushing my stuff rn
Raizen4k — Today at 1:38 PM
Nice
I’m currently working on redoing the entire standard/square board classes to use layouts and be able to add buttons
GVCS — Today at 3:59 PM
i'm back and working on the jbuttons
Raizen4k
 started a call.
 — Today at 3:59 PM
Raizen4k — Today at 4:01 PM
can you join the call
GVCS — Today at 4:07 PM
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.event.*;
 
public class RoundButton extends JButton {
 
  public RoundButton(String label) {
    super(label);
 
    setBackground(Color.lightGray);
    setFocusable(false);
 
    /*
     These statements enlarge the button so that it 
     becomes a circle rather than an oval.
    */
    Dimension size = getPreferredSize();
    size.width = size.height = Math.max(size.width, size.height);
    setPreferredSize(size);
 
    /*
     This call causes the JButton not to paint the background.
     This allows us to paint a round background.
    */
    setContentAreaFilled(false);
  }
 
  protected void paintComponent(Graphics g) {
    if (getModel().isArmed()) {
      g.setColor(Color.gray);
    } else {
      g.setColor(getBackground());
    }
    g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
 
    super.paintComponent(g);
  }
 
  protected void paintBorder(Graphics g) {
    g.setColor(Color.darkGray);
    g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
  }
 
  // Hit detection.
  Shape shape;
 
  public boolean contains(int x, int y) {
    // If the button has changed size,  make a new shape object.
    if (shape == null || !shape.getBounds().equals(getBounds())) {
      shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
    }
    return shape.contains(x, y);
  }
 
  public static void main(String[] args) {
 
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("Rounded Button Example");
    frame.setLayout(new FlowLayout());
 
    JButton b1 = new RoundButton("B1");
    JButton b2 = new RoundButton("B2");
 
    frame.add(b1);
    frame.add(b2);
 
    frame.setSize(300, 150);
    frame.setVisible(true);
  }
}
Raizen4k — Today at 4:24 PM
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.*;
import javax.swing.*;
Expand
message.txt
5 KB
Raizen4k — Today at 4:24 PM
square board
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.*;
import javax.swing.*;


//CONCRETE STRATEGY
public class StandardBoard implements MancalaBoard{
	private int x;
	private int y;
	private int width;
	private int height;

	/**
	 * Constructs a board.
	 */
	public StandardBoard(int x, int y, int width, int height) {
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
		
		
		RoundButton pitA1 = new RoundButton(null);
		RoundButton pitA2 = new RoundButton(null);
		RoundButton pitA3 = new RoundButton(null);
		RoundButton pitA4 = new RoundButton(null);
		RoundButton pitA5 = new RoundButton(null);
		RoundButton pitA6 = new RoundButton(null);
		RoundButton pitB1 = new RoundButton(null);
		RoundButton pitB2 = new RoundButton(null);
		RoundButton pitB3 = new RoundButton(null);
		RoundButton pitB4 = new RoundButton(null);
		RoundButton pitB5 = new RoundButton(null);
		RoundButton pitB6 = new RoundButton(null);
		RoundButton trenchA = new RoundButton(null);
		RoundButton trenchB = new RoundButton(null);
		
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
... (37 lines left)
Collapse
message.txt
5 KB
Raizen4k — Today at 4:25 PM
standard board
﻿
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.*;
import javax.swing.*;


//CONCRETE STRATEGY
public class StandardBoard implements MancalaBoard{
	private int x;
	private int y;
	private int width;
	private int height;

	/**
	 * Constructs a board.
	 */
	public StandardBoard(int x, int y, int width, int height) {
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
		
		
		RoundButton pitA1 = new RoundButton(null);
		RoundButton pitA2 = new RoundButton(null);
		RoundButton pitA3 = new RoundButton(null);
		RoundButton pitA4 = new RoundButton(null);
		RoundButton pitA5 = new RoundButton(null);
		RoundButton pitA6 = new RoundButton(null);
		RoundButton pitB1 = new RoundButton(null);
		RoundButton pitB2 = new RoundButton(null);
		RoundButton pitB3 = new RoundButton(null);
		RoundButton pitB4 = new RoundButton(null);
		RoundButton pitB5 = new RoundButton(null);
		RoundButton pitB6 = new RoundButton(null);
		RoundButton trenchA = new RoundButton(null);
		RoundButton trenchB = new RoundButton(null);
		
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
