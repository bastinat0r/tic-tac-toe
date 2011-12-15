public class TicTacToe {
    private int[] fields;
    private int turn;

    public TicTacToe() {
	fields = new int[9];
	turn = 0;

	for(int f: fields) {
	    f = 0;
	}  
    }

    public int[] getFields() {
	return fields;
    }

    public void setField(int id, int player)  throws Exception {
	if(player != turn)
	    throw Exception("It's not your turn!");
	else if(id < 0 || id > 8)
	    throw Exception("ids have to be between 0 and 8");
	else {
	    fields[id] = player;
	    turn = 3 - turn;
	}

    }
}