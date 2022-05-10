public class MegaBytesConverter {
    public static void printMegaBytesAndKiloBytes(int kiloBytes) {
        if (kiloBytes < 0) {
            System.out.println("Invalid Value");
        } else {
            int wholeMegaBytes = Math.round(kiloBytes / 1024);
            int remainder = kiloBytes % 1024;
//        System.out.println(wholeMegaBytes);
//        System.out.println(remainder);
            System.out.println(kiloBytes + " KB = " + wholeMegaBytes + " MB and " + remainder + " KB");
        }
    }
}

// 1 MB = 1024 KB
