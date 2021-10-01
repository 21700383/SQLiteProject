import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	
	public static void main(String[] args) {
		Connection con = null;
		
		try {
			Class.forName("org.sqlite.JDBC"); // SQLite JDBC üũ
			
			// SQLite �����ͺ��̽� ���Ͽ� ����
			String dbFile = "myfirst.db";
			con = DriverManager.getConnection("jdbc:sqlite:" + dbFile); // myfirst.db�� ����
			/*
			// ������ ��ȸ
			System.out.println("\n*** ������ ��ȸ ***");
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
			//������ �߰�
			System.out.println("\n*** �� ������ �߰� ***");
			Statement statAdd = con.createStatement();
			String sqlAdd = "insert into g_artists (name, a_type, a_year, debut, regdate)"
			+  "values ('�����', '����', '2000���', '2005��', datetime('now','localtime'));";
			int cnt = statAdd.executeUpdate(sqlAdd); // �����Ͱ� ���� 0�� �ƴ� ����
			if(cnt > 0) {
				System.out.println("���ο���Ͱ� �߰��Ǿ����ϴ�!");
			}
			else {
				System.out.println("[ERROR] ������ �߰� ����!");
			}
			statAdd.close();
			*/
			/*
			System.out.println("\n*** ������ ���� ***");
			Statement statEdit = con.createStatement();
			String sqlEdit = "update g_artists set a_year = '2000���, 2010���, 2020���' " 
			+ "where id = 1;";
			int cnt = statEdit.executeUpdate(sqlEdit); // �����Ͱ� ���� 0�� �ƴ� ����
			if(cnt > 0) {
				System.out.println("�����Ͱ� �����Ǿ����ϴ�");
			}
			else {
				System.out.println("[ERROR] ������ ���� ����!");
			}
			statEdit.close();
			*/
			System.out.println("\n*** ������ ���� ***");
			Statement satDel = con.createStatement();
			String sqlDel = "delete from g_artists " + "where id = 7;";
			int cnt = satDel.executeUpdate(sqlDel); // satDel�� ����ɰ�� 0�� �ƴ� ��������
			if(cnt > 0) {
				System.out.println("�����Ͱ� �����Ǿ����ϴ�");
			}
			else {
				System.out.println("[ERROR] ������ ���� ����!");
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
