package club.futurer.community.puzzle;

public class Transfer {
    private Transfer() {}

    public static String  transfer(Color color) {
        //11 10 01 00
//        if(color == Color.DarkGreen)
//            return "11";
//        if(color == Color.LightGreen)
//            return "10";
//        if(color == Color.Blue)
//            return "01";
//        if(color == Color.Purple)
//            return "00";

        //11 10 00 01
//        if(color == Color.DarkGreen)
//            return "11";
//        if(color == Color.LightGreen)
//            return "10";
//        if(color == Color.Blue)
//            return "00";
//        if(color == Color.Purple)
//            return "01";

        //11 01 10 00
//        if(color == Color.DarkGreen)
//            return "11";
//        if(color == Color.LightGreen)
//            return "01";
//        if(color == Color.Blue)
//            return "10";
//        if(color == Color.Purple)
//            return "00";

        //11 01 00 10
//        if(color == Color.DarkGreen)
//            return "11";
//        if(color == Color.LightGreen)
//            return "01";
//        if(color == Color.Blue)
//            return "00";
//        if(color == Color.Purple)
//            return "10";

        //11 00 01 10
//        if(color == Color.DarkGreen)
//            return "11";
//        if(color == Color.LightGreen)
//            return "00";
//        if(color == Color.Blue)
//            return "01";
//        if(color == Color.Purple)
//            return "10";

        //11 00 10 01
//        if(color == Color.DarkGreen)
//            return "11";
//        if(color == Color.LightGreen)
//            return "00";
//        if(color == Color.Blue)
//            return "10";
//        if(color == Color.Purple)
//            return "01";

        //10 11 00 01
//        if(color == Color.DarkGreen)
//            return "10";
//        if(color == Color.LightGreen)
//            return "11";
//        if(color == Color.Blue)
//            return "00";
//        if(color == Color.Purple)
//            return "01";

        //10 11 01 00
//        if(color == Color.DarkGreen)
//            return "10";
//        if(color == Color.LightGreen)
//            return "11";
//        if(color == Color.Blue)
//            return "01";
//        if(color == Color.Purple)
//            return "00";

        //10 00 01 11
//        if(color == Color.DarkGreen)
//            return "10";
//        if(color == Color.LightGreen)
//            return "00";
//        if(color == Color.Blue)
//            return "01";
//        if(color == Color.Purple)
//            return "11";

        //10 00 11 01
//        if(color == Color.DarkGreen)
//            return "10";
//        if(color == Color.LightGreen)
//            return "00";
//        if(color == Color.Blue)
//            return "11";
//        if(color == Color.Purple)
//            return "01";

        //10 01 11 00
//        if(color == Color.DarkGreen)
//            return "10";
//        if(color == Color.LightGreen)
//            return "01";
//        if(color == Color.Blue)
//            return "11";
//        if(color == Color.Purple)
//            return "00";
        //10 01 00 11
//        if(color == Color.DarkGreen)
//            return "10";
//        if(color == Color.LightGreen)
//            return "01";
//        if(color == Color.Blue)
//            return "00";
//        if(color == Color.Purple)
//            return "11";

        //01 11 00 10
//        if(color == Color.DarkGreen)
//            return "01";
//        if(color == Color.LightGreen)
//            return "11";
//        if(color == Color.Blue)
//            return "00";
//        if(color == Color.Purple)
//            return "10";
        //01 11 10 00
//        if(color == Color.DarkGreen)
//            return "01";
//        if(color == Color.LightGreen)
//            return "11";
//        if(color == Color.Blue)
//            return "10";
//        if(color == Color.Purple)
//            return "00";
        //01 00 10 11
//        if(color == Color.DarkGreen)
//            return "01";
//        if(color == Color.LightGreen)
//            return "00";
//        if(color == Color.Blue)
//            return "10";
//        if(color == Color.Purple)
//            return "11";
        //01 00 11 10
//        if(color == Color.DarkGreen)
//            return "01";
//        if(color == Color.LightGreen)
//            return "00";
//        if(color == Color.Blue)
//            return "11";
//        if(color == Color.Purple)
//            return "10";
        //01 10 11 00
//        if(color == Color.DarkGreen)
//            return "01";
//        if(color == Color.LightGreen)
//            return "10";
//        if(color == Color.Blue)
//            return "11";
//        if(color == Color.Purple)
//            return "00";
        //01 10 00 11
//        if(color == Color.DarkGreen)
//            return "01";
//        if(color == Color.LightGreen)
//            return "10";
//        if(color == Color.Blue)
//            return "00";
//        if(color == Color.Purple)
//            return "11";

        //00 11 10 01
//        if(color == Color.DarkGreen)
//            return "00";
//        if(color == Color.LightGreen)
//            return "11";
//        if(color == Color.Blue)
//            return "10";
//        if(color == Color.Purple)
//            return "01";
        //00 11 01 10
//        if(color == Color.DarkGreen)
//            return "00";
//        if(color == Color.LightGreen)
//            return "11";
//        if(color == Color.Blue)
//            return "01";
//        if(color == Color.Purple)
//            return "10";
        //00 10 11 01
//        if(color == Color.DarkGreen)
//            return "00";
//        if(color == Color.LightGreen)
//            return "10";
//        if(color == Color.Blue)
//            return "11";
//        if(color == Color.Purple)
//            return "01";
        //00 10 01 11
//        if(color == Color.DarkGreen)
//            return "00";
//        if(color == Color.LightGreen)
//            return "10";
//        if(color == Color.Blue)
//            return "01";
//        if(color == Color.Purple)
//            return "11";
        //00 01 11 10
//        if(color == Color.DarkGreen)
//            return "00";
//        if(color == Color.LightGreen)
//            return "01";
//        if(color == Color.Blue)
//            return "11";
//        if(color == Color.Purple)
//            return "10";
        //00 01 10 11
        if(color == Color.DarkGreen)
            return "00";
        if(color == Color.LightGreen)
            return "01";
        if(color == Color.Blue)
            return "10";
        if(color == Color.Purple)
            return "11";

        throw new IllegalArgumentException();
    }

    public static String transfer(Size size) {
        if(size == Size.SS)
            return "00";
        if(size == Size.SB)
            return "01";
        if(size == Size.BS)
            return "10";
        if(size == Size.BB)
            return "11";
        throw new IllegalArgumentException();
    }
}
