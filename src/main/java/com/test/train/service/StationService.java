package com.test.train.service;

import com.test.train.dto.StationDto;
import com.test.train.dto.StationResultsDto;
import com.test.train.model.Station;
import com.test.train.repository.StationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class StationService {

    @Autowired
    private StationRepository stationRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public StationResultsDto findAll(){
        final var stations = List.of(modelMapper.map(stationRepository.findAll(), StationDto[].class));

        final var result = StationResultsDto
                .builder()
                .stations(stations)
                .build();

        return result;
    }

    public StationResultsDto findByStringIn(String texto){
        final var stations  = findAll()
                .getStations()
                .stream()
                .filter(state -> state.getName().toUpperCase(Locale.ROOT).startsWith(texto.toUpperCase(Locale.ROOT)))
                .map(res -> res)
                .collect(Collectors.toList());

        final var nextChars = stations
                .stream()
                .map(station -> {
                    try {
                        return station.getName().replace(texto, "").substring(0,1);
                    }catch(StringIndexOutOfBoundsException e){
                        return null;
                    }
                }).collect(Collectors.toList());


        return StationResultsDto
                .builder()
                .stations(stations)
                .nextChars(nextChars)
                .build();
    }

    public void save(StationDto station){
        stationRepository.save(modelMapper.map(station, Station.class));
    }

}
