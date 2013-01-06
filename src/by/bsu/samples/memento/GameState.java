package by.bsu.samples.memento;

/**
 *
 * @author Areldar
 */
public class GameState implements IDraw {

    private int[][] cells;
	private int moves;
	
	public static final int AREA_SIZE = 9;

    public GameState( ) {
        cells = new int[AREA_SIZE][AREA_SIZE];
		moves = 0;
        for(int x = 0 ; x < AREA_SIZE ; x++)
        {
            for(int y = 0 ; y < AREA_SIZE ; y++){
				cells[x][y] = 0;	
			}
        }
    }
    /**
     * Хранитель, определенный в виде
     * внутреннего члена класса GameState-а
     */
    public void setElement( int x, int y, int nmbr)
    {
        cells[x][y] = nmbr;
        moves++;
    }

    public void draw() {
        for(int x = 0 ; x < AREA_SIZE ; x++)
        {
            for(int y = 0 ; y < AREA_SIZE ; y++)
			{
                System.out.print(String.valueOf(cells[x][y]).toString() + ' ');
			}
            System.out.print("\n");
        }
    }
	
    public class Memento {
        private int[][] state;
        private Memento() {
            state = new int[AREA_SIZE][AREA_SIZE];
        }
    }

    /* 
	 * Методы хозяина
     */
    public Memento createMemento( ) {
        Memento res = new Memento();
        for (int x = AREA_SIZE; --x>=0;)
		{
            for (int y = AREA_SIZE; --y>=0;)
			{
                res.state[x][y] = cells[x][y] ;
			}
		}
		return res;
    }

    public void setMemento( Memento mem ) {
        if( mem != null )
		{
            for (int x = AREA_SIZE; --x>=0;)
			{
				for (int y = AREA_SIZE; --y>=0;)
				{
					cells[x][y] = mem.state[x][y];
				}
			}
		}   
    }
}