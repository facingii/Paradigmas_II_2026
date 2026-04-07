package mx.uv.fiee.iinf.paradigmas.code;

public class Film {

    private String title;
    private int year;

    public Film (String title, int year)
    {
        this.title = title;
        this.year = year;
    }

    @Override
    public String toString() {
        return  "Film{" + "title=" + title + ", year=" + year + '}';
    }
}
