import org.junit.Test;
import static org.junit.Assert.*;
import model.PaymentInfoModel;

public class PaymentInfoModelTest {

    private int[] testPlate = { 4, 5 };

    @Test
    public void testPaymentInfoModelCreation() {
        PaymentInfoModel paymentInfoModel = new PaymentInfoModel("Motocycle", testPlate);
        assertNotNull(paymentInfoModel);
    }
}