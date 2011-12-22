
public class WargamesAi extends TicTacToeAi {

	public WargamesAi(int playerId) {
		super(playerId);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int move(int[] fields){
		System.out.println("The only winng-move is not to play!");
		return 0;
	}

}
