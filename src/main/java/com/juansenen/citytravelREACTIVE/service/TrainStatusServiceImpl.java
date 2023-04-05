package com.juansenen.citytravelREACTIVE.service;

import com.juansenen.citytravelREACTIVE.domain.TrainStatus;
import com.juansenen.citytravelREACTIVE.repository.TrainStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TrainStatusServiceImpl implements TrainStatusService{

    @Autowired
    private TrainStatusRepository trainStatusRepository;
    @Override
    public Flux<TrainStatus> findAll() {
        return trainStatusRepository.findAll();
    }

    @Override
    public Mono<TrainStatus> findByCode(String code) {
        return trainStatusRepository.findByCode(code);
    }

    @Override
    public TrainStatus addTrain(TrainStatus trainStatus) {
        return trainStatusRepository.save(trainStatus).block();
    }
}
