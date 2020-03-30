package fr.uvsq.exo4_2.operation;

public class Division implements Operation{
	
	public Division() {
		
	}
	
	public double execute(final double ope1, final double ope2) throws Exception {
		
		if(ope2 == 0)
		{
			System.err.println("Il ets impossible de diviser par 0");
			throw new Exception();
		}
		return ope1 / ope2;
	}

}
