package CreateDataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class dropdata {
	private static final String Driver="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/nqt";
	private static final String username="root";
	private static final String password="root";
	private static PreparedStatement pmst;
	private static Connection conn;
	public static void main(String[] args) {
		
		try {
			Scanner src=new Scanner(System.in);
			
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Class.forName(Driver);
			//Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root", "password");
			//Connection
			conn=DriverManager.getConnection(url,username,password);
			System.out.println("Enter database name:");
			String sql="drop database "+ src.next();
			//PreparedStatement 
			pmst=conn.prepareStatement(sql);
			int i=pmst.executeUpdate();
			if(i==0){
				System.out.println("database is deleted");
			}else {
				System.out.println("database is not deleted");
			}
			pmst.close();
			conn.close();
			src.close();
			} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
