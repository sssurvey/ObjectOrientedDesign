package storage;

import java.util.ArrayList;
import java.util.List;

import jsonUtil.NoteToJsonConvertor;
import model.noteModel.NoteEntry;
import model.noteModel.NoteModel;
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
    public String getNoteByNid(String nid) {
        NoteEntry noteEntry = null;
        for (int i = 0; i < StorageEntity.getTotalParkCount(); i++) {
            try {
                noteEntry = getNoteByPidAndNid(StorageEntity.getParkAtIndex(i).getPid(), nid);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (noteEntry != null)
                return NoteToJsonConvertor.noteEntryToJson(noteEntry, StorageEntity.getParkAtIndex(i).getPid());
        }
        return null;
    }

    @Override
    public boolean updateNoteByNid(NoteEntry noteEntry) {
        for (NoteModel noteModel : StorageEntity.ALL_NOTES) {
            for (NoteEntry tempNoteEntry : noteModel.getNoteList()) {
                if (noteEntry.getNid().equals(tempNoteEntry.getNid())) {
                    tempNoteEntry = noteEntry;
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

    private List<String> updateAllPids() {
        List<String> pidList = new ArrayList<>();
        for (Park temPark : StorageEntity.ALL_PARKS) {
            pidList.add(temPark.getPid());
        }
        return pidList;
    }
}