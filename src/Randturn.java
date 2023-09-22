import java.util.*;
import java.security.SecureRandom;
public class Randturn {
	public static int doturn(ArrayList<Integer> state) {
		ArrayList<Integer> numlist = new ArrayList<Integer>();
		for (int i = 1; i < 10; i++) {
			if (state.contains(i) != true) {
				numlist.add(i);
			}	

		}
		SecureRandom numinbetween = new SecureRandom();
		int size = numlist.size();
		int tomoveindex = numinbetween.nextInt(size);
		int tomove = numlist.get(tomoveindex);
		return tomove;
	}

}
