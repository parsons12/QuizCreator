
public class Main {

	public static void main(String[] args) {
		QuestionBank q = new QuestionBank("src/QuestionBank.txt");//file to read from
		Frame view = new Frame("Test in Progress..."); //create frame
		new Handler(view, q);//create handler
		view.setVisible(true);

	}
}
