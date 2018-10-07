package tableLamp.bulb;

public class Lightbulb {

    public enum LightStatus {
        ON, OFF
    }

    private LightStatus Status;

    public Lightbulb() {
        Status = LightStatus.OFF;
    }

    public LightStatus getStatus() {
        return Status;
    }

    public void ChangeStatus() {
        if (Status.equals(LightStatus.OFF)) {
            Status = LightStatus.ON;
        } else {
            Status = LightStatus.OFF;
        }
    }
}
