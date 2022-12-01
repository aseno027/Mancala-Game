import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MancalaView extends JFrame implements ChangeListener {

	private Model mancalaModel;
	private int numStones;
	private int style;

	public static void main(String args[]) {
		MancalaView v = new MancalaView();
		v.mainMenu();
	}

	public void mainMenu() {

		numStones = 3;// default
		style = 1;// default

		setLayout(new BorderLayout());

		JLabel title = new JLabel("*MANCALA GAME*", SwingConstants.CENTER);

		title.setFont(new Font("Monospaced", Font.BOLD + Font.ITALIC, 30));
		title.setBackground(Color.lightGray);
		title.setOpaque(true);

		JLabel numStonesSelected = new JLabel((numStones + " STONES"), SwingConstants.CENTER);// default
		numStonesSelected.setBackground(Color.cyan);
		numStonesSelected.setOpaque(true);
		JLabel styleSelected = new JLabel("STYLE " + style, SwingConstants.CENTER);// default
		styleSelected.setBackground(Color.pink);
		styleSelected.setOpaque(true);

		JPanel panel = new JPanel(new GridLayout(0, 3, 0, 10));
		JLabel prompt1 = new JLabel("Select number of stones: ", SwingConstants.CENTER);
		prompt1.setBackground(Color.cyan);
		prompt1.setOpaque(true);
		JButton threeStones = new JButton("3 Stones");
		threeStones.addActionListener(event -> {
			numStones = 3;
			numStonesSelected.setText((numStones + " STONES"));
		});
		JButton fourStones = new JButton("4 Stones");
		fourStones.addActionListener(event -> {
			numStones = 4;
			numStonesSelected.setText((numStones + " STONES"));
		});
		panel.add(prompt1);
		panel.add(threeStones);
		panel.add(fourStones);
		JLabel prompt2 = new JLabel("\nSelect style: ", SwingConstants.CENTER);
		prompt2.setBackground(Color.pink);
		prompt2.setOpaque(true);
		JButton styleOne = new JButton("Style 1");// change later
		styleOne.addActionListener(event -> {
			style = 1;
			styleSelected.setText("STYLE " + style);
		});
		JButton styleTwo = new JButton("Style 2");// change later
		styleTwo.addActionListener(event -> {
			style = 2;
			styleSelected.setText("STYLE " + style);
		});

		JLabel prompt3 = new JLabel("YOUR SELECTIONS: ", SwingConstants.CENTER);
		prompt3.setBackground(Color.lightGray);
		prompt3.setOpaque(true);
		panel.add(prompt2);
		panel.add(styleOne);
		panel.add(styleTwo);
		panel.add(prompt3);
		panel.add(numStonesSelected);
		panel.add(styleSelected);

		JButton startGame = new JButton("START GAME");
		startGame.addActionListener(event -> {
			dispose();
			viewBoard();
		});

		add(title, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		add(startGame, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);

	}

	public void viewBoard() {
		JFrame boardFrame = new JFrame();
		boardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final BoardComponent board = new BoardComponent();
		if(style == 1) {
			board.add(new StandardBoard(20, 20, 100, 75));
		}
		if(style == 2) {
			board.add(new SquareBoard(20, 20, 100, 75));
		}
		boardFrame.add(board, BorderLayout.CENTER);
		boardFrame.setTitle("Mancala Board");
		boardFrame.setSize(1000,500);
		boardFrame.setVisible(true);

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub

	}

}