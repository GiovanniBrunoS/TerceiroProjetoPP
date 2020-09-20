package video.playlist;

import java.util.Stack;

public class CommandExecuter {
	private Stack<Commands> done;
	private Stack<Commands> undone;

	public CommandExecuter() {
		super();
		this.done = new Stack<Commands>();
		this.undone = new Stack<Commands>();
	}

	public void execute(Commands c) {
		done.push(c);
		undone.clear();
		c.doAction();
	}

	public void undo() {
		if (!done.isEmpty()) {
			Commands c = done.pop();
			undone.push(c);
			c.undoAction();
		}
	}

	public void redo() {
		if (!undone.isEmpty()) {
			Commands c = undone.pop();
			done.push(c);
			c.doAction();
		}	
	}
}
