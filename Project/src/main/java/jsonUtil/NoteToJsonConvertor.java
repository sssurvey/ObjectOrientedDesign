package jsonUtil;

import com.google.gson.Gson;

import model.noteModel.NoteEntry;

public class NoteToJsonConvertor {

    public static String NoteToJsonNidResponse(NoteEntry noteEntry) {
        Gson gson = new Gson();
        return gson.toJson(new NoteEntryNidReturnModel(noteEntry));
    }

    private static class NoteEntryNidReturnModel {
        private String nid;

        private NoteEntryNidReturnModel(NoteEntry noteEntry) {
            this.nid = noteEntry.getNid();
        }
    }
}