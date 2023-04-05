package com.juansenen.citytravelREACTIVE.controller;

import com.juansenen.citytravelREACTIVE.domain.TrainStatus;
import com.juansenen.citytravelREACTIVE.service.TrainStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class TrainStatusController {

    @Autowired
    private TrainStatusService trainStatusService;

    @GetMapping(value = "/trainsStatus", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<TrainStatus> getAllTrainStatus(){
        return trainStatusService.findAll();
    }

    @PostMapping(value = "/trainsStatus")
    public ResponseEntity<TrainStatus> addTrainStatus(@RequestBody TrainStatus trainStatus){
        TrainStatus newTrainStatus = trainStatusService.addTrain(trainStatus);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(newTrainStatus);
    }

}
