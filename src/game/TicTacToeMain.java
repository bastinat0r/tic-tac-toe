
public class TicTacToeMain {

	public static void main(String[] args) {
		System.out.println("TicTacToe");
		
		TicTacToeAi[] ais = {new DumbAi(1), new DumbAi(2)};
		TicTacToe t = new TicTacToe();
		
		int i = 0;
		int win = 0;
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
		System.out.println("player " + win + "wins!");
	}
}
