import java.util.Scanner;

class LeakyBucket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter bucket capacity: ");
        int capacity = sc.nextInt();
        System.out.print("Enter output rate: ");
        int rate = sc.nextInt();
        System.out.print("Enter number of packets: ");
        int n = sc.nextInt();
        
        int bucket = 0;
        
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter packet size: ");
            int packet = sc.nextInt();
            
            if (bucket + packet <= capacity) {
                bucket += packet;
                System.out.println("Packet accepted");
            } else {
                System.out.println("Packet dropped");
            }
            
            int sent = Math.min(bucket, rate);
            bucket -= sent;
            
            System.out.println("Packets sent: " + sent);
            System.out.println("Packets remaining: " + bucket);
        }
        sc.close();
    }
}
