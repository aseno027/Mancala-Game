import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class MancalaView extends JFrame implements ChangeListener {

	private Model mancalaModel;
	private int[] pits;
	private MancalaBoard boardStyle;
	
	public MancalaView(Model mancalaModel) {
		this.mancalaModel = mancalaModel;
		boardStyle = new StandardBoard();
		JFrame menuFrame = new JFrame();
		menuFrame.setLayout(new BorderLayout());

		JLabel title = new JLabel("*MANCALA GAME*", SwingConstants.CENTER);

		title.setFont(new Font("Monospaced", Font.BOLD + Font.ITALIC, 30));
		title.setBackground(Color.lightGray);
		title.setOpaque(true);

		JLabel numStonesSelected = new JLabel((this.mancalaModel.getInitialStoneNum() + " STONES"), SwingConstants.CENTER);// default
		numStonesSelected.setBackground(Color.cyan);
		numStonesSelected.setOpaque(true);
		JLabel styleSelected = new JLabel("Standard Board", SwingConstants.CENTER);// default
		styleSelected.setBackground(Color.pink);
		styleSelected.setOpaque(true);

		JPanel panel = new JPanel(new GridLayout(0, 3, 0, 10));
		JLabel prompt1 = new JLabel("Select number of stones: ", SwingConstants.CENTER);
		prompt1.setBackground(Color.cyan);
		prompt1.setOpaque(true);
		JButton threeStones = new JButton("3 Stones");
		threeStones.addActionListener(event -> {
			this.mancalaModel.setInitialStoneNum(3);
			numStonesSelected.setText((this.mancalaModel.getInitialStoneNum() + " STONES"));
		});
		JButton fourStones = new JButton("4 Stones");
		fourStones.addActionListener(event -> {
			this.mancalaModel.setInitialStoneNum(4);
			numStonesSelected.setText((this.mancalaModel.getInitialStoneNum() + " STONES"));
		});
		panel.add(prompt1);
		panel.add(threeStones);
		panel.add(fourStones);
		JLabel prompt2 = new JLabel("\nSelect style: ", SwingConstants.CENTER);
		prompt2.setBackground(Color.pink);
		prompt2.setOpaque(true);
		JButton styleOne = new JButton("Standard Board");// change later
		styleOne.addActionListener(event -> {
			boardStyle = new StandardBoard();
			styleSelected.setText("Standard Board");
		});
		JButton styleTwo = new JButton("Square Board");// change later
		styleTwo.addActionListener(event -> {
			boardStyle = new SquareBoard();
			styleSelected.setText("Square Board");
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
			menuFrame.dispose();
			viewBoard();
		});

		menuFrame.add(title, BorderLayout.NORTH);
		menuFrame.add(panel, BorderLayout.CENTER);
		menuFrame.add(startGame, BorderLayout.SOUTH);

		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.pack();
		menuFrame.setVisible(true);
		
	}

	public void viewBoard() {
		boardStyle.initialNumStone(this.mancalaModel.getInitialStoneNum());
		boardStyle.generateBoard();
		for(int i = 0; i < 14; i++) {
			int pitNum = i;
			boardStyle.getPitButtons()[i].addActionListener(event -> {
				this.mancalaModel.moveStones(pitNum);
				boardStyle.setMessage(this.mancalaModel.getDisplayMessage());
			});
		}
		boardStyle.getUndoButtons().addActionListener(event -> {
				this.mancalaModel.undoMove();
				boardStyle.setMessage(this.mancalaModel.getDisplayMessage());
			});
    }

	@Override
	public void stateChanged(ChangeEvent e) {
		pits = mancalaModel.getPits();
		ImageFiles img = new ImageFiles();
		
		for(int i = 0; i < 14; i++) {
			if(i == 0 || i == 7) {
				if(pits[i] > 25) {
					boardStyle.getPitButtons()[i].setIcon(img.getMancalaImg(25));
				}else {
					boardStyle.getPitButtons()[i].setIcon(img.getMancalaImg(pits[i]));
				}
			} else {
				if(pits[i] > 20) {
					boardStyle.getPitButtons()[i].setIcon(img.getPitImg(20));
				}else {
					boardStyle.getPitButtons()[i].setIcon(img.getPitImg(pits[i]));
				}
			}
		}
		

	}

}
