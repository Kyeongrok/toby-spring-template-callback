public class ExMethod {

    private int plus(int val1, int val2){
        System.out.println("int plus");
        return val1 + val2;
    }

    private int plus(int val1, int val2, int val3){
        System.out.println("int plus2");
        return val1 + val2 + val3;
    }

    private float plus(float val1, float val2){
        System.out.println("float plus");
        return val1 + val2;
    }

    private int minus(int val1, int val2){
        return val1 - val2;
    }

    private void multiple(int val1, int val2){
        System.out.println(val1 * val2);
    }

    public static void main(String[] args) {
        ExMethod exMethod = new ExMethod();
//        int r1 = exMethod.plus(20, 20);
//        int r2 = exMethod.minus(20, 30);
//        exMethod.multiple(r1, exMethod.minus(20, 10));
//        float val1 = 1.8f;
//        float val2 = 3.7f;

        System.out.println(exMethod.plus(1.8f, 3.7f)); // 5.5
        System.out.println(exMethod.plus(10, 20));
        System.out.println(exMethod.plus(10, 20, 30));
        // 1 / 2 = 0.5
        // 20 - 30
        // r1 = 30, r2 = -10
        // 30 * -10
        // 40 * 10
    }
}
