package com.juansenen.citytravelREACTIVE.controller;

import com.juansenen.citytravelREACTIVE.domain.TrainStatus;
import com.juansenen.citytravelREACTIVE.service.TrainStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class TrainStatusController {

    @Autowired
    private TrainStatusService trainStatusService;

    @GetMapping(value = "/trainsStatus", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<TrainStatus> getAllTrainStatus(){
        return trainStatusService.findAll();
    }

    @PostMapping(value = "/trainsStatus")
    public Mono<ResponseEntity<TrainStatus>> addTrainStatus(@RequestBody TrainStatus trainStatus){
        return trainStatusService.addTrain(trainStatus)
                .map(newTrainStatus -> ResponseEntity.status(HttpStatus.CREATED).body(newTrainStatus));
        /**  El método map() se utiliza para transformar el objeto newTrainStatus emitido por el método addTrain()
         * del servicio en un ResponseEntity con un código de estado HttpStatus.CREATED. */
    }

    /** Para ser reactiva necesita el metodo asincrono MONO*/
    @GetMapping(value = "/trainsStatus/{code}")
    public Mono<ResponseEntity<TrainStatus>> findTrainByCode(@PathVariable String code){
        return trainStatusService.getOneTrain(code)
                .map(trainStatus -> ResponseEntity.ok(trainStatus))
                .defaultIfEmpty(ResponseEntity.notFound().build());

    }

    @DeleteMapping(value="/trainStatus/{code}")
    public Mono<ResponseEntity<Void>> deleteTrainStatusByCode(@PathVariable String code) {
        return trainStatusService.deleteOneTrain(code)
                .then(Mono.just(ResponseEntity.noContent().<Void>build()))
                .onErrorResume(e -> Mono.just(ResponseEntity.notFound().build()));

        /** Para cumplir con el tipo Mono de retorno, se usa then() para envolver el código 204 de respuesta
         * si se produce error 404 tambien se empaqueta .onErrorResume( ...
         */
    }

}
