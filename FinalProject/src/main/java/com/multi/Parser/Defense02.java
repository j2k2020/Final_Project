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
 * Defense
 * 
POS : 포지션
G : 경기
GS : 선발경기
IP : 수비이닝
E : 실책
PKO : 견제사
PO : 자살
A : 보살
DP : 병살
FPCT : 수비율
PB : 포일
SB : 도루허용
CS : 도루실패
CS% : 도루저지율
 */
public class Defense02 {
	public static Connection getConnection() {
		String user = "springuser";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/springdb";
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	static public void selectList(Connection conn, PreparedStatement pstmt, ResultSet res) throws SQLException {
		String sql = "SELECT * FROM  defense ORDER BY dNum";
		pstmt = conn.prepareStatement(sql);
		res = pstmt.executeQuery();
		while (res.next()) {
//				 dNum, dName, dTeam, dPOS, dG, dGS, dIP, dE, dPKO, dPO, dA, dDP, dFPCT, dPB, dSB, dCS, dCSPercent
			Integer dNum = Integer.parseInt(res.getString("dNum")); //1
			String dName = res.getString("dName"); //2
			String dTeam = res.getString("dTeam"); //3
			String dPOS = res.getString("dPOS"); //4 
			String dG = res.getString("dG"); //5
			String dGS = res.getString("dGS"); //6
			String dIP = res.getString("dIP"); //7
			String dE = res.getString("dE"); //8
			String dPKO = res.getString("dPKO"); //9
			String dPO = res.getString("dPO"); //10
			String dA = res.getString("dA"); //11
			String dDP = res.getString("dDP"); //12
			String dFPCT = res.getString("dFPCT"); //13
 			String dPB = res.getString("dPB"); //14
			String dSB = res.getString("dSB"); //15
			String dCS = res.getString("dCS"); //16
			String dCSPercent = res.getString("dCSPercent"); //17
			System.out.println(
					String.format(" %d %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s " ,
							dNum, dName, dTeam, dPOS, dG, dGS, dIP, dE, dPKO, dPO, dA, dDP, dFPCT, dPB, dSB, dCS, dCSPercent));
		}

	}

	
	static public void insertList(Connection conn, PreparedStatement pstmt, ResultSet res, Elements tables1) throws Exception {

		
			String sql = "INSERT INTO defense VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ";
			pstmt = conn.prepareStatement(sql);

			int row1=tables1.select("tr").size()-1; //행 (-1행을 한 이유: 컬럼명 제외한 리스트만 받아옴) 
			System.out.println("tr사이즈: "+row1);
			int col1=tables1.select("tr td").size()/row1;
			System.out.println("tr td사이즈: "+col1);
			/*
			 * System.out.println("tables1.get(1) ? : "+tables1.get(1));
			 * System.out.println("**********************************************");
			 * System.out.println("tables1.get(2) ? : "+tables1.get(2));
			 */
				int k = 1;
				for (int j = 1; j < tables1.size(); j++) { //배열1부터 받아옴(컬럼명 제외하고)(tr) //총 31행
					System.out.println("tables1.size: "+tables1.size()); //총 31행
					System.out.println(j);
					
					for (int i = 1; i < tables1.get(1).tagName("td").select("td").size(); i++) {
						System.out.println("??["+i+"]: "+col1);
						
							if (k == 1) { //k는 col1이 17개 중
								pstmt.setInt(k, Integer.parseInt(tables1.get(j).tagName("td").select("td").get(i).text())); //1번째는 숫자
							} else {
								pstmt.setString(k, tables1.get(j).tagName("td").select("td").get(i).text()); //2번째부터는 문자
							}
							k += 1;
							System.out.println("k는 뭔가: "+k);
							
							if (k == col1+1) { //<tr>한 행이 끝나는 시점
								k = 1;
							}	
						} pstmt.executeUpdate();
					}
					
	}

	public static void main(String[] args) throws Exception {

		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet res = null;
		String sql;

		Document doc = Jsoup.connect("https://www.koreabaseball.com/Record/Player/Defense/Basic.aspx").get();

		Elements tables1 = doc.select("tr");

		//for (int i = 1; i < tables1.size(); i++) {
			//System.out.println(tables1.get(i).text());
//			System.out.println(tables2.get(i).text());
		//}

		insertList(conn, pstmt, res, tables1);

		selectList(conn, pstmt, res);
	}
}