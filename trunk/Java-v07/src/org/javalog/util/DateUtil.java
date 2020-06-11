// 使用package关键字来声明类所在的包（命名空间）
// 包名建议使用全小写形式，不同部分使用点号分隔，每部分会生成一级目录
// 包名中的各部分不能单独使用java、javax、sun、oracle等单词
// 这是为了安全性考虑的，可以防止用户恶意篡改Java官方的API类库
// 如果单独使用了这个单词作为包名的个部分，在运行时会得到 java.lang.SecurityException
package org.javalog.util;

public class DateUtil {
	public void printDate(){
		System.out.println("org.javalog.util.Date");
	}
}
