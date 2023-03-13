
package pojos.Events.GetEvents;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.processing.Generated;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "numberOfAttendees",
    "status",
    "created",
    "updated",
    "transactionId",
    "attendee"
})
@Generated("jsonschema2pojo")
public class Attendance {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("numberOfAttendees")
    private Integer numberOfAttendees;
    @JsonProperty("status")
    private String status;
    @JsonProperty("created")
    private Created__1 created;
    @JsonProperty("updated")
    private Updated__1 updated;
    @JsonProperty("transactionId")
    private String transactionId;
    @JsonProperty("attendee")
    private Attendee attendee;
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

    @JsonProperty("numberOfAttendees")
    public Integer getNumberOfAttendees() {
        return numberOfAttendees;
    }

    @JsonProperty("numberOfAttendees")
    public void setNumberOfAttendees(Integer numberOfAttendees) {
        this.numberOfAttendees = numberOfAttendees;
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
    public Created__1 getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(Created__1 created) {
        this.created = created;
    }

    @JsonProperty("updated")
    public Updated__1 getUpdated() {
        return updated;
    }

    @JsonProperty("updated")
    public void setUpdated(Updated__1 updated) {
        this.updated = updated;
    }

    @JsonProperty("transactionId")
    public String getTransactionId() {
        return transactionId;
    }

    @JsonProperty("transactionId")
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @JsonProperty("attendee")
    public Attendee getAttendee() {
        return attendee;
    }

    @JsonProperty("attendee")
    public void setAttendee(Attendee attendee) {
        this.attendee = attendee;
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
