package storage;

import java.util.ArrayList;
import java.util.List;

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
    public void updatePark(Park park, String pid) {
        for (Park tempPark : StorageEntity.ALL_PARKS) {
            if (pid.equals(tempPark.getPid())) {
                StorageEntity.replaceEntryAtIndex(StorageEntity.ALL_PARKS.indexOf(tempPark), park);
            }
        }
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
                    tempNote.addNote(noteEntry);
                }
            }
            StorageEntity.addEntry(new NoteModel(pid, noteEntry));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public NoteModel getNoteModelByPid(String pid) {
        for (NoteModel tempNoteModel : StorageEntity.ALL_NOTES) {
            if (pid.equals(tempNoteModel.getPid())) {
                return tempNoteModel;
            }
        }
        return null;
    }

    @Override
    public NoteEntry getNoteByPidAndNid(String pid, String nid) {
        NoteModel noteModel = getNoteModelByPid(pid);
        if (noteModel != null) {
            for (NoteEntry tempNoteEntry : noteModel.getNoteList()) {
                if (nid.equals(tempNoteEntry.getNid()))
                    return tempNoteEntry;
            }
        }
        return null;
    }

    private List<String> updateAllPids() {
        List<String> pidList = new ArrayList<>();
        for (Park temPark : StorageEntity.ALL_PARKS) {
            pidList.add(temPark.getPid());
        }
        return pidList;
    }
}