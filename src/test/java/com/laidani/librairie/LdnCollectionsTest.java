package com.laidani.librairie;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author Youcef LAIDANI
 */
public class LdnCollectionsTest {

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerException_whenListIsNull() {
        // Given
        List<Object> inputs = null;
        // When
        LdnCollections.partition(inputs, 2);
        // Then NullPointerException is thrown
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException_whenLengthIsZero() {
        // Given
        List<Integer> inputs = Arrays.asList(1, 2, -3, 4, -5, 6);
        int partsSize = 0;
        // When
        LdnCollections.partition(inputs, partsSize);
        // Then IllegalArgumentException is thrown
    }

    @Test
    public void shouldReturnEmptyList_whenListIsEmpty() {
        // Given
        List<Integer> empty = new ArrayList<>();
        int partsSize = 2;

        // When
        List<List<Integer>> result = LdnCollections.partition(empty, partsSize);

        // Then
        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void shouldReturnListOfListOfIntegers_whenListAndSizeAreCorrect() {
        // Given
        List<Integer> inputs = Arrays.asList(1, 2, 3, 4, 5);
        int partsSize = 2;

        // When
        List<List<Integer>> result = LdnCollections.partition(inputs, partsSize);

        // Then
        Assert.assertTrue(Objects.nonNull(result));
        Assert.assertTrue(result.size() == 3);
        Assert.assertTrue(result.get(0).size() == 2);
        Assert.assertEquals(result.get(0), Arrays.asList(1, 2));
        Assert.assertTrue(result.get(1).size() == 2);
        Assert.assertEquals(result.get(1), Arrays.asList(3, 4));
        Assert.assertTrue(result.get(2).size() == 1);
        Assert.assertEquals(result.get(2), Arrays.asList(5));
    }

    @Test
    public void shouldReturnListOfListOfStrings_whenListAndSizeAreCorrect() {
        // Given
        List<String> listeEntier = Arrays.asList("Youcef", "Robin", "Cyril");
        int partsSize = 2;

        // When
        List<List<String>> result = LdnCollections.partition(listeEntier, partsSize);

        // Then
        Assert.assertFalse(result.isEmpty());
        Assert.assertTrue(result.get(0).size() == 2);
        Assert.assertEquals(result.get(0), Arrays.asList("Youcef", "Robin"));
        Assert.assertTrue(result.get(1).size() == 1);
        Assert.assertEquals(result.get(1), Arrays.asList("Cyril"));

    }

    @Test
    public void shouldReturnOneList_whenListSizeIsGreetGreatThenPartsSize() {
        // Given
        List<String> inputs = Arrays.asList("Youcef", "Robin", null, "Cyril");
        int partsSize = 10;

        // When
        List<List<String>> result = LdnCollections.partition(inputs, partsSize);

        // Then
        Assert.assertTrue(Objects.nonNull(result));
        Assert.assertTrue(result.size() == 1);
        Assert.assertEquals(result.get(0), Arrays.asList("Youcef", "Robin", null, "Cyril"));
    }


    @Test
    public void shouldReturnCorrectResult_whenListOfObjects() {
        // Given
        List<ObjectForTest> inputs = Arrays.asList(
                new ObjectForTest(1L, "Youcef", LocalDate.of(1991, Month.JULY, 3)),
                new ObjectForTest(2L, "Robin", LocalDate.of(1990, Month.JANUARY, 15)),
                new ObjectForTest(3L, "Cyril", LocalDate.of(1973, Month.AUGUST, 5))
        );
        int taille = 2;
        // When
        List<List<ObjectForTest>> result = LdnCollections.partition(inputs, taille);

        // Then
        Assert.assertTrue(Objects.nonNull(result));
        Assert.assertTrue(result.size() == 2);

        Assert.assertTrue(result.get(0).size() == 2);
        Assert.assertTrue(result.get(0).get(0).getId() == 1L);
        Assert.assertEquals(result.get(0).get(0).getName(), "Youcef");
        Assert.assertEquals(result.get(0).get(0).getBirthDay(), LocalDate.of(1991, Month.JULY, 3));

        Assert.assertTrue(result.get(0).get(1).getId() == 2L);
        Assert.assertEquals(result.get(0).get(1).getName(), "Robin");
        Assert.assertEquals(result.get(0).get(1).getBirthDay(), LocalDate.of(1990, Month.JANUARY, 15));

        Assert.assertTrue(result.get(1).size() == 1);
        Assert.assertTrue(result.get(1).get(0).getId() == 3L);
        Assert.assertEquals(result.get(1).get(0).getName(), "Cyril");
        Assert.assertEquals(result.get(1).get(0).getBirthDay(), LocalDate.of(1973, Month.AUGUST, 5));
    }
}
