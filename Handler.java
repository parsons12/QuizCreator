import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Handler {

	// create variables
	Frame view;
	QuestionBank questions;
	List<Question> words;
	JTextArea text;
	JTextField field;
	JRadioButton[] rbuttons;
	JButton start;
	JButton next;
	JButton submit;
	int i = 0;
	int numCorrect = 0;
	int numQuestions = 5;
	String userAnswer;
	List<Question> wrong = new LinkedList<Question>();

	/**
	 * Constructor -- set reference to the give view (frame) and model (dictionary)
	 * 
	 * @param view The view
	 * @param dict The model
	 */
	public Handler(Frame view, QuestionBank q) {
		this.view = view;
		questions = q;
		text = view.getText();
		field = view.getField();
		rbuttons = view.getRadioButtons();
		next = view.next;
		submit = view.submit;
		start = view.start;

		setRadioButtonLabels();
		setNumQuestions(numQuestions);
		submit.setEnabled(false);
		next.setEnabled(false);

		// add event to start button
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i = setTextWithQuestion(i);
				start.setEnabled(false);// disable start button after clicked
				next.setEnabled(true);// enable next button after clicked
			}
		});

		// add event to next button
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JRadioButton rb : rbuttons) {
					if (rb.isSelected()) {// find selected radio button
						userAnswer = rb.getLabel();
						Question q = words.get(i - 1);
						String question = q.toString();
						rb.setSelected(false);
						if (wordsMatch(userAnswer, question))// check if correct
							numCorrect++;// increment number of correct answers
						else {
							wrong.add(q);// add wrong answers to list
						}
						if (i == numQuestions) {// if all questions are done
							next.setEnabled(false);// disable next button
							submit.setEnabled(true);// enable submit button
							field.setText("Test over, Please submit");// instruct user to submit
						} else {
							i = setTextWithQuestion(i);//set text with question
						}

					}
				}

			}
		});
		//create event for submit button
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				field.setText(Integer.toString(numCorrect) + "/" + Integer.toString(numQuestions));
				for (Question q : wrong) {

					JOptionPane.showMessageDialog(null, q.prettyPrint() + "Your answer: " + userAnswer);//display incorrect questions
				}
			}
		});
	}

	private void setRadioButtonLabels() {

		List<String> options = new ArrayList<String>();

		options.add("a");
		options.add("b");
		options.add("c");
		options.add("d");

		view.setRadioButtonLabels(options);
	}

	private void setNumQuestions(int n) {//set number of questions
		words = QuestionBank.getRandomPairs(n);
	}

	private int setTextWithQuestion(int i) {//put question into textfield

		Question q = words.get(i);
		text.setText(q.getQuestion() + "\n(a) " + q.getOptionA() + "\n(b) " + q.getOptionB() + "\n(c) " + q.getOptionC()
				+ "\n(d) " + q.getOptionD());

		return i + 1;

	}

	private boolean wordsMatch(String userAnswer, String question) {//to check if user is correct
		for (int i = 0; i < words.size(); i++) {
			Question p = words.get(i);
			if (p.toString().equals(question))
				return p.getCorrectAnswer().equals(userAnswer);
		}
		return false;
	}

}
