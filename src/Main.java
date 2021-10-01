import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	
	public static void main(String[] args) {
		Connection con = null;
		
		try {
			Class.forName("org.sqlite.JDBC"); // SQLite JDBC 체크
			
			// SQLite 데이터베이스 파일에 연결
			String dbFile = "myfirst.db";
			con = DriverManager.getConnection("jdbc:sqlite:" + dbFile); // myfirst.db에 연결
			/*
			// 데이터 조회
			System.out.println("\n*** 데이터 조회 ***");
			Statement statView = con.createStatement();
			String sqlView = "select * from g_artists";
			ResultSet rs = statView.executeQuery(sqlView);
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.println(id + " " + name);
			}
			statView.close();
			*/
			/*
			//데이터 추가
			System.out.println("\n*** 새 데이터 추가 ***");
			Statement statAdd = con.createStatement();
			String sqlAdd = "insert into g_artists (name, a_type, a_year, debut, regdate)"
			+  "values ('노라조', '남성', '2000년대', '2005년', datetime('now','localtime'));";
			int cnt = statAdd.executeUpdate(sqlAdd); // 데이터가 들어가면 0이 아닌 숫자
			if(cnt > 0) {
				System.out.println("새로운데이터가 추가되었습니다!");
			}
			else {
				System.out.println("[ERROR] 데이터 추가 오류!");
			}
			statAdd.close();
			*/
			/*
			System.out.println("\n*** 데이터 수정 ***");
			Statement statEdit = con.createStatement();
			String sqlEdit = "update g_artists set a_year = '2000년대, 2010년대, 2020년대' " 
			+ "where id = 1;";
			int cnt = statEdit.executeUpdate(sqlEdit); // 데이터가 들어가면 0이 아닌 숫자
			if(cnt > 0) {
				System.out.println("데이터가 수정되었습니다");
			}
			else {
				System.out.println("[ERROR] 데이터 수정 오류!");
			}
			statEdit.close();
			*/
			System.out.println("\n*** 데이터 삭제 ***");
			Statement satDel = con.createStatement();
			String sqlDel = "delete from g_artists " + "where id = 7;";
			int cnt = satDel.executeUpdate(sqlDel); // satDel이 실행될경우 0이 아닌 숫자저장
			if(cnt > 0) {
				System.out.println("데이터가 삭제되었습니다");
			}
			else {
				System.out.println("[ERROR] 데이터 삭제 오류!");
			}
			satDel.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {}
			}
		}
	}

}
