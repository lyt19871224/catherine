package com.qunar.fresh.yutingliu;

/**
 * The Integer implementation of the interface LineProcessor.
 * 
 * @version 2013/10/27.
 * @author catherine.liu
 *
 */
public class LineProcessorImpl implements LineProcessor<Integer> {
	int count = 0;
	@Override
	public void process(String lineInfo) {
		lineInfo = lineInfo.trim();
		
		if(!(lineInfo.isEmpty() || lineInfo.startsWith("//") || ( lineInfo.startsWith("/*") && lineInfo.endsWith("*/")))){
			++count;
		}
		
	}

	@Override
	public Integer fetchResult() {
		return count;
	}
}
