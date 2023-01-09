package br.com.areadigital.db.enums.produtos;

import lombok.Getter;

import java.util.Locale;

@Getter
public enum VisibilityCategoriaEnum {
	PUBLISHED("Published", 0),
	VISIBLE("Visible", 1) ,
	HIDDEN("Hidden", 1) ;

	private final String name;
	private final int id;

	private VisibilityCategoriaEnum(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public static String returnName(int id) {
		for (VisibilityCategoriaEnum e : values()) {
			if (e.getId() == (id))
				return e.name();
		}
		return "";
	}
	public static int returnId(String s) {
		for (VisibilityCategoriaEnum e : values()) {
			String value=e.getName().toUpperCase();
			if (value.equals(s.toUpperCase()))
				return e.getId();
		}
		return -1;
	} 
}
