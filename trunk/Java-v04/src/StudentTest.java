
public class StudentTest {
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setName("Tom");
		s1.setAge(20);
		s1.setGender("M");
		s1.setTel("1938293892");
		s1.setScore(580);
		// 在向控制台输出某个对象时，会调用它的toString方法，如果在对象的类中没有定义此方法，则会调用其父类的toString方法
		// toString方法的功能是把对象变为一个可读的字符串
		System.out.println(s1);
		
		Student s2 = new Student();
		s2.setName("Tom");
		s2.setAge(20);
		s2.setGender("M");
		s2.setTel("1938293892");
		s2.setScore(580);
		
		// 使用==操作符来判断两个对象引用是否指向同一个对象实例的内存地址
		// 并不是比较两个对象引用所指向的对象实例内容是否相同
		System.out.println(s1==s2);
		
		// equals()方法是Object类中定义的用于比较两个对象是否相等的方法
		// 默认逻辑是判断两个对象的引用是否指向同一个对象实例（就是this==that）
		// 如果要实现自定义的判等逻辑，需要在自定义的类中编写equals()方法来覆盖Object类中定义的此方法
		System.out.println(s1.equals(s2));
	}
}
