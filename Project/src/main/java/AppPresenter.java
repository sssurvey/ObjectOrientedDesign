import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import jsonUtil.NoteToJsonConvertor;
import jsonUtil.NoteValidator;
import jsonUtil.OrderToJsonConvertor;
import jsonUtil.OrderValidator;
import jsonUtil.ParkToJsonConvertor;
import jsonUtil.ParkValidator;
import jsonUtil.VisitorModelToJsonConvertor;
import model.noteModel.NoteEntry;
import model.noteModel.NoteModel;
import model.orderModel.OrderModel;
import model.visitorModel.*;
import park.Park;
import search.NoteSearch;
import search.ParkSearch;
import storage.Storage;
import storage.StorageContract;

public class AppPresenter implements AppContract {
    // TODO: externalize all the exception to an enum
    private StorageContract storageContract = new Storage();
    private ParkValidator parkValidator = new ParkValidator();
    private NoteValidator noteValidator = new NoteValidator();
    private OrderValidator orderValidator = new OrderValidator();

    private Gson gson = new Gson();

    @Override
    public String createPark(String parkJSON) throws Exception {
        Park park = parkValidator.parkValidation(parkJSON);
        JsonObject pidReturn = new JsonObject();
        storageContract.savePark(park);
        pidReturn.addProperty("pid", park.getPid());
        return gson.toJson(pidReturn);
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
        // TODO: use a better exception to replace this
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
        return NoteToJsonConvertor.allNoteToJson(storageContract.getAllNoteModel());
    }

    @Override
    public String getNoteViaNid(String nid) throws Exception {
        List list = storageContract.getNoteByNid(nid);
        NoteEntry noteEntry = (NoteEntry) list.get(0);
        String pid = (String) list.get(1);
        return NoteToJsonConvertor.noteEntryToJson(noteEntry, pid);
    }

    @Override
    public String updateNoteByPid(String nid, String noteJSON) throws Exception {
        NoteEntry noteEntry = noteValidator.noteValidation(noteJSON, Long.parseLong(nid));
        if (storageContract.updateNoteByNid(noteEntry))
            return NoteToJsonConvertor.noteToJsonNidResponse(noteEntry);
        else
            return null;
    }

    @Override
    public String createOrder(String orderJSON) throws Exception {
        OrderModel orderModel = orderValidator.orderValidation(orderJSON);
        storageContract.saveOrder(orderModel);
        return OrderToJsonConvertor.orderToJsonOidResponse(orderModel);
    }

    @Override
    public String getAllOrder() {
        List<OrderModel> list = storageContract.getAllOrderModel();
        return OrderToJsonConvertor.convertListOrderModelToOutputJSON(list);
    }

    @Override
    public String getOrderByOid(String oid) throws Exception {
        return OrderToJsonConvertor.orderToJsonDetailed(storageContract.getOrderModelByOid(oid));
    }

    @Override
    public String getAllVisitor() {
        return VisitorModelToJsonConvertor.visitorListToJson(storageContract.getAllVisitors());
    }

    @Override
    public String getVisitorDetailByVid(String vid) throws Exception {
        List<OrderModel> allOrders;
        List<NoteEntry> allNotes;
        VisitorModel visitorModel = storageContract.getVisitorByVid(vid);
        if (visitorModel != null) {
            allOrders = storageContract.getOrderModelByVid(vid);
            allNotes = storageContract.getAllNoteEntryByVid(vid);
            return VisitorModelToJsonConvertor.visitorDetailToJson(visitorModel, allOrders, allNotes);
        }
        throw new Exception("vid not found");
    }

    @Override
    public String searchParks(String key) {
        if (key == null) {
            return getAllParks();
        } else {
            return ParkToJsonConvertor.parkListToJsonLocationInfo(ParkSearch.search(key));
        }
    }

    @Override
    public String searchNotes(String key) {
        if (key == null) {
            return getAllNotes();
        } else {
            return NoteToJsonConvertor.allNoteToJson(NoteSearch.search(key));
        }
    }
}