
public class Calc {
    Integer firstIn;
    Integer secondIn;
    String[] actions = new String[]{"+", "-", "/", "*"};
    String action;
    Boolean isRoman = false;
    main.ConverterOfNum converterOfNum = new main.ConverterOfNum();
    public void doCalc(String val) throws main.OverOfValuesExeption, main.OnlyRomanOrArabianExeption {
        for (int i = 0; i < 4; i++) {
            String ch = actions[i];
            if (val.indexOf(ch) != -1) {
                action = ch;
            }
        }
        if (action == "+") {
            action = "\\+";
        }
        if (action == "*") {
            action = "\\*";
        }
        String[] valForCalc = val.split(action);
        try {
            firstIn = Integer.valueOf(valForCalc[0].trim());
            secondIn = Integer.valueOf(valForCalc[1].trim());
            System.out.println("Use a Arabian numbers...");
        } catch (Exception ex) {
            System.out.println("Use a Roman numbers...");
            firstIn = converterOfNum.romanToNumber(valForCalc[0].trim());
            secondIn = converterOfNum.romanToNumber(valForCalc[1].trim());
            isRoman = true;
        }
        if (firstIn >= 1 && firstIn <= 10 &&
                secondIn >= 1 && secondIn <= 10) {
            switch (action) {
                case ("\\+"):
                    if (isRoman == true) {
                        System.out.println(converterOfNum.convertNumToRoman(firstIn + secondIn));
                    } else {
                        System.out.println(firstIn + secondIn);
                    }
                    break;
                case ("-"):
                    if (isRoman == true) {
                        System.out.println(converterOfNum.convertNumToRoman(firstIn - secondIn));
                    } else {
                        System.out.println(firstIn - secondIn);
                    }
                    break;
                case ("/"):
                    if (isRoman == true) {
                        System.out.println(converterOfNum.convertNumToRoman(firstIn / secondIn));
                    } else {
                        System.out.println(firstIn / secondIn);
                    }
                    break;
                case ("\\*"):
                    if (isRoman == true) {
                        System.out.println(converterOfNum.convertNumToRoman(firstIn * secondIn));
                    } else {
                        System.out.println(firstIn * secondIn);
                    }
                    break;
            }
        } else if (firstIn < 1 ||  firstIn > 10 ||
        secondIn < 1 || secondIn > 10) {
            throw new main.OverOfValuesExeption("Values must be between 1 and 10");
        } else {
            throw new main.OnlyRomanOrArabianExeption("Only Arabian or Roman numbers");
        }
    }
}