public class E extends C {
    // At current level, we only care that ->
    // based on the UML diagram:
    // Class E will be inherit C

    private String infoAboutClass;

    public E(B b, D d) {
        super(b, d);
        this.infoAboutClass = "This is class E, I extend C";
    }

    @Override
    public String getInfoAboutClass() {
        System.out.println("Override the function in class C");
        return this.infoAboutClass;
    }

    @Override
    public String returnBinfo() {
        return super.returnBinfo();
    }

    @Override
    public String returnDinfo() {
        return super.returnDinfo();
    }
}
