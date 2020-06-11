package org.forten.sample;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class AddTest {

	protected Shell shell;
	private Text aText;
	private Text bText;
	private Label resultLabel;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AddTest window = new AddTest();
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
		shell.setSize(450, 200);
		shell.setText("SWT Application");
		resultLabel = new Label(shell, SWT.NONE);
		resultLabel.setFont(SWTResourceManager.getFont("微软雅黑", 16, SWT.BOLD));
		resultLabel.setBounds(197, 96, 168, 35);

		aText = new Text(shell, SWT.BORDER);
		aText.setBounds(10, 24, 73, 23);

		Label label = new Label(shell, SWT.NONE);
		label.setBounds(98, 27, 14, 17);
		label.setText("+");

		bText = new Text(shell, SWT.BORDER);
		bText.setBounds(118, 24, 73, 23);

		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String aStr = aText.getText();
				String bStr = bText.getText();
				try {
					double a = Double.parseDouble(aStr);
					double b = Double.parseDouble(bStr);
					resultLabel.setText((a + b) + "");
				} catch (NumberFormatException ex) {
					resultLabel.setText("请输入正确的数字格式");
				}
			}
		});
		btnNewButton.setBounds(207, 22, 45, 27);
		btnNewButton.setText("=");

	}
}
