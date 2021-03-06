package storage;

import java.util.ArrayList;
import java.util.List;

import model.noteModel.NoteEntry;
import model.noteModel.NoteModel;
import model.orderModel.OrderModel;
import model.visitorModel.VisitorModel;
import park.Park;

public class Storage implements StorageContract {

    // TODO only one instance of this class shuld be existed...

    @Override
    public void savePark(Park park) {
        StorageEntity.addEntry(park);
    }

    @Override
    public boolean updatePark(Park park, String pid) {
        for (Park tempPark : StorageEntity.ALL_PARKS) {
            if (pid.equals(tempPark.getPid())) {
                StorageEntity.replaceEntryAtIndex(StorageEntity.ALL_PARKS.indexOf(tempPark), park);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deletePark(String pid) {
        for (Park tempPark : StorageEntity.ALL_PARKS) {
            if (pid.equals(tempPark.getPid())) {
                StorageEntity.removePark(StorageEntity.ALL_PARKS.indexOf(tempPark));
                return true; // no more loop after this
            }
        }
        return false;
    }

    @Override
    public int getTotalParkCount() {
        return StorageEntity.getTotalParkCount();
    }

    @Override
    public Park getParkAtIndex(int index) {
        return StorageEntity.getParkAtIndex(index);
    }

    @Override
    public Park getParkByPid(String pid) {
        for (Park tempPark : StorageEntity.ALL_PARKS) {
            if (pid.equals(tempPark.getPid())) {
                return tempPark;
            }
        }
        return null;
    }

    @Override
    public void saveNoteModel(NoteModel noteModel) {
        StorageEntity.addEntry(noteModel);
    }

    @Override
    public boolean isNoteModelCreated(String pid) {
        for (NoteModel tempNote : StorageEntity.ALL_NOTES) {
            if (pid.equals(tempNote.getPid())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateNoteModel(NoteEntry noteEntry, String pid) {
        List<String> pidList = updateAllPids();
        if (pidList.contains(pid)) { // check if the park linked to the list is created
            for (NoteModel tempNote : StorageEntity.ALL_NOTES) {
                if (pid.equals(tempNote.getPid())) {
                    tempNote.getNoteList().add(noteEntry);
                    return true;
                }
            }
            StorageEntity.addEntry(new NoteModel(pid, noteEntry));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public NoteModel getNoteModelByPid(String pid) throws Exception {
        for (NoteModel tempNoteModel : StorageEntity.ALL_NOTES) {
            if (pid.equals(tempNoteModel.getPid())) {
                return tempNoteModel;
            }
        }
        throw new Exception("PID not found");
    }

    @Override
    public NoteEntry getNoteByPidAndNid(String pid, String nid) throws Exception {
        NoteModel noteModel = null;
        try {
            noteModel = getNoteModelByPid(pid);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (noteModel != null) {
            for (NoteEntry tempNoteEntry : noteModel.getNoteList()) {
                if (nid.equals(tempNoteEntry.getNid()))
                    return tempNoteEntry;
            }
        }
        throw new Exception("Pid Nid Combination Not found");
    }

    // TODO,!!! very bad implementation, no consistancy...
    @Override
    @SuppressWarnings("unchecked")
    public List getNoteByNid(String nid) throws Exception {

        NoteEntry noteEntry = null;
        List list = new ArrayList<>();
        String pid = null;

        for (int i = 0; i < StorageEntity.getTotalParkCount(); i++) {
            try {
                pid = StorageEntity.getParkAtIndex(i).getPid();
                noteEntry = getNoteByPidAndNid(pid, nid);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (noteEntry != null) {
                list.add(noteEntry);
                list.add(pid);
                return list;
            }
        }
        throw new Exception("Note Not found exception");
    }

    @Override
    public boolean updateNoteByNid(NoteEntry noteEntry) {
        for (NoteModel noteModel : StorageEntity.ALL_NOTES) {
            for (NoteEntry tempNoteEntry : noteModel.getNoteList()) {
                if (noteEntry.getNid().equals(tempNoteEntry.getNid())) {
                    noteModel.getNoteList().set(noteModel.getNoteList().indexOf(tempNoteEntry), noteEntry);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<NoteModel> getAllNoteModel() {
        List<NoteModel> allNoteList = new ArrayList<>(StorageEntity.ALL_NOTES);
        return allNoteList;
    }

    @Override
    public List<NoteEntry> getAllNoteEntryByVid(String vid) {
        List<NoteEntry> returnNoteEntries = new ArrayList<>();
        for (NoteModel noteModel : StorageEntity.ALL_NOTES) {
            for (NoteEntry noteEntry : noteModel.getNoteList()) {
                if (noteEntry.getVid().equals(vid))
                    returnNoteEntries.add(noteEntry);
            }
        }
        return returnNoteEntries;
    }

    @Override
    public void saveOrder(OrderModel orderModel) {
        StorageEntity.addEntry(orderModel);
    }

    @Override
    public List<OrderModel> getAllOrderModel() {
        List<OrderModel> allOrderList = new ArrayList<OrderModel>(StorageEntity.ALL_ORDERS);
        return allOrderList;
    }

    @Override
    public OrderModel getOrderModelByOid(String oid) throws Exception {
        for (OrderModel orderModel : StorageEntity.ALL_ORDERS) {
            if (oid.equals(orderModel.getOid())) {
                return orderModel;
            }
        }
        throw new Exception("Oid not found");
    }

    @Override
    public List<VisitorModel> getAllVisitors() {
        List<VisitorModel> visitorList = new ArrayList<>();
        for (OrderModel orderModel : StorageEntity.ALL_ORDERS) {
            visitorList.add(orderModel.getVisitorModel());
        }
        return visitorList;
    }

    @Override
    public VisitorModel getVisitorByVid(String vid) {
        for (VisitorModel visitorModel : StorageEntity.ALL_VISITORS) {
            if (visitorModel.getVid().equals(vid))
                return visitorModel;
        }
        return null;
    }

    @Override
    public List<OrderModel> getOrderModelByVid(String vid) {
        List<OrderModel> returnList = new ArrayList<>();
        for (OrderModel orderModel : StorageEntity.ALL_ORDERS) {
            returnList.add(orderModel);
        }
        return returnList;
    }

    private List<String> updateAllPids() {
        List<String> pidList = new ArrayList<>();
        for (Park temPark : StorageEntity.ALL_PARKS) {
            pidList.add(temPark.getPid());
        }
        return pidList;
    }
}