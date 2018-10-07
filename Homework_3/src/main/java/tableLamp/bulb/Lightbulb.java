package tableLamp.bulb;

import tableLamp.enumsUtil.Status;

public class Lightbulb {

    private tableLamp.enumsUtil.Status Status;

    public Lightbulb() {
        Status = Status.OFF;
    }

    public Status getStatus() {
        return Status;
    }

    public void ChangeStatus() {
        if (Status.equals(Status.OFF)) {
            Status = Status.ON;
        } else {
            Status = Status.OFF;
        }
    }
}