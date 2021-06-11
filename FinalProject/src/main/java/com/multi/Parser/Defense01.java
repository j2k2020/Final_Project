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
 * A : ����
CS : ��������
CS% : ����������
DP : ����
E : ��å
FPCT : ������
G : ���
GS : ���߰��
PB : ����
PKO : ������
PO : �ڻ�
POS : ������
SB : �������
 */
public class Defense01 {
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
		String sql = "SELECT * FROM DEFENSE ORDER BY dNum";
		pstmt = conn.prepareStatement(sql);
		res = pstmt.executeQuery();
		while (res.next()) {

//			dNUM, dNAME, dTEAM, dPOS, dG, dGS, dIP, dE, dPKO, dPO, dA, dDP, dFPCT, dPB, dSB, dCS, dCSPercent

			Integer dNUM = Integer.parseInt(res.getString("dNUM"));
			String dNAME = res.getString("dNAME");
			String dTEAM = res.getString("dTEAM");
			String dPOS = res.getString("dPOS");
			String dG = res.getString("dG");
			String dGS = res.getString("dGS");
			String dIP = res.getString("dIP");
			String dE = res.getString("dE");
			String dPKO = res.getString("dPKO");
			String dPO = res.getString("dPO");
			String dA = res.getString("dA");
			String dDP = res.getString("dDP");
			String dFPCT = res.getString("dFPCT");
			String dPB = res.getString("dPB");
			String dSB = res.getString("dSB");
			String dCS = res.getString("dCS");
			// CS&==CSPercent
			String dCSPercent = res.getString("dCSPercent");

			System.out.println(String.format("%d %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s", dNUM, dNAME, dTEAM,
					dPOS, dG, dGS, dIP, dE, dPKO, dPO, dA, dDP, dFPCT, dPB, dSB, dCS, dCSPercent));
		}

	}

	static public void insertList(Connection conn, PreparedStatement pstmt, ResultSet res, Elements tables1)
			throws SQLException {

		String sql = "INSERT INTO DEFENSE VALUES(?, ?, ?, ?,?, ?, ?, ?,?, ?, ?, ?,?, ?, ?, ?,?)";
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

		Document doc = Jsoup.connect("https://www.koreabaseball.com/Record/Player/Defense/Basic.aspx").get();

		Elements tables1 = doc.select("tr");

//		for (int i = 1; i < tables1.size(); i++) {
//			System.out.println(tables1.get(i).text());
//		}

		insertList(conn, pstmt, res, tables1);

		selectList(conn, pstmt, res);
	}
}
