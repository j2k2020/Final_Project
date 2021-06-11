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
 * Pitcher
 * 
 * 2B : 2루타
3B : 3루타
AO : 뜬공
AVG : 피안타율
BABIP : 인플레이타구타율
BB : 볼넷
BB/9 : 9이닝당 볼넷
BK : 보크
BSV : 블론세이브
CG : 완투
ER : 자책점
ERA : 평균자책점
G : 경기
GDP : 병살타
GF : 종료
GO : 땅볼
GO/AO : 땅볼/뜬공
GS : 선발
H : 피안타
HBP : 사구
HLD : 홀드
HR : 홈런
IBB : 고의4구
IP : 이닝
K/9 : 9이닝당 삼진
K/BB : 삼진/볼넷
L : 패
NP : 투구수
OBP : 피출루율
OPS : 피출루율+피장타율
P/G : 투구수/경기
P/IP : 투구수/이닝
QS : 퀄리티스타트
R : 실점
SAC : 희생번트
SF : 희생플라이
SHO : 완봉
SLG : 피장타율
SO : 삼진
SV : 세이브
SVO : 세이브기회
TBF : 타자수
TS : 터프세이브
W : 승
Wgr : 구원승
Wgs : 선발승
WHIP : 이닝당 출루허용률
WP : 폭투
WPCT : 승률
 */
public class PitcherP01 {
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
		String sql = "SELECT * FROM PITCHER ORDER BY PNum";
		pstmt = conn.prepareStatement(sql);
		res = pstmt.executeQuery();
		while (res.next()) {
//			pNUM, pNAME, pTEAM, pERA pG pW pL pSV pHLD pWPCT pIP pH pHR pBB pHBP pSO pR pER pWHIP pCG pSHO pQS pBSV pTBF pNP pAVG p2B p3B pSAC pSF pIBB pWP pBK
			Integer pNUM = Integer.parseInt(res.getString("pNUM"));
			String pNAME = res.getString("pNAME");
			String pTEAM = res.getString("pTEAM");
			String pERA = res.getString("pERA");
			String pG = res.getString("pG");
			String pW = res.getString("pW");
			String pL = res.getString("pL");
			String pSV = res.getString("pSV");
			String pHLD = res.getString("pHLD");
			String pWPCT = res.getString("pWPCT");
			String pIP = res.getString("pIP");
			String pH = res.getString("pH");
			String pHR = res.getString("pHR");
			String pBB = res.getString("pBB");
			String pHBP = res.getString("pHBP");
			String pSO = res.getString("pSO");
			String pR = res.getString("pR");
			String pER = res.getString("pER");
			String pWHIP = res.getString("pWHIP");
			String pCG = res.getString("pCG");
			String pSHO = res.getString("pSHO");
			String pQS = res.getString("pQS");
			String pBSV = res.getString("pBSV");
			String pTBF = res.getString("pTBF");
			String pNP = res.getString("pNP");
			String pAVG = res.getString("pAVG");
			String p2B = res.getString("p2B");
			String p3B = res.getString("p3B");
			String pSAC = res.getString("pSAC");
			String pSF = res.getString("pSF");
			String pIBB = res.getString("pIBB");
			String pWP = res.getString("pWP");
			String pBK = res.getString("pBK");

			System.out.println(String.format(
					"%d %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s",
					pNUM, pNAME, pTEAM, pERA, pG, pW, pL, pSV, pHLD, pWPCT, pIP, pH, pHR, pBB, pHBP, pSO, pR, pER,
					pWHIP, pCG, pSHO, pQS, pBSV, pTBF, pNP, pAVG, p2B, p3B, pSAC, pSF, pIBB, pWP, pBK));
		}

	}

	static public void insertList(Connection conn, PreparedStatement pstmt, ResultSet res, Elements tables1,
			Elements tables2) throws SQLException {

		String sql = "INSERT INTO PITCHER VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?)";
		pstmt = conn.prepareStatement(sql);

		int row1=tables1.select("tr").size()-1; //행
		int col1=tables1.select("tr td").size()/row1;
		int row2=tables2.select("tr").size()-1; //행 
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
			for (int i = 5; i < tables2.get(1).tagName("td").select("td").size(); i++) { //다음페이지의 5번째열부터
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

		Document doc = Jsoup.connect("https://www.koreabaseball.com/Record/Player/PitcherBasic/Basic1.aspx").get();
		Document doc2 = Jsoup.connect("https://www.koreabaseball.com/Record/Player/PitcherBasic/Basic2.aspx").get();

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
