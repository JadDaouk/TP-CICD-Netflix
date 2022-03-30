import fr.epsi.netflix.HtmlFactory;
import fr.epsi.netflix.Movie;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HtmlFactoryTest {

    private static HtmlFactory htmlFactory;

    @BeforeClass
    public static void setup() {
        htmlFactory = new HtmlFactory();
    }

    @Test
    public void generateDetailTest() {

        Movie movieTest = new Movie();
        movieTest.setTitle("Test");
        movieTest.setDescription("Description test.");

        String result = htmlFactory.generateDetail(movieTest);

        String expected = "<!doctype html><head> <meta charset=\"utf-8\"><title>Test</title></head><body><div><p>Titre</p><p>Test</p></div><div><p>Desccription</p><p>Description test.</p></div></body></html>";

        Assert.assertEquals(expected, result);
    }

    @Test
    public void generateHtmlTest() {
        Movie movieTest1 = new Movie();
        movieTest1.setTitle("Test1");
        movieTest1.setDescription("Description test1.");

        Movie movieTest2 = new Movie();
        movieTest1.setTitle("Test2");
        movieTest1.setDescription("Description test2.");

        List<Movie> listMovieTest = new ArrayList<>();
        listMovieTest.add(movieTest1);
        listMovieTest.add(movieTest2);

        String result = htmlFactory.generateHtml(listMovieTest);

        System.out.println(result);

        String expected = "<!doctype html><head> <meta charset=\"utf-8\"><title>Films/Series</title></head><body><style> table, table tr, table td, table th {border:1px solid black;border-collapse:collapse}</style><table><tr><th>id</th><th>type</th><th>titre</th><th>Réalisateur</th><th>Pays</th><th>Date</th><th>Detail</th></tr><tr><td>null</td><td>null</td><td>Test2</td><td>null</td><td>null</td><td></td><td><a href='movies/null.html'>detail</td></tr><tr><td>null</td><td>null</td><td>null</td><td>null</td><td>null</td><td></td><td><a href='movies/null.html'>detail</td></tr></table></body></html>";

        Assert.assertEquals(expected, result);

    }
}
