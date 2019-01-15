import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Frame extends JFrame {
	
	//create variables
	final static int numRadioButtons = 4;
	JRadioButton[] radioButtons;
	JButton start = new JButton("Start");
	JButton next = new JButton("Next");
	JButton submit = new JButton("Submit");
	JTextArea text = new JTextArea();
	JTextField field = new JTextField(15);
	JLabel welcome = new JLabel();
	
	
	public Frame(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 800);
		setLayout(new BorderLayout());
		JPanel panel = new JPanel(new GridLayout(0,1));
		
		
		ButtonGroup group = new ButtonGroup();
		radioButtons = new JRadioButton[numRadioButtons];
		for (int i = 0; i < numRadioButtons; i++) {
			radioButtons[i] = new JRadioButton();
			group.add(radioButtons[i]);
			panel.add(radioButtons[i]);
			
		}
		add(panel, BorderLayout.WEST);
		
		//create textfield for setting questions
		text.setFont(new Font("TimesRoman", Font.BOLD, 20));
		text.setForeground(Color.RED);
		text.setText("");
		add(text, BorderLayout.CENTER);
		
		//create text field for displaying num correct
		field.setFont(new Font("TimesRoman", Font.BOLD, 48));
		field.setForeground(Color.RED);
		field.setHorizontalAlignment(JTextField.CENTER);
		
		//create textfield for welcome
		welcome.setFont(new Font("TimesRoman", Font.BOLD, 16));
		welcome.setForeground(Color.BLUE);
		welcome.setHorizontalAlignment(JTextField.CENTER);
		welcome.setText("Welcome to CMU Testing Center!");
		add(welcome, BorderLayout.NORTH);
		
		JPanel subPanel = new JPanel();
		subPanel.add(start);
		subPanel.add(next);
		subPanel.add(submit);
		subPanel.add(field);
		add(subPanel, BorderLayout.SOUTH);
		
		
		
	}
	
	

	public JTextArea getText() {
		return text;
	}
	
	public JTextField getField() {
		return field;
	}
	
	public JRadioButton[] getRadioButtons() {
		return radioButtons;
	}
	
	/**
	 * Set labels of the radio buttons
	 * (to allow radio buttons be labeled at run time)
	 * @param labels The list of labels
	 */
	public void setRadioButtonLabels(List<String> labels) {
		for (int i = 0; i < labels.size(); i++)
			radioButtons[i].setText(labels.get(i));
	}
}
