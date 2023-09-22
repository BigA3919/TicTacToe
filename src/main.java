import java.util.*;
public class main {
	public static boolean awin = false;
	public static int xwins = 0;
	public static int owins = 0;
	public static int ties = 0;
	public static int gameamount = 0;
	private static void playgame(Boolean print, int player1move, int player2move) {
		ArrayList<Integer> board = new ArrayList<Integer>();
		board.clear();
		Boolean X = true;
		for(int i = 1; i < 10; i++) {
			
			int newmove;
			if (X) {
				if (player1move == 1) {
					newmove = Randturn.doturn(board);
				} else if (player1move == 2){
					newmove = minimax.domove(board, true);
				} else {
					while (true) {
						Boolean isin = false;
						String userturn = toolbox.getUserInput("Your move!");
						int input = Integer.parseInt(userturn);
						for (int check : board) {
							if (input == check) {
								isin = true;
							}
						}
						if (isin || input > 9) {
							System.out.println("Illegal move! try again");
						} else {
							newmove = input;
							break;
						}
					}
				}
				X = false;
			} else {
				if (player2move == 1) {
					newmove = Randturn.doturn(board);
				} else if (player2move == 2){
					newmove = minimax.domove(board, false);
				} else {
					while (true) {
						Boolean isin = false;
						String userturn = toolbox.getUserInput("Your move!");
						int input = Integer.parseInt(userturn);
						for (int check : board) {
							if (input == check) {
								isin = true;
							}
						}
						if (isin) {
							System.out.println("Illegal move! try again");
						} else {
							newmove = input;
							break;
						}
					}

				}
				X = true;
			}
			
			
			board.add(newmove);
			if (print) {
				printboard.print(board);
			}
			
			String stillplaying = toolbox.checkifdone(board);

				
			if (stillplaying != "false") {
				awin = true;
				if (print) {
					System.out.println(stillplaying + " wins");
				}
				if (stillplaying == "X") {
					xwins++;
				} else {
					owins++;
				}
				break;
			}
			
		}
		if (awin == false) {
			if (print) {
				System.out.println("tie");
			}
			ties++;
		}
		awin = false;
		gameamount++;
	}
	public static void main (String[] args) {
		System.out.println("Tictactoe with AI");
		
		while (true) {
			
			String gameinput = toolbox.getUserInput("Choose a gamemode! \n enter 1 for spectating games \n 2 to let the bots play against eachother for a long time \n 3 to play against the bot");
			int gamemode = Integer.parseInt(gameinput);
			if (gamemode == 1) {
				String p1 = toolbox.getUserInput("Select the ai type for player one! \n 1 for random \n 2 for minimax");
				int playerone = Integer.parseInt(p1);
				String p2 = toolbox.getUserInput("Select the ai type for player two! \n 1 for random \n 2 for minimax");
				int playertwo = Integer.parseInt(p2);
				main.playgame(true, playerone, playertwo);
				
			} else if (gamemode == 2) {
				xwins = 0;
				owins = 0;
				ties = 0;
				String p1 = toolbox.getUserInput("Select the ai type for player one! \n 1 for random \n 2 for minimax");
				int playerone = Integer.parseInt(p1);
				String p2 = toolbox.getUserInput("Select the ai type for player two! \n 1 for random \n 2 for minimax");
				int playertwo = Integer.parseInt(p2);
				String gamea = toolbox.getUserInput("how many games should be played?");
				int games = Integer.parseInt(gamea);
				for (int i = 0; i < games; i++) {
					main.playgame(false, playerone, playertwo);
				}
				
				
				xwins = xwins * 100;
				owins = owins * 100;
				ties = ties * 100;
				System.out.println("X won " + (xwins / games) + "% of games");
				System.out.println("O won " + ((owins / games)) + "% of games");
				System.out.println("X and O tied " + ((ties / games)) + "% of games");
			} else {
				String x = toolbox.getUserInput("Do you want to be X or O? \n 1 for X \n 2 for O");
				int player = Integer.parseInt(x);
				String p = toolbox.getUserInput("Select the ai type you want to play! \n 1 for random \n 2 for minimax");
				int computer = Integer.parseInt(p);
				if (player == 1) {
					main.playgame(true, 3, computer);
				}else {
					main.playgame(true, computer, 3);
				}
			}
		}
	}
}
