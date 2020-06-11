package org.forten.sample.sp;

public class RunnerProxy implements CanRun {
	private Runner runner;

	public RunnerProxy(Runner runner) {
		super();
		this.runner = runner;
	}

	public String beforeLog(){
		return runner.getName()+"在起跑点上准备比赛...";
	}
	
	public String afterLog(){
		return runner.getName()+"完成了比赛...";
	}
	
	@Override
	public void run() {
		System.out.println(beforeLog());
		long begin = System.currentTimeMillis();
		runner.run();
		long end = System.currentTimeMillis();
		System.out.println(runner.getName() + "用时" + ((end - begin) / 1000.0) + "秒到达终点。");
		System.out.println(afterLog());
	}

}
