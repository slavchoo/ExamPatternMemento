package memento;

/**
 *
 * @author training
 */
//Невозможно контролировать, что будет сохранено
public class GameStateBad2 implements IDraw{

    private Integer[][] cells;
	private Integer moves;

    public void setElement( Integer x, Integer y, Integer nmbr) {
        cells[x][y] = nmbr;
    }

    public void draw()    {
       for(int x = 0 ; x < 9 ; x++)
       {
           for(int y = 0 ; y < 9 ; y++)
               System.out.print(cells[x][y].toString() + ' ');
           System.out.print("\n");
       }
    }
    public GameStateBad2( ) {
        cells = new Integer[9][9];
        moves = 0;
    }
}