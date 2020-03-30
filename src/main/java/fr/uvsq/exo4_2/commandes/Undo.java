package fr.uvsq.exo4_2.commandes;
import java.util.Stack;

public class Undo implements Command{
	
	private Stack<Double> stackActuel;
	private Stack<Stack<Double>> stackList;
	
	public Undo(Stack<Double> pStack) {
		stackActuel = pStack;
		stackList = new Stack<Stack<Double>>();
	}
	
	public void actualisationStack() {
		Stack<Double> stackTransi = (Stack<Double>) stackActuel.clone();
		stackList.push(stackTransi);
	}
	
	
	public void execute() {
		if(!stackList.isEmpty())
		{
			while(!stackActuel.isEmpty())
			{
				stackActuel.pop();
			}
			
			stackList.pop();
			for(int i=0;i<stackList.get(stackList.size()-1).size();i++) {
				stackActuel.push(stackList.get(stackList.size()-1).get(i));
			}
		}
	}
}
