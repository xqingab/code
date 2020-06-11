package org.forten.sample.emp;

// 继承结构的声明：
// public class 子类 extends 父类{}
// 类只能有一个父类，可以有多个子类
public class Manager extends Employee {
	private int bonus;

	// 父类的构造方法是不能被继承的，只能被子类的构造方法调用
	// 在构造方法中使用super(...)是调用父类中的某个与参数列表相匹配的构造方法
	// 在构造方法中使用this(...)是调用本类中的某个与参数列表相匹配的构造方法
	// 无论是super(...)还是this(...)都必须出现在构造方法体的首行
	// 所以super(...)和this(...)不可能同时出现在一个构造方法中
	public Manager() {
		// 使用super()调用了父类的无参构造方法
		// 在构造方法中如果没有显式的调用父类的某个构造方法
		// Java也会自动的调用默认的构造方法或无参构造方法
		super();
		System.out.println("Manager()");
	}

	public Manager(String name, int salary) {
		// 使用super(name,salary)调用了父类的两个参数的构造方法
		super(name, salary);
		System.out.println("Manager(String name, int salary)");
	}

	public Manager(String name, int salary, int bonus) {
		// 调用本类中两个参数的构造方法
		this(name, salary);
		this.bonus = bonus;
		System.out.println("Manager(String name, int salary, int bonus)");
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	// 在具体的子类中写一个方法签名与父类中某个方法签名完全一致的方法，这种做法被称为方法的覆盖（覆写、重写）
	// 目的：把比较一般的行为深化为更加特殊的子类特有的行为
	public void work() {
		System.out.println("出主意。。。");
	}

	public int getFinalSalary() {
		return salary + bonus;
	}

	@Override
	public String toString() {
		return "经理 [分红：" + bonus + ", 姓名：" + name + ", 工资：" + salary + "]";
	}
}