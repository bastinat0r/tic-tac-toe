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
		return fields.clone();
	}
	
	public static int testWin(int[] fields) {
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
		
		boolean allOccupyed = true;
		for(int f: fields) {
			if(f == 0) {
				allOccupyed = false;
				break;
			}
		}
		
		if(allOccupyed)
			return 3;
		
		return 0;
	}
	
	public int testWin() {
		return testWin(fields);
	}

	public int setField(int id, int player)  throws Exception {
		if(player != turn)
			throw new Exception("It's not your turn player " + player +"!");
		else if(id < 0 || id > 8)
			throw new Exception("ids have to be between 0 and 8");
		else {
			if(fields[id] != 0)
				throw new Exception("Field arlready occupyed!");
			fields[id] = player;
			turn = 3 - turn;
		}

		return testWin();

	}
	
	public String toString() {
		String rVal = "";
		
		for(int i = 0; i<9; i++) {
			if(i%3 == 0) {
				rVal = rVal + "\n";
			}
			rVal = rVal + fields[i];
			
		}
		return rVal;
	}
}