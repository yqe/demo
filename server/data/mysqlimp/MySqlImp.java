package mysqlimp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlImp{

	Statement stmt;

	public MySqlImp() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/malygos?"
				+ "user=root&password=root&useUnicode=true&characterEncoding=UTF8";
		Class.forName("com.mysql.jdbc.Driver");// 动态加载MySQL驱动
		conn = DriverManager.getConnection(url);// 获得elcs数据库的连接
		stmt = conn.createStatement();// 获得陈述引用
	}

	/**
	 * 数据库提取信息方法
	 * 
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public ResultSet query(String sql) throws SQLException {
		ResultSet result = stmt.executeQuery(sql);
		return result;
	}

	/**
	 * 数据库更新删除修改信息方法
	 * 
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public int update(String sql) throws SQLException {
		int result = stmt.executeUpdate(sql);
		return result;
	}
	
//	public double getsum(String sql)throws SQLException {
//		int result = stmt.
//		return result;
//		}
}