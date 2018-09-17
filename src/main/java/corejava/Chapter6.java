package corejava;

import javax.swing.*;

public class Chapter6 {

    private static void talkingClock() {
        TalkingClock clock = new TalkingClock(1000, true);
        clock.start();

        // keep program running until user selects "Ok"
        JOptionPane.showConfirmDialog(null, "Quit program?");
        System.exit(0);
    }

    public static void main(String[] args) {
        talkingClock();
    }
}
