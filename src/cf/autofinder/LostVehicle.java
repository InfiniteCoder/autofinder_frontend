package cf.autofinder;


public class LostVehicle{
    private String chassisNumber;
    private String licenseNumber;
    private Long mobileNumber;
    private String model;
    private String company;
    private Long lostPincode;

    protected LostVehicle(){}
    
    public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public LostVehicle(String chassisNumber,String licenseNumber,Long long1){
        //only important fields set in constructor
        this.chassisNumber = chassisNumber;
        this.licenseNumber = licenseNumber;
        this.mobileNumber = long1;
    }
    
    //getter and setter methods
    public String getChassisNumber(){
        return chassisNumber;
    }

    public String getLicenseNumber(){
        return licenseNumber;
    }

    public Long getMobileNumber(){
        return mobileNumber;
    }

    public String getModel(){
        return model;
    }

    public String getCompany(){
        return company;
    }

    public Long getLostPincode(){
        return lostPincode;
    }

    public void setModel(String model){
        this.model = model;
    }

    public void setCompany(String company){
        this.company = company;
    }

    public void setLostPincode(Long long1){
        this.lostPincode = long1;
    }
}
