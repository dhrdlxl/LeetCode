class Solution {
    public String toHex(int num) {
        StringBuilder sb = new StringBuilder();

        if (num >= 0) {
            getHexadecimal(sb, num);
        } else if (num < 0) {
            StringBuilder twosComplement = new StringBuilder();
            
            long number = -1L * num;

            getTwosComplement(twosComplement, number);
            int bitValue = 1;
            int sum = 0;
            for (int i = 0; i < 32; i++) {
                if (twosComplement.charAt(i) == '1') {
                    sum += bitValue;
                }
                bitValue *= 2;

                if (bitValue == 16) {
                    getHexadecimal(sb, sum);
                    bitValue = 1;
                    sum = 0;
                }
            }
        }

        sb.reverse();

        return sb.toString();
    }

    private void getHexadecimal(StringBuilder sb, int num) {
        int remainder = 0;

        if (num == 0) {
            sb.append(0);
            return;
        }

        while (num > 0) {
            remainder = (num % 16);
            num /= 16;
            if (remainder < 10) {
                sb.append(remainder);
            } else {
                sb.append((char)('a' + remainder - 10));
            }
        }
    }

    private void getTwosComplement(StringBuilder sb, long num) {
        long remainder = 0;

        while (num > 0) {
            remainder = (num % 2);
            num /= 2;

            sb.append((remainder + 1) % 2);
        }

        while (sb.length() < 32) {
            sb.append(1);
        }

        int index = 0;
        while (index < 32 && sb.charAt(index) == '1') {
            sb.replace(index, index + 1, "0");
            index++;
        }

        sb.replace(index, index + 1, "1");
    }
}