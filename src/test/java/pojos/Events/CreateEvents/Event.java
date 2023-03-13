
package pojos.Events.CreateEvents;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.processing.Generated;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "title",
    "date",
    "fee",
    "duration",
    "attendeeLimit",
    "schedule",
    "description",
    "tac",
    "status",
    "created",
    "updated",
    "isActive",
    "isRefundable",
    "refundableUpToDay",
    "address",
    "images"
})
@Generated("jsonschema2pojo")
public class Event {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("date")
    private Date date;
    @JsonProperty("fee")
    private Integer fee;
    @JsonProperty("duration")
    private Integer duration;
    @JsonProperty("attendeeLimit")
    private Integer attendeeLimit;
    @JsonProperty("schedule")
    private Object schedule;
    @JsonProperty("description")
    private Object description;
    @JsonProperty("tac")
    private String tac;
    @JsonProperty("status")
    private String status;
    @JsonProperty("created")
    private Created created;
    @JsonProperty("updated")
    private Updated updated;
    @JsonProperty("isActive")
    private Boolean isActive;
    @JsonProperty("isRefundable")
    private Boolean isRefundable;
    @JsonProperty("refundableUpToDay")
    private Object refundableUpToDay;
    @JsonProperty("address")
    private Address address;
    @JsonProperty("images")
    private List<Object> images;
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

    @JsonProperty("date")
    public Date getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(Date date) {
        this.date = date;
    }

    @JsonProperty("fee")
    public Integer getFee() {
        return fee;
    }

    @JsonProperty("fee")
    public void setFee(Integer fee) {
        this.fee = fee;
    }

    @JsonProperty("duration")
    public Integer getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @JsonProperty("attendeeLimit")
    public Integer getAttendeeLimit() {
        return attendeeLimit;
    }

    @JsonProperty("attendeeLimit")
    public void setAttendeeLimit(Integer attendeeLimit) {
        this.attendeeLimit = attendeeLimit;
    }

    @JsonProperty("schedule")
    public Object getSchedule() {
        return schedule;
    }

    @JsonProperty("schedule")
    public void setSchedule(Object schedule) {
        this.schedule = schedule;
    }

    @JsonProperty("description")
    public Object getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(Object description) {
        this.description = description;
    }

    @JsonProperty("tac")
    public String getTac() {
        return tac;
    }

    @JsonProperty("tac")
    public void setTac(String tac) {
        this.tac = tac;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("created")
    public Created getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(Created created) {
        this.created = created;
    }

    @JsonProperty("updated")
    public Updated getUpdated() {
        return updated;
    }

    @JsonProperty("updated")
    public void setUpdated(Updated updated) {
        this.updated = updated;
    }

    @JsonProperty("isActive")
    public Boolean getIsActive() {
        return isActive;
    }

    @JsonProperty("isActive")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("isRefundable")
    public Boolean getIsRefundable() {
        return isRefundable;
    }

    @JsonProperty("isRefundable")
    public void setIsRefundable(Boolean isRefundable) {
        this.isRefundable = isRefundable;
    }

    @JsonProperty("refundableUpToDay")
    public Object getRefundableUpToDay() {
        return refundableUpToDay;
    }

    @JsonProperty("refundableUpToDay")
    public void setRefundableUpToDay(Object refundableUpToDay) {
        this.refundableUpToDay = refundableUpToDay;
    }

    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(Address address) {
        this.address = address;
    }

    @JsonProperty("images")
    public List<Object> getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(List<Object> images) {
        this.images = images;
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
