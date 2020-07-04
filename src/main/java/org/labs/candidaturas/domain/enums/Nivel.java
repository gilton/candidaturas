package org.labs.candidaturas.domain.enums;

public enum Nivel {
	BASICO("Básico"),
	JUNIOR("Júnior"),
	PLENO("Pleno"),
	AVANCADO("Avançado"),
	EXPERT("Expert");
	
	private String value;
	
	Nivel(String value) { this.value = value; }
}
