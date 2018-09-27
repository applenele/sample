package com.dxy.lenny.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import org.jsoup.select.NodeVisitor;

import java.util.function.Function;

/**
 * @author niele
 * @date 2018/9/5
 */
public class JsoupHtmlUtil {

	public static String replaceHtmlTag(String str, String tag, String tagAttrib, Function<String, String> function) {
		Document doc = Jsoup.parse(str);
		Elements pngs = doc.select("img[src]");
		for (Element element : pngs) {
			String imgUrl = element.attr("src");
			String replaceUrl = function.apply(imgUrl);
			element.attr("src", replaceUrl);
		}
		str = doc.toString();
		return str;
	}


	public static void main(String[] args) {
		StringBuffer content = new StringBuffer();
		content.append("<ul class=\"imgBox\"><li><img id=\"160424\" src='uploads/allimg/160424/1-160424120T1-50.jpg' class=\"src_class\"></li>");
		content.append("<li><img id=\"150628\" src=\"uploads/allimg/150628/1-15062Q12247.jpg\" class=\"src_class\"></li></ul>");
		System.out.println("原始字符串为:" + content.toString());
//        String newStr = replaceHtmlTag(content.toString(), "img", "src", s -> "https://www.baidu.com");
////        System.out.println("       替换后为:" + newStr);

		//System.out.println(Jsoup.clean(content));
	}

}
