package jsonUtil;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import jsonUtil.OrderToJsonConvertor.AllOrderReturnModel;
import model.noteModel.NoteEntry;
import model.orderModel.OrderModel;
import model.visitorModel.VisitorModel;

public class VisitorModelToJsonConvertor {

    public static String visitorListToJson(List<VisitorModel> visitorList) {
        Gson gson = new Gson();
        List<VisitorModelBasic> outputList = new ArrayList<>();
        for (VisitorModel visitorModel : visitorList) {
            outputList.add(new VisitorModelBasic(visitorModel));
        }
        return gson.toJson(outputList);
    }

    public static String visitorDetailToJson(VisitorModel visitorModel, List<OrderModel> orderModelList,
            List<NoteEntry> noteLists) {
        Gson gson = new Gson();
        List<AllOrderReturnModel> returnOrderModels = new ArrayList<>();
        for (OrderModel orderModel : orderModelList) {
            returnOrderModels.add(new AllOrderReturnModel(orderModel));
        }
        return gson.toJson(new VisitorDetail(visitorModel, returnOrderModels, noteLists));
    }

    public static String visitorBasicToJson(VisitorModel visitorModel) {
        Gson gson = new Gson();
        return gson.toJson(new VisitorModelBasic(visitorModel));
    }

    private static class VisitorModelBasic {
        private String vid;
        private String name;
        private String email;

        private VisitorModelBasic(VisitorModel visitorModel) {
            this.vid = visitorModel.getVid();
            this.name = visitorModel.getName();
            this.email = visitorModel.getEmail();
        }

        private VisitorModelBasic(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    private static class VisitorDetail {
        private String vid;
        private VisitorModelBasic visitor;
        private List<AllOrderReturnModel> orders;
        private List<NoteEntry> noteEntries;

        private VisitorDetail(VisitorModel visitorModel, List<AllOrderReturnModel> orderModels,
                List<NoteEntry> noteEntries) {
            this.vid = visitorModel.getVid();
            this.visitor = new VisitorModelBasic(visitorModel.getName(), visitorModel.getEmail());
            this.orders = orderModels;
            this.noteEntries = noteEntries;
        }
    }

}