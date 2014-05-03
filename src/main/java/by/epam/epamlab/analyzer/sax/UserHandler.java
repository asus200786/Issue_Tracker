package by.epam.epamlab.analyzer.sax;

import java.util.HashMap;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.epam.epamlab.constants.ConstantsControllers;
import by.epam.epamlab.model.beans.User;

public class UserHandler extends DefaultHandler {
	private static final String USERS = "users";
	private static final String START_PARSE_XML = "Start parse XML.";
	private static final String STOP_PARSE_XML = "Stop parse XML.";

	private final Map<String, User> users;
	private User currUser = null;
	private UserEnum currUserEnum = null;

	private final static int LOGIN_ATTR_INDEX = 0;
	private final static int PASSWORD_ATTR_INDEX = 1;
	private final static int ROLE_ATTR_INDEX = 2;

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
		if (qName.equals(ConstantsControllers.USER)) {
			currUser = new User();
			currUser.setLogin(attributes.getValue(LOGIN_ATTR_INDEX));
			currUser.setPassword(attributes.getValue(PASSWORD_ATTR_INDEX));
			currUser.setRole(attributes.getValue(ROLE_ATTR_INDEX));
		}
		if (!ConstantsControllers.USER.equals(qName) && !qName.equals(USERS)) {
			currUserEnum = UserEnum.valueOf(qName.toUpperCase());
			// String firstName = attributes.getValue(FIRSTNAME_ATTR_INDEX);
			// String lastName = attributes.getValue(LASTNAME_ATTR_INDEX);
			// String emailAddress =
			// attributes.getValue(EMAILADDRESS_ATTR_INDEX);
			// users.put(emailAddress, new User(id, firstName, lastName,
			// emailAddress, password, role));
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (qName.equals(ConstantsControllers.USER))
			users.put(currUser.getLogin(), currUser);
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		String string = new String(ch, start, length);
		if (currUserEnum == null)
			return;
		switch (currUserEnum) {
		case FIRSTNAME:
			currUser.setFirstName(string);
			break;
		case LASTNAME:
			currUser.setLastName(string);
			break;
		case EMAILADDRESS:
			currUser.setEmailAddress(string);
			break;
		}
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println(STOP_PARSE_XML);
	}

}
