package fr.uvsq.exo4_2;

import  fr.uvsq.exo4_2.commandes.Command;
import fr.uvsq.exo4_2.commandes.Quit;
import fr.uvsq.exo4_2.commandes.Undo;
import java.util.HashMap;

public class Interpreteur {
	
	private HashMap<String,Command> mapCommand;
	
	public Interpreteur() {
		mapCommand = new HashMap<String,Command>();
	}
	
	public void execute(final String name) throws Exception{
		
		if(this.mapCommand.containsKey(name)) {
			try {
				this.mapCommand.get(name).execute();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			throw new Exception();
		}
	}
	
	public void addCommand(final String name, final Command c) {
		this.mapCommand.put(name,c);
	}
	
	public void initInterpreteur() {
		Undo u = new Undo();
		Quit q = new Quit();
		
		this.mapCommand.put("undo",u);
		this.mapCommand.put("quit",q);
	}
	
}
