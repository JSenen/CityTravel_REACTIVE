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

    Mono<TrainStatus> addTrain(TrainStatus trainStatus);
    Mono<TrainStatus> getOneTrain(String code); //Notacion MONO para ser reactiva

    Mono<Void> deleteOneTrain (String code);

}
