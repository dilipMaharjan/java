package jms.p2p.model;

import java.io.Serializable;

public class Patient implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String insuranceProvider;
	private Long copay;
	private Long amountTobePaid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInsuranceProvider() {
		return insuranceProvider;
	}

	public void setInsuranceProvider(String insuranceProvider) {
		this.insuranceProvider = insuranceProvider;
	}

	public Long getCopay() {
		return copay;
	}

	public void setCopay(Long copay) {
		this.copay = copay;
	}

	public Long getAmountTobePaid() {
		return amountTobePaid;
	}

	public void setAmountTobePaid(Long amountTobePaid) {
		this.amountTobePaid = amountTobePaid;
	}

	public Patient(int id, String name, String insuranceProvider, Long copay, Long amountTobePaid) {
		this.id = id;
		this.name = name;
		this.insuranceProvider = insuranceProvider;
		this.copay = copay;
		this.amountTobePaid = amountTobePaid;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", insuranceProvider=" + insuranceProvider + ", copay=" + copay
				+ ", amountTobePaid=" + amountTobePaid + "]";
	}
}
