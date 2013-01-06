package memento;
import java.util.Stack;
/**
 *
 * @author training
 */
public class ControllerBad2 {
    private Stack<GameStateBad2> undostates;
	private Stack<GameStateBad2> redostates;
    private GameStateBad2 currentstate;
    public void addElement ( Integer x, Integer y ) {
//...
        undostates.push( currentstate );
		redostates.clear();
//...
    }
    public void Undo() {
        if( !( undostates.isEmpty( ) ) )
        {
            redostates.push( currentstate );
			currentstate = undostates.pop();
        }
    }
	public void Redo() {
        if( !( redostates.isEmpty( ) ) )
        {
			undostates.push( currentstate );
            currentstate = redostates.pop();
        }
    }
//...
}