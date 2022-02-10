package com.test.train.controller;

import com.test.train.dto.StationDto;
import com.test.train.dto.StationResultsDto;
import com.test.train.model.Station;
import com.test.train.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/station")
public class StationController {

    @Autowired
    private StationService statesService;

    @GetMapping("/filter/{text}")
    public ResponseEntity<StationResultsDto> findByStringIn(@PathVariable(value = "text") String text){
        return ResponseEntity.ok(statesService.findByStringIn(text));
    }

    @GetMapping
    public ResponseEntity<StationResultsDto> findAll(){
        return ResponseEntity.ok(statesService.findAll());
    }

}
