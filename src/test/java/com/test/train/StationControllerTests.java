package com.test.train;

import com.test.train.service.StationService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StationControllerTests {

    @Autowired
    private StationService stationService;

    @Test
    public void shouldBeReturnStations() {
        final var stationResultsDto = stationService.findAll();
        Assertions.assertEquals(stationResultsDto.getStations().size(), 8);
    }

    @Test
    public void shouldBeReturnStationsStartsWith() {
        final var stationResultsDto = stationService.findByStringIn("Lar");
        Assertions.assertEquals(stationResultsDto.getStations().size(), 2);
        Assertions.assertEquals(stationResultsDto.getNextChars().size(), 2);
        Assertions.assertEquals(stationResultsDto.getNextChars().get(0), "d");
        Assertions.assertEquals(stationResultsDto.getNextChars().get(1), "e");

    }


}
