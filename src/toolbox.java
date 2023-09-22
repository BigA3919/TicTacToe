import java.util.*;
import java.io.*;
public class toolbox {
	public static String checkifdone (ArrayList<Integer> board) {
		ArrayList<Integer> Olist = new ArrayList<Integer>();
		ArrayList<Integer> Xlist = new ArrayList<Integer>();
		for (int i = 0; i < board.size(); i++) {
			int numtoadd = board.get(i);
			if (i % 2 == 0) {
				Xlist.add(numtoadd);
			} else {
				Olist.add(numtoadd);
			}
		}
		for (int i = 1; i < 3; i++) {
			String XorO;
			if (i == 1) {
				board = Xlist;
				XorO = "X";
			} else {
				board = Olist;
				XorO = "O";
			}
			if (board.contains(1)){
				if (board.contains(2) && board.contains(3)) {
					return XorO;
				}
				if (board.contains(4) && board.contains(7)) {
					return XorO;
				}
			}
			if (board.contains(9)) {
				if (board.contains(6) && board.contains(3)) {
					return XorO;
				}
				if (board.contains(8) && board.contains(7)) {
					return XorO;
				}
			}
			if (board.contains(5)) {
				if (board.contains(2) && board.contains(8)) {
					return XorO;
				}
				if (board.contains(4) && board.contains(6)) {
					return XorO;
				}
				if (board.contains(1) && board.contains(9)) {
					return XorO;
				}
				if (board.contains(3) && board.contains(7)) {
					return XorO;
				}
			}
			
		}
		return "false";
	}
	public static String getUserInput(String prompt) {
		String inputLine = null;
		System.out.print(prompt + " ");
		try {
			BufferedReader is = new BufferedReader(
			new InputStreamReader(System.in));
			inputLine = is.readLine();
			if (inputLine.length() == 0) return null;
		} catch (IOException e) {
			System.out.println("IOException: " + e);
		}
		return inputLine.toLowerCase();
	}
}
