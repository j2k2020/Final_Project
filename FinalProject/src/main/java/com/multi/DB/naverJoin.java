package com.multi.DB;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class naverJoin {
	
	private static String URL = "https://nid.naver.com/user2/V2Join?token_sjoin=VFtub3Pan86TUCC2&langSelect=ko_KR&chk_all=on&termsService=on&termsPrivacy=on&termsLocation=Y&termsEmail=Y";
	
	public static void main(String[] args) throws Exception{
		
	//1. Document를 가져온다
	Document doc = Jsoup.connect(URL).get();

	//2.목록을 가져온다
	System.out.println(""+doc.toString());
	
	}

}
