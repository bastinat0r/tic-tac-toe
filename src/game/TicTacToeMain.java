
public class TicTacToeMain {

	public static void main(String[] args) {
		System.out.println("TicTacToe");
		

		int numGames = 0;
		
		while(numGames < 20) {

			int win = 0;
			TicTacToeAi[] ais = {new RandomAi(1), new GoodAi(2)};
			TicTacToe t = new TicTacToe();
			
			
			int i = 0;
			while(win == 0) {
				System.out.println(t);
				try {
					win = t.setField(ais[i%2].move(t.getFields()), i%2+1);
					i++;
				} catch (Exception e) {
					e.printStackTrace();
					i++;
				}
			}

			System.out.println(t);
			System.out.println("player " + win + " wins!");
			numGames++;
		}
	}
}
