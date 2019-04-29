import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Insert implements Operation {

	private String url;
	private String userName;
	private String password;
	private String query1; // INSERT into info(id, name, phone_no)
	private String query2; // VALUES(172014017, 'Nadia Chowdhury Mithila' , 147582)

	public Insert(String url, String userName, String password) {
		this.url = url;
		this.userName = userName;
		this.password = password;
	}

	public String getQuery1() {
		return query1;
	}

	public void setQuery1(String query1) {
		this.query1 = query1;
	}

	public String getQuery2() {
		return query2;
	}

	public void setQuery2(String query2) {
		this.query2 = query2;
	}

	@Override
	public void execute() {

		Connection connection = null; Statement statement = null;
           try {
            connection = DriverManager.getConnection(url, userName, password);
			statement = connection.createStatement();
			statement.executeUpdate(query1 + query2);
			System.out.println("Insert Successful!!!");
			// statement.executeUpdate("INSERT into info(id, name, phone_no)" + "VALUES(1720140017, 'Nadia Chowdhpury Mithila' , 14750082)");

		} catch (Exception e) {
			//System.out.println(e);
		} finally {
			try {
				connection.close();
				statement.close();
			} catch (Exception e1) {
				System.out.println(e1);
			}
		}

	}
}