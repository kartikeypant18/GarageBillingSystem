package entity;
import java.util.List;

public class Invoice {
    private int id;
    private int customerId;
    private int vechicleId;
    private List<Integer> serviceIds;

    public Invoice(int id, int customerId, int vechicleId, List<Integer> serviceIds) {
        this.id = id;
        this.customerId = customerId;
        this.vechicleId = vechicleId;
        this.serviceIds = serviceIds;
    }

    public List<Integer> getServiceIds() {
        return serviceIds;
    }

    public void setServiceIds(List<Integer> serviceIds) {
        this.serviceIds = serviceIds;
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

    @Override
    public String toString() {
        return "Invoice [id=" + id + ", customerId=" + customerId + ", vechicleId=" + vechicleId + ", serviceIds=" + serviceIds + "]";
    }
}
