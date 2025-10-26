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

  // 이름 중복 방지 2단계
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Car car = (Car) o;
    return car.getName().equals(name);
  }

  // 이름 중복 방지 1단계
  @Override
  public int hashCode() {
    return name.hashCode();
  }

}
