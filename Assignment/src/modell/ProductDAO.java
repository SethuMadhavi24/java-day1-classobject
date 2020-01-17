package modell;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
//import java.util.List2;

//import daoImpl.Agent;
import daoImpl.Productreg;
import daoImpl.Register;
import modell.ConnectionManager;
import modell.Product;
public class ProductDAO extends ConnectionManager implements Productreg{
	public boolean save(Product product) {
		String sql="insert into products(pid,pname,msq,price) values(?,?,?,?)";
		try {
			PreparedStatement ps=ConnectionManager.getConnection().prepareStatement(sql);
			ps.setString(1, product.getPid());
			ps.setString(2, product.getPname());
			ps.setInt(3, product.getMsq());
			ps.setInt(4, product.getPrice());
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
	public List<Product> displayAllUsers() {
		// TODO Auto-generated method stub
		String sql="Select * from products";
		List <Product> list1=new LinkedList<Product>();
		try {
			PreparedStatement ps=ConnectionManager.getConnection().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Product product=new Product();
				//rs.getString("firstname");
				product.setPid(rs.getString("pid"));
				product.setPname(rs.getString("pname"));
				product.setMsq(rs.getInt("msq"));
				product.setPrice(rs.getInt("price"));
				list1.add(product);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	/*	public List2<Product> displayAllUsers2() {
			// TODO Auto-generated method stub
			String sql="Select * from products";
			List2 <Product> list2=new LinkedList<Product>();
			try {
				PreparedStatement ps=ConnectionManager.getConnection().prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					Product product=new Product();
					//rs.getString("firstname");
					product.setPid(rs.getString("pid"));
					product.setPname(rs.getString("pname"));
					product.setMsq(rs.getString("msq"));
					product.setPrice(rs.getString("price"));
					list2.add(product);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}*/
		return list1;
		//return list2;

	}	
	//return list1;
}
