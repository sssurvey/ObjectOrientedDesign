import jsonUtil.ParkValidator;
import park.Park;
import storage.Storage;
import storage.StorageContract;

public class AppPresenter implements AppContract {

	private StorageContract storageContract = new Storage();
	private ParkValidator parkValidator = new ParkValidator();

	@Override
	public String createPark(String parkJSON) throws Exception {
		Park park = parkValidator.parkValidation(parkJSON);
		storageContract.savePark(park);
		return park.getPid();
	}

	@Override
	public String updatePark(String pid, String parkJSON) throws Exception {
		Park park = parkValidator.parkValidation(parkJSON);
		if (storageContract.updatePark(park, pid))
			return park.getPid();
		throw new Exception("PID of provided is not yet created");
	}

	@Override
	public String deletePark(String pid) {
		return null;
	}

	@Override
	public String getAllParks() {
		return null;
	}

	@Override
	public String getParkDetail(String pid) {
		return null;
	}

	@Override
	public String createNoteAssociateToPark(String pid, String noteJSON) {
		return null;
	}

	@Override
	public String getAllNoteAssociateToPark(String pid) {
		return null;
	}

	@Override
	public String getNoteEntryViaNidAndPid(String pid, String nid) {
		return null;
	}

	@Override
	public String getAllNotes() {
		return null;
	}

	@Override
	public String getNoteViaNid(String nid) {
		return null;
	}

	@Override
	public String updateNoteByPid(String nid, String noteJSON) {
		return null;
	}

}