public class TicTacToe {
	private int[] fields;
	private int turn;

	public TicTacToe() {
		fields = new int[9];
		turn = 1;

		for(int f: fields) {
			f = 0;
		}  
	}

	public int[] getFields() {
		return fields;
	}

	public int setField(int id, int player)  throws Exception {
		if(player != turn)
			throw new Exception("It's not your turn!");
		else if(id < 0 || id > 8)
			throw new Exception("ids have to be between 0 and 8");
		else {
			fields[id] = player;
			turn = 3 - turn;
		}

		for(int i = 0; i<3; i++) {
			if(fields[i] == fields[3+i] && fields[i] == fields[6+i] && fields[i] != 0)
				return fields[i];
			if(fields[3*i] == fields[3*i+1] && fields[3*i] == fields[3*i+2] && fields[3*i] != 0)
				return fields[3*i];
		}
		
		if(fields[0] == fields[4] && fields[4] == fields[8] && fields[0] != 0)
			return fields[0];
		
		if(fields[2] == fields[4] && fields[4] == fields[6] && fields[2] != 0)
			return fields[2];
		
		return 0;

	}
}