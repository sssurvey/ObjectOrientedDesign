package jsonUtil;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import model.noteModel.NoteModel;
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

    public static String visitorModelToJsonDetailed(VisitorModel visitorModel, OrderModel orderModel,
            NoteModel noteModel) {
        Gson gson = new Gson();
        return null;
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
    }
}