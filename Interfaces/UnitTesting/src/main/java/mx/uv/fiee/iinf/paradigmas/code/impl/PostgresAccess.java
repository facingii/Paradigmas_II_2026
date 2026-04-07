package mx.uv.fiee.iinf.paradigmas.code.impl;

import mx.uv.fiee.iinf.paradigmas.code.models.Student;

import java.util.ArrayList;
import java.util.List;

/***
 *
 * Acceso a datos concreta dificil de escalar y no conveniente para pruebas
 * automátizadas.
 *
 */
public class PostgresAccess {

    public void open ()
    {
        System.out.println("opening connection to real db...");
    }

    public List<Student> getStudentList ()
    {
        System.out.println("getting student list from real db...");
        return new ArrayList<>();
    }

    public void AddStudent (mx.uv.fiee.iinf.paradigmas.code.models.Student student)
    {
        System.out.println("adding student to real db...");
    }

}

