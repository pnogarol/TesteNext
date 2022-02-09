package com.test.train.controller;

import com.test.train.dto.StationDto;
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
    public ResponseEntity<List<StationDto>> findByStringIn(@PathVariable(value = "text") String text){
        return ResponseEntity.ok(statesService.findByStringIn(text));
    }

    @GetMapping
    public ResponseEntity<List<StationDto>> findAll(){
        return ResponseEntity.ok(statesService.findAll());
    }
}
