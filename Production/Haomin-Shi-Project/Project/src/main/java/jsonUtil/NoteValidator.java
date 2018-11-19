package jsonUtil;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.noteModel.NoteEntry;

public class NoteValidator {
    public NoteEntry noteValidation(String noteJSON) throws Exception {
        NoteEntry noteEntry = jsonParser(noteJSON);
        return noteEntry;
    }

    public NoteEntry noteValidation(String noteJSON, long pid) throws Exception {
        NoteEntry noteEntry = jsonParser(noteJSON, pid);
        return noteEntry;
    }

    private NoteEntry jsonParser(String noteJSON) throws Exception {

        NoteEntry noteEntry = null;

        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(noteJSON);

        if (jsonElement.isJsonObject()) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            noteEntry = new NoteEntry(jsonObject.get("title").getAsString(), jsonObject.get("text").getAsString(),
                    jsonObject.get("vid").getAsString());
        } else {
            throw new Exception("Not valid JSON");
        }
        return noteEntry;
    }

    private NoteEntry jsonParser(String noteJSON, long pid) throws Exception {

        NoteEntry noteEntry = null;

        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(noteJSON);

        if (jsonElement.isJsonObject()) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            noteEntry = new NoteEntry(jsonObject.get("title").getAsString(), jsonObject.get("text").getAsString(),
                    jsonObject.get("vid").getAsString(), pid);
        }
        return noteEntry;
    }
}