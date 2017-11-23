package cf.autofinder;

class CountVehicle {
	public long lostPincode;
	public long count;
	public	 CountVehicle(){}
	public void setLostPincode(long lostPincode) {
		this.lostPincode = lostPincode;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public CountVehicle(long lostPincode, long count) {
		this.lostPincode = lostPincode;
		this.count = count;
	}

	public long getLostPincode() {
		return this.lostPincode;
	}

	public long getCount() {
		return this.count;
	}
}

