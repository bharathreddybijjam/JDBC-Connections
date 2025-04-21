package CreateDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class dynamic_Application {
	private static final String Driver="com.mysql.cj.jdbc.Driver";
	private static final String username="root";
	private static final String password="root";
	private static Connection conn;
	private static PreparedStatement pmst;
	public static void main(String[] args) {
		int choice;
		do {
			Scanner src=new Scanner(System.in);
			System.out.println("Choose ur choice");
			displaymenu();
			choice=Integer.parseInt(src.next());
			switch(choice) {
			case 1:
				createdatabase();
				break;
			case 2:
				dropdatabase();
				break;
			case 3:
				createtable();
			case 4:
				datainsertion();
				break;
			case 5:
				detelebyemail();
				break;
			case 6:
				updatedata();
				break;
			case 7:
				getbyemail();
				break;
			case 8:
				getall();
				break;
			case 9:
				login();
				
				
			}
			
		} while (choice>0);
	}

	private static void createtable() {
		// TODO Auto-generated method stub
		try {
			Scanner src=new Scanner(System.in);
			Class.forName(Driver);
			System.out.println("enter the database name:");
			String url="jdbc:mysql://localhost:3306/"+src.next();
			conn=DriverManager.getConnection(url, username, password);
			System.out.println("Enter the table name");
			String sql="create table "+src.next()+ " (" +"order_id INT, " +"order_name VARCHAR(255), " +"order_pincode BIGINT, " +"order_address VARCHAR(255)" +")";
			pmst=conn.prepareStatement(sql);
			int i=pmst.executeUpdate();
			if(i==0) {
				System.out.println("Successfully created table");
			}else {
				System.out.println("table is not created");
			}
			conn.close();
			pmst.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	private static void login() {
		// TODO Auto-generated method stub
		try {
			Scanner src=new Scanner(System.in);
			Class.forName(Driver);
			System.out.println("Enter database name:");
			String url="jdbc:mysql://localhost:3306/"+src.next();
			conn=DriverManager.getConnection(url, username, password);
			System.out.println("enter table name");
			String sql="select order_id,order_pincode from "+src.next();
			System.out.println("Enter login id");
			long login_id=src.nextLong();
			System.out.println("Enter order_pincode");
			long pin=src.nextLong();
//			pmst.setInt(1, (int) login_id);
//			pmst.setI(2, pin);
			pmst=conn.prepareStatement(sql);
			ResultSet rs=pmst.executeQuery();
//			if(rs.next())
//			{
//				System.out.println("login successful");
//			}
//			else {
//				System.out.println("login unsuccessful");
//			}
			while(rs.next()) {
				if(rs.getLong("order_id")==login_id && rs.getLong("order_pincode")==pin) {
					System.out.println("login successful");
				}
		
			}
			System.out.println("login unsuccessful");
//			System.out.println("");
			} catch (Exception e) {
				
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	private static void getbyemail() {
		// TODO Auto-generated method stub
		try {
			Scanner src=new Scanner(System.in);
			Class.forName(Driver);
			System.out.println("Enter database name:");
			String url="jdbc:mysql://localhost:3306/"+src.next();
			conn=DriverManager.getConnection(url, username, password);
			System.out.println("Enter table name");
			String sql="select * from " +src.next()+" where order_pincode=?";	
			pmst=conn.prepareStatement(sql);
			System.out.println("enter name");
			pmst.setLong(1,src.nextLong());
			ResultSet rs=pmst.executeQuery();
			while(rs.next()) {
				System.out.println("oder id : "+rs.getLong("order_id"));
				System.out.println("order name : "+rs.getString("order_name"));
				System.out.println("order pincode : "+rs.getLong("order_pincode"));
				System.out.println("order address : "+rs.getString("order_address"));
				
			}
			} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

	private static void dropdatabase() {
		// TODO Auto-generated method stub
		try {
			Class.forName(Driver);
			String url="jdbc:mysql://localhost:3306/";
			conn=DriverManager.getConnection(url, username, password);
			System.out.println("Enter database name");
			Scanner src=new Scanner(System.in);
			String sql="drop database "+src.next();
			pmst=conn.prepareStatement(sql);
			int i=pmst.executeUpdate();
			if(i==0) {
				System.out.println("Successfully drop database");
			}else {
				System.out.println("database is not drop");
			}
			conn.close();
			pmst.close();
			} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private static void createdatabase() {
		// TODO Auto-generated method stub
		try {
			Class.forName(Driver);
			String url="jdbc:mysql://localhost:3306/";
			conn=DriverManager.getConnection(url, username, password);
			System.out.println("Enter database name");
			Scanner src=new Scanner(System.in);
			String sql="create database "+src.next();
			pmst=conn.prepareStatement(sql);
			int i=pmst.executeUpdate();
			if(i>0) {
				System.out.println("Successfully created database");
			}else {
				System.out.println("database is not created");
			}
			conn.close();
			pmst.close();
			} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void getall() {
		// TODO Auto-generated method stub
		try {
			Scanner src=new Scanner(System.in);
			Class.forName(Driver);
			System.out.println("Enter database name");
			String url="jdbc:mysql://localhost:3306/"+src.next();
			conn=DriverManager.getConnection(url, username, password);
			System.out.println("Enter table name");
			String sql="select * from "+src.next();
			pmst=conn.prepareStatement(sql);
			ResultSet rs=pmst.executeQuery();
			while(rs.next()){
				System.out.println("oder id : "+rs.getLong("order_id"));
				System.out.println("order name : "+rs.getString("order_name"));
				System.out.println("order pincode : "+rs.getLong("order_pincode"));
				System.out.println("order address : "+rs.getString("order_address"));
			}
			pmst.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	private static void updatedata() {
		// TODO Auto-generated method stub
		try {
			Scanner src=new Scanner(System.in);
			Class.forName(Driver);
			System.out.println("enter database name to insert data");
			String url="jdbc:mysql://localhost:3306/"+src.next();
			conn=DriverManager.getConnection(url, username, password);
			System.out.println("Enter database table name");
			String sql="update  "+src.next()+"set order_name=?,order_pincode=?,order_address=? where order_id=?";
			pmst=conn.prepareStatement(sql);
			System.out.println("Enter order name");
			pmst.setString(1,src.next());
			System.out.println("Enter order pincode");
			pmst.setLong(2,src.nextLong());
			System.out.println("Enter order address");
			pmst.setString(3, src.next());
			int i=pmst.executeUpdate();
			System.out.println("Enter order id");
			pmst.setLong(4,src.nextLong());
			if(i>0) {
				System.out.println("Successfully update database");
			}else {
				System.out.println("database is not update");
			}
			conn.close();
			pmst.close();
			} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void detelebyemail() {
			try {
				Scanner src = new Scanner(System.in);
				Class.forName(Driver);
				System.out.println("Enter Database name to insert data");
				String url = "jdbc:mysql://localhost:3306/"+ src.next();
				conn  = DriverManager.getConnection(url, username, password);
				System.out.println("Enter Database table name");
				String sql = "delete from "+src.next() + " where order_id=? ";
				pmst = conn.prepareStatement(sql);
				System.out.println("Enter order id");
				pmst.setLong(1, src.nextLong());
				int i = pmst.executeUpdate();
				if(i>0) {
					System.out.println("Database deleted Successfully");
				}else {
					System.out.println("Database Not deleted...!");
				}
				conn.close();
				pmst.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// TODO Auto-generated method stub
		

	private static void datainsertion() {
		// TODO Auto-generated method stub
		try {
			Scanner src=new Scanner(System.in);
			Class.forName(Driver);
			System.out.println("enter database name to insert data");
			String url="jdbc:mysql://localhost:3306/"+src.next();
			conn=DriverManager.getConnection(url, username, password);
			System.out.println("Enter database table name");
			String sql="insert into  "+src.next()+"(order_id,order_name,order_pincode,order_address)values(?,?,?,?)";
			pmst=conn.prepareStatement(sql);
			System.out.println("Enter order id");
			pmst.setLong(1,src.nextLong());
			System.out.println("Enter order name");
			pmst.setString(2,src.next());
			System.out.println("Enter order pincode");
			pmst.setLong(3,src.nextLong());
			System.out.println("Enter order address");
			pmst.setString(4, src.next());
			int i=pmst.executeUpdate();
			if(i>0) {
				System.out.println("Successfully inserted database");
			}else {
				System.out.println("database is not inserted");
			}
			conn.close();
			pmst.close();
			} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void displaymenu() {
		// TODO Auto-generated method stub
		System.out.println("\t1.create database");
		System.out.println("\t2.drop database");
		System.out.println("\t3.create table");
		System.out.println("\t4.data insertion");
		System.out.println("\t5.delete by email");
		System.out.println("\t6.update data");
		System.out.println("\t7.get by email ");
		System.out.println("\t8.get all");
		System.out.println("\t9.login");
		System.out.println("\t10.exit");
		
	}
}
