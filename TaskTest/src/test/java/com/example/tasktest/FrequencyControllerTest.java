package com.example.tasktest;

import com.example.tasktest.controller.FrequencyController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

class FrequencyControllerTest {

    @Test
    void testGetCharacterFrequency() {
        FrequencyController controller = new FrequencyController();

        String input = "Hello, World!";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        List<CharacterFrequency> result = controller.getCharacterFrequency();
        System.setIn(System.in); // Reset the input stream

        Assertions.assertEquals(10, result.size());
        Assertions.assertEquals('l', result.get(0).getCharacter());
        Assertions.assertEquals(3, result.get(0).getFrequency());
    }
}
