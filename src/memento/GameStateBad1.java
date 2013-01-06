/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memento;

/**
 *
 * @author training
 */
//нарушение инкапсуляции
public class GameStateBad1 implements IDraw {

    private Integer[][] cells;
	private Integer moves;

    public void setElement( Integer x, Integer y, Integer nmbr) {
        cells[x][y] = nmbr;
    }

    public GameStateBad1( ) {
        cells = new Integer[9][9];
		moves = 0;

    }
    public void draw() {
        for(int x = 0 ; x < 9 ; x++)
        {
            for(int y = 0 ; y < 9 ; y++)
                System.out.print(cells[x][y].toString() + ' ');
            System.out.print("\n");
        }
    }
    public GameStateBadMemento getState( ) {
		GameStateBadMemento res = new GameStateBadMemento( );
		res.cells = this.cells;
        return res;
    }
	public void setState( GameStateBadMemento istate) {
		this.cells = istate.cells;
    }
}
class GameStateBadMemento {
	public Integer[][] cells;
	public GameStateBadMemento( ){
		cells = new Integer[9][9];
	}
}