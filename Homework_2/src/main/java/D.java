public class D extends B {
    // At current level, we only care that ->
    // based on the UML diagram:
    // Class D is Associated with B
    // Class C is is Depended on B

    private String infoAboutClass;

    public D() {
        super();
        this.infoAboutClass = "This is class D, LOL, and I extend class B";
    }

    @Override
    public void setEditable(String editable) {
        System.out.println("Overrided  the function in class B");
        super.setEditable(editable);
    }

    @Override
    public String getEditable() {
        return super.getEditable();
    }

    @Override
    public String getInfoAboutClass() {
        return this.infoAboutClass;
    }
}