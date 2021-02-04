import java.util.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static PrizePool myPrizePool = new PrizePool();
    private static Set<Prize> prizePool = myPrizePool.getPrizePool();


    public static void main(String[] args) {

        System.out.println("\n************* 抽奖活动 ***********\n");
        printPrizes();
        printMenu();

        boolean flag = true;
        int choice;
        Prize currentPrize = null;

        while (flag) {

            if (prizePool.size() == 0) {
                System.out.println("奖品已抽完，新年快乐！");
                break;
            }

            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("输入无效，请从下面数字中进行选择:");
                printMenu();
                continue;
            }

            switch (choice) {
                case 0:
                    flag = false;
                    break;
                case 1:
                    currentPrize = lottery();
                    System.out.println("抽中了 " +
                            currentPrize.getPrizeId() +
                            " 号礼物，" +
                            currentPrize.getName() + "!");
                    System.out.println("剩余礼物数量: " + prizePool.size() + "\n");
                    break;
                case 2:
                    if(currentPrize != null) {
                        reLottery(currentPrize);
                        System.out.println("剩余礼物数量: " + prizePool.size() + "\n");
                    } else {
                        System.out.println("请先抽一个呀！\n");
                    }
                    break;
                case 3:
                    printPrizes();
                    break;
                case 4:
                    printMenu();
                    break;
                default:
                    System.out.println("输入无效，请从下面数字中进行选择:");
                    printMenu();
                    break;
            }

        }
    }

    private static void printMenu() {
        System.out.println("菜单");
        System.out.println("********************");
        System.out.println(0 + ": " + "退出抽奖");
        System.out.println(1 + ": " + "抽取一个");
        System.out.println(2 + ": " + "重抽抽取");
        System.out.println(3 + ": " + "查看奖池");
        System.out.println(4 + ": " + "查看菜单");
        System.out.println("********************");
        System.out.println();
    }

    private static Prize lottery() {
        List<Prize> list = new ArrayList<>(prizePool);
        int randomIndex = new Random().nextInt(list.size());
        Prize prize = list.get(randomIndex);
        prizePool.remove(prize);
        return prize;
    }

    private static void reLottery(Prize currentPrize) {
        if(prizePool.contains(currentPrize)) {
            System.out.println("请勿重复放回！");
        } else {
            prizePool.add(currentPrize);
            System.out.println(currentPrize.getPrizeId() + " 号礼物：" + currentPrize.getName() +
                    "，已放回，请重新抽奖!");
        }
    }

    private static void printPrizes() {
        List<Prize> list = new ArrayList<>(prizePool);
        Collections.sort(list);
        System.out.println("剩余礼物数量： " + prizePool.size());
        System.out.println("********************");
        list.forEach(prize -> System.out.println(prize.getPrizeId() + ": " + prize.getName()));
        System.out.println("********************");
        System.out.println();
    }

}
