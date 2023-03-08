
package pojos.DeliverySettings;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class FlexibleDeliveryOption {

    private Integer deliveryBy;
    private Integer orderBegin;
    private Integer orderEnd;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Integer getDeliveryBy() {
        return deliveryBy;
    }

    public void setDeliveryBy(Integer deliveryBy) {
        this.deliveryBy = deliveryBy;
    }

    public Integer getOrderBegin() {
        return orderBegin;
    }

    public void setOrderBegin(Integer orderBegin) {
        this.orderBegin = orderBegin;
    }

    public Integer getOrderEnd() {
        return orderEnd;
    }

    public void setOrderEnd(Integer orderEnd) {
        this.orderEnd = orderEnd;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
