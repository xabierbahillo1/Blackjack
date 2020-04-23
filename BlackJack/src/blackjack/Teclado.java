package blackjack;

import java.util.Scanner;

public class Teclado {
	//Atributos
	private static Teclado miTeclado;
	private Scanner sc;
	//Constructora
	private Teclado() {
		sc = new Scanner (System.in);
	}
	//Metodos
	public static Teclado getTeclado() {
		if (miTeclado==null) {
			miTeclado=new Teclado();
		}
		return miTeclado;
	}
	public String leerString() throws CaracterIncorrectoException  {
		String entrada=sc.nextLine();
		if (entrada.equals("1") ||(entrada.equals("2"))){
			return entrada;
		}
		else {
			throw new CaracterIncorrectoException();
		}
	}
	public String leerStringSinRestriccion() {
		String entrada=sc.nextLine();
		return entrada;
	}
}
