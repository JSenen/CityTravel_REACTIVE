# CityTravel_REACTIVE
***
![Java](https://img.shields.io/badge/Java-red?style=for-the-badge&logo=Java&logoColor=white)
![Spring](https://img.shields.io/badge/SpringBoot-green?style=for-the-badge&logo=spring&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-orange?style=for-the-badge&logo=postman&logoColor=white)
![Mongodb](https://img.shields.io/badge/mongodb-black?style=for-the-badge&logo=mongodb&logoColor=green)
![RectiveX](https://img.shields.io/badge/reactivex-grey?style=for-the-badge&logo=reactivex&logoColor=violet)
***
Se ha creado una simulación de una API Reactiva, la cual, por medio de **RXJava**,implementación open-source de la 
librería ReactiveX para una programación reactiva.
Trabajando bajo flujos de datos asincronos.
La Api simula un flujo continuo de datos con un tren, en el que se comprueba Velocidad, Peso y KwH.

Se ha usado como motor de base de datos, MongoDB
Para arrancar MonfoDb, desde la terminal se debe introducir el siguiente comando:

```
mongod --dbpath /[Ruta a mongo db]
```

y se han realizado una peticiones:
1. GET
    ```
    @GetMapping(value = "/trainsStatus", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<TrainStatus> getAllTrainStatus(){
        return trainStatusService.findAll();
    }
   ```
2. POST
    ```
   @PostMapping(value = "/trainsStatus")
    public Mono<ResponseEntity<TrainStatus>> addTrainStatus(@RequestBody TrainStatus trainStatus){
        return trainStatusService.addTrain(trainStatus)
                .map(newTrainStatus -> ResponseEntity.status(HttpStatus.CREATED).body(newTrainStatus));
        /**  El método map() se utiliza para transformar el objeto newTrainStatus emitido por el método addTrain()
         * del servicio en un ResponseEntity con un código de estado HttpStatus.CREATED. */
    }
   ```
3. PUT
    ```
   @PutMapping(value = "/trainStatus/{code}")
    public Mono<ResponseEntity<TrainStatus>> updateTrainStatus (@PathVariable String code, @RequestBody TrainStatus trainUpdated){
        return trainStatusService.updateTrainStatus(code, trainUpdated)
                .map(trainStatus -> ResponseEntity.ok(trainStatus));
    }
   ```
4. DELETE
    ```
    @DeleteMapping(value="/trainStatus/{code}")
    public Mono<ResponseEntity<Void>> deleteTrainStatusByCode(@PathVariable String code) {
        return trainStatusService.deleteOneTrain(code)
                .then(Mono.just(ResponseEntity.noContent().<Void>build()))
                .onErrorResume(e -> Mono.just(ResponseEntity.notFound().build()));

        /** Para cumplir con el tipo Mono de retorno, se usa then() para envolver el código 204 de respuesta
         * si se produce error 404 tambien se empaqueta .onErrorResume( ...
         */
    }
   ```
Para su comprobación, dentro del mismo proyecto se encuentra la carpeta __**POSTAM**__ con el ENTORNO y la COLECCIÓN.

**EJECUCION**:
Para ejecutar el programa, basta con ejecutar el siguiente comando en la consola del IDE donde se carge el proyecto, o 
desde la propia terminal del PC asegurandonos de encontrarse en la carpeta raiz del proyecto,

```
mvn spring-boot:run
```
