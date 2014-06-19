package com.qunar.fresh.yutingliu;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

/**
 * static the effective number of lines  in java code.
 * 
 * @version 2013/10/27
 * @author catherine.liu
 *
 */
public class StaticLines {
	
	/* fileName */
	private static final String FILENAME_TESTDATA = "src/com/qunar/fresh/yutingliu/TestData.java";
	
	/*code format*/
	private static final String CODE_FORMAT = "utf-8";
	
	/**
	 * read lines from the file and process them.
	 * @param file
	 * @param charset
	 * @param process
	 * @throws IOException
	 */
	public static <T> void readFile(File file,String charset,LineProcessor<T> process) throws IOException{
		BufferedReader reader = null;
		try
		{
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String lineInfo = "";
			while((lineInfo = reader.readLine())!=null)
			{
				process.process(lineInfo);//这段是变化的东西.抽象出来.
			}
			
			System.out.println("代码有效行数："+process.fetchResult());
		}
		finally
		{
			closeQuitely(reader);
		}
	}
	
	/**
	 * close reader.
	 * @param closeable
	 */
	public static void closeQuitely(Closeable closeable){
		if(closeable!=null) {
			try {
				closeable.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		closeable = null; //remember point to null.
	}
	
	/**
	 * main function.
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		LineProcessor<Integer> lineProcessorInteger = new LineProcessorImpl();
		readFile(new File(FILENAME_TESTDATA),CODE_FORMAT,lineProcessorInteger);
	}
	
	



}
