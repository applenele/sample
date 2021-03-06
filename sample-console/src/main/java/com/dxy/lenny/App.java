package com.dxy.lenny;

import com.dxy.lenny.model.User;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.collect.Maps;
import com.opencsv.CSVWriter;
import org.apache.commons.codec.digest.DigestUtils;
import org.hashids.Hashids;

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

//    String url = "https://www.dddd.com/asd?qdd=1212&asdd=22";
//
//    System.out.printf(String.valueOf(isValidUrl(url)));

    //System.out.println(System.currentTimeMillis());

    //sign();

    //getSignature();
//		long start = System.currentTimeMillis();
//		for (int i = 0; i < 10; i++) {
//			hashId();
//		}
//		long end = System.currentTimeMillis();
//		System.out.println("耗时：" + (end-start)/1000);

//		StackTraceElement[] stackTrace = new RuntimeException().getStackTrace();
//		for (StackTraceElement stackTraceElement : stackTrace) {
//			System.out.println(stackTraceElement.getMethodName());
//			if ("main".equals(stackTraceElement.getMethodName())) {
//				return Class.forName(stackTraceElement.getClassName());
//			}
    //}

    Gson gson = new Gson();
    User user = new User();
    user.setUsername("张收纳");

    System.out.println(gson.toJson(user));
  }


  /**
   * hashId https://github.com/10cella/hashids-java
   */
  public static void hashId() {
    Hashids hashids = new Hashids("this is my salt");
    String org = "dddddd1231313asdasdasdasdqsadasdasd";
    String hash = hashids.encodeHex(org);

    System.out.println(hash);

    String val = hashids.decodeHex(hash);

    if (val.equals(org)) {
      //System.out.println(true);
    } else {
      System.out.println("加解码失败");
    }
  }


  public static String getSignature() {
    TreeMap<String, String> params = Maps.newTreeMap();

    params.put("noncestr", "das2asqeqwe");
    params.put("timestamp", "1544603041");
    params.put("app_id", "bcde139b6f8a4109ba417b0fe9015d5f");
    params.put("app_secret", "20d6f35303cf4be6a59f0b66755df9be");

    StringBuilder signatureSbd = new StringBuilder();
    for (Map.Entry<String, String> entry : params.entrySet()) {
      signatureSbd.append(entry.getKey());
      signatureSbd.append("&");
      signatureSbd.append(entry.getValue());
    }

    String signature = DigestUtils.sha1Hex(signatureSbd.toString());

    System.out.printf(signature);

    return signature;
  }

  public static void sign() {
    TreeMap<String, String> params = Maps.newTreeMap();

    params.put("noncestr", "das2asqeqwe");
    params.put("timestamp", "1544603041");
    params.put("url", "/home/index");
    params.put("ticket", "f2b57d4457aa42cca220a7d91db4ff3b");

    StringBuilder signatureSbd = new StringBuilder();
    for (Map.Entry<String, String> entry : params.entrySet()) {
      signatureSbd.append(entry.getKey());
      signatureSbd.append("&");
      signatureSbd.append(entry.getValue());
    }

    String signature = DigestUtils.sha1Hex(signatureSbd.toString());

    System.out.println(signature);

    StackTraceElement[] stackTrace = new RuntimeException().getStackTrace();
    for (StackTraceElement stackTraceElement : stackTrace) {
      System.out.println(stackTraceElement.getMethodName());
//			if ("main".equals(stackTraceElement.getMethodName())) {
//				return Class.forName(stackTraceElement.getClassName());
//			}
    }
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
