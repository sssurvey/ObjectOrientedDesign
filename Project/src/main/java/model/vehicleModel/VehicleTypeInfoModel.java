package model.vehicleModel;

public enum VehicleTypeInfoModel {

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