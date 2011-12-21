
public class DumbAi extends TicTacToeAi {

	public DumbAi(int playerId) {
		super(playerId);
	}

	@Override
	public int move(int[] fields) {

		for(int i = 0; i<fields.length; i++) {
			if(fields[i] == 0)
				return i;
		}
		return 0;

	}

}
