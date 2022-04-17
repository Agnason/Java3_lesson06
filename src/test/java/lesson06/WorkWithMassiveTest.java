package lesson06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WorkWithMassiveTest {
    WorkWithMassive work;

    @BeforeEach
    void before() {
        work = new WorkWithMassive();
    }

    @Test
    void doRevertMassive() {
        Assertions.assertArrayEquals(new int[]{}, work.doRevertMassive(new int[]{1, 2, 3, 4}));
    }

    @Test
    void doRevertMassive1() {
        int[] in = new int[]{1, 3, 4, 5, 5, 6, 8};
        int[] out = new int[]{5, 5, 6, 8};

        Assertions.assertArrayEquals(out, work.doRevertMassive(in));
    }

    @Test
    void doRevertMassiveThrowsException() {
        Assertions.assertThrows(NullPointerException.class, () -> work.doRevertMassive(new int[]{}));
    }

    static Stream<Arguments> dataForMassTestDoRevertMassive() {
        return Stream.of(
                Arguments.arguments(new int[]{3, 6, 8}, new int[]{1, 3, 4, 5, 4, 3, 6, 8}),
                Arguments.arguments(new int[]{5}, new int[]{1, 3, 4, 5}),
                Arguments.arguments(new int[]{656, 8}, new int[]{4, 656, 8})
        );
    }

    @ParameterizedTest
    @MethodSource("dataForMassTestDoRevertMassive")
    void massTestDoRevertMassive(int[] expected, int[] actual) {
        Assertions.assertArrayEquals(expected, work.doRevertMassive(actual));
    }

    @Test
    void checkArrayFor1And4True() {
        Assertions.assertTrue(work.checkArrayFor1And4(new int[]{1, 1, 4, 4}));
    }

    @Test
    void checkArrayFor1And4False() {
        Assertions.assertFalse(work.checkArrayFor1And4(new int[]{1, 1, 4, 4, 3}));
        ;
    }

    static Stream<Arguments> dataForCheckArrayFor1And4() {
        List<Arguments> list = new ArrayList<>();
        list.add(Arguments.arguments(new int[]{3, 6, 8}));
        list.add(Arguments.arguments(new int[]{4, 4, 4, 4, 4, 4, 4, 4}));
        list.add(Arguments.arguments(new int[]{1, 1, 1, 1, 1, 1,}));
        list.add(Arguments.arguments(new int[]{1, 2, 1, 4, 4}));
        return list.stream();
    }

    @ParameterizedTest
    @MethodSource("dataForCheckArrayFor1And4")
    void massCheckArrayFor1And4(int[] actual) {
        Assertions.assertFalse(work.checkArrayFor1And4(actual));
    }

}