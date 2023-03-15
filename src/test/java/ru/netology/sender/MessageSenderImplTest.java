package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderImplTest {
    @Test
    void testsCheckLanguageMessageBeingSent() {

        String expected = "Добро пожаловать";

//    GeoServiceMock geoServiceMock = new GeoServiceMock();
//    geoServiceMock.setValue(new Location("Moscow", Country.RUSSIA, "Lenina", 15));
//
//    LocalizationServiseMock localizationServiseMock = new LocalizationServiseMock();
//    localizationServiseMock.locale(Country.RUSSIA);
//
//    MessageSenderImpl messageSender = new MessageSenderImpl(geoServiceMock,localizationServiseMock);
//    Map<String, String> headers = new HashMap<String, String>();
//    headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");
//
//    String result = messageSender.send(headers);
//
//    Assertions.assertEquals(expected,result);

        GeoService geoService = Mockito.spy(GeoServiceImpl.class);
        Mockito.when(geoService.byIp("172.0.32.11")).thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));

        LocalizationService localizationService = Mockito.spy(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.11");

        String result = messageSender.send(headers);

        Assertions.assertEquals(expected, result);
    }
}
