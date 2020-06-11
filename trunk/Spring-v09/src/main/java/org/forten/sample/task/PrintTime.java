package org.forten.sample.task;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("printTime")
public class PrintTime {
	public void print() {
		System.out.println(new Date());
	}

	public void printLine() {
		System.out.println("============================");
	}
}
