package by.epam.epamlab.analyzer.sax;

import java.util.HashMap;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.epam.epamlab.model.beans.User;

public class UserHandler extends DefaultHandler {
	private static final String START_PARSE_XML = "Start parse XML.";
	private static final String STOP_PARSE_XML = "Stop parse XML.";
	private String login;
	UserAttrEnum thisElement = null;
	private final Map<String, User> users;

	private final static int ID_ATTR_INDEX = 0;
	private final static int FIRSTNAME_ATTR_INDEX = 1;
	private final static int LASTNAME_ATTR_INDEX = 2;
	private final static int EMAILADDRESS_ATTR_INDEX = 3;
	private final static int PASSWORD_ATTR_INDEX = 4;
	private final static int ROLE_ATTR_INDEX = 5;

	private enum UserAttrEnum {
		USER, ID, FIRSTNAME, LASTNAME, EMAILADDRESS, PASSWORD, ROLE
	}

	public UserHandler() {
		super();
		this.users = new HashMap<String, User>();
	}

	public Map<String, User> getUsers() {
		return users;
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println(START_PARSE_XML);
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		thisElement = UserAttrEnum.valueOf(localName.toUpperCase());
		if (UserAttrEnum.USER.equals(thisElement)) {
			int id = Integer.parseInt(attributes.getValue(ID_ATTR_INDEX));
			String firstName = attributes.getValue(FIRSTNAME_ATTR_INDEX);
			String lastName = attributes.getValue(LASTNAME_ATTR_INDEX);
			String emailAddress = attributes.getValue(EMAILADDRESS_ATTR_INDEX);
			String password = attributes.getValue(PASSWORD_ATTR_INDEX);
			String role = attributes.getValue(ROLE_ATTR_INDEX);
			users.put(login, new User(id, firstName, lastName, emailAddress,
					password, role));
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		super.characters(ch, start, length);
		if (UserAttrEnum.EMAILADDRESS.equals(thisElement)) {
			String emailAddress = new String(ch, start, length);
			login = emailAddress;
		}
		thisElement = null;
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println(STOP_PARSE_XML);
	}

}
