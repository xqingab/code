import java.util.Arrays;

public class Question {
	private String quesText;
	private Option[] options;

	public Question() {
		super();
	}

	/*
	 * public Question(String quesText, Option[] options) { super();
	 * this.quesText = quesText; this.options = options; }
	 */

	// Option... options参数被称为可变长参数，是Java5以后引入的
	// options实际上就是一个Option类型对象的数组
	// 在调用方法时，如果方法中有可变长参数，则它对应的实际参数的个数可以是0到多个
	// 注意：一个方法中可以有多个形式参数，但在它们中只能有一个参数是可变长的，并且这个参数的位置一定在参数列表的最后
	public Question(String quesText, Option o1, Option o2, Option... options) {
		super();
		this.quesText = quesText;
		this.options = new Option[options.length + 2];
		this.options[0] = o1;
		this.options[1] = o2;
		for (int i = 0; i < options.length; i++) {
			this.options[i + 2] = options[i];
		}
	}

	public String getQuesText() {
		return quesText;
	}

	public void setQuesText(String quesText) {
		this.quesText = quesText;
	}

	public Option[] getOptions() {
		return options;
	}

	public void setOptions(Option[] options) {
		this.options = options;
	}

	@Override
	public String toString() {
		return "Question [quesText=" + quesText + ", options=" + Arrays.toString(options) + "]";
	}
}
