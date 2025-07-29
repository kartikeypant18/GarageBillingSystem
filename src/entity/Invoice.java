package entity;

public class Invoice {
    private int id;
    private int customerId;
    private int vechicleId;
    private int serviceId;

    public Invoice(int id, int customerId, int vechicleId, int serviceId) {
        this.id = id;
        this.customerId = customerId;
        this.vechicleId = vechicleId;
        this.serviceId = serviceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getVechicleId() {
        return vechicleId;
    }

    public void setVechicleId(int vechicleId) {
        this.vechicleId = vechicleId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String toString() {
        return "Invoice[ " +
                "id=" + id +
                ", customerId= " + customerId +
                ", vechicleId= " + vechicleId +
                ", serviceId= "  + serviceId +
                " ]";
    }
}
