package by.epam.epamlab.utilities;

import by.epam.epamlab.model.beans.User;
import by.epam.epamlab.model.enums.RolesUser;

public class ServletUtilities {
	public static String headerWithTitle(String title) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<!doctype html>\n");
		stringBuilder.append("<html lang=\"en\">\n");
		stringBuilder
				.append("<head>\n<title>\n<meta charset=\"UTF-8\">\n<title>");
		stringBuilder.append(title).append("</title></head>\n<body>\n");
		stringBuilder.append("<div class=\"main\">\n");
		stringBuilder.append("<header>\n");
		stringBuilder.append("<div><h1>Join our Issue-Tracker</h1></div>");
		stringBuilder.append("</header>\n");
		return stringBuilder.toString();
	}

	public static String userMenuFragment(User user) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<div class=\"authentication\">\n");
		if (user.getRole() != RolesUser.USER
				&& user.getRole() != RolesUser.ADMINISTRATOR) {
			// method="post" as a servlet causes doPost servers for data entered
			// into the form
			stringBuilder.append("<div class=\"WelcomeMessage\"><h2>Welcome,")
					.append(RolesUser.GUEST).append("</h2></div>");
			stringBuilder
					.append("<form name=\"login\" method=\"post\" action=\"/IssueTracker/LoginController\" class=\"loginForm\">\n");
			stringBuilder.append("<label for=\"login\">Login: </label>\n");
			stringBuilder
					.append("<input type=\"text\" name=\"login: \" size=\"25\" required=\"required\" placeholder=\"Your login\" class=\"inputLogin\">\n");
			stringBuilder.append("<label for=\"password\">Login: </label>\n");
			stringBuilder
					.append("<input type=\"text\" name=\"password: \" size=\"25\" required=\"required\" placeholder=\"Your password\" class=\"inputPassword\">\n");
			stringBuilder.append("<input type=\"submit\" value=\"Log In\">\n");
			stringBuilder.append("</form>");

		} else {

			if (user.getRole() == RolesUser.ADMINISTRATOR) {

			}
		}
		stringBuilder.append("</div>\n");
		return stringBuilder.toString();
	}

	public static String issuesListFragment(User user) {
		return null;
	}

	public static String footer() {
		return ("</body>\n</html>\n");
	}
}
