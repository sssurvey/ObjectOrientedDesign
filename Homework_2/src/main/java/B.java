public class B {
    // At current level, we only care that ->
    // based on the UML diagram:
    // Class A will be depend to B
    // Class D Associate with B

    private String infoAboutClass;
    private String editable;    // I created this for other class to use

    public B (){
        this.infoAboutClass = "This is class B, hello, and stay Classy";
    }

    public String getInfoAboutClass() {
        return infoAboutClass;
    }

    public void setEditable(String editable) {
        this.editable = editable;
    }

    public String getEditable() {
        return editable;
    }
}
