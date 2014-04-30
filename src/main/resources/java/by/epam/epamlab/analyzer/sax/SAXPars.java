package by.epam.epamlab.analyzer.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.epam.epamlab.constants.Constants;
import by.epam.epamlab.model.beans.User;

public class SAXPars extends DefaultHandler {

	User user = new User();
	String thisElement = "";

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Start parse XML.");
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		thisElement = qName;
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if (thisElement.equals("id")) {
			user.setIdUser(new Integer(new String(ch, start, length)));
		}

		if (thisElement.equals("firstName")) {
			user.setFirstName(new String(ch, start, length));
		}

		if (thisElement.equals("lastName")) {
			user.setLastName(new String(ch, start, length));
		}

		if (thisElement.equals("password")) {
			user.setPassword(new String(ch, start, length));
		}
		if (thisElement.equals("emailAddress")) {
			user.setEmailAddress(new String(ch, start, length));
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		thisElement = Constants.EMPTY_STRING;
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("Stop parse XML.");
	}

}
