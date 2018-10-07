package tableLamp.control;

import tableLamp.enumsUtil.Status;

public class Button {

    private Status status;

    public Button() {
        status = Status.OFF;
    }

    public Status getStatus() {
        return status;
    }

    public void flipTheSwitch() { // courtesy of BoostMobile USA "Are you ready to Flip The Switch?"
        switch (this.getStatus()) {
            case OFF:
                status = Status.ON;
                break;
            default:
                status = Status.OFF;
        }
    }
}
