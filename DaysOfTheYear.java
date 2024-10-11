import java.util.Scanner;

public class DaysOfTheYear {
    //Final variables
    static final String CUR_DATE = "The current date is: ";
    static final String DAY_MON = "Do you want to increase the day or the month? (day or month): ";
    static final String INP_INVD = "Input invalid, please try again!";
    static final String FI_DT_PX = "The current date is: 31st of December";
    static final String FINAL_DATE = "The current date is: 31 of December";
    static final String WINNER = " is the winner of the game!";
    static final String MON_ERR = "Can't change the month, please try again!";
    static final String DAY_ERR = "Can't change the day, please try again!";
    static final String SEL_DATE = "Which day do you want to pick: ";
    static final String SEL_MONTH = "Which month do you want to pick: ";
    // Final Max limit days in a month for calculation
    private static final int FEB_MAX = 28;
    private static final int LEEP_DAY = 29;
    private static final int DAYS_IN_MONTH = 30;
    private static final int MAX_DAY_MON = 31;
    // Final
    static final int DAY_ONE = 1;
    static final int DAY_TWO = 2;
    static final int DAY_THREE = 3;
    static final int DAY_FOUR = 4;
    static final int DAY_FIVE = 5;
    static final int DAY_SIX = 6;
    static final int DAY_SEVEN = 7;
    static final int DAY_EIGHT = 8;
    static final int DAY_NINE = 9;
    static final int DAY_TEN = 10;
    static final int DAY_ELEVEN = 11;
    static final int DAY_TWELVE = 12;
    static final int DAY_THIRTEEN = 13;
    
    //main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 1; //day
        int y = 1; //month
        int player = 1;
        boolean isDayMonthEntered = false;
        
        if (args.length == DAY_TWO) {
            x = Integer.parseInt(args[0]);
            y = Integer.parseInt(args[1]);
            isDayMonthEntered = true;
        }

        while (true) {
            if (isDayMonthEntered) {
                System.out.println(CUR_DATE
                + getOrdinalDate(x) + " of " + getmonthName(y));
            } else {
                System.out.println(CUR_DATE + x + " of " + getmonthName(y));
            }
            System.out.println("It is Player " + player + "'s Turn!");
            String choice = userInput(sc, DAY_MON);
            boolean isDM = true;
            
            while (isDM) {
                if (choice.equals("day") || choice.equals("month")) {
                    break;
                } else {
                    System.out.println(INP_INVD);
                    String choice1;
                    do {
                        choice1 = sc.nextLine().trim();
                        if (!choice1.equals("day") && !choice1.equals("month")) {
                            System.out.println(INP_INVD);
                        }
                    } while (!choice1.equals("day") && !choice1.equals("month"));
                    choice = choice1;
                    isDM = false;
                }
            }
            
            if (choice.equals("day")) {
                if (isDayMonthEntered) {
                    if ((y == 2 && x == FEB_MAX) 
                    || ((y == DAY_FOUR 
                    || y == DAY_SIX 
                    || y == DAY_NINE
                    || y == DAY_ELEVEN) && x == DAYS_IN_MONTH) 
                    ||((y == 1 
                    || y == DAY_THREE
                    || y == DAY_FIVE 
                    || y == DAY_SEVEN
                    ||y == DAY_EIGHT 
                    || y == DAY_TEN 
                    || y == DAY_TWELVE) && x == MAX_DAY_MON)) {
                        System.out.println(DAY_ERR);
                        String choice2;
                        do {
                            choice2 = sc.nextLine().trim();
                            if (choice2.equals("day")) {
                                System.out.println(DAY_ERR);
                            } else if (choice2.equals("month")) {
                                int a=1;
                            } else {
                                System.out.println(INP_INVD);
                            }
                        } while (!(choice2.equals("month")));
                        
                        int newMonth = newmonthValue(sc, y, x);
                        if (newMonth != -1) {
                            y = newMonth;
                        }
                    } else {
                        int newDay = newdayValue(sc, x, y);
                        if (newDay != -1) {
                            x = newDay;
                        }
                    }
                } else {
                    if (y == 2 && x == FEB_MAX) {
                        System.out.println(DAY_ERR);
                        String choice2;
                        do {
                            choice2 = sc.nextLine().trim();
                            if (choice2.equals("day")) {
                                System.out.println(DAY_ERR);
                            } else if (choice2.equals("month")) {
                                int a=1;
                            } else {
                                System.out.println(INP_INVD);
                            }
                        } while (!(choice2.equals("month")));
                         int newMonth = newmonthValue(sc, y, x);
                        if (newMonth != -1) {
                            y = newMonth;
                        }
                    } else {
                        int newDay = newdayValue(sc, x, y);
                        if (newDay != -1) {
                            x = newDay;
                        }
                    }
                }
            } else if (choice.equals("month")) {
                if (isDayMonthEntered) {
                    if (y == DAY_TWELVE) {
                        System.out.println(MON_ERR);
                        String choice3;
                        do {
                            choice3 = sc.nextLine().trim();
                            if (choice3.equals("month")) {
                                System.out.println(MON_ERR);
                            } else if (choice3.equals("day")) {
                                int a=1;
                            } else {
                                System.out.println(INP_INVD);
                            }
                        } while (!(choice3.equals("day")));
                        
                        int newDay = newdayValue(sc, x, y);
                        if (newDay != -1) {
                            x = newDay;
                        }
                    } else {
                        int newMonth = newmonthValue(sc, y, x);
                        if (newMonth != -1) {
                            y = newMonth;
                        }
                    }
                } else {
                    if (y == DAY_TWELVE) {
                        System.out.println(MON_ERR);
                        String choice3;
                        do {
                            choice3 = sc.nextLine().trim();
                            if (choice3.equals("month")) {
                                System.out.println(MON_ERR);
                            } else if (choice3.equals("day")) {
                                int a=1;
                            } else {
                                System.out.println(INP_INVD);
                            }
                        } while (!(choice3.equals("day")));
                    
                        int newDay = newdayValue(sc, x, y);
                        if (newDay != -1) {
                            x = newDay;
                        }
                    } else {
                        int newMonth = newmonthValue(sc, y, x);
                        if (newMonth != -1) {
                            y = newMonth;
                        }
                    }
                }
            } else {
                System.out.println(INP_INVD);
                continue;
            }

            if (x == MAX_DAY_MON && y == DAY_TWELVE) {
                if (isDayMonthEntered) {
                    System.out.println(FI_DT_PX);
                } else {
                    System.out.println(FINAL_DATE);
                }
                System.out.println("Player " + player + WINNER);
                break;
            }
        player = (player == 1) ? 2 : 1;
        }
    sc.close();
    }
//This method takes day as input. 
    public static String getOrdinalDate(int x) {
        if (x >= DAY_ELEVEN && x <= DAY_THIRTEEN) {
            return x + "th";
        }
        switch (x % DAY_TEN) {
            case 1: return x + "st";
            case 2: return x + "nd";
            case DAY_THREE: return x + "rd";
            default: return x + "th";
        }
    }

    public static String userInput(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }
   
    public static String getmonthName(int y) {
    switch (y) {
        case DAY_ONE:
            return "January";
        case DAY_TWO:
            return "February";
        case DAY_THREE:
            return "March";
        case DAY_FOUR:
            return "April";
        case DAY_FIVE:
            return "May";
        case DAY_SIX:
            return "June";
        case DAY_SEVEN:
            return "July";
        case DAY_EIGHT:
            return "August";
        case DAY_NINE:
            return "September";
        case DAY_TEN:
            return "October";
        case DAY_ELEVEN:
            return "November";
        case DAY_TWELVE:
            return "December";
        default:
            return INP_INVD;
        }
    }
// check invalid day
    public static int newdayValue(Scanner sc, int x, int y) {
        int countDay = 1;
        do {
            if (countDay == 1) {
                System.out.print(SEL_DATE);
            }
            String input = sc.nextLine().trim();
            try {
                int newDay = Integer.parseInt(input);
                if (y == 2 && newDay >= LEEP_DAY) {
                    countDay++;
                    System.out.println(INP_INVD);
                } else if (newDay > x && (y == DAY_FOUR
                || y == DAY_SIX
                || y == DAY_NINE 
                || y == DAY_ELEVEN) 
                && newDay > DAYS_IN_MONTH) {
                    countDay++;
                    System.out.println(INP_INVD);
                } else if (newDay > x && newDay <= MAX_DAY_MON) {
                    countDay++;
                    return newDay;
                } else if (y == 2 && newDay > FEB_MAX) {
                    countDay++;
                    System.out.println(INP_INVD);
                } else {
                    countDay++;
                    System.out.println(INP_INVD);
                }
            } catch (NumberFormatException e) {
                countDay++;
                System.out.println(INP_INVD);
            }
        }while (true);
    }
    //check invalid month
    public static int newmonthValue(Scanner sc, int y, int x) {
        int countMonth = 1;
        do {
            if (countMonth ==1) {
                System.out.print(SEL_MONTH);
            }
            String input = sc.nextLine().trim();
            try {
                int newMonth = Integer.parseInt(input);
                if (newMonth == 2 && x >= LEEP_DAY) {
                    countMonth++;
                    System.out.println(INP_INVD);
                }else if (newMonth > y && (newMonth == DAY_FOUR 
                || newMonth == DAY_SIX
                || newMonth == DAY_NINE 
                || newMonth == DAY_ELEVEN) && x > DAYS_IN_MONTH){
                    countMonth++;
                    System.out.println(INP_INVD);
                }else if (newMonth > y && newMonth <= DAY_TWELVE) {
                    countMonth++;
                    return newMonth;
                } else {
                    countMonth++;
                    System.out.println(INP_INVD);
                }
            } catch (NumberFormatException e) {
                countMonth++;
                System.out.println(INP_INVD);
            }
        }while (true);
    }
}

