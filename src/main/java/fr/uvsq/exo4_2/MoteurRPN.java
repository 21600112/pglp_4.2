package fr.uvsq.exo4_2;

import fr.uvsq.exo4_2.operation.*;
import java.util.Stack;
import java.util.HashMap;
import fr.uvsq.exo4_2.commandes.*;

public class MoteurRPN {
	
	private Stack<Double> stackOperandes;
	private HashMap<String,Operation> stackOperations;
	private Undo u;
	
	public MoteurRPN(final Stack <Double> pOperandes,Undo pU){
		stackOperandes = pOperandes;
		stackOperations = new HashMap<String,Operation>();
		u = pU;
		this.stackOperations.put("+",new Addition());
		this.stackOperations.put("-",new Soustraction());
		this.stackOperations.put("*",new Multiplication());
		this.stackOperations.put("/",new Division());
	}
	
	public void addOperande(final Double pOperande) {
		stackOperandes.push(pOperande);
	}
	
	public void executeOperation(final String pOperation) throws Exception{
		if(stackOperations.containsKey(pOperation))
		{
			if(stackOperandes.size()>=2) {
				double ope2 = this.stackOperandes.pop();
				double ope1 = this.stackOperandes.pop();
				
				try {
					double res = this.stackOperations.get(pOperation).execute(ope1,ope2);
					this.stackOperandes.push(res);
					u.actualisationStack();
				}
				catch(Exception e) {
					this.stackOperandes.push(ope1);
					this.stackOperandes.push(ope2);
					e.printStackTrace();
				}
			}
		}
		else {
			throw new Exception();
		}
	}
	
	public void printOperandes() {
		for(int i=0;i<this.stackOperandes.size();i++){
			System.out.println(this.stackOperandes.get(i));
		}
	}
	
	// add une methode pour ajouter une commande comme modulo par exemple
	
}
