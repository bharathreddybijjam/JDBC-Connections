package CreateDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class insertion {
	private static final String driver="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/vishnu";
	private static final String userame="root";
	private static final String password="root";
	private static Connection conn;
	private static PreparedStatement pmst;
	public static void main(String[] args) {
		try {
			Scanner src=new Scanner(System.in);
			Class.forName(driver);
			conn=DriverManager.getConnection(url, userame, password);
			String sql="insert into login(id,email,password) values(?,?,?)";
			pmst = conn.prepareStatement(sql); 
			System.out.println("Enter id");
			pmst.setString(1, src.next());
			System.out.println("Enter email");
			pmst.setString(2, src.next());
			System.out.println("Enter password");
			pmst.setString(3, src.next());
			int i=pmst.executeUpdate();
			if(i>0) {
				System.out.println("Data Inserted");
			}else {
				System.out.println("Data not Inserted");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
