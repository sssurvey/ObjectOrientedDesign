import org.junit.Test;
import static org.junit.Assert.*;

import java.io.EOFException;

public class AppPresenterTest {

    AppPresenter presenter = new AppPresenter();

    @Test
    public void createParkTest() {
        try {
            assertNotNull(presenter.createPark(""));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateParkTest() {
        try {
            assertNotNull(presenter.updatePark("", ""));
        } catch (Exception e) {
            assertNotNull(e);
        }
    }

    @Test
    public void getAllParksTest() {
        assertNotNull(presenter.getAllParks());
    }

    @Test
    public void getAllNotesTest() {
        try {
            assertNotNull(presenter.getAllNoteAssociateToPark(""));
        } catch (Exception e) {
            assertNotNull(e);
        }
    }

    @Test
    public void createOrderTest() {
        try {
            assertNotNull(presenter.createOrder(""));
        } catch (Exception e) {
            assertNotNull(e);
        }
    }

    @Test
    public void getAllOrdersTest() {
        try {
            assertNotNull(presenter.getAllOrder());
        } catch (Exception e) {
            assertNotNull(e);
        }
    }

    @Test
    public void getOrderTest() {
        try {
            assertNotNull(presenter.getOrderByOid(""));
        } catch (Exception e) {
            assertNotNull(e);
        }
    }

    @Test
    public void getAllVisitor() {
        try {
            assertNotNull(presenter.getAllVisitor());
        } catch (Exception e) {
            assertNotNull(e);
        }
    }

    @Test
    public void getVisitorByVidTest() {
        try {
            assertNotNull(presenter.getVisitorDetailByVid(""));
        } catch (Exception e) {
            assertNotNull(e);
        }
    }
}