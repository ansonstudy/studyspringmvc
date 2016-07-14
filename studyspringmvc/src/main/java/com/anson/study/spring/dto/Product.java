/**
 * 
 */
package com.anson.study.spring.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

/**
 * @author yonghua
 *
 */
public class Product implements Serializable {
	
	private static final long serialVersionUID = -833873853226846147L;

	private Long id;
	
	@NotNull
	@Size(min=1, max=20)
	private String productName;

	private String introduce;
	
	@NotNull
	@DecimalMin("0.01")
	@NumberFormat(pattern="$###,###.00")
	private BigDecimal price;
	
	private Date ctime;
	private Date utime;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String aName) {
		this.productName = aName;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String anIntroduce) {
		this.introduce = anIntroduce;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal aPrice) {
		this.price = aPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public Date getUtime() {
		return utime;
	}

	public void setUtime(Date utime) {
		this.utime = utime;
	}

}
