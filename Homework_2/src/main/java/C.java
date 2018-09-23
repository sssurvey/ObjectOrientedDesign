public class C extends A {
    // At current level, we only care that ->
    // based on the UML diagram:
    // Class C will be
    // Class C will be depend on D

    private D dDependent;

    private String infoAboutClass;

    public C(B b, D d) {
        super(b);
        this.dDependent = d;
        this.infoAboutClass = "This is class C, gg, I extend A";
    }

    @Override
    public String getInfoAboutClass() {
        System.out.println("Override the function in class A");
        return infoAboutClass;
    }

    public String returnDinfo() {
        return dDependent.getInfoAboutClass();
    }
}
