package fr.uvsq.exo4_2.commandes;

public class Quit implements Command{
	
	public Quit() {
		
	}
	
	public void execute() {
		System.out.println("Vous quittez le programme");
	}
}
