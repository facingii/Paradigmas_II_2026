package mx.uv.fiee.iinf.paradigmas.code;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main (String [] args) {
        MyUtils<Integer> m = new MyUtils<> ();
        m.set (10);
        System.out.println (m.get ());

        float result = m.<Float>average (0.1f);
        System.out.println (result);
    }
}