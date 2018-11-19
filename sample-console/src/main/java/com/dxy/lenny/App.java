package com.dxy.lenny;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opencsv.CSVWriter;

/**
 * Hello world!
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

//    try (FileWriter writer = new FileWriter("/Users/niele/workplaces/temp/dddd.csv", true);
//        CSVWriter csvWriter = new CSVWriter(writer)) {
//      writer.write('\uFEFF');
//
//      String[] arr = new String[]{"1231231231231231231231", "demo"};
//      csvWriter.writeNext(arr);
//    } catch (IOException e) {
//    }

    String url = "https://www.dddd.com/asd?qdd=1212&asdd=22";

    System.out.printf(String.valueOf(isValidUrl(url)));
  }


  public static boolean isValidUrl(String urlString) {
    URI uri = null;
    try {
      uri = new URI(urlString);
    } catch (URISyntaxException e) {
      e.printStackTrace();
      return false;
    }

    if (uri.getHost() == null) {
      return false;
    }
    if (uri.getScheme().equalsIgnoreCase("http") || uri.getScheme().equalsIgnoreCase("https")) {
      return true;
    }
    return false;
  }

}
