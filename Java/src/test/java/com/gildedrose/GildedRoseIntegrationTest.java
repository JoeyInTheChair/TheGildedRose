package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseIntegrationTest {

    @Test
    void gildedRoseOver30Days() throws IOException {
        // When it runs for 30 days
        TexttestFixture fixture = new TexttestFixture();
        String output = fixture.runGildedRose(new String[]{"30"});

        // Then I get the expected output

        assertEquals(getExpectedOutput(), output);
    }

    private String getExpectedOutput() throws IOException {
        return String.join(System.lineSeparator(), Files.readAllLines(Paths.get("src/test/resources/gilded_rose_expected_output.txt")));
    }


}
