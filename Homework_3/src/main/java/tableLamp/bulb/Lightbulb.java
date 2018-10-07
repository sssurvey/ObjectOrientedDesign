package tableLamp.bulb;

import tableLamp.enumsUtil.Status;

public class Lightbulb {

    private Status status;

    public Lightbulb() {
        status = Status.OFF;
    }

    public Status getStatus() {
        return status;
    }

    public void ChangeStatus(Status status) {
        switch (status) {
            case ON:
                this.status = Status.ON;
                break;
            case OFF:
                this.status = Status.OFF;
        }
    }
}