package org.forten.code.ui;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.io.FileUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.forten.code.builder.AppCoreBuilder;
import org.forten.code.builder.DbBuilder;
import org.forten.code.builder.HibernateDaoBuilder;
import org.forten.code.builder.Log4jBuilder;
import org.forten.code.builder.LoginActionBuilder;
import org.forten.code.builder.LoginBoBuilder;
import org.forten.code.builder.PageLoginBuilder;
import org.forten.code.builder.UserVoForLoginBuilder;
import org.forten.code.builder.WebXmlBuilder;
import org.forten.code.model.Const;
import org.forten.code.model.ContextConfig;
import org.forten.utils.io.SerializationUtil;

import freemarker.template.TemplateException;

public class ConfigWindow {
	public static ContextConfig context;
	protected Shell shell;
	private Text workspaceText;
	private Text projectNameText;
	private Text basePackageText;
	private Text jdbcDriverClassText;
	private Text jdbcUrlText;
	private Text jdbcUsernameText;
	private Text jdbcPasswordText;
	private Text templatePathText;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ConfigWindow window = new ConfigWindow();
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
		shell.setSize(600, 480);
		shell.setText("系统参数配置");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setAlignment(SWT.RIGHT);
		lblNewLabel.setBounds(104, 82, 61, 17);
		lblNewLabel.setText("工作空间：");
		
		Label label = new Label(shell, SWT.NONE);
		label.setAlignment(SWT.RIGHT);
		label.setText("项目名称：");
		label.setBounds(104, 111, 61, 17);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setAlignment(SWT.RIGHT);
		label_1.setText("基础包名：");
		label_1.setBounds(104, 141, 61, 17);
		
		Label lblJdbc = new Label(shell, SWT.NONE);
		lblJdbc.setAlignment(SWT.RIGHT);
		lblJdbc.setText("JDBC驱动类：");
		lblJdbc.setBounds(79, 170, 86, 17);
		
		Label lblJdbcUrl = new Label(shell, SWT.NONE);
		lblJdbcUrl.setAlignment(SWT.RIGHT);
		lblJdbcUrl.setText("JDBC URL：");
		lblJdbcUrl.setBounds(89, 199, 76, 17);
		
		Label lblJdbc_1 = new Label(shell, SWT.NONE);
		lblJdbc_1.setAlignment(SWT.RIGHT);
		lblJdbc_1.setText("JDBC用户名：");
		lblJdbc_1.setBounds(79, 228, 86, 17);
		
		Label lblJdbc_2 = new Label(shell, SWT.NONE);
		lblJdbc_2.setAlignment(SWT.RIGHT);
		lblJdbc_2.setText("JDBC密码：");
		lblJdbc_2.setBounds(79, 257, 86, 17);
		
		workspaceText = new Text(shell, SWT.BORDER);
		workspaceText.setBounds(171, 79, 253, 23);
		
		projectNameText = new Text(shell, SWT.BORDER);
		projectNameText.setBounds(171, 108, 253, 23);
		
		basePackageText = new Text(shell, SWT.BORDER);
		basePackageText.setBounds(171, 138, 253, 23);
		
		jdbcDriverClassText = new Text(shell, SWT.BORDER);
		jdbcDriverClassText.setBounds(171, 167, 253, 23);
		
		jdbcUrlText = new Text(shell, SWT.BORDER);
		jdbcUrlText.setBounds(171, 196, 253, 23);
		
		jdbcUsernameText = new Text(shell, SWT.BORDER);
		jdbcUsernameText.setBounds(171, 225, 253, 23);
		
		jdbcPasswordText = new Text(shell, SWT.BORDER);
		jdbcPasswordText.setBounds(171, 254, 253, 23);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				DirectoryDialog dd = new DirectoryDialog(shell);
				String workspace = dd.open();
				workspace = workspace.replace("\\", "/");
				workspaceText.setText(workspace);
			}
		});
		btnNewButton.setBounds(430, 77, 80, 27);
		btnNewButton.setText("浏览...");
		
		Button saveConfigBtn = new Button(shell, SWT.NONE);
		saveConfigBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fd = new FileDialog(shell);
				String configFilePath = fd.open();
				
				String workspace = workspaceText.getText();
				String projectName = projectNameText.getText();
				String basePackageName = basePackageText.getText();
				String jdbcDriverClass = jdbcDriverClassText.getText();
				String jdbcUrl = jdbcUrlText.getText();
				String jdbcUsername = jdbcUsernameText.getText();
				String jdbcPassword = jdbcPasswordText.getText();
				String templatePath = templatePathText.getText();
				
				context = new ContextConfig(workspace, projectName, basePackageName, jdbcDriverClass, jdbcUrl, jdbcUsername, jdbcPassword,templatePath);
				Const.context = context;
				byte[] bytes = SerializationUtil.serialize(context);
				try {
					FileUtils.writeByteArrayToFile(new File(configFilePath), bytes);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					WebXmlBuilder.buildFile();
					AppCoreBuilder.buildFile();
					DbBuilder.buildFile();
					HibernateDaoBuilder.buildFile();
					Log4jBuilder.buildFile();
					LoginActionBuilder.buildFile();
					LoginBoBuilder.buildFile();
					PageLoginBuilder.buildFile();
					UserVoForLoginBuilder.buildFile();
				} catch (IOException | TemplateException | SQLException e1) {
					e1.printStackTrace();
				}
				MessageBox msgBox = new MessageBox(shell);
				msgBox.setMessage("配置保存成功");
				msgBox.setText("信息");
				msgBox.open();
			}
		});
		saveConfigBtn.setBounds(157, 336, 80, 27);
		saveConfigBtn.setText("保存");
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fd = new FileDialog(shell);
				String configFilePath = fd.open();
				byte[] bytes = null;
				try {
					bytes = FileUtils.readFileToByteArray(new File(configFilePath));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				context = SerializationUtil.deserialize(bytes);
				workspaceText.setText(context.getWorkspace());
				basePackageText.setText(context.getBasePackageName());
				jdbcDriverClassText.setText(context.getJdbcDriverClass());
				jdbcPasswordText.setText(context.getJdbcPassword());
				jdbcUrlText.setText(context.getJdbcUrl());
				jdbcUsernameText.setText(context.getJdbcUsername());
				projectNameText.setText(context.getProjectName());
				templatePathText.setText(context.getTemplatePath());
				
				Const.context = context;
			}
		});
		button.setBounds(344, 336, 80, 27);
		button.setText("载入");
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setText("模板路径：");
		label_2.setAlignment(SWT.RIGHT);
		label_2.setBounds(79, 287, 86, 17);
		
		templatePathText = new Text(shell, SWT.BORDER);
		templatePathText.setBounds(171, 281, 253, 23);
		
		Button templatePathBtn = new Button(shell, SWT.NONE);
		templatePathBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				DirectoryDialog dd = new DirectoryDialog(shell);
				String templatePath = dd.open();
				templatePath = templatePath.replace("\\", "/");
				templatePathText.setText(templatePath);
			}
		});
		templatePathBtn.setText("浏览...");
		templatePathBtn.setBounds(430, 277, 80, 27);

	}
}
