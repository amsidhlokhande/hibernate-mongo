package com.amsidh.mvc.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class Purchase {

	private String article;

	private Date datePurchase;

	private BigDecimal total;

	private BigDecimal IVA;

	Purchase() {
	}

	public Purchase(String article, Date datePurchase, BigDecimal total, BigDecimal IVA) {
		this.article = article;
		this.datePurchase = datePurchase;
		this.total = total;
		this.IVA = IVA;
	}

	public String getArticle() {

		return article;
	}

	public void setArticle(String article) {

		this.article = article;
	}

	public Date getDatePurchase() {
		return datePurchase;
	}

	public void setDatePurchase(Date datePurchase) {
		this.datePurchase = datePurchase;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getIVA() {
		return IVA;
	}

	public void setIVA(BigDecimal IVA) {
		this.IVA = IVA;
	}
}