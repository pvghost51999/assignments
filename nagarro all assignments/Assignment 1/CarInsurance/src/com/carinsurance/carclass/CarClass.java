package com.carinsurance.carclass;

public class CarClass {
	private String model;
	private String type;
	private double cost;
	private String insurance;

	public CarClass(String model, String type, Double cost, String insurance) {

		this.model = model;
		this.type = type;
		this.cost = cost;
		this.insurance = insurance;

	}

	public String getModel() {
		return model;
	}

	/**
	 * Sets the model.
	 *
	 * @param model type of model enter by user
	 */
	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type it will hold type of car like sedan/hatchback/suv
	 */
	public void setType(String type) {
		this.type = type;
	}

	public double getCost() {
		return cost;
	}

	/**
	 * Sets the cost.
	 *
	 * @param cost it will hold the cost of the cat
	 */
	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getInsurance() {
		return insurance;
	}

	/**
	 * Sets the insurance.
	 *
	 * @param insurance type of insurance will be stored here
	 */
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

}
