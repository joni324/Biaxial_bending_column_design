public class Concrete extends Column{
    private double fc = 5.5; //default to 5.5ksi
    public Concrete(){
        super.setE(Properties.E(fc));
    }
    private double[][] coords; //(x,y) in inches

    public void setCoords(double[][] coords) {
        this.coords = coords;
        super.setArea(Properties.Area(coords));
        super.setXc(Properties.Xc(coords,super.getArea()));
        super.setYc(Properties.Yc(coords,super.getArea()));
        super.setIxx(Properties.Ixx(coords));
        super.setIyy(Properties.Iyy(coords));
    }
    public double[][] getCoords(){
        return coords;
    }
    public void setFc(double fc){
        this.fc = fc;
        super.setE(Properties.E(fc));
    }
    public double getFc(){
        return fc;
    }
}
