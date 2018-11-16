package jsonUtil;

import java.util.List;

import com.google.gson.Gson;

import model.noteModel.NoteEntry;
import model.noteModel.NoteModel;

public class NoteToJsonConvertor {

    public static String noteToJsonNidResponse(NoteEntry noteEntry) {
        Gson gson = new Gson();
        return gson.toJson(new NoteEntryNidReturnModel(noteEntry));
    }

    public static String noteModelToJson(NoteModel noteModel) {
        Gson gson = new Gson();
        return gson.toJson(noteModel.getNoteList());
    }

    public static String noteEntryToJson(NoteEntry noteEntry, String pid) {
        Gson gson = new Gson();
        return gson.toJson(new NoteEntryPidNidReturnModel(noteEntry, pid));
    }
    
    public static String allNoteToJson(List<NoteModel> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    private static class NoteEntryNidReturnModel {
        private String nid;

        private NoteEntryNidReturnModel(NoteEntry noteEntry) {
            this.nid = noteEntry.getNid();
        }
    }

    private static class NoteEntryPidNidReturnModel {
        private String pid;
        private String nid;
        private String vid;
        private String date;
        private String title;
        private String text;

        private NoteEntryPidNidReturnModel(NoteEntry noteEntry, String pid) {
            this.pid = pid;
            this.nid = noteEntry.getNid();
            this.vid = noteEntry.getVid();
            this.date = noteEntry.getDate();
            this.title = noteEntry.getTitle();
            this.text = noteEntry.getText();
        }
    }
}