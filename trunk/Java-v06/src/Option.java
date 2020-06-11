
public class Option {
	private String optText;
	private boolean flag;

	public Option() {
		super();
		this.flag = false;
	}

	public Option(String optText, boolean flag) {
		super();
		this.optText = optText;
		this.flag = flag;
	}

	public String getOptText() {
		return optText;
	}

	public void setOptText(String optText) {
		this.optText = optText;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Option [optText=" + optText + ", flag=" + flag + "]";
	}
}
