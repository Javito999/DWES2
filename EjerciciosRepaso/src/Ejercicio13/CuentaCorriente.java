package Ejercicio13;

public class CuentaCorriente extends Cuenta {

	public CuentaCorriente(int a, double saldo) {
		super(a, 0.0);
		
	}
	 // Override del método sacarDinero - permite quedarse en negativo
    @Override
    public void sacarDinero(double cantidad) {
    	 setSaldo(getSaldo() - cantidad);
	        System.out.println("Cantidad retirada de la cuenta corriente: " + cantidad);
    }
    
    public String toString() {
        return "Cuenta Corriente - " + super.toString();
    }
	
	
	
	
	

}
