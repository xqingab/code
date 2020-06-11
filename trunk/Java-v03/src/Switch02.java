/**
 * 输入月份
 * 
 * 2,3,4月为春季
 * 
 * 5,6,7月为夏季
 * 
 * 8,9,10月为秋季
 *
 * 11,12,1月为冬季
 */
public class Switch02 {
	public static void main(String[] args) {
		int month=2;
		// switch语句只能进行相等性判断
		// 在同一个switch语句中各case块后的字面量不能重复
		// 对于一系列的嵌套if语句，switch语句通常性能更好
		
		// switch语句后的圆括号里的变量是要被判断的条件值
		// 变量的类型必须是byte、short、int、char、枚举对象；从Java7以后，可以使用字符串类型
		// switch语句块中有1到多个case块，用于判定条件值等于什么的时候执行的逻辑
		// switch语句块中可以有0到1个default块，其中定义没有符合case中任何值的情况下执行的逻辑
		// 每个case块的最后，应该以一条break语句结束，否则会把第一个符合条件的case块及其后续的所有case块和default块执行一次
		// 如果在连续多个case块中没有break语句，可以合并它们为一类条件
		switch (month) {
		case 2:
		case 3:
		case 4:
			System.out.println("春季");
			break;
		case 5:
		case 6:
		case 7:
			System.out.println("夏季");
			break;
		case 8:
		case 9:
		case 10:
			System.out.println("秋季");
			break;
		case 11:
		case 12:
		case 1:
			System.out.println("冬季");
			break;
		default:
			System.out.println("请输入正确的月份");
			break;
		}
	}
}
