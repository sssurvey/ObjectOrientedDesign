package tableLamp.control;

import tableLamp.bulb.LightbulbContract;
import tableLamp.enumsUtil.Status;

public class Button {

    // IMO, the button is the Higher level module
    // Since the button is acting as a Controller

    private Status status;
    private LightbulbContract lb;

    // Here the Button takes in a LightbulbContract obj, and since in Java, we can supply a sub-class of the parent-class
    // as an obj, thus, in application, we can put a Lightbulb.java class here, and achieving the Dependency Inversion
    public Button(LightbulbContract lb) {
        this.lb = lb;
        status = Status.OFF;
    }

    public Status getStatus() {
        return status;
    }

    public void pushButton() {
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
