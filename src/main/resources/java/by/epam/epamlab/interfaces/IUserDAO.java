package by.epam.epamlab.interfaces;

import by.epam.epamlab.model.beans.User;

public interface IUserDAO {
	public User getUser(String login, String password);
	
}
