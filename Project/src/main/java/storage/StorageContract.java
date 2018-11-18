package storage;

import java.util.List;

import model.noteModel.NoteEntry;
import model.noteModel.NoteModel;
import model.orderModel.OrderModel;
import model.visitorModel.VisitorModel;
import park.Park;

public interface StorageContract {

    public void savePark(Park park);

    public boolean updatePark(Park park, String pid);

    public boolean deletePark(String pid);

    public int getTotalParkCount();

    public Park getParkAtIndex(int index);

    public Park getParkByPid(String pid);

    public void saveNoteModel(NoteModel noteModel);

    public boolean isNoteModelCreated(String pid);

    public boolean updateNoteModel(NoteEntry noteEntry, String pid);

    public boolean updateNoteByNid(NoteEntry noteEntry);

    public NoteModel getNoteModelByPid(String pid) throws Exception;

    public NoteEntry getNoteByPidAndNid(String pid, String nid) throws Exception;

    public List<NoteModel> getAllNoteModel();

    public List getNoteByNid(String nid) throws Exception;

    public void saveOrder(OrderModel orderModel);

    public List<OrderModel> getAllOrderModel();

    public OrderModel getOrderModelByOid(String pid) throws Exception;

    public List<VisitorModel> getAllVisitors();
}