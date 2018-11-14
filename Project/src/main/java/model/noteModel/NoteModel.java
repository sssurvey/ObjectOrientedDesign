package model.noteModel;

import java.util.ArrayList;
import java.util.List;

import park.Park;

public class NoteModel {

    private String pid;
    private List<NoteEntry> noteList = new ArrayList<>();

    public NoteModel(Park park) {
        this.pid = park.getPid();
    }

    public void addNote(String title, String text, String vid) {
        noteList.add(new NoteEntry(title, text, vid));
    }

    /**
     * @return the pid
     */
    public String getPid() {
        return pid;
    }

    public NoteEntry getNote(String nid) {
        NoteEntry noteEntry = null;
        for (NoteEntry tempNote : noteList) {
            if (nid.equals(tempNote.getNid()))
                return tempNote;
        }
        return noteEntry;
    }

    /**
     * @return the noteList
     */
    public List<NoteEntry> getNoteList() {
        return noteList;
    }
}