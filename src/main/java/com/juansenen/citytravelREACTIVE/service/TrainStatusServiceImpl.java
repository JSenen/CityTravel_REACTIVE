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
    public Mono<TrainStatus> addTrain(TrainStatus trainStatus) {
        return trainStatusRepository.save(trainStatus);
    }

    @Override
    public Mono<TrainStatus> getOneTrain(String code) {
        return trainStatusRepository.findByCode(code);
    }

    @Override
    public Mono<Void> deleteOneTrain(String code) {
        return trainStatusRepository.findByCode(code) //Recuperamos el objeto
                .flatMap(trainStatus -> trainStatusRepository.deleteByCode(trainStatus.getCode()))
                .then();
        /** se utiliza flatMap() para transformar este Mono<TrainStatus> en un Mono<Void> que llama a deleteByCode()
         * con el objeto TrainStatus  y ejecutamos la eliminación del tren.
         *  Se utiliza el método then() para convertir el resultado en un Mono<Void> y devolverlo.
         */




    }
}
