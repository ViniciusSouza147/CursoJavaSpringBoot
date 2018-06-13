package br.com.cursospring.domain.enums;

public enum StatusPayment {
	PENDING(1, "Pending"), 
	SETTLED(2, "Settled"), 
	CANCELED(3, "Canceled");

	private int cod;
	private String description;

	private StatusPayment(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}

	public static StatusPayment toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (StatusPayment x : StatusPayment.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("ID Invalid: " + cod);
	}
}
