package mx.uv.fiee.iinf.paradigmas.code;

public class A {
    @Override public String toString () {
        return "I'm class A object";
    }
}

class B extends A {
    @Override public String toString () {
        return "I'm class B object";
    }
}

class C extends A {
    @Override public String toString () {
        return "I'm class C object";
    }
}
