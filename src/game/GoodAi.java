
public class GoodAi extends TicTacToeAi{

	public GoodAi(int playerId) {
		super(playerId);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int move(int[] fields) {
		if(fields[4] == 0)
			return 4;
		
		int num = 0;
		for(int i = 0; i<9; i++)
			if(fields[i] != 0)
				num++;
		if(num == 1)
			return 0;
		
		for(int i=0; i<9; i++) {
			if(fields[i] == 0) {
				fields[i] = playerId;
				if(TicTacToe.testWin(fields) == playerId) {
					for(int j=0; j<9; j++)
						System.out.print(fields[j]);
					System.out.println(" winning action " + i);
					return i;
				}
				fields[i] = 0;
				
			}
		}
		for(int i=0; i<9; i++) {
			if(fields[i] == 0) {				
				fields[i] = 3-playerId;
				if(TicTacToe.testWin(fields) == 3-playerId) {
					for(int j=0; j<9; j++)
						System.out.print(fields[j]);
					System.out.println(" lose prevent " + i);
					return i;
				}
				fields[i] = 0;
			}
		}

		for(int i = 0; i<9; i++) {
			if(fields[i] == 0)
				return i;
		}
		
		return 0;
	}
	
}
