
package pojos.DeliverySettings;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class PDeliveryOptions {

    private String availability;
    private String availabilityBranch;
    private List<String> deliveryType;
    private List<String> estimatedDeliveryTime;
    private List<FlexibleDeliveryOption> flexibleDeliveryOptions;
    private Integer freeDeliveryRange;
    private Integer maxDeliveryRange;
    private Integer minFreeDeliveryOrder;
    private Integer perMileCost;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getAvailabilityBranch() {
        return availabilityBranch;
    }

    public void setAvailabilityBranch(String availabilityBranch) {
        this.availabilityBranch = availabilityBranch;
    }

    public List<String> getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(List<String> deliveryType) {
        this.deliveryType = deliveryType;
    }

    public List<String> getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }

    public void setEstimatedDeliveryTime(List<String> estimatedDeliveryTime) {
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }

    public List<FlexibleDeliveryOption> getFlexibleDeliveryOptions() {
        return flexibleDeliveryOptions;
    }

    public void setFlexibleDeliveryOptions(List<FlexibleDeliveryOption> flexibleDeliveryOptions) {
        this.flexibleDeliveryOptions = flexibleDeliveryOptions;
    }

    public Integer getFreeDeliveryRange() {
        return freeDeliveryRange;
    }

    public void setFreeDeliveryRange(Integer freeDeliveryRange) {
        this.freeDeliveryRange = freeDeliveryRange;
    }

    public Integer getMaxDeliveryRange() {
        return maxDeliveryRange;
    }

    public void setMaxDeliveryRange(Integer maxDeliveryRange) {
        this.maxDeliveryRange = maxDeliveryRange;
    }

    public Integer getMinFreeDeliveryOrder() {
        return minFreeDeliveryOrder;
    }

    public void setMinFreeDeliveryOrder(Integer minFreeDeliveryOrder) {
        this.minFreeDeliveryOrder = minFreeDeliveryOrder;
    }

    public Integer getPerMileCost() {
        return perMileCost;
    }

    public void setPerMileCost(Integer perMileCost) {
        this.perMileCost = perMileCost;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
