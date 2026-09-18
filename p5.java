import java.util.Scanner;

class SlidingWindow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w, f;

        System.out.print("Enter window size: ");
        w = sc.nextInt();

        System.out.print("\nEnter number of frames to transmit: ");
        f = sc.nextInt();

        int[] frames = new int[f + 1];

        System.out.print("\nEnter " + f + " frames: ");
        for (int i = 1; i <= f; i++) {
            frames[i] = sc.nextInt();
        }

        System.out.println("\nWith sliding window protocol the frames will be sent in the following manner");
        System.out.println("(assuming no corruption of frames)\n");
        System.out.println("After sending " + w + " frames at each stage sender waits for acknowledgement sent by the receiver\n");

        for (int i = 1; i <= f; i++) {
            if (i % w == 0) {
                System.out.println(frames[i]);
                System.out.println("Acknowledgement of above frames sent is received by sender\n");
            } else {
                System.out.print(frames[i] + " ");
            }
        }

        if (f % w != 0) {
            System.out.println("\nAcknowledgement of above frames sent is received by sender");
        }

        sc.close();
    }
}
