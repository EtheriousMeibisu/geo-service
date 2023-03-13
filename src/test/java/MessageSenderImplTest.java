import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MessageSenderImplTest {

@Test
    void testsCheckLanguageMessageBeingSent(){

    String expected = "Добро пожаловать";

    GeoServiceMock geoServiceMock = new GeoServiceMock();
    geoServiceMock.setValue(new Location("Moscow", Country.RUSSIA, "Lenina", 15));

    LocalizationServiseMock localizationServiseMock = new LocalizationServiseMock();
    localizationServiseMock.locale(Country.RUSSIA);

    MessageSenderImpl messageSender = new MessageSenderImpl(geoServiceMock,localizationServiseMock);
    Map<String, String> headers = new HashMap<String, String>();
    headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");

    String result = messageSender.send(headers);

    Assertions.assertEquals(expected,result);
}
}
