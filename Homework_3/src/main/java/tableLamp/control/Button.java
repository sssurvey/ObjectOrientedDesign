package tableLamp.control;

import tableLamp.bulb.Lightbulb;
import tableLamp.enumsUtil.Status;

public class Button {

    private Status status;
    private Lightbulb lb;

    public Button(Lightbulb lb) {
        this.lb = lb;
        status = Status.OFF;
    }

    public Status getStatus() {
        return status;
    }

    public void flipTheSwitch() { // courtesy of BoostMobile USA "Are you ready to Flip The Switch?"
        switch (this.getStatus()) {
            case OFF:
                status = Status.ON;
                this.lb.ChangeStatus(Status.ON);
                break;
            case ON:
                status = Status.OFF;
                this.lb.ChangeStatus(Status.OFF);
        }
    }
}
