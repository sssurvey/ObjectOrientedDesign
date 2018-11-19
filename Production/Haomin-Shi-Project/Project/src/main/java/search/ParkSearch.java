package search;

import java.util.ArrayList;
import java.util.List;

import jsonUtil.ParkToJsonConvertor;
import park.Park;
import storage.StorageEntity;

public class ParkSearch {

    public static List<Park> search(String key) {
        List<Park> matchList = new ArrayList<>();
        for (Park park : StorageEntity.ALL_PARKS) {
            String parkString = ParkToJsonConvertor.parkToJsonModel(park);
            if (parkString.contains(key)) {
                matchList.add(park);
            }
        }
        return matchList;
    }
}