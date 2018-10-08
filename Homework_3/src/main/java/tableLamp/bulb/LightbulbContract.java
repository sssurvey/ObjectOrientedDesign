package tableLamp.bulb;

import tableLamp.enumsUtil.Status;

public interface LightbulbContract {

    Status getStatus();

    void ChangeStatus(Status status);

}
