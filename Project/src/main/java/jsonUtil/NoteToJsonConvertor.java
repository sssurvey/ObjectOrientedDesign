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

    private static class NoteEntryNidReturnModel {
        private String nid;

        private NoteEntryNidReturnModel(NoteEntry noteEntry) {
            this.nid = noteEntry.getNid();
        }
    }
}