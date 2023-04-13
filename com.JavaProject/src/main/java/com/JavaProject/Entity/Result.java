package com.JavaProject.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Result {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private int cpi;
	
	@Column
	private int spi;

	public Result() {
		super();
	}

	public Result(int id, int cpi, int spi) {
		super();
		this.id = id;
		this.cpi = cpi;
		this.spi = spi;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCpi() {
		return cpi;
	}

	public void setCpi(int cpi) {
		this.cpi = cpi;
	}

	public int getSpi() {
		return spi;
	}

	public void setSpi(int spi) {
		this.spi = spi;
	}

	@Override
	public String toString() {
		return "Result [id=" + id + ", cpi=" + cpi + ", spi=" + spi + "]";
	}

	
}
