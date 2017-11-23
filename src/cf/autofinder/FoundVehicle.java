package cf.autofinder;





public class FoundVehicle{

    private String chassisNumber;
    private String licenseNumber;
    private String foundRtoOffice;


    public FoundVehicle(String chassisNumber,String licenseNumber, String foundRtoOffice){
        this.chassisNumber = chassisNumber;
        this.licenseNumber = licenseNumber;
        this.foundRtoOffice = foundRtoOffice;
    }

    public String getChassisNumber(){
        return this.chassisNumber;
    }

    public String getLicenseNumber(){
        return this.licenseNumber;
    }

    public String getFoundRtoOffice(){
        return this.foundRtoOffice;
    }
}

