package co.develhope.CRUD.services;


import co.develhope.CRUD.entities.Car;
import co.develhope.CRUD.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tania Ielpo
 */

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;


    public Car create(Car car) {
        car.setId(null);
        return carRepository.saveAndFlush(car);
    }

    public List<Car> retrieveAll() {
        return carRepository.findAll();
    }

    public Car getSingle(long id) {
        if(carRepository.existsById(id))
            return carRepository.getById(id);
        else
            return new Car();
    }


    public Car updateSingleCar(long id, Car car) {
        if(carRepository.existsById(id)) {
            car.setId(id);
            return carRepository.saveAndFlush(car);
        }
        else
            return new Car();
    }

    public HttpStatus deleteSingle(long id) {
        if(carRepository.existsById(id)) {
            carRepository.deleteById(id);
            return HttpStatus.OK;
        }
        else
            return HttpStatus.CONFLICT;
    }

    public void deleteAll() {
        carRepository.deleteAll();
    }
}
