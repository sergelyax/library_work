package AbstractFactory;

import java.util.ArrayList;
import java.util.List;

abstract class Car{
    String name;
    List accessories = new ArrayList();

    public String toString(){
        return "Model car: " + name + "\n" + accessories;
    }
}

class LuxCar extends Car{
    public LuxCar(CarPartsFactory carPartsFactory){
        name = "Nice Car";
        accessories.add(carPartsFactory.addCarSalon());
        accessories.add(carPartsFactory.addSteeringWheel());
        accessories.add(carPartsFactory.addGPS());
    }
}

class BasicCar extends Car{
    public BasicCar(CarPartsFactory carPartsFactory){
        name = "Basic Car";
        accessories.add(carPartsFactory.addCarSalon());
        accessories.add(carPartsFactory.addSteeringWheel());
    }
}

interface CarPartsFactory{
    public abstract CarSalon addCarSalon();
    public abstract SteeringWheel addSteeringWheel();
    public abstract GPS addGPS();
}

class LuxCarPartsFactory implements CarPartsFactory{
    public CarSalon addCarSalon(){
        return new LeatherCarSalon();
    }

    public SteeringWheel addSteeringWheel(){
        return new HeatedSteeringWheel();
    }

    public GPS addGPS(){
        return new CarGPS();
    }
}

class BasicCarPartsFactory implements CarPartsFactory{
    public CarSalon addCarSalon(){
        return new BasicCarSalon();
    }

    public SteeringWheel addSteeringWheel(){
        return new BasicSteeringWheel();
    }

    public GPS addGPS(){
        return null;
    }
}

interface CarSalon{
    public abstract String toString();
}

class LeatherCarSalon implements CarSalon{
    public String toString(){
        return "Leather Salon";
    }
}

class BasicCarSalon implements CarSalon{
    public String toString(){
        return "Basic Salon";
    }
}

interface SteeringWheel{
    public String toString();
}

class HeatedSteeringWheel implements SteeringWheel{
    public String toString(){
        return "Heated steering wheel";
    }
}

class BasicSteeringWheel implements SteeringWheel{
    public String toString(){
        return "Basic steering wheel";
    }
}

interface GPS{
    public String toString();
}

class CarGPS implements GPS{
    public String toString(){
        return "GPS";
    }
}
public class AbstractFactoryMain{
    public static void main(String[] args) {
        CarPartsFactory myLuxFactory = new LuxCarPartsFactory();
        CarPartsFactory myBasicFactory = new BasicCarPartsFactory();

        Car myLuxCar = new LuxCar(myLuxFactory);
        Car myBasicCar = new BasicCar(myBasicFactory);

        System.out.println(myLuxCar);
        System.out.println(myBasicCar);
    }
}