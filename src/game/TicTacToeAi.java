
public abstract class TicTacToeAi {
	public abstract int move (int[] fields);
	int playerId;
	
	public TicTacToeAi(int playerId) {
		this.playerId = playerId;
	}
}
