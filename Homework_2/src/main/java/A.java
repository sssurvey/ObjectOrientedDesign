public class A {
    // At this level, we care that:
    // A is dependent to B.java
    // Class C is subClass of A
    private B bDependent;

    private String infoAboutClass;

    public A(B b) {
        // DI
        this.bDependent = b;
        this.infoAboutClass = "This is class A, hello, and world";
    }

    // For Unit Testing, and proof-of-dependency
    public String returnBinfo() {
        return this.bDependent.getInfoAboutClass();
    }

    public String getInfoAboutClass() {
        return this.infoAboutClass;
    }
}
