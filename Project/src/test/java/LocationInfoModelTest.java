import org.junit.Test;
import static org.junit.Assert.*;
import model.LocationInfoModel;;

public class LocationInfoModelTest {
    @Test
    public void testLocationInfoModelConstructor() {
        String nameTest = "Froest Park";
        String regionTest = "IL";
        String addressTest = "1000 S Statevill St";
        String phoneTest = "333-123-1111";
        String webTest = "https://www.thisisforestpark.org";
        float[] geoTest = { 44.5f, 33, 7f };

        LocationInfoModel locationInfoModel = new LocationInfoModel(nameTest, regionTest, addressTest, phoneTest,
                webTest, geoTest);
        assertNotNull(locationInfoModel);
    }
}