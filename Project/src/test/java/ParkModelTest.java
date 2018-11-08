import org.junit.Test;
import static org.junit.Assert.*;
import model.parkModel.*;
import model.vehicleModel.*;

public class ParkModelTest {

	@Test
	public void parkModelConstructorTest() {
		ParkModel parkModel = new ParkModel();
		assertNotNull(parkModel);
	}

	@Test
	public void parkModelCompleteTest() {
		ParkModel parkModel = new ParkModel();
		float[] testGeo = { 33.3f, 44, 5f };
		int[] testPlate = { 3, 5 };
		parkModel.setLocationInfoModel(new LocationInfoModel("name", "region", "address", "phone", "web", testGeo));
		parkModel.setPaymentInfoModel(new PaymentInfoModel(VehicleTypeInfoModel.MOTOCYCLE, testPlate));

		// Test getString values, like name, region, addr, phone, and web
		assertEquals("name", parkModel.getLocationInfoModel().getName());
		assertEquals("region", parkModel.getLocationInfoModel().getRegion());
		assertEquals("address", parkModel.getLocationInfoModel().getAddress());
		assertEquals("phone", parkModel.getLocationInfoModel().getPhone());
		assertEquals("web", parkModel.getLocationInfoModel().getWeb());

		// Test Geo
		float[] geoResult = parkModel.getLocationInfoModel().getGeo();
		assertArrayEquals(testGeo, geoResult, 2);
	}
}