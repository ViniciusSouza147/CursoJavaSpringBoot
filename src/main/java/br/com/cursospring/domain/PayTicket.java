package br.com.cursospring.domain;

import java.util.Date;

import javax.persistence.Entity;

import br.com.cursospring.domain.enums.StatusPayment;

@Entity
public class PayTicket extends Payment{
	private static final long serialVersionUID = 1L;

	private Date dueDate;
	private Date paymentDate;
	
	public PayTicket() {}

	public PayTicket(Integer id, StatusPayment status, Order order, Date dueDate, Date paymentDate) {
		super(id, status, order);
		this.dueDate = dueDate;
		this.paymentDate = paymentDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
		
}
