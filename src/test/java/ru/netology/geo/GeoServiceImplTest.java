package ru.netology.geo;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {

    @ParameterizedTest
    @MethodSource("source")
    public void testByIp(String ip, Location expected) {
        //act
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location result = geoService.byIp(ip);

        //assert
        assertEquals(expected, result);
    }

    private static Stream<Arguments> source() {
        Location location = new Location(null, null, null, 0);
        Location location1 = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        Location location2 = new Location("New York", Country.USA, " 10th Avenue", 32);
        Location location3 = new Location("Moscow", Country.RUSSIA, null, 0);
        Location location4 = new Location("New York", Country.USA, null,  0);
        return Stream.of(Arguments.of("127.0.0.1",location), Arguments.of("172.0.32.11",location1), Arguments.of("96.44.183.149",location2), Arguments.of("172.0.34.21",location3), Arguments.of("96.45.186.159",location4), Arguments.of("2.92.6.255", null));
    }
}