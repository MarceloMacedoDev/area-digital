package br.com.areadigital.db.enums;

public enum BooleanEnum {
	FALSE(false, 0),TRUE(true, 1) ;
	private final boolean nome;
	private final int id;

	private BooleanEnum(Boolean nome, int id) {
		this.nome = nome;
		this.id = id;
	}

	public Boolean getNome() {
		return nome;
	}

	public int getId() {
		return id;
	}

	public static boolean returnName(int id) {
		for (BooleanEnum e : values()) {
			if (e.getId() == (id))
				return e.getNome();
		}
		return false;
	}
	public static int returnId(Boolean s) {
		for (BooleanEnum e : values()) {
			if (e.getNome().equals(s))
				return e.getId();
		}
		return -1;
	} 
}
