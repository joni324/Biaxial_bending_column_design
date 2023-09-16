public class Load {
    private double[] P = {0,0,0};
    private double[] M = {0,0};

    Load(double[] P, double[] M){
        this.P = P;
        this.M = M;
    }

    public double[] getM() {
        return M;
    }

    public double[] getP() {
        return P;
    }

    public void translate(double deltaX,double deltaY){
        P[0] += deltaX;
        P[1] += deltaY;
    }

    public void rotate(double angle){
        P = Transform.RotateCoords(angle, new double[][] {P})[0];
        M = Transform.RotateCoords(angle, new double[][] {M})[0];
    }
}
