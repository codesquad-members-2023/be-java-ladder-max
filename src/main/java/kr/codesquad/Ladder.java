//    void printVerticalLine(int people, int Ladder) {
//        for (int i = 0; i < Ladder; i++) {
//            System.out.print("|");
//            printHorizontalLine(people);
//            System.out.println();
//        }
//    }
//
//
//    private void printHorizontalLine(int people) {
//        for (int i = 0; i < people; i++) {
//            if (randomBoolean()) {
//                System.out.print("-");
//            } else {
//                System.out.print(" ");
//            }
//            System.out.print("|");
//        }
//    }
    private boolean randomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }
