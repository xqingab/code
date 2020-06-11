package org.forten.sample.demo1;

public interface Attackable {
	default void attack(){
		System.out.println("Fire...");
	}
}
