package ru.netology.i18n;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    @ParameterizedTest
    @MethodSource("source")
    public void testLocale(Country country, String expected) {
        //act
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String result = localizationService.locale(country);

        //assert
        assertEquals(expected, result);
    }

    private static Stream<Arguments> source() {
        return Stream.of(Arguments.of(Country.RUSSIA, "Добро пожаловать"), Arguments.of(Country.USA, "Welcome"), Arguments.of(Country.BRAZIL, "Welcome"), Arguments.of(Country.GERMANY, "Welcome"));
    }
}