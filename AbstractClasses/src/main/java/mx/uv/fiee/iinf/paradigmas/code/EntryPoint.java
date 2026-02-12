package mx.uv.fiee.iinf.paradigmas.code;

public class EntryPoint {

    public static void main (String [] args) {
        Persona p = new ProfesorTitular ("Diana", "Montejo", 30);
        String s = p.toString ();

        System.out.println (s);
    }

}