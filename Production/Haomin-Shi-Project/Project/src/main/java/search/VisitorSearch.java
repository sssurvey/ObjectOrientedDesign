package search;

import java.util.ArrayList;
import java.util.List;

import jsonUtil.VisitorModelToJsonConvertor;
import model.visitorModel.VisitorModel;
import storage.StorageEntity;

public class VisitorSearch {

    public static List<VisitorModel> search(String key) {
        List<VisitorModel> matchList = new ArrayList<>();
        for (VisitorModel visitorModel : StorageEntity.ALL_VISITORS) {
            String visitorString = VisitorModelToJsonConvertor.visitorBasicToJson(visitorModel);
            if (visitorString.contains(key)) {
                matchList.add(visitorModel);
            }
        }
        return matchList;
    }
}