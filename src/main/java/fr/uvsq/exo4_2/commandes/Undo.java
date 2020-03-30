package fr.uvsq.exo4_2.commandes;
import java.util.Stack;

public class Undo implements Command{
	
	private Stack<Double> stack;
	
	public Undo(Stack<Double> pStack) {
		stack = pStack;
	}
	
	public void execute() {
		if(!stack.isEmpty())
		{
			stack.pop();
		}
	}
}
