package by.epam.epamlab.utilities;

public class ServletUtilities {
	public static String headerWithTitle(String title){
		StringBuilder stringBuilder = new StringBuilder("<html>\n<head>\n<title>\n");
		stringBuilder.append(title).append("</title></head>\n<body bgcolor=\"#fdf5e6\">\n");
		return stringBuilder.toString();
	}
	
	public static String footer() {
		return ("</body></html>\n");
	}
	
	public static String headerWithTitle(String title, String meta) {
		StringBuilder stringBuilder = new StringBuilder("<html>\n<head>\n<title>\n");
		stringBuilder.append(title).append("</title>").append(meta).append("</head>\n<body bgcolor=\"#fdf5e6\">\n");
		return stringBuilder.toString();
	}
}
