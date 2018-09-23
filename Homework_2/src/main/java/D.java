public class D extends B {
    // At current level, we only care that ->
    // based on the UML diagram:
    // Class D is Associated with B
    // Class C is is Depended on B
    // Class D has five F

    private String infoAboutClass;

    public D() {
        super();
        this.infoAboutClass = "This is class D, LOL, and I extend class B";
    }

    @Override
    public void setEditable(String editable) {
        System.out.println("Override the function in class B");
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

    public int instanceCounter() {
        F[] farray = new F[5];
        farray[0] = new F(new D());
        farray[1] = new F(new D());
        farray[2] = new F(new D());
        farray[3] = new F(new D());
        farray[4] = new F(new D());

        for (F f : farray) f.getInfoAboutClass();

        return farray.length;
    }
}