package user;

import java.util.HashMap;
import java.util.Map;

public class CommentFactory {
	
	private static Map<Integer, String> comments;

	private static void init() {
		comments = new HashMap<Integer, String>();
		comments.put(0, "Muito bom!");
		comments.put(1, "Excelente video");
		comments.put(2, "Gostei muito");
		comments.put(3, "Bacana");
		comments.put(4, "Achei interessante");
	}

	public static String get(Integer i) {
		if (comments == null)
			init();
		return comments.get(i);
	}
}
