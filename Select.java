import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Select implements Operation {

	private String url;
	private String userName;
	private String password;
	private String query;
	private int noOfColumns;

	

	public Select(String url, String userName, String password, int noOfColumns) {
		this.url = url;
		this.userName = userName;
		this.password = password;
		this.noOfColumns = noOfColumns;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
    
	@Override
	public void execute() {
		Connection connection = null;   Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DriverManager.getConnection(url, userName, password);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(getQuery());
			while (resultSet.next()) {
				System.out.print(resultSet.getInt("id"));
				System.out.print(" " + resultSet.getString("name"));
				System.out.print(" " + resultSet.getInt("phone_no"));
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				connection.close();   statement.close();
				resultSet.close();
			} catch (Exception e1) {
				System.out.println(e1);
			}
		}
	}

}
