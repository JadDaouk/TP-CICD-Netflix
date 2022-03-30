import fr.epsi.netflix.Movie;
import fr.epsi.netflix.MovieFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MovieFactoryTest {

    private static MovieFactory movieFactory;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d yyyy", Locale.US);


    @BeforeClass
    public static void setup() {
        movieFactory = MovieFactory.getInstance();
    }

    @Test
    public void createMovieTest() {
        String[] itemsTest = new String[12];
        //id
        itemsTest[0] = "1";
        //type
        itemsTest[1] = "test";
        //title
        itemsTest[2] = "Test";
        //director
        itemsTest[3] = "Director test";
        //cast
        itemsTest[4] = "Test";
        //country
        itemsTest[5] = "Country test";
        //dateAdded
        itemsTest[6] = "March 30 2022";
        //realeaseYear
        itemsTest[7] = "2022";
        //rating
        itemsTest[8] = "5";
        //duration
        itemsTest[9] = "1h30";
        //listedIn
        itemsTest[10] = "test";
        //description
        itemsTest[11] = "Description test.";

        Movie result = movieFactory.createMovie(itemsTest);
        Assert.assertEquals(itemsTest[0], result.getId());
        Assert.assertEquals(itemsTest[1], result.getType());
        Assert.assertEquals(itemsTest[2], result.getTitle());
        Assert.assertEquals(itemsTest[3], result.getDirector());
        Assert.assertEquals(itemsTest[4], result.getCast());
        Assert.assertEquals(itemsTest[5], result.getCountry());
        Assert.assertEquals(formatter.parse(itemsTest[6].trim(), LocalDate::from), result.getDateAdded());
        Assert.assertEquals(itemsTest[7], String.valueOf(result.getReleaseYear()));
        Assert.assertEquals(itemsTest[8], result.getRating());
        Assert.assertEquals(itemsTest[9], result.getDuration());
        Assert.assertEquals(itemsTest[10], result.getListedIn());
        Assert.assertEquals(itemsTest[11], result.getDescription());

    }

    @Test
    public void createMoviesTest() {
        List<String> datasTest = new ArrayList<>();

        datasTest.add("s1|Movie|Dick Johnson Is Dead|Kirsten Johnson||United States|September 25 2021|2020|PG-13|90 min|Documentaries|As her father nears the end of his life filmmaker Kirsten Johnson stages his death in inventive and comical ways to help them both face the inevitable.");
        datasTest.add("s2|TV Show|Blood & Water||Ama Qamata Khosi Ngema Gail Mabalane Thabang Molaba Dillon Windvogel Natasha Thahane Arno Greeff Xolile Tshabalala Getmore Sithole Cindy Mahlangu Ryle De Morny Greteli Fincham Sello Maake Ka-Ncube Odwa Gwanya Mekaila Mathys Sandi Schultz Duane Williams Shamilla Miller Patrick Mofokeng|South Africa|September 24 2021|2021|TV-MA|2 Seasons|International TV Shows TV Dramas TV Mysteries|After crossing paths at a party a Cape Town teen sets out to prove whether a private-school swimming star is her sister who was abducted at birth.");

        List<Movie> result = movieFactory.createMovies(datasTest);

        List<Movie> expected = new ArrayList<>();

        String[] itemsTest = new String[12];
        //id
        itemsTest[0] = "s1";
        //type
        itemsTest[1] = "Movie";
        //title
        itemsTest[2] = "Dick Johnson Is Dead";
        //director
        itemsTest[3] = "Kirsten Johnson";
        //cast
        itemsTest[4] = "";
        //country
        itemsTest[5] = "United States";
        //dateAdded
        itemsTest[6] = "September 25 2021";
        //realeaseYear
        itemsTest[7] = "2020";
        //rating
        itemsTest[8] = "PG-13";
        //duration
        itemsTest[9] = "90 min";
        //listedIn
        itemsTest[10] = "Documentaries";
        //description
        itemsTest[11] = "As her father nears the end of his life filmmaker Kirsten Johnson stages his death in inventive and comical ways to help them both face the inevitable.";

        Movie movieTest1 = movieFactory.createMovie(itemsTest);
        expected.add(movieTest1);

        //id
        itemsTest[0] = "s2";
        //type
        itemsTest[1] = "TV Show";
        //title
        itemsTest[2] = "Blood & Water";
        //director
        itemsTest[3] = "";
        //cast
        itemsTest[4] = "Ama Qamata Khosi Ngema Gail Mabalane Thabang Molaba Dillon Windvogel Natasha Thahane Arno Greeff Xolile Tshabalala Getmore Sithole Cindy Mahlangu Ryle De Morny Greteli Fincham Sello Maake Ka-Ncube Odwa Gwanya Mekaila Mathys Sandi Schultz Duane Williams Shamilla Miller Patrick Mofokeng";
        //country
        itemsTest[5] = "South Africa";
        //dateAdded
        itemsTest[6] = "September 24 2021";
        //realeaseYear
        itemsTest[7] = "2021";
        //rating
        itemsTest[8] = "TV-MA";
        //duration
        itemsTest[9] = "2 Seasons";
        //listedIn
        itemsTest[10] = "International TV Shows TV Dramas TV Mysteries";
        //description
        itemsTest[11] = "After crossing paths at a party a Cape Town teen sets out to prove whether a private-school swimming star is her sister who was abducted at birth.";

        Movie movieTest2 = movieFactory.createMovie(itemsTest);
        expected.add(movieTest2);

        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i).getId(), result.get(i).getId());
            Assert.assertEquals(expected.get(i).getType(), result.get(i).getType());
            Assert.assertEquals(expected.get(i).getTitle(), result.get(i).getTitle());
            Assert.assertEquals(expected.get(i).getDirector(), result.get(i).getDirector());
            Assert.assertEquals(expected.get(i).getCast(), result.get(i).getCast());
            Assert.assertEquals(expected.get(i).getCountry(), result.get(i).getCountry());
            Assert.assertEquals(expected.get(i).getDateAdded(), result.get(i).getDateAdded());
            Assert.assertEquals(expected.get(i).getReleaseYear(), result.get(i).getReleaseYear());
            Assert.assertEquals(expected.get(i).getRating(), result.get(i).getRating());
            Assert.assertEquals(expected.get(i).getDuration(), result.get(i).getDuration());
            Assert.assertEquals(expected.get(i).getListedIn(), result.get(i).getListedIn());
            Assert.assertEquals(expected.get(i).getDescription(), result.get(i).getDescription());
        }
    }
}
