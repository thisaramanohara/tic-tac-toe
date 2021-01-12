import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JPanel/* implements ActionListener*/ {
	
	 static JButton [] buttons = new JButton[9];
	 static JButton reset = new JButton("RESET");
	 static JLabel status = new JLabel();
	 static JLabel greet = new JLabel();
	 static int user=1;

	public static void TicTacToe(JPanel panel) {
		panel.setLayout(null);
		
		JLabel name = new JLabel();
		name.setFont(new Font("Arial",Font.BOLD,60));
		name.setBounds(70,50,450,70);
		name.setText("Tic - Tac - Toe");
		panel.add(name);
		
		
		greet.setFont(new Font("Arial",Font.BOLD,60));
		greet.setBounds(530,200,450,70);
		greet.setText("Congrats !!!");
		greet.setVisible(false);
		panel.add(greet);
		
		
		buttons[0] = new JButton();
		for(int i=0;i<9;i++) {
			buttons[i] = new JButton();
			buttons[i].addActionListener(new clicked(i));
			buttons[i].setFont(new Font("Arial",Font.BOLD,60));
			//buttons[i].setPreferredSize(new Dimension(200,200));
		}
		
		//positioning the buttons
		//--------------------------------
		buttons[0].setBounds(50,150,150,150);
		buttons[1].setBounds(200,150,150,150);
		buttons[2].setBounds(350,150,150,150);
		//---------------------------------
		buttons[3].setBounds(50,300,150,150);
		buttons[4].setBounds(200,300,150,150);
		buttons[5].setBounds(350,300,150,150);
		//---------------------------------
		buttons[6].setBounds(50,450,150,150);
		buttons[7].setBounds(200,450,150,150);
		buttons[8].setBounds(350,450,150,150);
		//---------------------------------
		
		status.setBounds(550,280,400,100);
		status.setFont(new Font("Arial",Font.BOLD,40));
		status.setText("  Game Status");
		panel.add(status);
		
		
		reset.setBounds(640,380,100,50);
		panel.add(reset);
		reset.addActionListener(new clicked());
		
		for(int i=0;i<9;i++) {
			panel.add(buttons[i]);
			
		}
				
		
		
	}
		
	
	public static void main(String[] args) {
		
		JFrame board = new JFrame("Tic Tac Toe");
		board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		board.setSize(900,700);
		board.setVisible(true);
		JPanel panel = new JPanel();
		board.add(panel);
		TicTacToe(panel);
		
		
	}

}


class clicked implements ActionListener {
	static int count=0;
	String player1 = "1";
	String player2 = "2";
	int id;
	
	public clicked() {
		
	}
	
	public clicked(int id) {
		this.id = id;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() != Game.reset) {
			count++;
			Game.buttons[id].setText(Integer.toString(Game.user));
			if(Game.user==1) {
				Game.user=2;
			}else {
				Game.user = 1;
			}
			Game.buttons[id].setEnabled(false);
			
			
		}else {
			for(int i=0;i<9;i++) {
				Game.buttons[i].setEnabled(true);
				Game.buttons[i].setText("");
				Game.user = 1;
			}
			Game.status.setText("  Game Status");
			count = 0;
		}

		
		
		//ways that player 1 wins
		boolean w1 = "1".equals(Game.buttons[0].getText()) && "1".equals(Game.buttons[1].getText()) && "1".equals(Game.buttons[2].getText());
		boolean w2 = "1".equals(Game.buttons[3].getText()) && "1".equals(Game.buttons[4].getText()) && "1".equals(Game.buttons[5].getText());
		boolean w3 = "1".equals(Game.buttons[6].getText()) && "1".equals(Game.buttons[7].getText()) && "1".equals(Game.buttons[8].getText());
		boolean w4 = "1".equals(Game.buttons[0].getText()) && "1".equals(Game.buttons[3].getText()) && "1".equals(Game.buttons[6].getText());
		boolean w5 = "1".equals(Game.buttons[1].getText()) && "1".equals(Game.buttons[4].getText()) && "1".equals(Game.buttons[7].getText());
		boolean w6 = "1".equals(Game.buttons[2].getText()) && "1".equals(Game.buttons[5].getText()) && "1".equals(Game.buttons[8].getText());
		boolean w7 = "1".equals(Game.buttons[0].getText()) && "1".equals(Game.buttons[4].getText()) && "1".equals(Game.buttons[8].getText());
		boolean w8 = "1".equals(Game.buttons[2].getText()) && "1".equals(Game.buttons[4].getText()) && "1".equals(Game.buttons[6].getText());
		
		//ways that player 2 wins
		boolean x1 = "2".equals(Game.buttons[0].getText()) && "2".equals(Game.buttons[1].getText()) && "2".equals(Game.buttons[2].getText());
		boolean x2 = "2".equals(Game.buttons[3].getText()) && "2".equals(Game.buttons[4].getText()) && "2".equals(Game.buttons[5].getText());
		boolean x3 = "2".equals(Game.buttons[6].getText()) && "2".equals(Game.buttons[7].getText()) && "2".equals(Game.buttons[8].getText());
		boolean x4 = "2".equals(Game.buttons[0].getText()) && "2".equals(Game.buttons[3].getText()) && "2".equals(Game.buttons[6].getText());
		boolean x5 = "2".equals(Game.buttons[1].getText()) && "2".equals(Game.buttons[4].getText()) && "2".equals(Game.buttons[7].getText());
		boolean x6 = "2".equals(Game.buttons[2].getText()) && "2".equals(Game.buttons[5].getText()) && "2".equals(Game.buttons[8].getText());
		boolean x7 = "2".equals(Game.buttons[0].getText()) && "2".equals(Game.buttons[4].getText()) && "2".equals(Game.buttons[8].getText());
		boolean x8 = "2".equals(Game.buttons[2].getText()) && "2".equals(Game.buttons[4].getText()) && "2".equals(Game.buttons[6].getText());
		
		if(w1 || w2 || w3 || w4 || w5 || w6 || w7 || w8) {
			Game.greet.setVisible(true);
			for(int i=0;i<9;i++) {
				Game.buttons[i].setEnabled(false);
				Game.status.setText("Player 1 wins !!!");
			}
		}
		
		else if(x1 || x2 || x3 || x4 || x5 || x6 || x7 || x8) {
			Game.greet.setVisible(true);
			for(int i=0;i<9;i++) {
				Game.buttons[i].setEnabled(false);
				Game.status.setText("Player 2 wins !!!");
			}
		}
		else if(count==9) {
			Game.status.setText("Draw !!!");
		}
		
		
		
		
		
	}
}








