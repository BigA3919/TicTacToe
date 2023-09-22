import java.security.SecureRandom;
import java.util.*;
public class minimax {
	public static int bestmovecalc(ArrayList<Integer> node, Boolean max) {
		String checkifdone = toolbox.checkifdone(node);
		if (checkifdone != "false") {
			if (checkifdone == "O") {
				return -1;
			} else {
				return 1;
			}
		}
		ArrayList<Integer> remainingoptions = new ArrayList<Integer>();
		
		for (int i = 1; i < 10; i++) {
			if (node.contains(i) != true) {
				remainingoptions.add(i);
			}
		}
		if (remainingoptions.isEmpty()) {
			return 0;
		}
		if (max) {
			int bestvalue = -999;
			for (int i : remainingoptions) {
				ArrayList<Integer> movetomake = new ArrayList<Integer>();
				for (int x : node) {
					movetomake.add(x);
				}
				movetomake.add(i);
				int v = bestmovecalc(movetomake, false);
				if (v > bestvalue){
					bestvalue = v;
				} else if (v == bestvalue) {
					SecureRandom rand = new SecureRandom();
					if (rand.nextInt(2) == 1) {
						bestvalue = v;
					}
					
				}
				movetomake.clear();
			}
			return bestvalue;
		} else {
			int bestvalue = 999;
			for (int i : remainingoptions) {
				ArrayList<Integer> movetomake = new ArrayList<Integer>();
				for (int x : node) {
					movetomake.add(x);
				}
				movetomake.add(i);
				int v = bestmovecalc(movetomake, true);
				if (v < bestvalue) {
					bestvalue = v;
				} else if (v == bestvalue) {
					SecureRandom rand = new SecureRandom();
					if (rand.nextInt(2) == 1) {
						bestvalue = v;
					}
					
				}
				movetomake.clear();
			}
			
			return bestvalue;
		}
	}
	public static int domove(ArrayList<Integer> board2, Boolean X) {
				ArrayList<Integer> remainingoptions = new ArrayList<Integer>();
		for (int i = 1; i < 10; i++) {
			if (board2.contains(i) != true) {
				remainingoptions.add(i);
			}	

		}
		ArrayList<Integer> movetomake = new ArrayList<Integer>();
		for (int x : board2) {
			movetomake.add(x);
		}
		movetomake.add(0);
		int size = movetomake.size()-1;

		if (X) {
			
			int bestvalue = -999;
			int bestmove = 23;
			for (int i : remainingoptions) {
				movetomake.set(size, i);				
				int v = bestmovecalc(movetomake, false);
				if (v > bestvalue){
					bestvalue = v;
					bestmove = i; 
				}else if (v == bestvalue) {
					SecureRandom rand = new SecureRandom();
					if (rand.nextInt(2) == 1) {
						bestvalue = v;
						bestmove = i;
					}
					
				}
			}
			return bestmove;
		} else {
			int bestvalue = 999;
			int bestmove = 23;
			for (int i : remainingoptions) {
				movetomake.set(size, i);
				int v = bestmovecalc(movetomake, true);
				if (v < bestvalue) {
					bestvalue = v;
					bestmove = i;
				} else if (v == bestvalue) {
					SecureRandom rand = new SecureRandom();
					if (rand.nextInt(2) == 1) {
						bestvalue = v;
						bestmove = i;
					}					
				}				
			}
			return bestmove;
		}
	} 
}
