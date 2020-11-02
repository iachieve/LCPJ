public static void main(String[] args) {
        System.out.println(isPowerOf(36, 6));
    }
    public static boolean isPowerOf(int num, int powerOf) {
        return (Math.log(num) / Math.log(powerOf)) % 1 == 0;
    }