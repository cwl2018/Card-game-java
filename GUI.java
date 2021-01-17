import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 * Javadoc of the GUI class
 * 
 * @author ChanWangLeung
 *
 */
public class GUI {
	JFrame frame;
	JPanel MainPanel = new JPanel();
	JPanel DealerPanel = new JPanel();
	JPanel PlayerPanel = new JPanel();
	JPanel RpCardBtnPanel = new JPanel();
	JPanel ButtonPanel = new JPanel();
	JPanel InfoPanel = new JPanel();

	// 6 JLabel components for holding 6 ImageIcon components.
	ImageIcon Image1 = new ImageIcon("card_back.gif");
	ImageIcon Image2 = new ImageIcon("card_back.gif");
	ImageIcon Image3 = new ImageIcon("card_back.gif");
	ImageIcon Image4 = new ImageIcon("card_back.gif");
	ImageIcon Image5 = new ImageIcon("card_back.gif");
	ImageIcon Image6 = new ImageIcon("card_back.gif");
	JLabel label_Image1 = new JLabel();
	JLabel label_Image2 = new JLabel();
	JLabel label_Image3 = new JLabel();
	JLabel label_Image4 = new JLabel();
	JLabel label_Image5 = new JLabel();
	JLabel label_Image6 = new JLabel();

	// 3 JButton components for the player to replace card 1, card 2 and card 3
	JButton btn_rpcard1 = new JButton("Replace Card 1");
	JButton btn_rpcard2 = new JButton("Replace Card 2");
	JButton btn_rpcard3 = new JButton("Replace Card 3");

	// 1 JLabel component showing the string “Bet: $” to guide the player to input
	// his/her bet.
	JLabel label_bet = new JLabel();
	JLabel label_money = new JLabel();

	// 1 JTextField component for the player to input his/her bet (in the form of a
	// positive integer).
	JTextField txt_inputbet = new JTextField(10);

	// 2 JButton components for the player to start the game (i.e. drawing 3 cards
	// from
	// the dealer’s pack) and to evaluate the result.
	JButton btn_start = new JButton("Start");
	JButton btn_result = new JButton("Result");

	// 2 JLabel components for displaying important messages and the remaining
	// budget
	// that the player has.
	JLabel txt_bottom = new JLabel();
	JLabel importantmessage = new JLabel();

	// 1 JMenuBar contains the following:
	// -1 JMenu “Control” contains 1 JMenuItem to quit the game.
	// -1 JMenu “Help” contains 1 JMenuItem for displaying the rule of the game (you
	// can copy the rules as stated in the section Rules to determine who has better
	// cards in Page 1 of this document).
	JMenuBar menuBar = new JMenuBar();
	JMenu menu1 = new JMenu("Control");
	JMenu menu2 = new JMenu("Help");
	JMenuItem exit = new JMenuItem("Exit");

	private Card deck[];
	private int currentCard;
	private Card playercard1, playercard2, playercard3, dealercard1, dealercard2, dealercard3;
	private int money;
	private int replacebutton1clicked = 0;
	private int replacebutton2clicked = 0;
	private int replacebutton3clicked = 0;
	private int readytoreplacecards = 0;
	private int readytogenerateresult = 0;
	private int readytostart = 1;
	private int cardsreplaced = 0;

	public static void main(String[] args) {
		GUI game = new GUI();
	}

	/**
	 * Constructor of the class GUI
	 */
	public GUI() {
		money = 100;
		DealerPanel.setBackground(Color.DARK_GRAY);
		PlayerPanel.setBackground(Color.DARK_GRAY);
		RpCardBtnPanel.setBackground(Color.DARK_GRAY);
		MainPanel.setLayout(new GridLayout(5, 1));
		MainPanel.add(DealerPanel);
		MainPanel.add(PlayerPanel);
		MainPanel.add(RpCardBtnPanel);
		MainPanel.add(ButtonPanel);
		MainPanel.add(InfoPanel);

		label_Image1.setIcon(Image1);
		label_Image2.setIcon(Image2);
		label_Image3.setIcon(Image3);
		label_Image4.setIcon(Image4);
		label_Image5.setIcon(Image5);
		label_Image6.setIcon(Image6);
		DealerPanel.add(label_Image1);
		DealerPanel.add(label_Image2);
		DealerPanel.add(label_Image3);
		PlayerPanel.add(label_Image4);
		PlayerPanel.add(label_Image5);
		PlayerPanel.add(label_Image6);

		btn_rpcard1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (replacebutton1clicked == 0 && readytoreplacecards == 1 && cardsreplaced < 2) {
					playercard1 = deck[currentCard - 1];
					currentCard++;
					Image4 = new ImageIcon("card_" + playercard1.getSuit() + playercard1.getCard() + ".gif");
					label_Image4.setIcon(Image4);
					cardsreplaced++;
				}
				replacebutton1clicked = 1;
			}

		});
		btn_rpcard2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (replacebutton2clicked == 0 && readytoreplacecards == 1 && cardsreplaced < 2) {
					playercard2 = deck[currentCard - 1];
					currentCard++;
					Image5 = new ImageIcon("card_" + playercard2.getSuit() + playercard2.getCard() + ".gif");
					label_Image5.setIcon(Image5);
					cardsreplaced++;
				}
				replacebutton2clicked = 1;
			}

		});
		btn_rpcard3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (replacebutton3clicked == 0 && readytoreplacecards == 1 && cardsreplaced < 2) {
					playercard3 = deck[currentCard - 1];
					currentCard++;
					Image6 = new ImageIcon("card_" + playercard3.getSuit() + playercard3.getCard() + ".gif");
					label_Image6.setIcon(Image6);
					cardsreplaced++;
				}
				replacebutton3clicked = 1;
			}

		});
		RpCardBtnPanel.add(btn_rpcard1);
		RpCardBtnPanel.add(btn_rpcard2);
		RpCardBtnPanel.add(btn_rpcard3);

		label_bet.setText("Bet: $");
		ButtonPanel.add(label_bet);

		ButtonPanel.add(txt_inputbet);

		btn_start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (readytostart == 1) {
					label_money.setText(txt_inputbet.getText());
					if (isInteger(txt_inputbet.getText())) {
						if (Integer.valueOf(txt_inputbet.getText()) > 0
								&& Integer.valueOf(txt_inputbet.getText()) <= money) {
							importantmessage.setText("Your current bet is: $ " + label_money.getText());
							replacebutton1clicked = 0;
							replacebutton2clicked = 0;
							replacebutton3clicked = 0;
							play();
							return;
						}
					}
					JOptionPane.showMessageDialog(frame, "WARNING: The bet you place must be a positive integer!");

				}
			}
		});
		ButtonPanel.add(btn_start);

		btn_result.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (readytogenerateresult == 1) {
					dealercard1 = deck[currentCard - 1];
					currentCard++;
					dealercard2 = deck[currentCard - 1];
					currentCard++;
					dealercard3 = deck[currentCard - 1];
					currentCard++;
					Image1 = new ImageIcon("card_" + dealercard1.getSuit() + dealercard1.getCard() + ".gif");
					Image2 = new ImageIcon("card_" + dealercard2.getSuit() + dealercard2.getCard() + ".gif");
					Image3 = new ImageIcon("card_" + dealercard3.getSuit() + dealercard3.getCard() + ".gif");
					label_Image1.setIcon(Image1);
					label_Image2.setIcon(Image2);
					label_Image3.setIcon(Image3);
					generateresult();
				}
				readytogenerateresult = 0;
				Image1 = new ImageIcon("card_back.gif");
				Image2 = new ImageIcon("card_back.gif");
				Image3 = new ImageIcon("card_back.gif");
				Image4 = new ImageIcon("card_back.gif");
				Image5 = new ImageIcon("card_back.gif");
				Image6 = new ImageIcon("card_back.gif");
				label_Image1.setIcon(Image1);
				label_Image2.setIcon(Image2);
				label_Image3.setIcon(Image3);
				label_Image4.setIcon(Image4);
				label_Image5.setIcon(Image5);
				label_Image6.setIcon(Image6);
				if (readytostart == 1) {
					importantmessage.setText("Please place your bet!");
					txt_bottom.setText(" Amount of money you have: $" + money);
				}
				replacebutton1clicked = 1;
				replacebutton2clicked = 1;
				replacebutton3clicked = 1;
			}

		});
		ButtonPanel.add(btn_result);

		importantmessage.setText("Please place your bet!");
		txt_bottom.setText(" Amount of money you have: $" + money);
		InfoPanel.add(importantmessage);
		InfoPanel.add(txt_bottom);

		menu2.addMenuListener(new menu2action());
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}

		});
		menu1.add(exit);
		menuBar.add(menu1);
		menuBar.add(menu2);

		frame = new JFrame("A Simple Card Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(MainPanel);
		frame.setJMenuBar(menuBar);
		frame.setSize(400, 700);
		frame.setVisible(true);

	}

	/**
	 * The codes to implemented from after the bet amount is verified to be valid
	 * Including: Creating a deck of cards, Shuffling the deck of cards ,Displaying
	 * players cards ,Enables Replace buttons ,Enables Result button
	 */
	public void play() {
		// TODO Auto-generated method stub

		readytostart = 0;

		// Create Deck of cards
		deck = new Card[52];
		currentCard = 1;
		for (int suit = 1; suit <= 4; suit++) {
			for (int card = 1; card <= 13; card++) {
				deck[currentCard - 1] = new Card(suit, card);
				currentCard++;
			}
		}
		// shuffle
		for (int i = 0; i < 52; i++) {
			Random a = new Random();
			int randomnum = a.nextInt(52);
			Card buffer = deck[randomnum];
			deck[randomnum] = deck[i];
			deck[i] = buffer;
		}

		currentCard = 1;
		playercard1 = deck[currentCard - 1];
		currentCard++;
		playercard2 = deck[currentCard - 1];
		currentCard++;
		playercard3 = deck[currentCard - 1];
		currentCard++;
		Image4 = new ImageIcon(
				"card_" + Integer.toString(playercard1.getSuit()) + Integer.toString(playercard1.getCard()) + ".gif");
		Image5 = new ImageIcon(
				"card_" + Integer.toString(playercard2.getSuit()) + Integer.toString(playercard2.getCard()) + ".gif");
		Image6 = new ImageIcon(
				"card_" + Integer.toString(playercard3.getSuit()) + Integer.toString(playercard3.getCard()) + ".gif");
		label_Image4.setIcon(Image4);
		label_Image5.setIcon(Image5);
		label_Image6.setIcon(Image6);
		readytoreplacecards = 1;
		readytogenerateresult = 1;
		cardsreplaced = 0;

	}

	/**
	 * ActionListener of the Menu Help
	 */
	public class menu2action implements MenuListener {
		@Override
		public void menuSelected(MenuEvent e) {
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(frame, "Rules to determine who has better cards:\r\n"
					+ "J, Q, K are regarded as special cards.\r\n" + "Rule 1: The one with more special cards wins.\r\n"
					+ "Rule 2: If both have the same number of special cards, add the face values of the other\r\n"
					+ "card(s) and take the remainder after dividing the sum by 10. The one with a bigger\r\n"
					+ "remainder wins. (Note: Ace = 1).\r\n"
					+ "Rule 3: The dealer wins if both rule 1 and rule 2 cannot distinguish the winner.");
		}

		@Override
		public void menuDeselected(MenuEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void menuCanceled(MenuEvent e) {
			// TODO Auto-generated method stub

		}

	}

	/**
	 * Checks if a String is an Integer
	 * 
	 * @param s String to be checked
	 * 
	 * @return boolean value of s is an Integer
	 */
	public boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		return true;
	}

	/**
	 * Calculates the winner of the game.
	 */
	public void generateresult() {

		readytostart = 1;

		int dealerjqk = 0, dealerpoints = 0;
		int playerjqk = 0, playerpoints = 0;
		if (dealercard1.getCard() > 10)
			dealerjqk++;
		else
			dealerpoints += dealercard1.getCard();
		if (dealercard2.getCard() > 10)
			dealerjqk++;
		else
			dealerpoints += dealercard2.getCard();
		if (dealercard3.getCard() > 10)
			dealerjqk++;
		else
			dealerpoints += dealercard3.getCard();
		if (playercard1.getCard() > 10)
			playerjqk++;
		else
			playerpoints += playercard1.getCard();
		if (playercard2.getCard() > 10)
			playerjqk++;
		else
			playerpoints += playercard2.getCard();
		if (playercard3.getCard() > 10)
			playerjqk++;
		else
			playerpoints += playercard3.getCard();
		// result
		if (dealerjqk < playerjqk) {
			winoutput();
			return;
		}
		if (dealerjqk > playerjqk) {
			loseoutput();
			return;
		}
		if (dealerpoints % 10 < playerpoints % 10) {
			winoutput();
			return;
		}
		if (dealerpoints % 10 >= playerpoints % 10) {
			loseoutput();
			return;
		}
	}

	/**
	 * Displays winner output, adds winnings to balance.
	 */
	public void winoutput() {
		JOptionPane.showMessageDialog(frame, "Congratulations! You win this round!");
		money += Integer.valueOf(txt_inputbet.getText());
	}

	/**
	 * Displays loser output, subtract losses from balance.
	 */
	public void loseoutput() {
		money -= Integer.valueOf(txt_inputbet.getText());
		if (money <= 0) {
			JOptionPane.showMessageDialog(frame,
					"Game over!\r\n" + "You have no more money!\n" + "Please start a new game");
			importantmessage.setText("You have no more money! ");
			txt_bottom.setText("Please start a new game!");
			readytostart = 0;
			return;
		}
		JOptionPane.showMessageDialog(frame, "Sorry! The Dealer wins this round!");
	}
}
