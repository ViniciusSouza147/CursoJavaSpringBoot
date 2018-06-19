package br.com.cursospring.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class RequestItem implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private RequestItemKPK id = new RequestItemKPK();
	
	private Double discount;
	private Integer amount;
	private Double price;
	
	public RequestItem() {
		
	}

	public RequestItem(Request request, Product product , Double discount, Integer amount, Double price) {
		super();
		id.setRequest(request);
		id.setProduct(product);
		this.discount = discount;
		this.amount = amount;
		this.price = price;
	}
	
	public Request getRequest() {
		return id.getRequest();
	}

	public Product getProduct() {
		return id.getProduct();
	}

	public RequestItemKPK getId() {
		return id;
	}

	public void setId(RequestItemKPK id) {
		this.id = id;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestItem other = (RequestItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
