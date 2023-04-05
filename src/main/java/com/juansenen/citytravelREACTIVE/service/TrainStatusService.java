package com.juansenen.citytravelREACTIVE.service;

import com.juansenen.citytravelREACTIVE.domain.TrainStatus;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TrainStatusService {

    Flux<TrainStatus> findAll();
    Mono<TrainStatus> findByCode(String code);
}
