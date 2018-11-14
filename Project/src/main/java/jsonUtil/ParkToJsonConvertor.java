package jsonUtil;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import model.parkModel.LocationInfoModel;

public class ParkToJsonConvertor {

    public static String allParkToJsonLoactionInfoAndPidToJson() {
        final storage.Storage storagehelper = new storage.Storage();
        List<OutputJsonModelLocationAndPid> allParkList = new ArrayList<>();
        for (int i = 0; i < storagehelper.getTotalParkCount(); i++) {
            allParkList.add(new OutputJsonModelLocationAndPid(storagehelper.getParkAtIndex(i).getPid(),
                    storagehelper.getParkAtIndex(i).getLocationInfoModel()));
        }
        return parkListToJsonLocationInfo(allParkList);
    }

    private static String parkListToJsonLocationInfo(List<OutputJsonModelLocationAndPid> parksList) {
        Gson gson = new Gson();
        return gson.toJson(parksList);
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