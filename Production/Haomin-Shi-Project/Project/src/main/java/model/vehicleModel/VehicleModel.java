package model.vehicleModel;

public class VehicleModel {

    private String state;
    private String plate;
    private String type;

    public VehicleModel(String state, String plate, String type) {
        this.state = state;
        this.plate = plate;
        this.type = type;
    }

    public VehicleModel() {
    }

    /**
     * @param plate the plate to set
     */
    public void setPlate(String plate) {
        this.plate = plate;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the plate
     */
    public String getPlate() {
        return plate;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }
}