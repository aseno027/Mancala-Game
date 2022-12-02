import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.geom.*;
import javax.swing.*;


//CONCRETE STRATEGY
public class SquareBoard implements MancalaBoard{

	/**
	 * Constructs a board.
	 */
	public void generateBoard() {
		
		JFrame boardFrame = new JFrame();
		BorderLayout layout = new BorderLayout();
		boardFrame.setLayout(layout);
		
		
		JPanel mancalaA = new JPanel(new BorderLayout()); // East
		JPanel mancalaB = new JPanel(new BorderLayout()); // West

		JPanel centerBoard = new JPanel(new GridLayout(4, 6));
	
		boardFrame.add(mancalaA, BorderLayout.EAST);
		boardFrame.add(mancalaB, BorderLayout.WEST);
		JLabel directionP1 = new JLabel("Player 1 --->", SwingConstants.CENTER);
		directionP1.setFont(new Font("Monospaced", Font.BOLD, 30));
		boardFrame.add(directionP1, BorderLayout.SOUTH);
		JLabel directionP2 = new JLabel("<--- Player 2", SwingConstants.CENTER);
		directionP2.setFont(new Font("Monospaced", Font.BOLD, 30));
		boardFrame.add(directionP2, BorderLayout.NORTH);
		boardFrame.add(centerBoard, BorderLayout.CENTER);

		boardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		boardFrame.setTitle("Mancala Board");
		boardFrame.setSize(1000, 500);
		boardFrame.setVisible(true);
		
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
		
		JLabel label;
		centerBoard.add(pitA1);
		centerBoard.add(pitA2);
		centerBoard.add(pitA3);
		centerBoard.add(pitA4);
		centerBoard.add(pitA5);
		centerBoard.add(pitA6);
		label = new JLabel("B6", SwingConstants.CENTER);
		label.setFont(new Font("Monospaced", Font.BOLD, 30));
		centerBoard.add(label);
		label = new JLabel("B5", SwingConstants.CENTER);
		label.setFont(new Font("Monospaced", Font.BOLD, 30));
		centerBoard.add(label);
		label = new JLabel("B4", SwingConstants.CENTER);
		label.setFont(new Font("Monospaced", Font.BOLD, 30));
		centerBoard.add(label);
		label = new JLabel("B3", SwingConstants.CENTER);
		label.setFont(new Font("Monospaced", Font.BOLD, 30));
		centerBoard.add(label);
		label = new JLabel("B2", SwingConstants.CENTER);
		label.setFont(new Font("Monospaced", Font.BOLD, 30));
		centerBoard.add(label);
		label = new JLabel("B1", SwingConstants.CENTER);
		label.setFont(new Font("Monospaced", Font.BOLD, 30));
		centerBoard.add(label);

		label = new JLabel("A1", SwingConstants.CENTER);
		label.setFont(new Font("Monospaced", Font.BOLD, 30));
		centerBoard.add(label);
		label = new JLabel("A2", SwingConstants.CENTER);
		label.setFont(new Font("Monospaced", Font.BOLD, 30));
		centerBoard.add(label);
		label = new JLabel("A3", SwingConstants.CENTER);
		label.setFont(new Font("Monospaced", Font.BOLD, 30));
		centerBoard.add(label);
		label = new JLabel("A4", SwingConstants.CENTER);
		label.setFont(new Font("Monospaced", Font.BOLD, 30));
		centerBoard.add(label);
		label = new JLabel("A5", SwingConstants.CENTER);
		label.setFont(new Font("Monospaced", Font.BOLD, 30));
		centerBoard.add(label);
		label = new JLabel("A6", SwingConstants.CENTER);
		label.setFont(new Font("Monospaced", Font.BOLD, 30));
		centerBoard.add(label);
		centerBoard.add(pitB1);
		centerBoard.add(pitB2);
		centerBoard.add(pitB3);
		centerBoard.add(pitB4);
		centerBoard.add(pitB5);
		centerBoard.add(pitB6);

		label = new JLabel("Mancala A", SwingConstants.CENTER);
		label.setFont(new Font("Monospaced", Font.BOLD, 30));
		mancalaA.add(label, BorderLayout.SOUTH);
		mancalaA.add(trenchA, BorderLayout.CENTER);
		label = new JLabel("Mancala B", SwingConstants.CENTER);
		label.setFont(new Font("Monospaced", Font.BOLD, 30));
		mancalaB.add(label, BorderLayout.NORTH);
		mancalaB.add(trenchB, BorderLayout.CENTER);
	}

}
