/**
 * 判断一个年份是否是闰年
 *
 * 如果一个数字可以被400整除则是闰年
 * 
 * 或者
 * 
 * 如果一个数字可以被4整除，但不能被100整除则是闰年
 */
public class If03 {
	public static void main(String[] args) {
		int year = 1900;
		if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
			System.out.println(year+"年是闰年。");
		}else{
			System.out.println(year+"年不是闰年。");
		}
	}
}
