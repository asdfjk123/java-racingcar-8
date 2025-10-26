package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;

public class RacingCarGame {

  public void StartGame() {
    Set<Car> cars = registerCars();
  }

  public String[] readCarNames() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String carNamesInput = Console.readLine();
    return carNamesInput.split(",");
  }

  public String[] validateCarNames(String[] carNames) {
    for (String carName : carNames) {
      if (carName.isBlank()) {
        throw new IllegalArgumentException("이름이 비었습니다.");
      }
      if (carName.length() > 5) {
        throw new IllegalArgumentException("이름이 5글자를 초과하였습니다.");
      }
    }
    return carNames;
  }

  public Set<Car> generateCars(String[] carNames) {
    Set<Car> cars = new HashSet<>();
    for (String carName : carNames) {
      cars.add(new Car(carName));
    }
    return cars;
  }

  public Set<Car> registerCars() {
    return generateCars(validateCarNames(readCarNames()));
  }
}
