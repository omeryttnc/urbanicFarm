package stepDefinitions.backendStepDef.Events;

import io.cucumber.java.en.Then;
import org.junit.Assert;

public class Events_stepDef {
    Event event = new Event();
    int createdEvent;
    @Then("user create an event from backend")
    public void userCreateAnEventFromBackend() {
       createdEvent= event.create();
    }
    @Then("assert if event is created from backend")
    public void assertIfEventIsCreatedFromBackend() {
        Assert.assertTrue(  event.getAllEvents().stream().anyMatch(t->t.equals(createdEvent)));
    }

    @Then("user update an event from backend")
    public void userUpdateAnEventFromBackend() {
        event.update(createdEvent);
    }

    @Then("user cancel an event from backend")
    public void userCancelAnEventFromBackend() {
        event.cancel(createdEvent);
    }

    @Then("user delete an event from backend")
    public void userDeleteAnEventFromBackend() {

    event.delete(createdEvent);

    }


    @Then("assert if event is deleted from backend")
    public void assertIfEventIsDeletedFromBackend() {
        Assert.assertTrue(  event.getAllEvents().stream().noneMatch(t->t.equals(createdEvent)));

    }
}
