package org.forten.sample.test;

import java.util.HashMap;
import java.util.Map;

public class Test03 {

	public static void main(String[] args) {
		Word w1 = new Word("apple", "苹果", "水果","IT公司");
		Word w2 = new Word("Windows","视窗","房屋墙上的窟窿","微软的OS");
		
		Map<String, Word> dic = new HashMap<>();
		dic.put(w1.getEng(), w1);
		dic.put(w2.getEng(), w2);
		
		for (Word w : dic.values()) {
			System.out.println(w);
		}
		
		Word noWord = dic.getOrDefault("some", new Word("Error: no word","错误：没有这个单词"));
		System.out.println(noWord);
	}

}
