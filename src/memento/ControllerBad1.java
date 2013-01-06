package memento;
import java.util.Stack;
/**
 *
 * @author training
 */
public class ControllerBad1 {
    private Stack<GameStateBadMemento> undostates;
	private Stack<GameStateBadMemento> redostates;
    private GameStateBad1 currentstate;
    public void addElement ( Integer x, Integer y ) {
//...
        undostates.add( currentstate.getState( ) );
		redostates.clear();
//...
    }
    public void undo() {
        if( !( undostates.isEmpty( ) ) )
        {
            redostates.push( currentstate.getState( ) );
			currentstate.setState( undostates.pop() );
        }
    }
	public void redo() {
        if( !( redostates.isEmpty( ) ) )
        {
			undostates.push( currentstate.getState( ) );
            currentstate.setState( redostates.pop() );
        }
    }
//...
}