package org.forten.editor;

import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.forten.sample.util.FileUtil;

public class TextEditor {

	protected Shell shell;
	private Text contentText;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TextEditor window = new TextEditor();
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
		shell.setSize(450, 600);
		shell.setText("SWT Application");

		Label filenameLabel = new Label(shell, SWT.NONE);
		filenameLabel.setBounds(10, 10, 414, 17);
		filenameLabel.setText("未打开任何文件");

		contentText = new Text(shell, SWT.BORDER | SWT.V_SCROLL);
		contentText.setBounds(10, 33, 414, 425);

		Button btnSave = new Button(shell, SWT.NONE);
		btnSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String content = contentText.getText();
				String filepath = filenameLabel.getText();
				File file = null;

				// 保存新建文件进行if块，保存编辑文件进行else块
				if (filepath.equals("未打开任何文件")) {
					FileDialog fd = new FileDialog(shell);
					fd.setFilterPath("c:/");
					fd.setFilterExtensions(new String[] { "*.txt" });
					filepath = fd.open() + ".txt";
					file = new File(filepath);
					FileUtil.writeFile(file, content);
					filenameLabel.setText(filepath);
				} else {
					file = new File(filepath);
					FileUtil.writeFile(file, content);
				}
			}
		});
		btnSave.setBounds(52, 493, 80, 27);
		btnSave.setText("Save");

		Button btnSaveAs = new Button(shell, SWT.NONE);
		btnSaveAs.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String content = contentText.getText();
				FileDialog fd = new FileDialog(shell);
				fd.setFilterPath("c:/");
				fd.setFilterExtensions(new String[] { "*.txt" });
				String filepath = fd.open() + ".txt";

				if (filepath != null) {
					File file = new File(filepath);
					filenameLabel.setText(filepath);
					FileUtil.writeFile(file, content);
				}
			}
		});
		btnSaveAs.setBounds(184, 493, 80, 27);
		btnSaveAs.setText("Save As...");

		Button btnOpen = new Button(shell, SWT.NONE);
		btnOpen.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fd = new FileDialog(shell);
				fd.setFilterPath("c:/");
				String filepath = fd.open();
				if (filepath != null) {
					File file = new File(filepath);
					String content = FileUtil.readFile(file);
					contentText.setText(content);
					filenameLabel.setText(filepath);
				}
			}
		});
		btnOpen.setBounds(316, 493, 80, 27);
		btnOpen.setText("Open");

	}
}
