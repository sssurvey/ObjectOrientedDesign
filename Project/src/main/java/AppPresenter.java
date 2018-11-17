import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import jsonUtil.NoteToJsonConvertor;
import jsonUtil.NoteValidator;
import jsonUtil.ParkToJsonConvertor;
import jsonUtil.ParkValidator;
import model.noteModel.NoteEntry;
import model.noteModel.NoteModel;
import park.Park;
import storage.Storage;
import storage.StorageContract;

public class AppPresenter implements AppContract {
	// TODO: externalize all the exception to an enum
	private StorageContract storageContract = new Storage();
	private ParkValidator parkValidator = new ParkValidator();
	private NoteValidator noteValidator = new NoteValidator();

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
	public String getParkDetail(String pid) throws Exception {
		Park park = storageContract.getParkByPid(pid);
		if (park != null)
			return ParkToJsonConvertor.parkToJsonModel(park);
		throw new Exception("PID not found");
	}

	@Override
	public String createNoteAssociateToPark(String pid, String noteJSON) throws Exception {
		NoteEntry noteEntry = noteValidator.noteValidation(noteJSON);
		if (storageContract.updateNoteModel(noteEntry, pid)) {
			return NoteToJsonConvertor.noteToJsonNidResponse(noteEntry);
		}
		//TODO: use a better exception to replace this
		throw new EOFException("pidNotFoundException");
	}

	@Override
	public String getAllNoteAssociateToPark(String pid) throws Exception {
		NoteModel noteModel = storageContract.getNoteModelByPid(pid);
		return NoteToJsonConvertor.noteModelToJson(noteModel);
	}

	@Override
	public String getNoteEntryViaNidAndPid(String pid, String nid) throws Exception {
		NoteEntry noteEntry = storageContract.getNoteByPidAndNid(pid, nid);
		return NoteToJsonConvertor.noteEntryToJson(noteEntry, pid);
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