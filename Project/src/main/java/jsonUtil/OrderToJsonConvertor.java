package jsonUtil;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import model.orderModel.OrderModel;
import model.orderModel.OrderModel.PaymentProcessingStatus;
import model.visitorModel.VisitorModel;
import util.NumberFormatter;
import util.PriceCalculator;

public class OrderToJsonConvertor {
    public static String orderToJsonOidResponse(OrderModel orderModel) {
        Gson gson = new Gson();
        JsonObject oidReturn = new JsonObject();
        oidReturn.addProperty("oid", orderModel.getOid());
        return gson.toJson(oidReturn);
    }

    public static String orderToJsonDetailed(OrderModel orderModel) {
        Gson gson = new Gson();
        return gson.toJson(new AllOrderReturnModelDetailed(orderModel));
    }

    public static String convertListOrderModelToOutputJSON(List<OrderModel> list) {
        Gson gson = new Gson();
        List<AllOrderReturnModel> allOrderReturnModelList = new ArrayList<>();
        for (OrderModel orderModel : list) {
            allOrderReturnModelList.add(new AllOrderReturnModel(orderModel));
        }
        return gson.toJson(allOrderReturnModelList);
    }

    static class AllOrderReturnModel {

        private String oid;
        private String pid;
        private String date;
        private String type;
        private int amount;

        AllOrderReturnModel(OrderModel orderModel) {
            this.oid = orderModel.getOid();
            this.pid = orderModel.getPid();
            this.date = orderModel.getDate();
            this.type = orderModel.getVehicleModel().getType();
            this.amount = PriceCalculator.getPrice(orderModel);
        }
    }

    private static class AllOrderReturnModelDetailed {

        private String oid;
        private String pid;
        private String vid;
        private String date;
        private String type;
        private int amount;
        private VisitorModelNoVid visitor;
        private PaymentProcessingStatus paymentProcessingStatus;

        private AllOrderReturnModelDetailed(OrderModel orderModel) {
            this.oid = orderModel.getOid();
            this.pid = orderModel.getPid();
            this.date = orderModel.getDate();
            this.type = orderModel.getVehicleModel().getType();
            this.amount = PriceCalculator.getPrice(orderModel);
            this.paymentProcessingStatus = orderModel.getPaymentProcessingStatus();
            this.visitor = new VisitorModelNoVid(orderModel.getVisitorModel());
            this.vid = orderModel.getVisitorModel().getVid();
            String cardNumber = visitor.getVisitorPaymentModel().getCard();
            this.visitor.getVisitorPaymentModel().setCard(NumberFormatter.showLastFourDigit(cardNumber));
        }

        private static class VisitorModelNoVid {

            private VisitorPaymentModel visitorPaymentModel;

            private VisitorModelNoVid(VisitorModel visitorModel) {
                this.visitorPaymentModel = new VisitorPaymentModel(visitorModel);
            }

            /**
             * @return the visitorPaymentModel
             */
            private VisitorPaymentModel getVisitorPaymentModel() {
                return visitorPaymentModel;
            }

            private static class VisitorPaymentModel {
                private String card;
                private String nameOnCard;
                private String expirationDate;
                private int zip;

                private VisitorPaymentModel(VisitorModel visitorModel) {
                    this.card = visitorModel.getCard();
                    this.nameOnCard = visitorModel.getNameOnCard();
                    this.expirationDate = visitorModel.getExpirationDate();
                    this.zip = visitorModel.getZip();
                }

                /**
                 * @return the card
                 */
                private String getCard() {
                    return card;
                }

                /**
                 * @param card the card to set
                 */
                private void setCard(String card) {
                    this.card = card;
                }
            }
        }
    }
}