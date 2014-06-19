package com.qunar.fresh.yutingliu;

/**
 * process per line in the java file.
 * 
 * @version 2013/10/27.
 * @author catherine.liu
 *
 * @param <T>
 */
public interface LineProcessor<T> {
	void process(String line);
	T fetchResult();
}
