import org.junit.Test;
import static org.junit.Assert.*;
import model.parkModel.*;
import model.vehicleModel.*;

public class PaymentInfoModelTest {

    private int[] testPlate = { 4, 5 };

    @Test
    public void testPaymentInfoModelCreation() {
        PaymentInfoModel paymentInfoModel = new PaymentInfoModel();
        assertNotNull(paymentInfoModel);
    }
}