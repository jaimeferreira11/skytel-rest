package py.com.skytel.jaimeferreira.utils;

public class CustomStringUtils {

	public static String getVowelsFromText(String text) {

		String str1 = text.replaceAll("(?i)[^aeiou]", "");
		return str1;

	}

}
