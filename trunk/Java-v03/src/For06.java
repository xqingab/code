/**
 * for一些不常用的语法
 */
public class For06 {
	public static void main(String[] args) {
		// 等同于while(true)
		// for后圆括号中的各部分可以省略
		for(;;){
			break;
		}
		
		// 如果在for之前就有一个变量可以作为计数器使用，则可以在for语句中省略第一部分
		int i = 0;
		for(;i<10;i++){
			System.out.println(i);
		}
		
		i=0;
		for(;;i++){
			System.out.println(i);
			if(i==5){
				break;
			}
		}
		
		i=0;
		for(;;){
			System.out.println(i);
			i++;
			if(i==5){
				break;
			}
		}
		
		// 在for循环的第一部分和第三部分可以定义多个变量的声明和改变，多条语句用逗号分隔
		for(int x=0,y = 20;x<y;x++,y--){
			System.out.println(x+","+y);
		}
		
		// 利用控制语句来定义中断循环后或重新开始下次循环后的目标位置，利用Java中的代码标签实现
		// 严禁使用
		a: for(int x = 0;x<10;x++){
			System.out.println("a");
			b:for(int y = 0;y<10;y++){
				System.out.println("b");
				c:for(int z = 0;z<10;z++){
					System.out.println("c");
					if(z==5){
						continue a;
					}
				}
			}
		}
			
	}
}
