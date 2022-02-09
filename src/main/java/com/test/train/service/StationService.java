package com.test.train.service;

import com.test.train.dto.StationDto;
import com.test.train.model.Station;
import com.test.train.repository.StationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Component
public class StationService {

    @Autowired
    private StationRepository stationRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public List<StationDto> findAll(){
        return List.of(modelMapper.map(stationRepository.findAll(), StationDto[].class));
    }

    public List<StationDto> findByStringIn(String texto){
        return findAll().stream().filter(state -> state.getName().toUpperCase(Locale.ROOT).startsWith(texto.toUpperCase(Locale.ROOT))).collect(Collectors.toList());
    }

    public void save(StationDto station){
        stationRepository.save(modelMapper.map(station, Station.class));
    }

}
