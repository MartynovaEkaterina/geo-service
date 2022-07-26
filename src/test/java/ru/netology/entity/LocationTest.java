package ru.netology.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {

    @ParameterizedTest
    @MethodSource("source")
    void testEquals(Location location, boolean expected) {
        //arrange
        Location location1 = new Location("Moscow", Country.RUSSIA, "Lenina", 15);

        //act
        boolean result = location1.equals(location);

        //assert
        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> source() {
        Location location1 = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        Location location2 = new Location("New York", Country.USA, " 10th Avenue", 32);
        Location location3 = new Location("Perm", Country.RUSSIA, "Lenina", 15);
        return Stream.of(Arguments.of(location1, true), Arguments.of(location2, false), Arguments.of(null, false), Arguments.of(location3, false));
    }
}