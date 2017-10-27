package lab4_1produtorconsumidor;

public class Dropbox {
	private int number;
	private boolean evenNumber = false;
	private boolean isEmpty;

	public int take(final boolean even) {
		System.out.format("%s CONSUMIDOR obtem %d.%n", even ? "PAR" : "IMPAR", number);
		this.isEmpty = true;
		return this.number;
	}

	public void put(int number) {
		this.number = number;
		setEvenNumber(number % 2 == 0);
		this.isEmpty = false;
		System.out.format("\nPRODUTOR gera %d.%n", number);
	}
	
	public boolean isEmpty() {
		return this.isEmpty;
	}

	public boolean isEvenNumber() {
		return evenNumber;
	}

	public void setEvenNumber(boolean evenNumber) {
		this.evenNumber = evenNumber;
	}
}
