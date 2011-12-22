
public class RandomAi extends TicTacToeAi{

	public RandomAi(int playerId) {
		super(playerId);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int move(int[] fields) {
		int num = 0;
		for(int f : fields) {
			if (f == 0)
				num ++;
		}
		
		int ran = (int) (Math.random()*num);
		
		for(int i = 0; i<9; i++) {
			if (fields[i] == 0) {
				if(ran == 0)
					return i;
				
				ran--;
			}
		}
		return 0;
	}

}
