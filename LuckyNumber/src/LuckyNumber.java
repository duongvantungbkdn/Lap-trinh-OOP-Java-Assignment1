import java.util.*;
public class LuckyNumber {
    public static final int MAXIMUM = 100; // tạo một hằng số maximum
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tôi đang nghĩ một số trong khoảng từ 0 đến 100...");
        int[] arr = play(sc);
        report(arr[0], arr[1], arr[2]);
    }

    public static int[] play(Scanner sc) {
        // ============ khởi tạo các giá trị ban đầu ================
        int playsNum = 0; // tổng số lượt chơi
        int leastPlay = Integer.MAX_VALUE; // số lần đoán ít nhất trong 1 lượt chơi
        int sum = 0; //tổng số lần dự đoán
        boolean playAgain = false; // biến lựa chọn chơi lại hay kết thúc trò chơi

        //============= 1 lượt chơi ==============================
        do{
            //------tạo số ngẫu nhiên 1 lượt chơi-------------
            int randomNum = (int) Math.floor(Math.random() * (MAXIMUM + 1));
            boolean isWin = false; // khởi tạo biến thể hiện đã đoán đúng hay chưa
            int timesNum = 0; // khởi tạo số lần dự đoán trong 1 lượt chơi

            //=========== 1 lần dự đoán ===========================
            do {
                System.out.print("Bạn đoán? ");
                int guessNum = sc.nextInt();
                timesNum++; // tăng số lần đoán lên 1
                if(guessNum == randomNum) {
                    System.out.println("Chúc mừng bạn đã đoán đúng con số may mắn sau " + timesNum + " lần dự đoán!");
                    sum += timesNum;  // tính tổng số lần dự đoán
                    playsNum++;       // tính tổng số lượt chơi
                    if(timesNum < leastPlay) {leastPlay = timesNum;} // số lần dự đoán ít nhất trong 1 lượt chơi
                    isWin = true; // đã đoán đúng, chọn lượt chơi tiếp hoặc dừng cuộc chơi
                } else if(guessNum < randomNum) {
                    System.out.println("Số may mắn lớn hơn số dự đoán của bạn.");
                } else {
                    System.out.println("Số may mắn nhỏ hơn số dự đoán của bạn.");
                }
            }while (isWin == false);
            System.out.print("Bạn có muốn tiếp tục chơi không? ");
            String answer = sc.next();
            if(answer.equalsIgnoreCase("y") ||answer.equalsIgnoreCase("yes")) {
                playAgain = true; // chọn chơi lượt tiếp theo
            } else {
                playAgain = false; // dừng trò chơi
            }
        }while(playAgain);
        int[] arrResult = {playsNum, sum, leastPlay};
        return arrResult; // trả về kết quả trò chơi
    }

    public static void report(int playsNum, int sum, int leastPlay) {
        System.out.println("Kết quả tổng quát của trò chơi: ");
        System.out.println("Tổng số lượt chơi = " + playsNum);
        System.out.println("Tổng số lần dự đoán = " + sum);
        System.out.println("Số lần dự đoán trung bình mỗi lượt = " +  ((double) sum/playsNum));
        System.out.println("Số lần dự đoán ít nhất = " + leastPlay);
    }

//    public static void play(Scanner sc) {
//        // -------- initial values --------
//        int playsNum = 0; // số lượt chơi
//        int leastPlay = Integer.MAX_VALUE; // số lần đoán ít nhất trong 1 lượt chơi
//        int sum = 0; //tổng số lượt chơi
//        boolean playAgain = false;
//
//        //============= 1 lượt chơi ==============================
//        do{
//            //------tạo số ngẫu nhiên 1 lượt chơi-------------
//            int randomNum = (int) Math.floor(Math.random() * (MAXIMUM + 1));
//            boolean isWin = false;
//            int timesNum = 0; // khởi tạo số lần dự đoán trong 1 lượt chơi
//            do {
//                System.out.print("Bạn đoán? ");
//                int guessNum = sc.nextInt();
//                timesNum++; // tăng số lần đoán
//                if(guessNum == randomNum) {
//                    System.out.println("Chúc mừng bạn đã đoán đúng con số may mắn sau " + timesNum + " lần dự đoán!");
//                    sum += timesNum;
//                    playsNum++;
//                    if(timesNum < leastPlay) {leastPlay = timesNum;}
//                    isWin = true;
//                } else if(guessNum < randomNum) {
//                    System.out.println("Số may mắn lớn hơn số dự đoán của bạn.");
//                } else {
//                    System.out.println("Số may mắn nhỏ hơn số dự đoán của bạn.");
//                }
//            }while (isWin == false);
//            System.out.print("Bạn có muốn tiếp tục chơi không? ");
//            String answer = sc.next();
//            if(answer.equalsIgnoreCase("y") ||answer.equalsIgnoreCase("yes")) {
//                playAgain = true;
//            } else {playAgain = false;}
//        }while(playAgain);
//        if(!playAgain) {
//            System.out.println("Kết quả tổng quát của trò chơi: ");
//            System.out.println("Tổng số lượt chơi = " + playsNum);
//            System.out.println("Tổng số lần dự đoán = " + sum);
//            System.out.println("Số lần dự đoán trung bình mỗi lượt = " +  ((double) sum/playsNum));
//            System.out.println("Số lần dự đoán ít nhất = " + leastPlay);
//        }
//    }
}
