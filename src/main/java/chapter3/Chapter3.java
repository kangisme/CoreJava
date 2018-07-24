package chapter3;

import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.nio.charset.Charset;

class Chapter3 {

    /**
     * 整数除以0会报异常，浮点数除以0将会得到无穷大或NaN
     */
    private static void isNaN() {
        // NaN
        double x = 0.0 / 0;
        System.out.println(x);
        // Infinity
        double y = 1 / 0.0;
        System.out.println(y);
        // -Infinity
        double z = -1 / 0.0;
        System.out.println(z);
    }

    /**
     * 神奇的字符集
     */
    private static void unicode() {
        String s = "\u0022+\u0022";
        // 虽然编译器提示s永远为false，但编译运行为true
        if ("" == s) {
            System.out.println("s为空");
        }
    }

    private static void utf16() {
        String greeting = "Hello";
        int n = greeting.length();
        int cpCount = greeting.codePointCount(0, greeting.length());
        System.out.println("string length is " + n);
        System.out.println("code count is " + cpCount);
    }

    private static void remainder() {
        System.out.println(-3 % 2);
    }

    private static void codeUnit() {
        // 这是一个字符，代码单元数量为2，代码点数量为1
        String code = "\uD834\uDD1E";
        System.out.println("代码单元数量：" + code.length());
        System.out.println("代码点数量：" + code.codePointCount(0, code.length()));
    }

    private static void getByte() {
        String str = "hello你好";
        // utf-16长度理论上是14
        int num = str.getBytes(Charset.forName("utf-16")).length;
        // 实际是16
        System.out.println(num);
        // 多了FEFF，这是BOM
        System.out.println(DatatypeConverter.printHexBinary(str.getBytes(Charset.forName("utf-16"))));
    }

    private static void fileReader() {
        File gbk_demo = new File("src/main/resources/file.txt");
        Reader reader = null;
        try {
            InputStream is = new FileInputStream(gbk_demo);
            reader = new InputStreamReader(is, "GBK");

            char c = (char) reader.read();
            System.out.println(c);

            c = (char) reader.read();
            System.out.println(c);

            c = (char) reader.read();
            System.out.println(c);

            c = (char) reader.read();
            System.out.println(c);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void supplementaryCodePoint() {
        // 一个非BMP字符
        String s = "\uD85F\uDFF9";
        // 长度等于2
        System.out.println(s.length());
        // 属于增补字符
        System.out.println(Character.isSupplementaryCodePoint(s.codePointAt(0)));
    }

    /**
     * 这是个死循环
     */
    private static void forever() {
        for (double i = 0; i != 10; i = i + 0.1) {
            System.out.println(i);
        }
    }

    /**
     * break标签是跳出循环到标签的层级，并不是执行标签处的语句
     */
    private static void breakOut() {
        go:
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            if (i == 5) {
                break go;
            }
        }
    }


    public static void main(String[] args) {
        isNaN();
        unicode();
        remainder();
        utf16();
        codeUnit();
        getByte();
        fileReader();
        supplementaryCodePoint();
//        forever();
        breakOut();
    }
}
