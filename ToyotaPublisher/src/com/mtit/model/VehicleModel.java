//IT19014128
//A.M.W.W.R.L. Wataketiya

package com.mtit.model;

public class VehicleModel {

	String modelName;
	int engineCapacity;
	double price;
	
	
	public VehicleModel(String name, int capacity, double price) {
		this.modelName = name;
		this.engineCapacity = capacity;
		this.price = price;
	}
	
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public int getEngineCapacity() {
		return engineCapacity;
	}
	public void setEngineCapacity(int engineCapacity) {
		this.engineCapacity = engineCapacity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "VehicleModel [modelName=" + modelName + ", engineCapacity=" + engineCapacity + ", price=" + price + "]";
	}
}
