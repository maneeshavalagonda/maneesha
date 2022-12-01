package com.maneesha.com.maneesha.example1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class jdbcforemployee {
	private static final String record =null;
	static Scanner obj = new Scanner(System.in);
	public static void createNewemployee(Connection connection ,employee obj) throws SQLException {
		PreparedStatement pstmt = connection.prepareStatement("insert into employee values(?,?,?,?,?,?,?)");
		pstmt.setInt(1, obj.getemployee_id());
		pstmt.setString(2, obj.getemployee_name());
		pstmt.setString(3, obj.getemployee_companyname());
		pstmt.setString(4, obj.getemployee_department());
		pstmt.setString(5, obj.getemployee_gender());
		pstmt.setString(6, obj.getemployee_address());
		pstmt.setFloat(7, obj.getemployee_salary());


		int employee_id = pstmt.executeUpdate();
		System.out.println(employee_id +"inserted succesfully");

	}
	private static void  update(Connection connection, int employee_id)throws SQLException {
		System.out.println("enter the update employee_name");
		Scanner input  =new Scanner(System.in);
		PreparedStatement pstmt = connection.prepareStatement("update employee set employee_name = ? where employee_id =?");
		pstmt.setInt(1,employee_id);

		int record = pstmt.executeUpdate();
		System.out.println (record +"updated sucessfully");
	}
	private static void delete(Connection connection, int employee_id)throws SQLException{
		System.out.println ("enter the delete employee_id");
		int value = obj.nextInt();
		PreparedStatement pstmt = connection.prepareStatement("delete from  employee  where employee_id =?");
		pstmt.setInt(1,value);
		//pstmt.executeUpdate();
		int record = pstmt.executeUpdate();
		System.out.println (record +"deleted sucessfully");
	}
/*mam--------------------------------private void viewrecord(connection, id){
sysout red the id to be read
int val = obj.nextInt();
preparedstmt(select * from t1 where id = ?)
pstmt.setInt(1,id);
ResultSet records = stmt.execute()
sysout (records.getInt(1)+


}*/
	private static void view (Connection connection,int employee_id)throws SQLException {
		
		PreparedStatement pstmt = connection.prepareStatement("select * from employee where employee_id =?");
		pstmt.setInt(1,employee_id);
		ResultSet records = pstmt.executeQuery();
		if (records.next()) {
			System.out.println (records.getInt(1)+records.getString(2)+records.getString(3)+records.getString(4)+records.getString(5)+records.getString(6)+records.getInt(7)); 
		}
		else {
			System.out.println("no data available");
		}
	}
	
        public static void main(String[] args) throws SQLException, NullPointerException, Exception {
		Connection connection = null;
		final employee Obj = new employee();
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employedetalis","root","Pavani@1");
		System.out.println("click 1 to add employee");
		System.out.println("click 2 to Update employee");
		System.out.println("click 3 to delete employee ");
		System.out.println("click 4 to View employee");

		System.out.println("Enter your choice from above");
		byte choice = obj.nextByte();
		switch(choice) {
		case 1:
			employee obj = getUser();
			//	obj is having the details of the user with 4 attr val got from runtime, 3 attr with def val
			createNewemployee(connection,obj);
			break;
		case 2:
			update(connection,12);
			break;
		case 3:
			delete(connection,13);

			break;
		case 4:
			
			view(connection,15);
			break;
		default :
			System.out.println("Enter valid input");
			connection.close();
		}

	}


	private static employee getUser() {
		employee user = new employee();
		System.out.println("Enter employee_id");
		user.setemployee_id(obj.nextInt());  //123456
		System.out.println("Enter employee_name");
		user.setemployee_name(obj.next());  //9944789
		System.out.println("Enter your employee_company");
		user.setemployee_companyname(obj.next()); //mamillapali
		System.out.println("Enter employee_department");
		user.setemployee_department(obj.next());  //blre
		System.out.println("Enter employee_gender");
		user.setemployee_gender(obj.next());  //blre
		System.out.println("Enter employee_address");
		user.setemployee_address(obj.next());  //blre
		System.out.println("Enter employee_salary");
		user.setemployee_salary(obj.nextFloat());  //blre


		return user;  



	}



}


