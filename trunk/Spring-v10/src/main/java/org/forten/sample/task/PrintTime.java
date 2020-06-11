package org.forten.sample.task;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("printTime")
public class PrintTime {
	@Scheduled(cron="1/5 * * * * ?")
	public void print() {
		System.out.println(new Date());
	}

	@Scheduled(cron="3/5 * * * * ?")
	public void printLine() {
		System.out.println("============================");
	}
}
