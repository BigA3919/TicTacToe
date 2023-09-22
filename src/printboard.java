import java.util.*;
public class printboard {
	public static void print(ArrayList<Integer> moves){
		System.out.println("\n");
		int turn = 0;
		String[] spots = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
		for (int move : moves) {
			if (turn == 0) {
				spots[move - 1] = "X";
				turn = 1;
			} else {
				spots[move - 1] = "O";
				turn = 0;
			}
		}
		System.out.println(spots[0]+ "| " + spots[1] + "| " + spots[2]);
		System.out.println(spots[3]+ "| " + spots[4] + "| " + spots[5]);
		System.out.println(spots[6]+ "| " + spots[7] + "| " + spots[8]);
	}
}
