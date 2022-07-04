package beans;

import java.util.Random;

public class Cars {
    CarsModel carsModel;
    RegisterSign registerSign;

    public Cars() {
        {
            int pickCarsModel = new Random().nextInt(CarsModel.values().length);
            this.carsModel = CarsModel.values()[pickCarsModel];
        }
        this.registerSign = new RegisterSign();
    }

    public enum CarsModel {
        VOLVO,
        MERCEDES,
        BMW,
        MAZDA;

    }

    class RegisterSign {
        private int number;
        private String letters;
        private int postfix;

        public RegisterSign() {
            this.number = (int) (Math.random() * 10_000);
            {
                char[] chars = {'A', 'B', 'C', 'E', 'H', 'I', 'K', 'M', 'O', 'P', 'T', 'X'};
                int lengthOfChars = chars.length;
                char firstSymbol = chars[new Random().nextInt(lengthOfChars)];
                char secondSymbol = chars[new Random().nextInt(lengthOfChars)];
                this.letters = String.valueOf(firstSymbol) + secondSymbol;
            }
            {
                int randomPostfix = (int) (Math.random() * 8);
                if (randomPostfix != 0) {
                    this.postfix = randomPostfix;
                } else {
                    this.postfix = randomPostfix + 1;
                }
            }
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
