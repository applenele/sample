package com.dxy.lenny;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args){

        Pattern p = Pattern.compile("java");
        Matcher m = p.matcher("java java java");
        StringBuffer sb = new StringBuffer();
        if(m.find()){
            m.appendReplacement(sb,"python");
        }
        System.out.println(sb);

        if(m.find()){
            m.appendReplacement(sb,"python");
        }
        System.out.println(sb);

        if(m.find()){
            m.appendReplacement(sb,"python");
        }
        System.out.println(sb);

        System.out.println(m.replaceAll("c++"));
    }
}
