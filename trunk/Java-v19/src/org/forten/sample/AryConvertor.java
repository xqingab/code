package org.forten.sample;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class AryConvertor {

	protected Shell shell;
	private Text numText;
	private Label resultLabel;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AryConvertor window = new AryConvertor();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 210);
		shell.setText("进制转换");

		numText = new Text(shell, SWT.BORDER);
		numText.setBounds(26, 21, 168, 23);

		resultLabel = new Label(shell, SWT.NONE);
		resultLabel.setBounds(10, 66, 414, 17);

		Button btnary = new Button(shell, SWT.NONE);
		btnary.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setResult(2);
			}
		});
		btnary.setBounds(26, 105, 80, 27);
		btnary.setText("2-Ary");

		Button btnary_1 = new Button(shell, SWT.NONE);
		btnary_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setResult(8);
			}

		});
		btnary_1.setBounds(132, 105, 80, 27);
		btnary_1.setText("8-Ary");

		Button btnary_2 = new Button(shell, SWT.NONE);
		btnary_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setResult(16);
			}
		});
		btnary_2.setBounds(238, 105, 80, 27);
		btnary_2.setText("16-Ary");

		Button btnary_3 = new Button(shell, SWT.NONE);
		btnary_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setResult(5);
			}
		});
		btnary_3.setBounds(344, 105, 80, 27);
		btnary_3.setText("5-Ary");

	}

	private void setResult(int ary) {
		String numStr = numText.getText();
		try {
			int num = Integer.parseInt(numStr);
			String result = Integer.toString(num, ary);
			resultLabel.setText(result);
		} catch (NumberFormatException ex) {
			resultLabel.setText("请输入有效数字");
		}
	}
}
