package Registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
//import java.util.List2;
import java.util.Scanner;

import daoImpl.Productreg;
import daoImpl.Register;
import modell.ConnectionManager;
import modell.Product;
import modell.ProductDAO;
import modell.RegisterDAO;
import modell.User;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String firstname;
		String lastname;
		String username = null;
		String pasword;
		String confirmpassword;
		String email;
		String mobile;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Register\n2.Login");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
		System.out.println("enter first name");
		firstname=sc.next();
		System.out.println("enter last name");
		lastname=sc.next();
		System.out.println("enter user name");
		username=sc.next();
		System.out.println("enter password");
		pasword=sc.next();
		System.out.println("confirm your password");
		confirmpassword=sc.next();
		if(pasword.equals(confirmpassword))
		{
		System.out.println("enter email id");
		email=sc.next();
		System.out.println("Enter mobile number");
		mobile=sc.next();
		User user=new User();
		//user.display();
		//ConnectionManager.getConnection();
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setUsername(username);
		user.setPasword(pasword);
		user.setEmail(email);
		user.setMobile(mobile);
		//RegisterDAO register=new RegisterDAO();
		Register register=new RegisterDAO();
		if(register.save(user))
			System.out.println("Data inserted sucessfully");
			else {
				
			System.out.println("check your query");
		
			}
		List<User> list=register.displayAllUsers();
		for(User users:list) {
			System.out.println(users.getFirstname());
			System.out.println(users.getLastname());
			System.out.println(users.getUsername());
			System.out.println(users.getPasword());
			System.out.println(users.getEmail());
			System.out.println(users.getMobile());
			//String un= user.getString(username);
			
		}
		System.out.println("Register Sucessfully");
		}
		else {
		System.out.println("Password and confirm password does not match!");
	}
		break;
		case 2:
			System.out.println("Login");
			System.out.println("enter user name");
			String username2=sc.next();
			System.out.println("enter password");
			String password2=sc.next();
			
			/*if((sql.equals(username2))&&(qry2.equals(pasword2)))
			{
				System.out.println("correct");
			}
			else {
				System.out.println("wrong");
			}*/
			//if(username.equals(username2))
			//{
			do {
			System.out.println("1.Admin Login\n2.Agent Login\n3.Exit");
			int n=sc.nextInt();
			switch(n)
			{
			case 1:
				do {
				System.out.println("Admin Login");
				System.out.println("1.Add product\t2.Display product\t3.Exit");
				int nn=sc.nextInt();
				//Productreg productreg=new ProductDAO();
				
				switch(nn)
				{
				case 1:
					System.out.println("Add Products");
					System.out.println("Total Quantity");
					int totqty=sc.nextInt();
					System.out.println("Enter Product ID");
					String pid=sc.next();
					System.out.println("Enter Product name");
					String pname=sc.next();
					System.out.println("Enter MinSellQuantity");
					int msq=sc.nextInt();
					System.out.println("Enter Price");
					int price=sc.nextInt();
					Product product=new Product();
					product.setPid(pid);
					product.setPname(pname);
					product.setMsq(msq);
					product.setPrice(price);
					Productreg productreg=new ProductDAO();
					if(productreg.save(product))
						System.out.println("Product added sucessfully");
						else {
							
						System.out.println("check your query");
					
						}
					List<Product> list1=productreg.displayAllUsers();
					for(Product products:list1) {
						System.out.println(products.getPid());
						System.out.println(products.getPname());
						System.out.println(products.getMsq());
						System.out.println(products.getPrice());
					}
						break;
				/*case 2:
					Connection connection;
					connection=ConnectionManager.getConnection();
					Statement st=connection.createStatement();
					ResultSet rs=st.executeQuery("Select * from products where pid="+pid);
					System.out.println("Display Product");
					System.out.println(rs.getString("pid"));
					System.out.println(rs.getString("pname"));
					System.out.println(rs.getInt("msq"));
					System.out.println(rs.getInt("price"));
					break;*/
						
				case 3:
					//System.exit(0);
					break;
				}
				}while(n!=3); 
				
				case 2:
						System.out.println("Agent Login");
						System.out.println("Enter ProductId");
						String id=sc.next();
						System.out.println("1.Buy \t2.sell");
						int n2=sc.nextInt();
						switch(n2)
						{
						case 1:
							/*List2<Product> list2=agent.displayAllUsers2();
							for(Product products:list2) {
								//System.out.println(products.getPid());
								System.out.println(products.getPname());
								//System.out.println(products.getMsq());
								System.out.println(products.getPrice());
							}
							Connection connection;
				}*/
							//int msq1=0;
							int msq1 = 0;
							int price1=0;
							Connection connection1;
							connection1=ConnectionManager.getConnection();
							Statement st1=connection1.createStatement();
							ResultSet rs1=st1.executeQuery("Select * from products where pid="+id);
							while(rs1.next())
							{
							/*System.out.println(rs.getString("pid"));
							System.out.println(rs.getString("pname"));
							System.out.println(rs.getInt("msq"));
							System.out.println(rs.getInt("price"));
							String pid1=rs.getString("pid");*/
							
							msq1=rs1.getInt("msq");
							price1 = rs1.getInt("price");
							//System.out.println(rs.getPrice());
							}
							System.out.println("Wanted Quantity");
							int wqty=sc.nextInt();
							if(wqty<=msq1)
							{
								
								int tot=wqty*price1;
								System.out.println("Total amount: "+tot);
							}
							else {
								System.out.println("Item not available");
							}
							break;
						
						case 2:
							int msq2 = 0;
							int price2=0;
							Connection connection2;
							connection2=ConnectionManager.getConnection();
							Statement st2=connection2.createStatement();
							ResultSet rs2=st2.executeQuery("Select * from products where pid="+id);
							while(rs2.next())
							{
								msq2=rs2.getInt("msq");
								price2 = rs2.getInt("price");
							}
						System.out.println("Wanted Quantity");
						int wqty1=sc.nextInt();
						if(wqty1<=msq2)
						{
							
							int tot=wqty1*price2;
							System.out.println("Total amount: "+tot);
							int remining=wqty1-msq2;
							System.out.println("Remaining stock:"+remining);
						}
						else {
							System.out.println("Item not available");
						}
						break;
							
						case 3:
							System.exit(0);
							break;
						}
							break;			
			}
			
			}while(choice!=3);
			}
			
	}
			//else {
				//System.out.println("Invalid username password");
			}
		
	
	

	/*private static String rs.getString(pid)getString(String string) {
		// TODO Auto-generated method stub
		return null;
	}*/

