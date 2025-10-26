package racingcar;

public class Car {

  private final String name;
  private int distance;

  public Car() {
    this.name = "";
    this.distance = 0;
  }

  public Car(String name) {
    this.name = name;
    this.distance = 0;
  }

  public Car(String name, int distance) {
    this.name = name;
    this.distance = distance;
  }

  public String getName() {
    return name;
  }

  public int getDistance() {
    return distance;
  }

  public void setDistance(int distance) {
    this.distance = distance;
  }

}
