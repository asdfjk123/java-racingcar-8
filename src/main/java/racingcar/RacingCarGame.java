package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

  public void startGame() {
    List<Car> cars = registerCars(); // 자동차 등록
    int attempts = readNumberOfAttempts(); // 사용자 이동 명령 입력
    startRace(cars, attempts); // 자동차 움직이기
    verifyWinner(cars); // 우승자 가리기
  }

  private void verifyWinner(List<Car> cars) {
    List<String> winners = whoIsWinner(cars);// 우승자를 최종 결과 리스트에 등록
    printFinalWinnersName(winners);// 우승자 출력
  }

  private void printFinalWinnersName(List<String> winners) {
    System.out.print("최종 우승자 : ");
    int numberOfWinners = winners.size();
    for (int i = 0; i < numberOfWinners; i++) {
      System.out.print(winners.get(i));
      if (i < numberOfWinners - 1) {
        System.out.print(", ");
      }
    }
  }

  private List<String> whoIsWinner(List<Car> cars) {
    int maxDistance = 0;
    List<String> winners = new ArrayList<>();
    for (Car car : cars) {
      maxDistance = Math.max(maxDistance, car.getDistance());
    }
    for (Car car : cars) {
      if (car.getDistance() ==  maxDistance) {
        winners.add(car.getName());
      }
    }
    return winners;
  }

  private void startRace(List<Car> cars, int attempts) {
    System.out.println("\n실행 결과");
    for(int count = 0; count < attempts; count++) {
      moveCars(cars);
    }
  }

  private void moveCars(List<Car> cars) {
    for (Car car : cars) {
      int pickedNumber = Randoms.pickNumberInRange(0, 9);
      car.setDistance(car.getDistance() + moveCar(pickedNumber));// 차 움직이기
    }
    printResultPerTurn(cars); // 턴마다 실행 결과 출력
  }

  private void printResultPerTurn(List<Car> cars) {
    for (Car car : cars) {
      System.out.print(car.getName() + " : ");
      for (int moves = 0; moves < car.getDistance(); moves++) {
        System.out.print("-");
      }
      System.out.println();
    }
    System.out.println();
  }

  private int moveCar(int pickedNumber) {
    if (pickedNumber >= 4) return 1;
    return 0;
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

  private List<Car> generateCars(String[] carNames) {
    List<Car> cars = new ArrayList<>();
    for (String carName : carNames) {
      cars.add(new Car(carName));
    }
    return cars;
  }

  private List<Car> registerCars() {
    return generateCars(validateCarNames(readCarNames()));
  }
}
