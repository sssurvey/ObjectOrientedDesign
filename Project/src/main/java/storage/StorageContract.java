package storage;

import java.util.List;

import model.noteModel.NoteEntry;
import model.noteModel.NoteModel;
import park.Park;

public interface StorageContract {

    public void savePark(Park park);

    public void updatePark(Park park, String pid);

    public boolean deletePark(String pid);

    public int getTotalParkCount();

    public Park getParkAtIndex(int index);

    public Park getParkByPid(String pid);

    public void saveNoteModel(NoteModel noteModel);

    public boolean isNoteModelCreated(String pid);

    public boolean updateNoteModel(NoteEntry noteEntry, String pid);

    public boolean updateNoteByNid(NoteEntry noteEntry);

    public NoteModel getNoteModelByPid(String pid);

    public NoteEntry getNoteByPidAndNid(String pid, String nid);

    public List<NoteModel> getAllNoteModel();

    public String getNoteByNid(String nid);
}