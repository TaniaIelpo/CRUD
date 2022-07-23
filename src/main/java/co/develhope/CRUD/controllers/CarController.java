package co.develhope.CRUD.controllers;


import co.develhope.CRUD.entities.Car;
import co.develhope.CRUD.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @PostMapping
    public Car create(@RequestBody Car car){
        return carRepository.saveAndFlush(car);
    }

    @GetMapping
    public List<Car> get(){
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public Car getSingle(@PathVariable long id){
        if(carRepository.existsById(id))
        return carRepository.getById(id);
        else
            return new Car();
    }
    @PutMapping("/{id}")
    public Car updateSingle(@PathVariable long id,
                             @RequestBody Car car){
       if(carRepository.existsById(id)) {
           car.setId(id);
           return carRepository.saveAndFlush(car);
       }
       else
           return new Car();
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteSingle(@PathVariable long id){
        if(carRepository.existsById(id)) {
            carRepository.deleteById(id);
            return HttpStatus.OK;
        }
        else
            return HttpStatus.CONFLICT;
    }

    @DeleteMapping()
    public void deleteAll(){
        carRepository.deleteAll();
    }

}
