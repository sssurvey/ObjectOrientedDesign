package jsonUtil;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoProperties.Storage;

import model.parkModel.LocationInfoModel;
import park.Park;

public class ParkToJsonConvertor {

    public static String allParkToJsonLoactionInfoAndPidToJson() {
        final storage.Storage storagehelper = new storage.Storage();
        Gson gson = new Gson();
        List<OutputJsonModelLocationAndPid> allParkList = new ArrayList<>();
        for (int i = 0; i < storagehelper.getTotalParkCount(); i++) {
            allParkList.add(new OutputJsonModelLocationAndPid(storagehelper.getParkAtIndex(i).getPid(),
                    storagehelper.getParkAtIndex(i).getLocationInfoModel()));
        }
        return gson.toJson(allParkList);
    }

    private OutputJsonModelLocationAndPid parkToJsonLocationInfo(Park park) {

        Gson gson = new Gson();
        return new OutputJsonModelLocationAndPid(park.getPid(), park.getLocationInfoModel());
    }

    private static class OutputJsonModelLocationAndPid {

        private String pid;
        private LocationInfoModel location_info;

        private OutputJsonModelLocationAndPid(String pid, LocationInfoModel locationInfoModel) {
            this.pid = pid;
            this.location_info = locationInfoModel;
        }
    }
}