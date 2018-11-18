package model.visitorModel;

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
        this.vid = NumberFormatter.formatToFiveDigitStringVid(IdGenerator.generateVid());
        this.visitorPaymentInfoModel = new VisitorPaymentInfoModel(card, nameOnCard, expirationDate, zip);
    }

    public VisitorModel(String name, String email, VisitorPaymentInfoModel visitorPaymentInfoModel) {
        this.name = name;
        this.email = email;
        this.visitorPaymentInfoModel = visitorPaymentInfoModel;
        this.vid = NumberFormatter.formatToFiveDigitStringVid(IdGenerator.generateVid());
    }

    public VisitorModel(String name, String email) {
        this.name = name;
        this.email = email;
        this.vid = NumberFormatter.formatToFiveDigitStringVid(IdGenerator.generateVid());
    }

    public VisitorModel() {
        this.vid = NumberFormatter.formatToFiveDigitStringVid(IdGenerator.generateVid());
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param vid the vid to set
     */
    public void setVid(String vid) {
        this.vid = vid;
    }

    /**
     * @return the vid
     */
    public String getVid() {
        return vid;
    }

    public void setupVisitorPaymentInfoModel(String card, String nameOnCard, String expirationDate, int zip) {
        this.visitorPaymentInfoModel = new VisitorPaymentInfoModel(card, nameOnCard, expirationDate, zip);
    }

    /**
     * @param visitorPaymentInfoModel the visitorPaymentInfoModel to set
     */
    public void setVisitorPaymentInfoModel(VisitorPaymentInfoModel visitorPaymentInfoModel) {
        this.visitorPaymentInfoModel = visitorPaymentInfoModel;
    }

    /**
     * @return the visitorPaymentInfoModel
     */
    public VisitorPaymentInfoModel getVisitorPaymentInfoModel() {
        return visitorPaymentInfoModel;
    }

    public String getCard() {
        return this.visitorPaymentInfoModel.getCard();
    }

    public void setCard(String card) {
        this.visitorPaymentInfoModel.setCard(card);
    }

    public String getExpirationDate() {
        return visitorPaymentInfoModel.getExpirationDate();
    }

    public String getNameOnCard() {
        return visitorPaymentInfoModel.getNameOnCard();
    }

    public int getZip() {
        return visitorPaymentInfoModel.getZip();
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

        /**
         * @param card the card to set
         */
        public void setCard(String card) {
            this.card = card;
        }

        /**
         * @return the card
         */
        private String getCard() {
            return card;
        }

        /**
         * @return the expirationDate
         */
        private String getExpirationDate() {
            return expirationDate;
        }

        /**
         * @return the nameOnCard
         */
        private String getNameOnCard() {
            return nameOnCard;
        }

        /**
         * @return the zip
         */
        private int getZip() {
            return zip;
        }
    }
}