
public class mainApp {

	public static void main(String[] args) {
		/*Delete d = new Delete("jdbc:mysql://localhost/dip","root","" );
		d.setQuery("DELETE FROM info WHERE id =172014016");
		d.execute();*/
		
		/*Insert i = new Insert("jdbc:mysql://localhost/dip","root","");
		i.setQuery1("INSERT into info(id, name, phone_no)");
		i.setQuery2("VALUES(172014017, 'Nadia Chowdhury' , 951369)");
		i.execute();*/
		
		Update u = new Update("jdbc:mysql://localhost/dip","root",""); 
		u.setQuery("UPDATE info SET id = 123, phone_no = 12300321 WHERE id = 172014016");  u.execute();
		
		Select s = new Select("jdbc:mysql://localhost/dip","root","",3);
		s.setQuery("SELECT * FROM info");
		s.execute();
		
	}
}
