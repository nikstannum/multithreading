package beans;

import java.util.Random;

public class Car {
    private CarsModel carsModel;
    private RegisterSign registerSign;

    public Car() {
        {
            int pickCarsModel = new Random().nextInt(CarsModel.values().length);
            this.carsModel = CarsModel.values()[pickCarsModel];
        }
        this.registerSign = new RegisterSign();
    }


    enum CarsModel {
        BMW,
        MAZDA,
        MERCEDES,
        VOLVO;

    }

    class RegisterSign {
        private final int number;
        private final String letters;
        private final int postfix;

        public RegisterSign() {
            this.number = (int) (Math.random() * 9000 + 1000);
            {
                char[] chars = {'A', 'B', 'C', 'E', 'H', 'I', 'K', 'M', 'O', 'P', 'T', 'X'};
                int lengthOfChars = chars.length;
                char firstSymbol = chars[new Random().nextInt(lengthOfChars)];
                char secondSymbol = chars[new Random().nextInt(lengthOfChars)];
                this.letters = String.valueOf(firstSymbol) + secondSymbol;
            }
            this.postfix = (int) (Math.random() * 7 + 1);
        }

        public CarsModel getCarsModel() {
            return carsModel;
        }

        public int getNumber() {
            return number;
        }

        public String getLetters() {
            return letters;
        }

        public int getPostfix() {
            return postfix;
        }

        @Override
        public String toString() {
            StringBuffer stringBuffer = new StringBuffer()
                    .append(number).append(" ").append(letters).append("-").append(postfix);
            return stringBuffer.toString();
        }

    }

    @Override
    public String toString() {
        return "Car: " + carsModel +
                ", register sign: " + registerSign;
    }
}
