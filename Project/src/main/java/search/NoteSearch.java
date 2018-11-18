package search;

import java.util.ArrayList;
import java.util.List;

import jsonUtil.NoteToJsonConvertor;
import model.noteModel.NoteEntry;
import model.noteModel.NoteModel;
import storage.StorageEntity;

public class NoteSearch {

    public static List<NoteModel> search(String key) {
        List<NoteModel> matchedModels = new ArrayList<>();
        List<NoteEntry> matchEntries = new ArrayList<>();
        for (NoteModel noteModel : StorageEntity.ALL_NOTES){

            NoteModel tempNoteModel = noteModel;
        
            for (NoteEntry noteEntry : noteModel.getNoteList()){
                String noteEntryString = NoteToJsonConvertor.noteEntryToJson(noteEntry, noteModel.getPid());
                if(noteEntryString.contains(key)){
                    matchEntries.add(noteEntry);
                }
            }
            tempNoteModel.setNoteList(null);
            if(matchEntries!=null){
                tempNoteModel.setNoteList(matchEntries);
                matchEntries = null;
                matchedModels.add(tempNoteModel);
            }
        }
        return matchedModels;
    }
}