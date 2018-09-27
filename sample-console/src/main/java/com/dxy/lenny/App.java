package com.dxy.lenny;

import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opencsv.CSVWriter;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

//        Pattern p = Pattern.compile("java");
//        Matcher m = p.matcher("java java java");
//        StringBuffer sb = new StringBuffer();
//        if(m.find()){
//            m.appendReplacement(sb,"python");
//        }
//        System.out.println(sb);
//
//        if(m.find()){
//            m.appendReplacement(sb,"python");
//        }
//        System.out.println(sb);
//
//        if(m.find()){
//            m.appendReplacement(sb,"python");
//        }
//        System.out.println(sb);
//
//        System.out.println(m.replaceAll("c++"));

		try (FileWriter writer = new FileWriter("/Users/niele/workplaces/temp/dddd.csv", true);
		     CSVWriter csvWriter = new CSVWriter(writer)) {
			writer.write('\uFEFF');

			String[] arr = new String[]{"1231231231231231231231","demo"};
			csvWriter.writeNext(arr);
		}
		catch (IOException e) {
		}
	}
}
