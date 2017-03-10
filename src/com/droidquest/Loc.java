package com.droidquest;

public class Loc {
	
    private static int X_SIZE = 28;
    private static int Y_SIZE = 32;
	private final int x;
	private final int y;
	private final int x_adj;
	private final int y_adj;

	public Loc() {
	    x = 0;
		y = 0;
		x_adj = 0;
		y_adj = 0;
	}
	
	public Loc(int loc_x, int loc_y) {
		x = loc_x;
		y = loc_y;
        x_adj = 0;
        y_adj = 0;
	}

    public Loc(int loc_x, int loc_y, int loc_x_adj, int loc_y_adj) {
        x = loc_x;
        y = loc_y;
        x_adj = loc_x_adj;
        y_adj = loc_y_adj;
    }

	public Loc getLoc() {
		return this;
	}
	
	public int[] getXY() {
		int[] a = new int[2];
		a[0] = x; a[1] = y;
		return a;
	}
	
	private int getPixelX() {
	    return x*X_SIZE+x_adj;
	}
	
	private int getPixelY() {
	    return y*Y_SIZE+y_adj;
	}
	
    public int[] getPixelXY() {
        int[] a = new int[2];
        a[0] = getPixelX();
        a[1] = getPixelY();
        return a;
    }
    
    public static Loc makeLoc(int px, int py) {
        return new Loc(px/X_SIZE, py/Y_SIZE, px%X_SIZE, py%Y_SIZE);     
    }
    
	public Loc move(int move_x, int move_y) {
		return new Loc(x+move_x, y+move_y);
	}
	
	public Loc nudge(int nudge_x, int nudge_y){
	    return makeLoc(getPixelX()+nudge_x, getPixelY()+nudge_y);
	}
}
