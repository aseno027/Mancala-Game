import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.geom.*;
import javax.swing.*;

//CONCRETE STRATEGY
public class StandardBoard implements MancalaBoard {

	
	/**
	 * generate standard mancala board.
	 */
	public void generateBoard() {

		ImageFiles img = new ImageFiles();
		
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
		boardFrame.setSize(1000, 600);
		boardFrame.setVisible(true);

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
		
		
		
		pitA1.setBackground(Color.WHITE);
		pitA2.setBackground(Color.WHITE);
		pitA3.setBackground(Color.WHITE);
		pitA4.setBackground(Color.WHITE);
		pitA5.setBackground(Color.WHITE);
		pitA6.setBackground(Color.WHITE);
		pitB1.setBackground(Color.WHITE);
		pitB2.setBackground(Color.WHITE);
		pitB3.setBackground(Color.WHITE);
		pitB4.setBackground(Color.WHITE);
		pitB5.setBackground(Color.WHITE);
		pitB6.setBackground(Color.WHITE);
		
		pitA1.setBorderPainted(false);
		pitA2.setBorderPainted(false);
		pitA3.setBorderPainted(false);
		pitA4.setBorderPainted(false);
		pitA5.setBorderPainted(false);
		pitA6.setBorderPainted(false);
		pitB1.setBorderPainted(false);
		pitB2.setBorderPainted(false);
		pitB3.setBorderPainted(false);
		pitB4.setBorderPainted(false);
		pitB5.setBorderPainted(false);
		pitB6.setBorderPainted(false);
		
		pitA1.setIcon(img.getPitImg(0));
		pitA2.setIcon(img.getPitImg(0));
		pitA3.setIcon(img.getPitImg(0));
		pitA4.setIcon(img.getPitImg(0));
		pitA5.setIcon(img.getPitImg(0));
		pitA6.setIcon(img.getPitImg(0));
		pitB1.setIcon(img.getPitImg(0));
		pitB2.setIcon(img.getPitImg(0));
		pitB3.setIcon(img.getPitImg(0));
		pitB4.setIcon(img.getPitImg(0));
		pitB5.setIcon(img.getPitImg(0));
		pitB6.setIcon(img.getPitImg(0));
		
		
		trenchA.setIcon(img.getMancalaImg(0));
		trenchB.setIcon(img.getMancalaImg(0));
		
		trenchA.setBackground(Color.WHITE);		
		trenchB.setBackground(Color.WHITE);
		
		trenchA.setBorderPainted(false);
		trenchB.setBorderPainted(false);
		
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
