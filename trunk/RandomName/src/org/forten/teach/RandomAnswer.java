/*
 * Copyright 2001-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.forten.teach;

import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

/**
 * 随机回答问题程序
 * 
 * @author <a href="mailto:du_yi@bbn.cn">Duyi</a>
 * @since 2014年3月16日
 */
public class RandomAnswer {

	protected Shell shell;
	private Label label;
	private Button btn;
	private Random r = new Random();
	private int time = 50;
	private String[] names = { "陈镇生", "马磊", "郭锐", "裴清悦", "蓝瑞永", "莫林南", "王阳阳", "黄金宝", "满孝琦", "刘灿", "徐庆", "高森", "孟丰凯",
			"龚文华", "李玮", "高展", "杨震", "张兴江", "李志强", "申刚", "管毅", "李启鑫", "朱越云", "郑全满" };

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			RandomAnswer window = new RandomAnswer();
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
		shell.setSize(450, 300);
		shell.setText("被选中者赏题一道");

		label = new Label(shell, SWT.CENTER);
		label.setForeground(SWTResourceManager.getColor(70, 130, 180));
		label.setFont(SWTResourceManager.getFont("微软雅黑", 50, SWT.NORMAL));
		label.setBounds(35, 52, 363, 96);
		label.setText("准备开始");

		btn = new Button(shell, SWT.NONE);
		btn.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.NORMAL));
		btn.setBounds(134, 187, 166, 41);
		btn.setText("Start");
		btn.addSelectionListener(new SelectionAdapter() {
			Timer timer = new Timer();
			TimerTask tt = null;

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (btn.getText().equals("Start")) {
					tt = new TimerTask() {
						@Override
						public void run() {
							Display.getDefault().syncExec(new Runnable() {
								@Override
								public void run() {
									label.setText(names[r.nextInt(names.length)]);
								}
							});
						}
					};
					timer.schedule(tt, new Date(), time);
					btn.setText("看看这次轮到谁");
				} else {
					tt.cancel();
					btn.setText("Start");
				}
			}
		});
	}
}
