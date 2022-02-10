package com.test.train.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@Builder
public class StationResultsDto {

    private List<StationDto> stations;
    private List<String> nextChars;

}
