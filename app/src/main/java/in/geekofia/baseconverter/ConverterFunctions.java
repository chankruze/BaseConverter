package in.geekofia.baseconverter;

public class ConverterFunctions {
    private static final String HEX_DIGITS = "0123456789ABCDEF";
    private static final char OCTAL_CHARS[] = {'0', '1', '2', '3', '4', '5', '6', '7'};
    private static final char HEX_CHARS[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static class FN_CODES {
        public static final int
                BIN2OCT = 28,
                BIN2DEC = 210,
                BIN2HEX = 216,
                OCT2BIN = 82,
                OCT2DEC = 810,
                OCT2HEX = 816,
                DEC2BIN = 102,
                DEC2OCT = 108,
                DEC2HEX = 1016,
                HEX2BIN = 162,
                HEX2OCT = 168,
                HEX2DEC = 1610;
    }

    public static class FN_MATH {
        /*******************
         * Binary To Rest
         *******************/

        public static String Binary2Decimal(int binary) {
            int decimal = 0;
            int n = 0;
            while (true) {
                if (binary == 0) {
                    break;
                } else {
                    int temp = binary % 10;
                    decimal += temp * Math.pow(2, n);
                    binary = binary / 10;
                    n++;
                }
            }
            return String.valueOf(decimal);
        }

        /*******************
         * Octal To Rest
         *******************/

        public static String Octal2Decimal(int octal) {
            int decimal = 0;
            int n = 0;
            while (octal != 0) {
                int temp = octal % 10;
                decimal += temp * Math.pow(8, n);
                octal = octal / 10;
                n++;
            }
            return String.valueOf(decimal);
        }

        /*******************
         * Decimal To Rest
         *******************/

        public static String Decimal2Hex(int decimal) {
            int rem;
            String hex = "";
            while (decimal > 0) {
                rem = decimal % 16;
                hex = HEX_CHARS[rem] + hex;
                decimal = decimal / 16;
            }
            return hex;
        }

        public static String Decimal2Binary(int decimal) {
            int binary[] = new int[40];
            int index = 0;
            while (decimal > 0) {
                binary[index++] = decimal % 2;
                decimal = decimal / 2;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = index - 1; i >= 0; i--) {
                stringBuilder.append(binary[i]);
            }
            return stringBuilder.toString();
        }

        public static String Decimal2Octal(int decimal) {
            int rem;
            String octal = "";
            while (decimal > 0) {
                rem = decimal % 8;
                octal = OCTAL_CHARS[rem] + octal;
                decimal = decimal / 8;
            }
            return octal;
        }

        /*******************
         * Decimal To Rest
         *******************/

        public static String Hex2Decimal(String hex) {
            int decimal = 0;
            for (int i = 0; i < hex.length(); i++) {
                char c = hex.charAt(i);
                int value = HEX_DIGITS.indexOf(c);
                decimal = 16 * decimal + value;
            }
            return String.valueOf(decimal);
        }
    }
}
