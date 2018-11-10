import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import model.vehicleModel.VehicleTypeInfoModel;
import park.*;

public class ParkTest {

    private String testName = "Tester Park";
    private String testRegion = "Illinois";
    private String testAddress = "3333 N Chicago st";
    private String testPhone = "3122213321";
    private String testWeb = "https://www.parkParkTest.org";
    private float[] testGeo = { 23.1f, 33.4f };
    private int[] testPlate = { 3, 5 };

    @Test
    public void parkIntegretyTest() {
        Park park = new Park(testName, testRegion, testAddress, testPhone, testWeb, testGeo, VehicleTypeInfoModel.CAR,
                testPlate);

        assertNotNull(park);

        // Locationinfo Park test
        assertEquals(testName, park.getLocationInfoModel().getName());
        assertEquals(testRegion, park.getLocationInfoModel().getRegion());
        assertEquals(testAddress, park.getLocationInfoModel().getAddress());
        assertEquals(testPhone, park.getLocationInfoModel().getPhone());
        assertEquals(testWeb, park.getLocationInfoModel().getWeb());

        float[] testGeoActual = park.getLocationInfoModel().getGeo();
        assertEquals(testGeo, testGeoActual);

        // Paymentinto Park test
        assertEquals(VehicleTypeInfoModel.CAR, park.getPaymentInfoModel().getVechicleTypeInfoModel());

        int[] testPlateActual = park.getPaymentInfoModel().getPlatePrices();
        assertEquals(testPlate, testPlateActual);
    }
}