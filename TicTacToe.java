package ThingsNeededToWork;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{
	
	//Variables needed for this all to work 
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();	
	JLabel textfield = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean player1_turn;
	boolean tie;
	
	TicTacToe() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Size of Tab
		frame.setSize(700,700);
		//Tabs color
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		
		//Color of txt background
		textfield.setBackground(Color.yellow);
		//Color of txt
		textfield.setForeground(Color.pink);
		//Font and ect.
		textfield.setFont(new Font("Times New Roman", Font.BOLD,75));
		//Where the txt is going to be placed
		textfield.setHorizontalAlignment(JLabel.CENTER);
		//Txt
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true);
		
		
		//where it starts and ends
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,700,100);
		
		
		//How many places we can interact with
		button_panel.setLayout(new GridLayout(3,3));
		//Color of txt background
		button_panel.setBackground(new Color(150,150,150));
		
		//The Making of the buttons and how it will look like
		for(int i = 0; i< 9; i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		
		title_panel.add(textfield);
		//Txt at the top
		frame.add(title_panel, BorderLayout.NORTH);
		//button
		frame.add(button_panel);
		
		
		firstTurn();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		for(int i = 0; i< 9; i++) {
			if(e.getSource() == buttons[i]) {
				if(player1_turn) {
					if(buttons[i].getText() == "") {
						//How the button looks like and its color
						buttons[i].setForeground(Color.blue);
						buttons[i].setText("X");
						player1_turn = false;
						textfield.setText("O Turn");
						check();
					}
				} else {
					if(buttons[i].getText() == "") {
						//How the button looks like and its color
						buttons[i].setForeground(Color.red);
						buttons[i].setText("O");
						player1_turn = true;
						textfield.setText("X Turn");
						check();
					}
				}
			}
			
		}
		
	}
	
	//To see which player gets to go first in the game
	public void firstTurn() {
		
		//How long you want the title to show until the turn is given
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			//Changed so that X always goes first
//		//First pick, First game
//		if(random.nextInt(2) == 0) {
			player1_turn = true;
			textfield.setText("X turn");
//		} else {
//			player1_turn = false;
//			textfield.setText("O turn");
//		}
		
	}
	
	//To see which player has won 
	public void check() {
		
		//CHECK X WIN CONDITIONS
		if(
				(buttons[0].getText()=="X") && 
				(buttons[1].getText()=="X") &&
				(buttons[2].getText()=="X")
				) {
			xWins(0,1,2);
		}
		
		if(
				(buttons[3].getText()=="X") && 
				(buttons[4].getText()=="X") &&
				(buttons[5].getText()=="X")
				) {
			xWins(3,4,5);
		}
		
		if(
				(buttons[6].getText()=="X") && 
				(buttons[7].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(6,7,8);
		}
		
		if(
				(buttons[0].getText()=="X") && 
				(buttons[3].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins(0,3,6);
		}
		
		if(
				(buttons[1].getText()=="X") && 
				(buttons[4].getText()=="X") &&
				(buttons[7].getText()=="X")
				) {
			xWins(1,4,7);
		}
		
		if(
				(buttons[2].getText()=="X") && 
				(buttons[5].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(2,5,8);
		}
		
		if(
				(buttons[0].getText()=="X") && 
				(buttons[4].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(0,4,8);
		}
		
		if(
				(buttons[2].getText()=="X") && 
				(buttons[4].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins(2,4,6);
		}
		
		
		
		//CHECK O WIN CONDITIONS
		if(
				(buttons[0].getText()=="O") && 
				(buttons[1].getText()=="O") &&
				(buttons[2].getText()=="O")
				) {
			oWins(0,1,2);
		}
		
		if(
				(buttons[3].getText()=="O") && 
				(buttons[4].getText()=="O") &&
				(buttons[5].getText()=="O")
				) {
			oWins(3,4,5);
		}
		
		if(
				(buttons[6].getText()=="O") && 
				(buttons[7].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(6,7,8);
		}
		
		if(
				(buttons[0].getText()=="O") && 
				(buttons[3].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins(0,3,6);
		}
		
		if(
				(buttons[1].getText()=="O") && 
				(buttons[4].getText()=="O") &&
				(buttons[7].getText()=="O")
				) {
			oWins(1,4,7);
		}
		
		if(
				(buttons[2].getText()=="O") && 
				(buttons[5].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(2,5,8);
		}
		
		if(
				(buttons[0].getText()=="O") && 
				(buttons[4].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(0,4,8);
		}
		
		if(
				(buttons[2].getText()=="O") && 
				(buttons[4].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins(2,4,6);
		}
		
		
		//CHECK TIE CONDITION
		boolean tie = true;
		for(int i = 0; i < 9; i++) {
			if(buttons[i].getText().equals("")) {
				tie = false;
				break;
			}
		}
		
		if(tie) {
			textfield.setText("Tie");
		}
		
		
	}
	
	//Player X won the game
	public void xWins(int a, int b, int c) {
		
		//What happens when X wins
		buttons[a].setBackground(Color.green);
		buttons[b].setBackground(Color.green);
		buttons[c].setBackground(Color.green);
		
		//no more buttons can be changed
		for (int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);
		}
		
		textfield.setText("X Wins");
		
	}
	
	//Player O won the game
	public void oWins(int a, int b, int c) {
			
			//What happens when X wins
			buttons[a].setBackground(Color.green);
			buttons[b].setBackground(Color.green);
			buttons[c].setBackground(Color.green);
			
			//no more buttons can be changed
			for (int i = 0; i < 9; i++) {
				buttons[i].setEnabled(false);
			}
			
			textfield.setText("O Wins");
			
	}
	
}
