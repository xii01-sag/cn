import java.util.*;

public class SlidingWindow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the total number of frames:");
        int totalFrames = scanner.nextInt();
        System.out.print("Enter the window size:");
        int windowSize = scanner.nextInt();
        
        int[] frames = new int[totalFrames];
        for (int i = 0; i < totalFrames; i++) {
            frames[i] = i;
        }
        
        int sent = 0;
        int ack = 0;
        
        System.out.println("\n Sliding Window Protocol Simulation\n");
        
        while (ack < totalFrames) {
            for (int i = 0; i < windowSize && sent < totalFrames; i++) {
                System.out.println("Sending Frame:" + frames[sent]);
                sent++;
            }
            
            System.out.print("Enter the number of frames to acknowledged:");
            int ackedFrames = scanner.nextInt();
            
            if (ackedFrames <= 0 || ackedFrames > windowSize || ack + ackedFrames > totalFrames) {
                System.out.println("Invalid acnowledgment input.");
            } else {
                for (int i = 0; i < ackedFrames; i++) {
                    System.out.println("Frame:" + frames[ack] + "acknowledged.");
                    ack++;
                }
            }
        }
        System.out.println("All frames have been sent and acknowledged successfully!");
        scanner.close();
    }
}
