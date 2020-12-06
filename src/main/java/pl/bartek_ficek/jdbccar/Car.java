package pl.bartek_ficek.jdbccar;


public class Car {

  private long carId;
  private String carMake;
  private String model;
  private String color;

    public Car(long carId, String carMake, String model, String color) {
        this.carId = carId;
        this.carMake = carMake;
        this.model = model;
        this.color = color;
    }

    public long getCarId() {
    return carId;
  }

  public void setCarId(long carId) {
    this.carId = carId;
  }


  public String getCarMake() {
    return carMake;
  }

  public void setCarMake(String carMake) {
    this.carMake = carMake;
  }


  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }


  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

}
