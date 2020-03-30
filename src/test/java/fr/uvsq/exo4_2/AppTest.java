package fr.uvsq.exo4_2;

import org.junit.Test;
import static org.junit.Assert.*;
import fr.uvsq.exo4_2.operation.*;
import fr.uvsq.exo4_2.commandes.*;
import java.util.Stack;

/**
 * Unit test for simple App.
 */
public class AppTest
{

	@Test
	public void additionWork() {
		Addition a = new Addition();
		assertTrue(a.execute(1.0,1.0) == 2.0);
	}
	
	@Test
	public void soustractionWork() {
		Soustraction s = new Soustraction();
		assertTrue(s.execute(1.0,1.0) == 0.0);
	}
	
	@Test
	public void multiplicationWork() {
		Multiplication m = new Multiplication();
		assertTrue(m.execute(1.0,1.0) == 1.0);
	}
	
	@Test(expected=Exception.class)
	public void divisionWork() throws Exception{
		Division d = new Division();
		assertTrue(d.execute(4.0,2.0) == 2.0);
	}
	
	@Test
	public void undoWork() {
		Stack <Double> stack = new Stack<Double>();
		Undo u = new Undo(stack);
		stack.push(3.0);
		u.actualisationStack();
		stack.push(4.0);
		u.actualisationStack();
		stack.push(5.0);
		u.actualisationStack();
		
		u.execute();
		assertTrue(stack.size() == 2);
	}
	
	@Test(expected=Exception.class)
	public void executeInterpreteurUndo() throws Exception{
		Stack <Double> stack = new Stack<Double>();
		Undo u = new Undo(stack);
		Interpreteur i = new Interpreteur(u);
		i.execute("undo");
		
	}
	
	@Test(expected=Exception.class)
	public void executeOperationMoteurAddition() throws Exception{
		Stack <Double> stack = new Stack<Double>();
		Undo u = new Undo(stack);
		MoteurRPN m = new MoteurRPN(stack,u);
		m.addOperande(2.0);
		u.actualisationStack();
		m.addOperande(3.0);
		u.actualisationStack();
		m.executeOperation("+");
		
	}
	
	@Test(expected=Exception.class)
	public void failExecuteOperationMoteurAddition() throws Exception{
		Stack <Double> stack = new Stack<Double>();
		Undo u = new Undo(stack);
		MoteurRPN m = new MoteurRPN(stack,u);
		m.addOperande(2.0);
		u.actualisationStack();
		m.addOperande(3.0);
		u.actualisationStack();
		m.executeOperation("è");
		
	}
	
	
}
