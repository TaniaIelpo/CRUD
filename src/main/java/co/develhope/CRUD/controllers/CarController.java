package co.develhope.CRUD.controllers;


import co.develhope.CRUD.entities.Car;
import co.develhope.CRUD.repositories.CarRepository;
import co.develhope.CRUD.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author Tania Ielpo
 */

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping
    public Car create(@RequestBody Car car){
        return carService.create(car);
    }

    @GetMapping
    public List<Car> get(){
        return carService.retrieveAll();
    }

    @GetMapping("/{id}")
    public Car getSingle(@PathVariable long id){
        return carService.getSingle(id);
    }
    @PutMapping("/{id}")
    public Car updateSingle(@PathVariable long id,
                             @RequestBody Car car){
       return carService.updateSingleCar(id,car);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteSingle(@PathVariable long id){
        return carService.deleteSingle(id);
    }

    @DeleteMapping()
    public void deleteAll(){
        carService.deleteAll();
    }

}
