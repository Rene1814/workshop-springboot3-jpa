package com.educandoweb.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.educandoweb.course.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order") //Order é palavra reservada do db, essa anotação cria uma tabela com nome tb_order no db
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id //Essa anotação diz que o atributo id é a chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
	private Integer orderStatus;
	
	@ManyToOne //Como um user pode ter muitos orders, essa anotação faz a associação de chave estrangeira com user
	@JoinColumn(name = "client_id")//na tabela pedidos do db vai ter uma chave estrangeira com nome client_id que vai conter o id do user associado a esse pedido
	private User client;
	
	@OneToMany(mappedBy = "id.order")//pq no OrderItem tem id e no id que tem o pedido
	private Set<OrderItem> items = new HashSet<>();
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)//No caso do 1 pra 1, estamos mapeando order e payment pra ter o mesmo id, por isso essa anotação é obrigatória
	private Payment payment;//Pssociação com a classe Payment. Um pedido tem zero ou um pagamento.
	
	public Order() {
	}

	public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
		this.id = id;
		this.moment = moment;
		setOrderStatus(orderStatus);
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	
	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus); //pega o número inteiro dessa classe e converte pra enum
	}
	
	public void setOrderStatus(OrderStatus orderStatus) {
		if (orderStatus != null) {
		this.orderStatus = orderStatus.getCode();
		}
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}
	
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Set<OrderItem> getItems(){
		return items;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

}
