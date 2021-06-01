package com.multi.DB;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//기록실
//선수기록
public class KBO2 {
	public static void main(String[] args) throws Exception{	
		Document doc = Jsoup.connect("https://www.koreabaseball.com/Record/Player/HitterBasic/Basic1.aspx").get(); //타자

		Elements contents;

		contents = doc.select(".tData01 tbody");

		Elements tmp = doc.select(".tData01 tbody");

		Element e = tmp.get(0);

		int teamNum = e.childNodeSize();
		
		System.out.println("타자= "+e.getElementsByTag("tr").get(0).text());

		/*
		 * int j = 0; for (int i = 0; i < teamNum; i++) {
		 * System.out.println("타자= "+e.getElementsByTag("tr").get(i).text());
		 * 
		 * }
		 */

		
	}
}
