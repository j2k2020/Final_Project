package com.multi.Parser;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/*
 * Hitter
 * 
 * 2B : 2루타
3B : 3루타
AB : 타수
AO : 뜬공
AVG : 타율
BB : 볼넷
BB/K : 볼넷/삼진
CS : 도루실패
E : 실책
G : 경기
GDP : 병살타
GO : 땅볼
GO/AO : 땅볼/뜬공
GPA : (1.8x출루율+장타율)/4
GW RBI : 결승타
H : 안타
HBP : 사구
HR : 홈런
IBB : 고의4구
ISOP : 순수장타율
MH : 멀티히트
OBP : 출루율
OPS : 출루율+장타율
P/PA : 투구수/타석
PA : 타석
PH-BA : 대타타율
R : 득점
RBI : 타점
RISP : 득점권타율
SAC : 희생번트
SB : 도루
SF : 희생플라이
SLG : 장타율
SO : 삼진
TB: 루타
XBH : 장타
XR : 추정득점
 */
public class HitterP01 {
	public static Connection getConnection() {
		String user = "springuser";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/springdb";
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	static public void selectList(Connection conn, PreparedStatement pstmt, ResultSet res) throws SQLException {
		String sql = "SELECT * FROM HITTER ORDER BY hNUM";
		pstmt = conn.prepareStatement(sql);
		res = pstmt.executeQuery();
		while (res.next()) {
//				hNUM, hNAME, hTEAM, hAVG, hG, hPA, hAB, hR, hH, h2B, h3B, hHR, hTB, hRBI, hSAC, hSF, hBB, hIBB, hHBP, hSO, hGDP, hSLG, hOBP, hOPS, hMH, hRISP, hPHBA
			Integer hNUM = Integer.parseInt(res.getString("hNUM"));
			String hNAME = res.getString("hNAME");
			String hTEAM = res.getString("hTEAM");
			String hAVG = res.getString("hAVG");
			String hG = res.getString("hG");
			String hPA = res.getString("hPA");
			String hAB = res.getString("hAB");
			String hR = res.getString("hR");
			String hH = res.getString("hH");
			String h2B = res.getString("h2B");
			String h3B = res.getString("h3B");
			String hHR = res.getString("hHR");
			String hTB = res.getString("hTB");
			String hRBI = res.getString("hRBI");
			String hSAC = res.getString("hSAC");
			String hSF = res.getString("hSF");
			String hBB = res.getString("hBB");
			String hIBB = res.getString("hIBB");
			String hHBP = res.getString("hHBP");
			String hSO = res.getString("hSO");
			String hGDP = res.getString("hGDP");
			String hSLG = res.getString("hSLG");
			String hOBP = res.getString("hOBP");
			String hOPS = res.getString("hOPS");
			String hMH = res.getString("hMH");
			String hRISP = res.getString("hRISP");
			String hPHBA = res.getString("hPHBA");
			System.out.println(
					String.format("%d %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s",
							hNUM, hNAME, hTEAM, hAVG, hG, hPA, hAB, hR, hH, h2B, h3B, hHR, hTB, hRBI, hSAC, hSF, hBB,
							hIBB, hHBP, hSO, hGDP, hSLG, hOBP, hOPS, hMH, hRISP, hPHBA));
		}

	}

	static public void insertList(Connection conn, PreparedStatement pstmt, ResultSet res, Elements tables1,
			Elements tables2) throws SQLException {

		String sql = "INSERT INTO HITTER VALUES(?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?)";
		pstmt = conn.prepareStatement(sql);

		int row1=tables1.select("tr").size()-1; //행
		int col1=tables1.select("tr td").size()/row1;
		int row2=tables2.select("tr").size()-1; //행s
		int col2=tables2.select("tr td").size()/row2;
		
		int k = 1;
		for (int j = 1; j < tables1.size(); j++) {
			for (int i = 1; i < tables1.get(1).tagName("td").select("td").size(); i++) {
				if (k == 1) {
					pstmt.setInt(k, Integer.parseInt(tables1.get(j).tagName("td").select("td").get(i).text()));
				} else {
					pstmt.setString(k, tables1.get(j).tagName("td").select("td").get(i).text());
				}
				k += 1;
			}
			for (int i = 5; i < tables2.get(1).tagName("td").select("td").size(); i++) {
				pstmt.setString(k, tables2.get(j).tagName("td").select("td").get(i).text());
				k += 1;
			}

			if (k == col1+col2-3) {
				k = 1;
			}
			pstmt.executeUpdate();
		}
	}

	public static void main(String[] args) throws IOException, SQLException {

		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet res = null;
		String sql;

		Document doc = Jsoup.connect("https://www.koreabaseball.com/Record/Player/HitterBasic/Basic1.aspx").get();
		Document doc2 = Jsoup.connect("https://www.koreabaseball.com/Record/Player/HitterBasic/Basic2.aspx").get();

		Elements tables1 = doc.select("tr");
		Elements tables2 = doc2.select("tr");

//		for (int i = 1; i < tables1.size(); i++) {
//			System.out.println(tables1.get(i).text());
//			System.out.println(tables2.get(i).text());
//		}

		insertList(conn, pstmt, res, tables1, tables2);

		selectList(conn, pstmt, res);
	}
}

