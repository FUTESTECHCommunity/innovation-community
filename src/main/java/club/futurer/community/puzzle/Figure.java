package club.futurer.community.puzzle;

public class Figure {
    public Ring[] rings = new Ring[16];
    public String address = "0xd64fdefa8dbc540c2582a6fc44b8f88ffb6657ce";

    public static Figure constructor() {
        Figure figure = new Figure();
        figure.rings[0] = ring(Color.DarkGreen, Color.LightGreen, Color.DarkGreen, Color.LightGreen, Size.SS, Size.SB, Size.SB, Size.SB);
        figure.rings[1] = ring(Color.Purple, Color.LightGreen, Color.DarkGreen, Color.LightGreen, Size.BB, Size.BS, Size.BB, Size.BB);
        figure.rings[2]= ring(Color.Blue, Color.DarkGreen, Color.Blue, Color.Purple, Size.SB, Size.BS, Size.SS, Size.SB);
        figure.rings[3] = ring(Color.Purple, Color.Purple, Color.DarkGreen, Color.Purple, Size.BS, Size.BS, Size.SB, Size.BS);
        figure.rings[4] = ring(Color.LightGreen, Color.DarkGreen, Color.Purple, Color.Blue, Size.SB, Size.SS, Size.SB, Size.BS);
        figure.rings[5] = ring(Color.DarkGreen, Color.Blue, Color.LightGreen, Color.LightGreen, Size.BB, Size.SS, Size.BB, Size.BB);
        figure.rings[6] = ring(Color.Blue, Color.DarkGreen, Color.Purple, Color.Blue, Size.SS, Size.BS, Size.BB, Size.SB);
        figure.rings[7] = ring(Color.Purple, Color.Blue, Color.Purple, Color.LightGreen, Size.BS, Size.BB, Size.SB, Size.SS);
        figure.rings[8] = ring(Color.LightGreen, Color.Purple, Color.Blue, Color.LightGreen, Size.BB, Size.BB, Size.BS, Size.BS);
        figure.rings[9] = ring(Color.Blue, Color.Blue, Color.LightGreen, Color.DarkGreen, Size.BS, Size.SS, Size.SB, Size.SB);
        figure.rings[10] = ring(Color.Blue, Color.DarkGreen, Color.DarkGreen, Color.Purple, Size.SS, Size.SS, Size.SB, Size.SS);
        figure.rings[11] = ring(Color.LightGreen,Color.DarkGreen, Color.LightGreen, Color.Blue, Size.SB, Size.BS, Size.SS, Size.BB);
        figure.rings[12] = ring(Color.Blue, Color.LightGreen, Color.DarkGreen, Color.LightGreen, Size.BB, Size.BS, Size.BS, Size.SS);
        figure.rings[13] = ring(Color.LightGreen, Color.LightGreen, Color.Blue, Color.Blue, Size.BB, Size.SS, Size.BB, Size.BB);
        figure.rings[14] = ring(Color.Purple, Color.Blue, Color.Purple, Color.Blue, Size.SB, Size.SB, Size.BS, Size.SB);
        figure.rings[15] = ring(Color.DarkGreen, Color.Blue, Color.Purple, Color.DarkGreen, Size.BS, Size.BS, Size.SS, Size.BS);
        return figure;
    }

    private static Ring ring(Color color1, Color color2, Color color3, Color color4, Size size1, Size size2, Size size3, Size size4) {
        Ring ring = new Ring();
        ring.initColors(color1, color2, color3, color4);
        ring.initSizes(size1, size2, size3, size4);
        return ring;
    }

}
