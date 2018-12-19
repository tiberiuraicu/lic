package com.example.demo.entites;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Senzor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String nume;

	private String stare;

	private Date dataOra;

	private String locatia;

	private String circuit;

	public Senzor() {

	}

	public Senzor(String nume, String stare, Date dataOra, String locatia, String circuit) {
		super();
		this.nume = nume;
		this.stare = stare;
		this.dataOra = dataOra;
		this.locatia = locatia;
		this.circuit = circuit;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getStare() {
		return stare;
	}

	public void setStare(String stare) {
		this.stare = stare;
	}

	public Date getDataOra() {
		return dataOra;
	}

	public void setDataOra(Date dataOra) {
		this.dataOra = dataOra;
	}

	public String getLocatia() {
		return locatia;
	}

	public void setLocatia(String locatia) {
		this.locatia = locatia;
	}

	public String getCircuit() {
		return circuit;
	}

	public void setCircuit(String circuit) {
		this.circuit = circuit;
	}

	@Override
	public String toString() {
		return "Senzor [nume=" + nume + ", stare=" + stare + ", dataOra=" + dataOra + ", locatia=" + locatia
				+ ", circuit=" + circuit + "]";
	}

}
