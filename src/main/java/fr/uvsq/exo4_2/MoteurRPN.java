package fr.uvsq.exo4_2;

import fr.uvsq.exo4_2.operation.*;
import java.util.Stack;
import java.util.HashMap;
import fr.uvsq.exo4_2.commandes.*;

public class MoteurRPN {
	
	private Stack<Double> stackOperandes;
	private HashMap<String,Operation> stackOperations;
	
	public MoteurRPN(final Stack <Double> pOperandes){
		stackOperandes = pOperandes;
		stackOperations = new HashMap<String,Operation>();	
		this.stackOperations.put("addition",new Addition());
		this.stackOperations.put("soustraction",new Soustraction());
		this.stackOperations.put("multiplication",new Multiplication());
		this.stackOperations.put("division",new Division());
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
					this.stackOperations.get(pOperation).execute(ope1,ope2);
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
