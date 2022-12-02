import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

//CONCRETE STRATEGY
public class StandardBoard implements MancalaBoard {

	private JButton[] pits = new JButton[14];
	private int numStones;
	private JButton undoButton;
	private JLabel messageLabel;
	/**
	 * generate standard mancala board.
	 */
	public void generateBoard() {
		
		ImageFiles img = new ImageFiles();
		
		JFrame boardFrame = new JFrame();
		BorderLayout layout = new BorderLayout();
		boardFrame.setLayout(layout);
		
		JPanel topPanel = new JPanel(new GridLayout());
		messageLabel = new JLabel("Player 1 turn", SwingConstants.CENTER);
		messageLabel.setFont(new Font("Monospaced", Font.BOLD, 15));
		JPanel undoButtonPanel = new JPanel();
		undoButton = new JButton("UNDO");
		undoButtonPanel.add(undoButton);
		topPanel.add(undoButtonPanel);
		topPanel.add(messageLabel);
		
		JPanel boardPanel = new JPanel(new BorderLayout());

		JPanel mancalaA = new JPanel(new BorderLayout()); // East
		JPanel mancalaB = new JPanel(new BorderLayout()); // West

		JPanel centerBoard = new JPanel(new GridLayout(4, 6));
	
		boardPanel.add(mancalaA, BorderLayout.EAST);
		boardPanel.add(mancalaB, BorderLayout.WEST);
		JLabel directionP1 = new JLabel("Player 1 --->", SwingConstants.CENTER);
		directionP1.setFont(new Font("Monospaced", Font.BOLD, 30));
		boardPanel.add(directionP1, BorderLayout.SOUTH);
		JLabel directionP2 = new JLabel("<--- Player 2", SwingConstants.CENTER);
		directionP2.setFont(new Font("Monospaced", Font.BOLD, 30));
		boardPanel.add(directionP2, BorderLayout.NORTH);
		boardPanel.add(centerBoard, BorderLayout.CENTER);
		
		boardFrame.add(topPanel,  BorderLayout.NORTH);
		boardFrame.add(boardPanel,  BorderLayout.CENTER);
		

		boardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		boardFrame.setTitle("Mancala Board");
		boardFrame.setSize(1000, 600);
		boardFrame.setVisible(true);

		
		
		//JButton[] pits = new JButton[14];
				
		for(int i = 0; i < pits.length; i++) {
			pits[i] = new RoundButton(null);
		}
		
		for(int i = 0; i < pits.length; i++) {
			pits[i].setBackground(Color.WHITE);
			pits[i].setBorderPainted(false);
		}
		
		for(int i = 0; i < pits.length; i++) {
			if(i == 0 || i == 7) {
				pits[i].setIcon(img.getMancalaImg(0));
			} else {
				pits[i].setIcon(img.getPitImg(numStones));
			}
		}
		
		
		JLabel label;
		for(int i = 13; i >= 8; i--) {
			centerBoard.add(pits[i]);
		}

		
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
		
		for(int i = 1; i < 7; i++) {
			centerBoard.add(pits[i]);
		}
		

		label = new JLabel("Mancala A", SwingConstants.CENTER);
		label.setFont(new Font("Monospaced", Font.BOLD, 30));
		mancalaA.add(label, BorderLayout.SOUTH);
		mancalaA.add(pits[7], BorderLayout.CENTER);
		label = new JLabel("Mancala B", SwingConstants.CENTER);
		label.setFont(new Font("Monospaced", Font.BOLD, 30));
		mancalaB.add(label, BorderLayout.NORTH);
		mancalaB.add(pits[0], BorderLayout.CENTER);
	}
	
	@Override
	public JButton[] getPitButtons() {
		return pits;
	}

	@Override
	public void initialNumStone(int numStones) {
		this.numStones = numStones;
		
	}

	@Override
	public JButton getUndoButtons() {
		return undoButton;
	}

	@Override
	public void setMessage(String s) {
		messageLabel.setText(s);
	}

}
