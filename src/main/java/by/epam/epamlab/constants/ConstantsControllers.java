package by.epam.epamlab.constants;

import by.epam.epamlab.model.beans.User;

public class ConstantsControllers {
	// parameters
	public static final String MESSAGE = "message";
	public static final String USER = "user";
	public static final String EMAIL_ADDRESS = "emailAddress";
	public static final String LOGIN = "login";
	public static final String PASSWORD = "password";
	public static final String FILENAME = "filename";
	public static final User GUEST_USER = new User("Guest", "", "GUEST");

	public static String WELCOME_PAGE_TITLE = "Welcom page / Dashboard";
	// errors
	public static String ERROR_NULL = "Sorry. Please enter \"login\" and \"password\".";
	public static String ERROR_EMPTY = "Field\'s empty. Please enter \"login\" and \"password\".";
	public static String ERROR_AUTHORIZATION = "Error of authorization. Check that the input data.";
	// urls
	public static String WELCOME_PAGE_URL = "/WelcomePageController";

}
