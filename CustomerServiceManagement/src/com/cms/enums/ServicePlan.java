package com.cms.enums;

public enum ServicePlan {
	SILVER( 1000 ),
	GOLD (2000),
	DIAMOND (5000),
	PLATINUM (10000);
	
	private int planCharges;

	private ServicePlan(int planCharges) {
		this.planCharges = planCharges;
	}
	@Override
	public String toString() {
		return name()+
				":"+planCharges;
	}
	public int getPlanCharges() {
		return planCharges;
	}

	
}
