package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;

public class RacingCarGame {

  public void startGame() {
    Set<Car> cars = registerCars(); // 자동차 등록
    int attempts = readNumberOfAttempts(); // 사용자 이동 명령 입력
    // 자동차 움직이기
    // 우승자 가리기
  }

  private int readNumberOfAttempts() {
    System.out.println("시도할 횟수는 몇 회인가요?");
    String input = Console.readLine();
    return validateAndParseNumber(input);
  }

  private int validateAndParseNumber(String input) {
    if (input.isEmpty()) {
      throw new IllegalArgumentException("아무 것도 입력하지 않았습니다.");
    }
    try {
      return Integer.parseInt(input);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("숫자가 아닌 다른 문자를 입력했습니다.");
    }
  }

  private String[] readCarNames() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String carNamesInput = Console.readLine();
    return carNamesInput.split(",");
  }

  private String[] validateCarNames(String[] carNames) {
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

  private Set<Car> generateCars(String[] carNames) {
    Set<Car> cars = new HashSet<>();
    for (String carName : carNames) {
      cars.add(new Car(carName));
    }
    return cars;
  }

  private Set<Car> registerCars() {
    return generateCars(validateCarNames(readCarNames()));
  }
}
