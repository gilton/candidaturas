package org.labs.candidaturas.domain.enums;

public enum Bandeira {
	
	MASTERCARD("Master Card"), 
	VISA("Visa"), 
	AMERICANEXPRESS("American Express"), 
	DINERSCLUB("Diners Club"), 
	DISCOVER("Discover"), 
	VOYAGER("Voyager"), 
	HIPERCARD("Hiper Card"), 
	AURA("Aura");
	
	private String value;
	
	Bandeira(String value) { this.value = value; }
	
}
