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
  Runner
G : 경기
SBA : 도루시도
SB : 도루허용
CS : 도루실패
SB% : 도루성공률
OOB : 주루사
POK : 견제사
 */
public class Runner01 {
	public static Connection getConnection() {
		String user = "springuser";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/springdb?serverTimezone=UTC";
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
		String sql = "SELECT * FROM Runner ORDER BY rNum";
		pstmt = conn.prepareStatement(sql);
		res = pstmt.executeQuery();
		while (res.next()) {

//			rNum,rName,rTeam,rG,rSBA,rSB,rCS,rSBp,rOOB,rPOK

			Integer rNum = Integer.parseInt(res.getString("rNum"));
			String rName = res.getString("rName");
			String rTeam = res.getString("rTeam");
			String rG = res.getString("rG");
			String rSBA = res.getString("rSBA");
			String rSB = res.getString("rSB");
			String rCS = res.getString("rCS");
			String rSBp = res.getString("rSBp");
			String rOOB = res.getString("rOOB");
			String rPOK = res.getString("rPOK");

			System.out.println(String.format("%d %s %s %s %s %s %s %s %s %s", rNum,rName,rTeam,rG,rSBA,rSB,rCS,rSBp,rOOB,rPOK));
		}

	}

	static public void insertList(Connection conn, PreparedStatement pstmt, ResultSet res, Elements tables1)
			throws SQLException {

		String sql = "INSERT INTO Runner VALUES(?, ?, ?, ?,?, ?, ?, ?,?, ?)";
		pstmt = conn.prepareStatement(sql);

		int row1 = tables1.select("tr").size() - 1; // ��
		int col1 = tables1.select("tr td").size() / row1;

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
			if (k == col1+1) {
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

		Document doc = Jsoup.connect("https://www.koreabaseball.com/Record/Player/Runner/Basic.aspx").get();

		Elements tables1 = doc.select("tr");

//		for (int i = 1; i < tables1.size(); i++) {
//			System.out.println(tables1.get(i).text());
//		}

		insertList(conn, pstmt, res, tables1);

		selectList(conn, pstmt, res);
	}
}
