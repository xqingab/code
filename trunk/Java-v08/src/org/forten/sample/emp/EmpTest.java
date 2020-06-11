package org.forten.sample.emp;

public class EmpTest {

	public static void main(String[] args) {
		// 使用较抽象的类型声明对象的引用，而分配给它的对象是较具体的类型对象，是向上转型
		// 是很自然的转型，是安全的
		// 这种声明方式被称为面向抽象的编程风格，优点，减少相互影响（低耦合）
		Employee m1 = new Manager("刘备", 3000, 1000000);
		Employee c1 = new Coder("赵云", 8999, 15);

		// 使用较具体的类型进行声明，而分配给它的对象是较抽象的类型对象，这是向下转型
		// 不安全，如果一定要这么做，则需要强制转型
		// Coder c2 = new Employee("aaa", 50);

		System.out.println(m1);
		System.out.println(c1);

		// 因为在Manager类中覆盖了work()方法，所以在使用Manager对象时，调用的是它自己的work()方法
		m1.work();
		// 因为在Coder类中没有覆盖work()方法，所以在使用Coder对象时，调用的是它父类的（即Employee）work()方法
		c1.work();

		System.out.println(m1.getFinalSalary());
		System.out.println(c1.getFinalSalary());
		
		// 当使用父类声明一个引用变量，而对象是其子类的实例时，子类中的特有实例变量和方法不会直接被访问到
		// 只能使用父类中已有的程序成员
		// 如果在特殊场景下，必须使用子类实例的特有方法或实例变量，则需要对引用变量进行强制转型
		System.out.println(c1.getName()+"的基本工资是"+((Coder)c1).getBaseSalary());
		
		// 看看构造方法的执行顺序
		Employee m2 = new Manager();
	}

}
