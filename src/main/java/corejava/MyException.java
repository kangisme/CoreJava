package corejava;

public class MyException extends RuntimeException {

    public MyException(String msg) {
        super(msg);
    }

    private static void throwException(boolean i){
        if (i) {
            throw new MyException("这是个自定义的Exception");
        } else {
            System.out.println("hello");
        }
    }

    /**
     * 自定义的Exception不是必须throws或try-catch的
     * @param args
     */
    public static void main(String[] args) {
        throwException(true);
    }
}
