package daoImpl;

import java.util.List;

import modell.User;



public interface Register {
	public boolean save(User user);
	public List<User> displayAllUsers();
}
