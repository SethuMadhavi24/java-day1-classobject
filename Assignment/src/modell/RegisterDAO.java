package modell;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import daoImpl.Register;
import modell.ConnectionManager;
import modell.User;

public class RegisterDAO extends ConnectionManager implements Register{
	public boolean save(User user) {
		String sql="insert into users(firstname,lastname,username,pasword,email,mobile) values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps=ConnectionManager.getConnection().prepareStatement(sql);
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3,user.getUsername());
			ps.setString(4, user.getPasword());
			ps.setString(5, user.getEmail());
			ps.setString(6,user.getMobile());
			int resultset=ps.executeUpdate();
			if(resultset==1)
			
				return true;
			
			else 
				return false;
		}
			catch(SQLException e) {
				e.printStackTrace();
			}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
		}

	@Override
	public List<User> displayAllUsers() {
		// TODO Auto-generated method stub
		String sql="Select * from users";
		List <User> list=new LinkedList<User>();
		try {
			PreparedStatement ps=ConnectionManager.getConnection().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				User user=new User();
				//rs.getString("firstname");
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setUsername(rs.getString("username"));
				user.setPasword(rs.getString("pasword"));
				user.setEmail(rs.getString("email"));
				user.setMobile(rs.getString("mobile"));
				list.add(user);
				
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}

}
