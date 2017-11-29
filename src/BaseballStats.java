import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import java.text.*;

public class BaseballStats implements ActionListener {

	JFrame mainFrame;
	
	JPanel namePanel;
	JLabel nameLabel;
	JTextField nameTextField;
	
	JPanel gamePanel1;
	JLabel gameLabel1;
	JSpinner gameSpinner1;

	JPanel gamePanel2;
	JLabel gameLabel2;
	JSpinner gameSpinner2;
	
	JPanel gamePanel3;
	JLabel gameLabel3;
	JSpinner gameSpinner3;
	
	JPanel gamePanel4;
	JLabel gameLabel4;
	JSpinner gameSpinner4;
	
	JPanel gamePanel5;
	JLabel gameLabel5;
	JSpinner gameSpinner5;
	
	JPanel listPanel;
	JLabel listLabel;
	JTextArea listTextArea;
	JScrollPane listScrollPane;
	
	JPanel buttonPanel;
	JButton addButton;
	JButton resetButton;
	JButton showButton;
	
	ArrayList<Player> playerList = new ArrayList<Player>();
	
	DecimalFormat decimalFormat = new DecimalFormat("0.000");
	
	public void actionPerformed(ActionEvent event)
	{
		Object control = event.getSource();
		if (control == addButton)
		{
			Player currentPlayer = new Player();
			
			currentPlayer.hits = new int[5];
			currentPlayer.hits[0] = (int) gameSpinner1.getValue();
			currentPlayer.hits[1] = (int) gameSpinner2.getValue();
			currentPlayer.hits[2] = (int) gameSpinner3.getValue();
			currentPlayer.hits[3] = (int) gameSpinner4.getValue();
			currentPlayer.hits[4] = (int) gameSpinner5.getValue();
			
			currentPlayer.name = nameTextField.getText();
			
			playerList.add(currentPlayer);
			
			nameTextField.setText("");
			
			gameSpinner1.setValue(1);
			gameSpinner2.setValue(1);
			gameSpinner3.setValue(1);
			gameSpinner4.setValue(1);
			gameSpinner5.setValue(1);
			
			listTextArea.setText("");
			
			for(Player player : playerList)
			{
				listTextArea.setText(listTextArea.getText() + player.name + "\n");
			}
			
		}
		if (control == resetButton)
		{
			nameTextField.setText("");

			gameSpinner1.setValue(1);
			gameSpinner2.setValue(1);
			gameSpinner3.setValue(1);
			gameSpinner4.setValue(1);
			gameSpinner5.setValue(1);
			
			listTextArea.setText("");
			
			playerList.clear();
		}
		if (control == showButton)
		{
			String sentence = "";
			
			for(Player player : playerList)
			{
				double totalHits = 0;
				
				totalHits = totalHits + player.hits[0];
				totalHits = totalHits + player.hits[1];
				totalHits = totalHits + player.hits[2];
				totalHits = totalHits + player.hits[3];
				totalHits = totalHits + player.hits[4];
				
				String battingAvg = decimalFormat.format(totalHits/5);
				
				if (battingAvg.equals("1.000"))
					sentence += player.name + " got an average of " + battingAvg + " hit. \n";
				else
					sentence += player.name + " got an average of " + battingAvg + " hits. \n";
			}
			
			JOptionPane.showMessageDialog(null, sentence);
		}
		
	}
	
	public static void main(String[] args) 
	{
		new BaseballStats();
		
	}
	
	public BaseballStats()
	{
		mainFrame = new JFrame();

		JPanel mainPanel = (JPanel)mainFrame.getContentPane();
		
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		namePanel = new JPanel();
		nameLabel = new JLabel("Player Name:");
		nameTextField = new JTextField(20);
		
		gamePanel1 = new JPanel();
		gameLabel1 = new JLabel("Game 1:");
		gameSpinner1 = new JSpinner(new SpinnerNumberModel(1,1,5,1));
		
		gamePanel2 = new JPanel();
		gameLabel2 = new JLabel("Game 2:");
		gameSpinner2 = new JSpinner(new SpinnerNumberModel(1,1,5,1));
		
		gamePanel3 = new JPanel();
		gameLabel3 = new JLabel("Game 3:");
		gameSpinner3 = new JSpinner(new SpinnerNumberModel(1,1,5,1));
		
		gamePanel4 = new JPanel();
		gameLabel4 = new JLabel("Game 4:");
		gameSpinner4 = new JSpinner(new SpinnerNumberModel(1,1,5,1));
		
		gamePanel5 = new JPanel();
		gameLabel5 = new JLabel("Game 5:");
		gameSpinner5 = new JSpinner(new SpinnerNumberModel(1,1,5,1));
		
		listPanel = new JPanel();
		listLabel = new JLabel("Current Players:");
		listTextArea = new JTextArea(3, 20);
		listTextArea.setEditable(false);
		listScrollPane = new JScrollPane(listTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		buttonPanel = new JPanel();
		addButton = new JButton("Add Player");
		addButton.addActionListener(this);
		resetButton = new JButton("Reset Players");
		resetButton.addActionListener(this);
		showButton = new JButton("Show Stats");
		showButton.addActionListener(this);
		
		namePanel.add(nameLabel);
		namePanel.add(nameTextField);
		
		gamePanel1.add(gameLabel1);
		gamePanel1.add(gameSpinner1);

		gamePanel2.add(gameLabel2);
		gamePanel2.add(gameSpinner2);

		gamePanel3.add(gameLabel3);
		gamePanel3.add(gameSpinner3);

		gamePanel4.add(gameLabel4);
		gamePanel4.add(gameSpinner4);

		gamePanel5.add(gameLabel5);
		gamePanel5.add(gameSpinner5);
		
		listPanel.add(listLabel);
		listPanel.add(listScrollPane);
		
		buttonPanel.add(addButton);
		buttonPanel.add(resetButton);
		buttonPanel.add(showButton);
		
		mainFrame.add(namePanel);
		mainFrame.add(gamePanel1);
		mainFrame.add(gamePanel2);
		mainFrame.add(gamePanel3);
		mainFrame.add(gamePanel4);
		mainFrame.add(gamePanel5);
		mainFrame.add(listPanel);
		mainFrame.add(buttonPanel);
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}

}
