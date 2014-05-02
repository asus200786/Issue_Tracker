package by.epam.epamlab.model.impls;

import java.io.IOException;
import java.util.Map;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.epam.epamlab.analyzer.sax.UserHandler;
import by.epam.epamlab.constants.Constants;
import by.epam.epamlab.exceptions.ExceptionDAO;
import by.epam.epamlab.interfaces.IUserDAO;
import by.epam.epamlab.model.beans.User;

public class UserImplXML implements IUserDAO {

	private Map<String, User> users;
	private static UserImplXML instance;

	private UserImplXML() throws ExceptionDAO {
		readingXML();
	}

	public synchronized static UserImplXML getImplXML() throws ExceptionDAO {
		if (instance == null) {
			instance = new UserImplXML();
		}
		return instance;
	}

	@Override
	public User getUser(String login, String password) {
		User user = users.get(login);
		if (user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

	private void readingXML() throws ExceptionDAO {
		try {
			XMLReader xmlReader = XMLReaderFactory.createXMLReader();
			UserHandler userHandler = new UserHandler();
			xmlReader.setContentHandler(userHandler);
			if (userHandler != null) {
				xmlReader.parse(Constants.INPUT_XML);
				users = userHandler.getUsers();
			}
		} catch (SAXException e) {
			System.out.println(Constants.ERROR_ANALYZER_SAX);
			e.printStackTrace();
			throw new ExceptionDAO(Constants.ERROR_ANALYZER_SAX);
		} catch (IOException e) {
			System.out.println(Constants.ERROR_IO_STREAM);
			e.printStackTrace();
			throw new ExceptionDAO(Constants.ERROR_IO_STREAM);
		}
	}

}
