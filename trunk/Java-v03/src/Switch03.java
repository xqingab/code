/**
 * 输入一个年份和一个月份
 * 
 * 判断这个月份有多少天
 */
public class Switch03 {
	public static void main(String[] args) {
		int month = 2;
		int year = 2001;
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println(month + "月有31天");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println(month + "月有30天");
			break;
		case 2:
			if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
				System.out.println(year + "年" + month + "月有29天");
			} else {
				System.out.println(year + "年" + month + "月有28天");
			}
			break;
		default:
			System.out.println("请输入正确的月份");
			break;
		}
	}
}
