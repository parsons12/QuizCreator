import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class QuestionBank {
	static List<Question> list = new ArrayList<Question>();

	public QuestionBank(String fname) {
		try {
			File inf = new File(fname);
			Scanner fscan = new Scanner(inf);
			fscan.useDelimiter("[\t\r\n]+");

			while (fscan.hasNext()) {//scan through file and set variables
				int qnum = fscan.nextInt();
				String q = fscan.nextLine().replaceAll("\\t", " ");
				fscan.next();
				String a = fscan.nextLine().replaceAll("\\t", " ");
				fscan.next();
				String b = fscan.nextLine().replaceAll("\\t", " ");
				fscan.next();
				String c = fscan.nextLine().replaceAll("\\t", " ");
				fscan.next();
				String d = fscan.nextLine().replaceAll("\\t", " ");
				String answer = fscan.next();
				list.add(new Question(q, a, b, c, d, answer)); //add question 
			}
			fscan.close();
		} catch (IOException e) {//if file is not found
			System.out.printf("File %s not found.\n", fname);
		}
	}

	public static List<Question> getRandomPairs(int n) {//get random questions
		List<Question> questions = new ArrayList<Question>();
		Random rnd = new Random();
		int k, count = 0;
		while (count < n) {
			k = rnd.nextInt(list.size());
			questions.add(list.get(k));
			count++;
		}
		return questions;
	}
}
