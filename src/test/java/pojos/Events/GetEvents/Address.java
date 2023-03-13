
package pojos.Events.GetEvents;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.processing.Generated;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "title",
    "created",
    "updated",
    "address",
    "city",
    "state",
    "postal",
    "sessionId",
    "lat",
    "lng",
    "isDefault",
    "isSellerAddress",
    "deletedAt"
})
@Generated("jsonschema2pojo")
public class Address {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("created")
    private Created__2 created;
    @JsonProperty("updated")
    private Updated__2 updated;
    @JsonProperty("address")
    private String address;
    @JsonProperty("city")
    private String city;
    @JsonProperty("state")
    private String state;
    @JsonProperty("postal")
    private String postal;
    @JsonProperty("sessionId")
    private Object sessionId;
    @JsonProperty("lat")
    private Double lat;
    @JsonProperty("lng")
    private Double lng;
    @JsonProperty("isDefault")
    private Boolean isDefault;
    @JsonProperty("isSellerAddress")
    private Boolean isSellerAddress;
    @JsonProperty("deletedAt")
    private Object deletedAt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("created")
    public Created__2 getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(Created__2 created) {
        this.created = created;
    }

    @JsonProperty("updated")
    public Updated__2 getUpdated() {
        return updated;
    }

    @JsonProperty("updated")
    public void setUpdated(Updated__2 updated) {
        this.updated = updated;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("postal")
    public String getPostal() {
        return postal;
    }

    @JsonProperty("postal")
    public void setPostal(String postal) {
        this.postal = postal;
    }

    @JsonProperty("sessionId")
    public Object getSessionId() {
        return sessionId;
    }

    @JsonProperty("sessionId")
    public void setSessionId(Object sessionId) {
        this.sessionId = sessionId;
    }

    @JsonProperty("lat")
    public Double getLat() {
        return lat;
    }

    @JsonProperty("lat")
    public void setLat(Double lat) {
        this.lat = lat;
    }

    @JsonProperty("lng")
    public Double getLng() {
        return lng;
    }

    @JsonProperty("lng")
    public void setLng(Double lng) {
        this.lng = lng;
    }

    @JsonProperty("isDefault")
    public Boolean getIsDefault() {
        return isDefault;
    }

    @JsonProperty("isDefault")
    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    @JsonProperty("isSellerAddress")
    public Boolean getIsSellerAddress() {
        return isSellerAddress;
    }

    @JsonProperty("isSellerAddress")
    public void setIsSellerAddress(Boolean isSellerAddress) {
        this.isSellerAddress = isSellerAddress;
    }

    @JsonProperty("deletedAt")
    public Object getDeletedAt() {
        return deletedAt;
    }

    @JsonProperty("deletedAt")
    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
