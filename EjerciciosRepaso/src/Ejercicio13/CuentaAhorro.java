package Ejercicio13;

public class CuentaAhorro extends Cuenta{

	public CuentaAhorro(int a, double saldo) {
		super(a, 0.0);
		
	}
	
	@Override
    public void sacarDinero(double cantidad) {
    	if (getSaldo() - cantidad >= 0) {
            setSaldo(getSaldo() - cantidad);
            System.out.println("Cantidad retirada de la cuenta de ahorro: " + cantidad);
        } else {
            System.err.println("No se puede retirar una cantidad mayor al saldo en la cuenta de ahorro.");
        }
    }
    
    public String toString() {
        return "Cuenta Corriente - " + super.toString();
    }

}
