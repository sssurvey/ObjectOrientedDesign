package tableLamp.bulb;

import tableLamp.enumsUtil.Status;

public class Lightbulb implements LightbulbContract {

    private Status status;

    public Lightbulb() {
        status = Status.OFF;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
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