package jsonUtil;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import model.parkModel.LocationInfoModel;
import park.Park;

public class ParkToJsonConvertor {

    public static String parkToJsonModel(Park park) {
        Gson gson = new Gson();
        return gson.toJson(park);
    }

    public static OutputJsonModelLocationAndPid parkToJsonLoactionInfoAndPidToJson(Park park) {
        return new OutputJsonModelLocationAndPid(park.getPid(), park.getLocationInfoModel());
    }

    public static String parkListToJsonLocationInfo(List<Park> parkList) {
        List<OutputJsonModelLocationAndPid> returnList = new ArrayList<>();
        for (Park park : parkList) {
            returnList.add(new OutputJsonModelLocationAndPid(park.getPid(), park.getLocationInfoModel()));
        }
        return listToJson(returnList);
    }

    private static String listToJson(List parksList) {
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