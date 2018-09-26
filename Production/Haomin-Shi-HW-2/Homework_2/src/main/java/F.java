public class F {
    // At current level, we only care that ->
    // based on the UML diagram:
    // Class F have 2 D

    private D dDependent;

    private String infoAboutClass;

    public F(D d) {
        this.dDependent = d;
        this.infoAboutClass = "This is Class F, I have 2 instances of D";
    }

    public String getInfoAboutClass() {
        return infoAboutClass;
    }

    public int instanceCounter() {
        D[] darray = new D[2];
        darray[0] = new D();
        darray[1] = new D();

        for (D d : darray) d.getInfoAboutClass();

        return darray.length;
    }
}
