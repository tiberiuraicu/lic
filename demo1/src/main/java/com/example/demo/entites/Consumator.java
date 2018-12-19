package com.example.demo.entites;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Consumator {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String tip;

	private Integer idDispozitiv;

	private double putereConsumata;

	private Date dataOra;

	private boolean stare;// aprins/inchis

	private String circuit;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public Integer getIdDispozitiv() {
		return idDispozitiv;
	}

	public void setIdDispozitiv(Integer idDispozitiv) {
		this.idDispozitiv = idDispozitiv;
	}

	public double getPutereConsumata() {
		return putereConsumata;
	}

	public void setPutereConsumata(double putereConsumata) {
		this.putereConsumata = putereConsumata;
	}

	public Date getDataOra() {
		return dataOra;
	}

	public void setDataOra(Date dataOra) {
		this.dataOra = dataOra;
	}

	public boolean isStare() {
		return stare;
	}

	public void setStare(boolean stare) {
		this.stare = stare;
	}

	public String getCircuit() {
		return circuit;
	}

	public void setCircuit(String circuit) {
		this.circuit = circuit;
	}

}
