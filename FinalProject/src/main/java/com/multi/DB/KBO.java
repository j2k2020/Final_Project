package com.multi.DB;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class KBO {
	
//	private static String URL = "https://www.koreabaseball.com/Record/Player/HitterBasic/Basic1.aspx";

	public static void main(String[] args) throws Exception{
//		// 1. Document를 가져온다
//		Document doc = Jsoup.connect(URL).get();
//
//		// 2.목록을 가져온다
//		System.out.println(""+doc.toString());
		
		Document doc = Jsoup.connect("https://www.koreabaseball.com/Record/Team/Hitter/Basic1.aspx").get();
		Document doc2 = Jsoup.connect("https://www.koreabaseball.com/Record/Team/Hitter/Basic2.aspx").get();
		Elements contents;
		Elements contents2;
		contents = doc.select(".tData tbody");
		contents2 = doc2.select(".tData tbody");
		Elements tmp = doc.select(".tData tbody");
		Elements tmp2 = doc2.select(".tData tbody");
		Element e = tmp.get(0);
		Element e2 = tmp2.get(0);
		int teamNum = e.childNodeSize();
		int teamNum2 = e2.childNodeSize();
		int j = 0;
		for (int i = 0; i < teamNum; i++) {
			System.out.println(e.getElementsByTag("tr").get(i).text());
			System.out.println(e2.getElementsByTag("tr").get(i + j).text());
		}

		
		
		

	}



}
