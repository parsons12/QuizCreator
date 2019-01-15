
public class Question {
	String question, a, b, c, d, answer;
	//constructor for question
	public Question(String q, String A, String B, String C, String D, String ans) {
		question = q;
		a = A;
		b = B;
		c = C;
		d = D;
		answer = ans;
	}
	public String getQuestion() {
		return question;
	}
	public String getOptionA() {
		return a;
	}
	public String getOptionB() {
		return b;
	}
	public String getOptionC() {
		return c;
	}
	public String getOptionD() {
		return d;
	}
	public String getCorrectAnswer() {
		return answer;
	}
	public String toString() {
		return question + " a." + a + " b." + b + " c." + c+ " d." + d;
	
	}
	public String prettyPrint() {//for displaying incorrect questions to user
		return question + "\na)" + a + "\nb)" + b + "\nc)" + c + "\nd)" + d + "\nCorrect Answer: " + answer + "\n";
	}
}
