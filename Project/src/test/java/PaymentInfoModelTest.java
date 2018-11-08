import org.junit.Test;
import static org.junit.Assert.*;
import model.PaymentInfoModel;
import model.VehicleTypeInfoModel;

public class PaymentInfoModelTest {

    private int[] testPlate = { 4, 5 };

    @Test
    public void testPaymentInfoModelCreation() {
        PaymentInfoModel paymentInfoModel = new PaymentInfoModel(VehicleTypeInfoModel.MOTOCYCLE, testPlate);
        assertNotNull(paymentInfoModel);
    }
}