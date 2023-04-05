package com.juansenen.citytravelREACTIVE.repository;

import com.juansenen.citytravelREACTIVE.domain.TrainStatus;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface TrainStatusRepository extends ReactiveMongoRepository<TrainStatus,String> {
    /** Lista de elementos FLUX */
    Flux<TrainStatus> findAll();
    /** Elemento individual MONO */
    Mono<TrainStatus> findByCode(String code);

}
