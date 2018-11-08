package model;

public class PaymentInfoModel {

    private int[] licensePlate = new int[2];
    private String vechicleType;

    public PaymentInfoModel(String vehicleType, int[] plate) {
        for (VehicleTypeInfo vehicleTypeInfo : VehicleTypeInfo.values()) {
            if (vehicleTypeInfo.toString().equals(vehicleType)) {
                this.vechicleType = vehicleType;
            }
        }

        this.licensePlate[0] = plate[0];
        this.licensePlate[1] = plate[1];
    }

    /**
     * @return the licensePlate
     */
    public int[] getLicensePlate() {
        return licensePlate;
    }

    /**
     * @return the vechicleType
     */
    public String getVechicleType() {
        return vechicleType;
    }

    // TODO externaliz it late on...
    enum VehicleTypeInfo {

        // Motocycle, Car, Rv
        MOTOCYCLE {
            @Override
            public String toString() {
                return "Motocycle";
            }
        },

        CAR {
            @Override
            public String toString() {
                return "Car";
            }
        },

        RV {
            @Override
            public String toString() {
                return "RV";
            }
        }
    }
}