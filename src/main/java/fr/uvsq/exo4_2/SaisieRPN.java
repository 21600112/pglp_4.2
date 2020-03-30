package fr.uvsq.exo4_2;

import java.util.Scanner;
import java.util.Stack;
import fr.uvsq.exo4_2.commandes.Undo;

public class SaisieRPN {
	
	private MoteurRPN m;
	private Interpreteur i;
	private Stack<Double> stackOperandes;
	private Scanner s;
	
	public SaisieRPN() {
		stackOperandes = new Stack<Double>();
		Undo u = new Undo(stackOperandes);
		i = new Interpreteur(u);
		m = new MoteurRPN(stackOperandes);
		
	}
	
	public void calcul() throws Exception{
		
		s = new Scanner(System.in);
		String line="";
		boolean notQuit= true;
		
		while(notQuit) {
			
			try {
				double d = s.nextDouble();
				m.addOperande(d);
			}
			catch(Exception moteurOperande) {
				try {
					line = s.nextLine();
					m.executeOperation(line);
					
				}
				catch(Exception moteurOperation){
					try {
						i.execute(line);
					}
					catch(Exception interpreteur) {
						interpreteur.printStackTrace();
					}
				}
				
			}
			
			if(line.equals("quit")) {
				notQuit = false;
			}
			else {
				m.printOperandes();
			}
		}
		s.close();
		
	}
}
