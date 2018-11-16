package model.visitorModel;

import model.parkModel.PaymentInfoModel;
import util.IdGenerator;
import util.NumberFormatter;

public class VisitorModel {

    private String name;
    private String email;
    private String vid;
    private VisitorPaymentInfoModel visitorPaymentInfoModel;

    public VisitorModel(String name, String email, String card, String nameOnCard, String expirationDate, int zip) {
        this.name = name;
        this.email = email;
        this.vid = NumberFormatter.formatToEightDigitStringNid(IdGenerator.generateVid());
        this.visitorPaymentInfoModel = new VisitorPaymentInfoModel(card, nameOnCard, expirationDate, zip);
    }

    private class VisitorPaymentInfoModel {

        private String card;
        private String nameOnCard;
        private String expirationDate;
        private int zip;

        private VisitorPaymentInfoModel(String card, String nameOnCard, String expirationDate, int zip) {
            this.card = card;
            this.nameOnCard = nameOnCard;
            this.expirationDate = expirationDate;
            this.zip = zip;
        }
    }
}