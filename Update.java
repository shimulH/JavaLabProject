import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Update implements Operation {
	
	private String url;
	private String userName;
	private String password;
	
	private String query;
	

	public Update(String url, String userName, String password) {
		this.url = url;
		this.userName = userName;
		this.password = password;
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
		try {
			connection = DriverManager.getConnection(url, userName, password);
			statement = connection.createStatement();
			statement.executeUpdate(query);
			System.out.println("Update Successful!!!");
			//statement.executeUpdate("UPDATE info SET id = 172014016, name = 'Ashikur Rahamn', phone_no = 753357 WHERE id = 100");
			}catch(Exception e) {
			System.out.println(e);
		}finally {
			try {
				connection.close();
				statement.close();
			}catch(Exception e1) {
				System.out.println(e1);
			}
		}
		
	}

}
