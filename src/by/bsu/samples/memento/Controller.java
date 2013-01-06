package by.bsu.samples.memento;
import java.util.Stack;
/**
 *
 * @author Areldar
 */
public class Controller {
    private Stack<GameState.Memento> undostates;
    private Stack<GameState.Memento> redostates;
    private GameState currentstate;

    public Controller(GameState workingstate) {
        currentstate = workingstate;
        undostates = new Stack<GameState.Memento>();
        redostates = new Stack<GameState.Memento>();
    }

    public void addElement ( int x, int y, int nmbr ) {
//...
        undostates.push( currentstate.createMemento( ) );
        currentstate.setElement(x, y, nmbr);
		redostates.clear();
//...
    }
	
    public void undo() {
        if(!undostates.isEmpty())
        {
            redostates.push( currentstate.createMemento() );
            currentstate.setMemento( undostates.pop() );
        }
    }
	
    public void redo() {
		if(!redostates.isEmpty())
		{
			undostates.push( currentstate.createMemento() );
			currentstate.setMemento( redostates.pop() );
		}
    }
//...
}
