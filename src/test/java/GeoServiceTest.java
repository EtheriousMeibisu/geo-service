import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import ru.netology.entity.Country;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceTest {
    GeoServiceImpl geoService;

    @BeforeEach
    public void beforeEach() {
        geoService = new GeoServiceImpl();
    }
    @Test
    void test_byIp() {

        Country expected = Country.USA;
        String ip = "96.233.125.6";

        Country actual = geoService.byIp(ip).getCountry();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void test_byCoordinates() {

        double latitude = 1.2;
        double longitude = 5.3;

        Executable executable = () -> geoService.byCoordinates(latitude, longitude);

        Assertions.assertThrows(RuntimeException.class, executable);
    }
}
