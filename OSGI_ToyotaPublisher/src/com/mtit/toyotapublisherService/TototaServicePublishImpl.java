//IT19014128
//A.M.W.W.R.L. Wataketiya

package com.mtit.toyotapublisherService;

import java.util.ArrayList;
import java.util.List;

import com.mtit.model.VehicleModel;

public class TototaServicePublishImpl implements ToyotaServicePublish {
	
	private List<VehicleModel> modelList = new ArrayList<VehicleModel>();

	@Override
	public String publishService() {
		ServiceInitiator();
		return "Executing Toyota service publish";
	}

	@Override
	public void ServiceInitiator() {
		VehicleModel vehicleModel = new VehicleModel("Corolla", 1800, 4000000.0);
		VehicleModel vehicleModel2 = new VehicleModel("Camry", 2500, 6000000.0);
		VehicleModel vehicleModel3 = new VehicleModel("Prius", 1990, 5500000.0);
		VehicleModel vehicleModel4 = new VehicleModel("Aqua", 1490, 3700000.0);
		VehicleModel vehicleModel5 = new VehicleModel("Vitz", 1000, 2500000.0);
		modelList.add(vehicleModel);
		modelList.add(vehicleModel2);
		modelList.add(vehicleModel3);
		modelList.add(vehicleModel4);
		modelList.add(vehicleModel5);
	}

	@Override
	public int getEngineCapacity(String model) {
		String modelName;
		for(VehicleModel v: modelList) {
			modelName = v.getModelName();
			if(modelName.toLowerCase().equals(model.toLowerCase()  )  )
			{
				return v.getEngineCapacity();
			}
		}
		System.out.println("Model name "+model+" not found!");
		return -1;
	}

	@Override
	public double getPrice(String model) {
		String modelName;
		for(VehicleModel v: modelList) {
			modelName = v.getModelName();
			if(modelName.toLowerCase().equals(model.toLowerCase()  )  )
			{
				return v.getPrice();
			}
		}
		System.out.println("Model name "+model+" not found!");
		return -1;
	}

}
