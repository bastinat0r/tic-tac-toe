public class Grid implements Comparable<Grid> {
    private int[] grid;

    public int[] getGrid() { return this.grid; }
    public int[] get()     { return this.grid; }

    public int size() {
        return (int)Math.sqrt( this.grid.length );
    }

    public Grid( int[] grid ) {
        this.grid = grid;
    }

    public Grid( int[][] grid ) {
        this( from2D( grid ) );
    }

    public Grid rotate(){
        int[][] grid = this.to2D();
        int[][] newGrid = new int[ grid[0].length ][ grid.length ];
        for( int y = 0; y < grid.length; y++ ) {
            for( int x = 0; x < grid.length; x++ ) {
                newGrid[x][y] = grid[ grid.length - y - 1 ][x];
            }
        }
        return new Grid( newGrid );
    }

    public Grid mirror() {
        int[][] grid = this.to2D();
        for ( int i = 0, minus_i = grid.length - 1; i < (grid.length / 2) - 1; i++, minus_i-- )  {
            int[] buffer = grid[i];
            grid[i] = grid[ minus_i ];
            grid[minus_i] = buffer;
        }
        return new Grid( grid );
    }

    public int hash(){
        int hash = 0;
        for( int i = grid.length - 1; i >= 0; i-- ){
            hash += grid[i] * (int)Math.pow(3,i);
        }
        return hash;
    }
    
    public Grid normalize() {
        Grid[] allGrids = new Grid[8];
        allGrids[0] = this;
        allGrids[1] = this.mirror();
        for( int i = 2; i < allGrids.length; i++ )
            allGrids[i] = allGrids[i - 2].rotate();
        Grid smallest = allGrids[0];
        for( int i = 1; i < allGrids.length; i++ ) {
            if ( allGrids[i].compareTo( smallest ) < 0 )
                smallest = allGrids[i];
        }
        return smallest;
    }

    public int[][] to2D() {
        int size = this.size();
        int[][] newGrid = new int[ size ][ size ];
        for( int i = 0; i < this.grid.length; i++ ) {
            newGrid[ i / size ][ i % size ] = this.grid[i];
        }
        return newGrid;
    }

    public void print() {
        for(int i=0;i<this.grid.length;i++) System.out.print( this.grid[i] + " " );
        System.out.println();
    }

    public int compareTo( Grid grid ) {
        return ( new Integer(this.hash()) ).compareTo( new Integer( grid.hash() ) );
    }

    private static int[] from2D( int[][] grid ) {
        int[] newGrid = new int[ grid.length * grid[0].length ];
        for( int y = 0; y < grid.length; y++ ) {
            for( int x = 0; x < grid[y].length; x++ ) {
                newGrid[y * grid[y].length + x] = grid[y][x];
            }
        }
        return newGrid;
    }
}
