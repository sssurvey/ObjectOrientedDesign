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
        this.vid = NumberFormatter.formatToEightDigitStringVid(IdGenerator.generateVid());
        this.visitorPaymentInfoModel = new VisitorPaymentInfoModel(card, nameOnCard, expirationDate, zip);
    }

    public VisitorModel(String name, String email, VisitorPaymentInfoModel visitorPaymentInfoModel) {
    }

    public VisitorModel(String name, String email) {
    }

    public VisitorModel() {
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
         * @param expirationDate the expirationDate to set
         */
        public void setExpirationDate(String expirationDate) {
            this.expirationDate = expirationDate;
        }

        /**
         * @param nameOnCard the nameOnCard to set
         */
        public void setNameOnCard(String nameOnCard) {
            this.nameOnCard = nameOnCard;
        }

        /**
         * @param zip the zip to set
         */
        public void setZip(int zip) {
            this.zip = zip;
        }

        /**
         * @return the card
         */
        public String getCard() {
            return card;
        }

        /**
         * @return the expirationDate
         */
        public String getExpirationDate() {
            return expirationDate;
        }

        /**
         * @return the nameOnCard
         */
        public String getNameOnCard() {
            return nameOnCard;
        }

        /**
         * @return the zip
         */
        public int getZip() {
            return zip;
        }
    }
}