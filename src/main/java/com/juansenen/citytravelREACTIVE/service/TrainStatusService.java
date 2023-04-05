package com.juansenen.citytravelREACTIVE.service;

import com.juansenen.citytravelREACTIVE.domain.TrainStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TrainStatusService {

    Flux<TrainStatus> findAll();
    Mono<TrainStatus> findByCode(String code);

    void addTrain(TrainStatus trainStatus);

}
