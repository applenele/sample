package com.dxy.lenny;

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
		sign();

//		long start = System.currentTimeMillis();
//		for (int i = 0; i < 10; i++) {
//			hashId();
//		}
//		long end = System.currentTimeMillis();
//		System.out.println("耗时：" + (end-start)/1000);
	}

	/**
	 * hashId
	 * https://github.com/10cella/hashids-java
	 */
	public static void hashId() {
		Hashids hashids = new Hashids("this is my salt");
		String org = "dddddd1231313asdasdasdasdqsadasdasd";
		String hash = hashids.encodeHex(org);

		System.out.println(hash);

		String val = hashids.decodeHex(hash);

		if (val.equals(org)) {
			//System.out.println(true);
		}
		else {
			System.out.println("加解码失败");
		}
	}


	public static void sign() {
		TreeMap<String, String> params = Maps.newTreeMap();

		params.put("noncestr", "das2asqeqwe");
		params.put("timestamp", "1542700291905");
		params.put("url", "/home/index");
		params.put("ticket", "cadfd67a457d47daa9cec484d41150ae");

		StringBuilder signatureSbd = new StringBuilder();
		for (Map.Entry<String, String> entry : params.entrySet()) {
			signatureSbd.append(entry.getKey());
			signatureSbd.append("&");
			signatureSbd.append(entry.getValue());
		}

		String signature = DigestUtils.sha1Hex(signatureSbd.toString());

		System.out.println(signature);
	}

	public static boolean isValidUrl(String urlString) {
		URI uri = null;
		try {
			uri = new URI(urlString);
		}
		catch (URISyntaxException e) {
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
