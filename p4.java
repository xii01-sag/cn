import java.io.*;

class crc_gen {
    static int[] divide(int[] divisor, int[] rem) {
        int cur = 0;
        while (true) {
            while (cur < rem.length && rem[cur] == 0) {
                cur++;
            }
            if ((rem.length - cur) < divisor.length) {
                break;
            }
            for (int i = 0; i < divisor.length; i++) {
                rem[cur + i] = rem[cur + i] ^ divisor[i];
            }
        }
        return rem;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] data;
        int[] div;
        int[] divisor;
        int[] rem;
        int[] crc;
        int data_bits, divisor_bits, tot_length;

        System.out.println("Enter number of data bits: ");
        data_bits = Integer.parseInt(br.readLine());
        data = new int[data_bits];

        System.out.println("Enter data bits: ");
        for (int i = 0; i < data_bits; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        divisor_bits = 17;
        divisor = new int[] {
            1, 0, 0, 0, 1, 0, 0, 0, 0,
            0, 1, 0, 0, 0, 0, 1
        };

        tot_length = data_bits + divisor_bits - 1;
        div = new int[tot_length];
        rem = new int[tot_length];
        crc = new int[tot_length];

        for (int i = 0; i < data_bits; i++) {
            div[i] = data[i];
        }

        System.out.print("Dividend (after appending 0's) are: ");
        for (int i = 0; i < div.length; i++) {
            System.out.print(div[i]);
        }
        System.out.println();

        for (int j = 0; j < div.length; j++) {
            rem[j] = div[j];
        }

        rem = divide(divisor, rem);

        for (int i = 0; i < div.length; i++) {
            crc[i] = div[i] ^ rem[i];
        }

        System.out.println();
        System.out.println("CRC code: ");
        for (int i = 0; i < crc.length; i++) {
            System.out.print(crc[i]);
        }

        System.out.println();
        System.out.println("Enter CRC code of " + tot_length + " bits: ");

        for (int i = 0; i < crc.length; i++) {
            crc[i] = Integer.parseInt(br.readLine());
        }

        for (int j = 0; j < crc.length; j++) {
            rem[j] = crc[j];
        }

        rem = divide(divisor, rem);

        for (int i = 0; i < rem.length; i++) {
            if (rem[i] != 0) {
                System.out.println("Error");
                break;
            }
            if (i == rem.length - 1) {
                System.out.println("No Error");
            }
        }
    }
}
