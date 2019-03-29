package club.futurer.community.puzzle;

import org.web3j.utils.Numeric;

public class Ring {
    public Color[] colors = new Color[4];
    public Size[] sizes = new Size[4];

    public void initColors(Color color1, Color color2, Color color3, Color color4) {
        colors[0] = color1;
        colors[1] = color2;
        colors[2] = color3;
        colors[3] = color4;
    }

    public void initSizes(Size size1, Size size2, Size size3, Size size4) {
        sizes[0] = size1;
        sizes[1] = size2;
        sizes[2] = size3;
        sizes[3] = size4;
    }

    public byte[] evaluate() {
        byte[] result = new byte[2];
        String bytes1 = Transfer.transfer(colors[0]) + Transfer.transfer(colors[1]) + Transfer.transfer(colors[2]) + Transfer.transfer(colors[3]);
        result[0] = transfer(bytes1);
        String bytes2 = Transfer.transfer(sizes[0]) + Transfer.transfer(sizes[1]) + Transfer.transfer(sizes[2]) + Transfer.transfer(sizes[3]);
        result[1] = transfer(bytes2);
        return result;
    }

    public static byte transfer(String var1) {
        int result = 0;
        for(int i = 0; i < var1.length(); i++) {
            result <<= 1;
            if(var1.charAt(i) == '1') {
                result += 1;
            }
        }
        return (byte)result;
    }

//    public static void main(String[] args) {
//        System.out.println(Numeric.toHexString(new byte[]{transfer("01000100")}));
//    }
}
