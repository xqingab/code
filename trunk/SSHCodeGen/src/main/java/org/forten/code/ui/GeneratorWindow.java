package org.forten.code.ui;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.io.FileUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.forten.code.builder.ActionBuilder;
import org.forten.code.builder.BoBuilder;
import org.forten.code.builder.EntityBuilder;
import org.forten.code.builder.PageListAllBuilder;
import org.forten.code.builder.PageSaveBuilder;
import org.forten.code.builder.PageUpdateBuilder;
import org.forten.code.builder.VoBuilder;
import org.forten.code.model.Const;
import org.forten.code.model.ContextConfig;
import org.forten.utils.io.SerializationUtil;

import freemarker.template.TemplateException;

public class GeneratorWindow {

	protected Shell shell;
	private Text tableNameText;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			GeneratorWindow window = new GeneratorWindow();
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
		
		FileDialog fd = new FileDialog(shell);
		String configFilePath = fd.open();
		byte[] bytes = null;
		try {
			bytes = FileUtils.readFileToByteArray(new File(configFilePath));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		ContextConfig context = SerializationUtil.deserialize(bytes);
		Const.context = context;
		
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
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		tableNameText = new Text(shell, SWT.BORDER);
		tableNameText.setBounds(166, 86, 175, 23);
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(113, 89, 36, 17);
		label.setText("表名：");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					String tableName= tableNameText.getText();
					EntityBuilder.buildFile(tableName);
					VoBuilder.buildFile(tableName);
					BoBuilder.buildFile(tableName);
					ActionBuilder.buildFile(tableName);
					PageSaveBuilder.buildFile(tableName);
					PageUpdateBuilder.buildFile(tableName);
					PageListAllBuilder.buildFile(tableName);
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (TemplateException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(166, 170, 80, 27);
		btnNewButton.setText("生成");

	}
}
