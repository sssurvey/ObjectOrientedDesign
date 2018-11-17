import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import jsonUtil.ParkToJsonConvertor;
import jsonUtil.ParkValidator;
import park.Park;
import storage.Storage;
import storage.StorageContract;

public class AppPresenter implements AppContract {
	// TODO: externalize all the exception to an enum
	private StorageContract storageContract = new Storage();
	private ParkValidator parkValidator = new ParkValidator();
	private Gson gson = new Gson();

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
	public void deletePark(String pid) throws Exception {
		if (storageContract.deletePark(pid))
			return;
		throw new Exception("PID not found");
	}

	@Override
	@SuppressWarnings("unchecked")
	public String getAllParks() {

		List allParkList = new ArrayList<>();

		for (int i = 0; i < storageContract.getTotalParkCount(); i++) {
			allParkList.add(ParkToJsonConvertor.parkToJsonLoactionInfoAndPidToJson(storageContract.getParkAtIndex(i)));
		}

		return gson.toJson(allParkList);
	}

	@Override
	public String getParkDetail(String pid) throws Exception{
		Park park = storageContract.getParkByPid(pid);
		if (park != null) return ParkToJsonConvertor.parkToJsonModel(park);
		throw new Exception("PID not found");
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