package com.educandoweb.course.entities.enums;

public enum OrderStatus {
	
	//Os nº entre parenteses são os números que eu defino sem deixar q o java defina automaticamente
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);	

	//O code, o construtor e métdodo getCode são para que os números colocados no parenteses não deem erro
	private int code;
	
	private OrderStatus(int code) { //esse construtor tem q ser privado
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	//Esse codigo abaixo converte um valor numérico para tipo enumerado
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
