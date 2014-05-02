package by.epam.epamlab.factories;

import by.epam.epamlab.exceptions.ExceptionDAO;
import by.epam.epamlab.interfaces.IUserDAO;
import by.epam.epamlab.model.impls.UserImplXML;

public class UserFactory {

	public static IUserDAO getClassFromFactory() throws ExceptionDAO {
		return UserImplXML.getImplXML();
	}
}
