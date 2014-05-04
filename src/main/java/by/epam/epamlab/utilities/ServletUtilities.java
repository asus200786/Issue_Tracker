package by.epam.epamlab.utilities;

import by.epam.epamlab.model.beans.User;
import by.epam.epamlab.model.enums.RolesUser;

public class ServletUtilities {

	public ServletUtilities() {
		super();
	}

	public static String headerWithTitle(String title) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<!doctype html>\n");
		stringBuilder.append("<html lang=\"en\">\n");
		stringBuilder.append("<head>\n<meta charset=\"UTF-8\">\n<title>");
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
		if (user==null) {
			// method="post" as a servlet causes doPost servers for data entered
			// into the form
			stringBuilder.append("<div class=\"WelcomeMessage\"><h2>Welcome,")
					.append(RolesUser.GUEST).append("</h2></div>");
			stringBuilder
					.append("<form name=\"login\" method=\"post\" action=\"/IssueTracker/LoginController\" class=\"loginForm\">\n");
			stringBuilder.append("<label for=\"login\">Login: </label>\n");
			stringBuilder
					.append("<input type=\"text\" name=\"login\" size=\"25\" required=\"required\" class=\"inputLogin\">\n");
			stringBuilder
					.append("<label for=\"password\">Password: </label>\n");
			stringBuilder
					.append("<input type=\"text\" name=\"password\" size=\"25\" required=\"required\" class=\"inputPassword\">\n");
			stringBuilder.append("<input type=\"submit\" value=\"Log In\">\n");
			stringBuilder.append("</form>\n");

		} else {
			stringBuilder.append("<div class=\"userMenu\">\n");
			stringBuilder.append("<div class=\"WelcomeMessage\"><h2>Welcome, ")
					.append(user.getFirstName()).append(user.getLastName())
					.append("!</h2></div>\n");
			stringBuilder.append("<ul class=\"userActions\">");
			stringBuilder.append("<li><a href=\"#\">Edit profile</a></li>\n");
			stringBuilder
					.append("<li><a href=\"#\">Change password</a></li>\n");
			stringBuilder
					.append("<li><button>Submit Issue</button></li></ul>n");

			stringBuilder
					.append("<li><a href=\"/IssueTracker/LogoutController\">Logout</a></li>\n");
			stringBuilder.append("</ul></div>");
			if (user.getRole().equals(RolesUser.ADMINISTRATOR)) {
				stringBuilder.append("<div class=\"adminMenu\">\n");
				stringBuilder
						.append("<div><h3>Menu administrator's.</h3></div>\n");
				stringBuilder.append("<ul><li>");
				stringBuilder.append("<ul class=\"submenu\">\n");
				stringBuilder.append("<li><a href=\"#\">Projects</a></li>\n");
				stringBuilder.append("<li><a href=\"#\">Statuses</a></li>\n");
				stringBuilder
						.append("<li><a href=\"#\">Resolutions</a></li>\n");
				stringBuilder.append("<li><a href=\"#\">Priorities</a></li>\n");
				stringBuilder.append("<li><a href=\"#\">Types</a></li>\n");
				stringBuilder.append("</ul></li><li><ul>");
				stringBuilder
						.append("<li><a href=\"#\">Add Project</a></li>\n");
				stringBuilder
						.append("<li><a href=\"#\">Add Resolution</a></li>\n");
				stringBuilder
						.append("<li><a href=\"#\">Add Priority</a></li>\n");
				stringBuilder.append("<li><a href=\"#\">Add Type</a></li>\n");
				stringBuilder.append("</ul></li>");
				stringBuilder
						.append("<li><a href=\"#\">Search user</a></li>\n");
				stringBuilder.append("<li><a href=\"#\">Add user</a></li>\n");
				stringBuilder.append("</ul></div>\n");
			}
		}
		stringBuilder.append("</div>\n");
		return stringBuilder.toString();
	}

	public static String issuesListFragment(User user) {
		StringBuilder stringBuilder = new StringBuilder();
		
		return stringBuilder.toString();
	}

	public static String footer() {
		return ("</div>\n</body>\n</html>\n");
	}
}
