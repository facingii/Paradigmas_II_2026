package mx.uv.fiee.iinf.paradigmas.code;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        int [] vector = { 5, 2, 9, 1, 5, 6 };

//        Number[] vec = null;
//        switch (vector.getClass().getName())
//        {
//            case "Integer":
//                vec = new Integer[vector.length];
//                for (int i = 0; i < vector.length; i++) {
//                    vec[i] = vector[i];
//                }
//                break;
//            case "Double":
//                vec = new Double[vector.length];
//                for (int i = 0; i < vector.length; i++) {
//                    vec[i] = vector[i];
//                }
//                break;
//                default:
//                    throw new IllegalArgumentException();
//        }

//        var myA = new A ();
//        var myB = new B ();
//        myA = myB;
//        myB = myA;
//
//        B mySecondB = (B) myA;
//        DoSomething(mySecondB);
//
//        DoSomething(myB);
//        DoSomething(new C());
//
//        Utils.sort(vec);


        //****************************************************************************************//
        // list A [A, A, A, A, A]
        // list B [B, B, B, B, B]

        // list A [B, A, C]
        // list B [B, B, B]




        ArrayList<A> listA = new ArrayList<A> (3);
        listA.add(new B());
        listA.add(new A());
        listA.add(new C());

//        ArrayList<B> listB = new ArrayList<B> ();
//        listB.add(new B());
//        listB.add(myB);

        var MyBB = new B();

//        ArrayList<C> listC = new ArrayList<C> ();
//        listC.add(new C());
//
//        ArrayList<C> listCC = new ArrayList<C> ();
//        listC  = listCC;

        //listB = listA
        //listA = listB; // Error: incompatible types: ArrayList<B> cannot be converted to ArrayList<A>

        processElements(listA, new C());
    }

    public static void DoSomething (A parameter)
    {
        parameter.execute();
    }


    public static <T> void processElements (ArrayList<T> elements, T newVal) {
        elements.add(newVal);

        for (T item: elements) {
            System.out.println ("\t" + item);
        }
    }

    public static void processsListA(ArrayList<A> lista)
    {
        // process A types
    }

    public static void processsListB(ArrayList<B> lista) {
        // process B types
    }

    public static void procesList(ArrayList<?> lista)
    {
        lista.add()
    }
}

class A
{
    public void execute ()
    {
        System.out.println ("Executing A");
    }
}

class B extends A
{
    public void MyFinalize ()
    {

    }
}

class C extends B
{}
















