package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MessageSenderImplTest {

    @ParameterizedTest
    @MethodSource("source")
    public void testSend( Map<String, String> ipMap, String expected) {
        //act
        GeoServiceImpl geoService = Mockito.spy(new GeoServiceImpl());
        LocalizationServiceImpl localizationService = Mockito.spy(new LocalizationServiceImpl());
        MessageSenderImpl messageSender = new MessageSenderImpl(geoService,localizationService);
        String result = messageSender.send(ipMap);

        //assert
        Assertions.assertEquals(expected,result);
    }

    private static Stream<Arguments> source() {
        Map<String, String> ipRus = new HashMap<>();
        ipRus.put("x-real-ip", "172.0.32.11");
        Map<String, String> ipUSA = new HashMap<>();
        ipUSA.put("x-real-ip", "96.45.186.159");
        return Stream.of(Arguments.of(ipRus, "Добро пожаловать"), Arguments.of(ipUSA, "Welcome"));
    }
}