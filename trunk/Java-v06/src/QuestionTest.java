
public class QuestionTest {

	public static void main(String[] args) {
		Option o1 = new Option("1a", false);
		Option o2 = new Option("1b", false);
		Option o3 = new Option("1c", true);
		Option o4 = new Option("1d", false);
		Option o5 = new Option("1e", false);

		Question q1 = new Question("Question 1", o1, o2, o3, o4, o5);
		System.out.println(q1);

		Option o21 = new Option("2a", false);
		Option o22 = new Option("2b", true);

		Question q2 = new Question("Question 2", o21, o22);
		System.out.println(q2);
	}

}
