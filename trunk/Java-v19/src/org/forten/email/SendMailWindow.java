package org.forten.email;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class SendMailWindow {

	protected Shell shell;
	private Text toText;
	private Text subjectText;
	private Text msgText;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SendMailWindow window = new SendMailWindow();
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
		shell.setSize(800, 600);
		shell.setText("SWT Application");
		
		Label label = new Label(shell, SWT.NONE);
		label.setAlignment(SWT.RIGHT);
		label.setBounds(10, 10, 61, 17);
		label.setText("收信人：");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setAlignment(SWT.RIGHT);
		label_1.setBounds(10, 45, 61, 17);
		label_1.setText("标题：");
		
		toText = new Text(shell, SWT.BORDER);
		toText.setBounds(77, 10, 697, 23);
		
		subjectText = new Text(shell, SWT.BORDER);
		subjectText.setBounds(77, 39, 697, 23);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setAlignment(SWT.RIGHT);
		label_2.setBounds(10, 68, 61, 17);
		label_2.setText("内容：");
		
		msgText = new Text(shell, SWT.BORDER | SWT.V_SCROLL);
		msgText.setBounds(35, 91, 739, 368);
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String subject = subjectText.getText();
				String msg = msgText.getText();
				String to = toText.getText();
				MailUtil.sendMail(subject, msg, to);
			}
		});
		button.setBounds(362, 498, 80, 27);
		button.setText("发送");

	}

}
