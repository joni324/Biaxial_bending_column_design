public class Concrete extends ColumnGeometry{
    private double fc = 5.5; //default to 5.5ksi
    public Concrete(){
        this.setE(Properties.E(fc));
    }
    public void setFc(double fc){
        this.fc = fc;
        this.setE(Properties.E(fc));
    }
    public double getFc(){
        return fc;
    }
    public void ReduceSection(){
        this.setCoordinates(Transform.ReduceSection(this.getCoordinates()));
        this.updateProperties();
    }
    public void updateProperties(){
        this.setArea(Properties.Area(this.getCoordinates()));
        this.setXc(Properties.Xc(this.getCoordinates(),this.getArea()));
        this.setYc(Properties.Yc(this.getCoordinates(),this.getArea()));
        this.setIxx(Properties.Ixx(this.getCoordinates()));
        this.setIyy(Properties.Iyy(this.getCoordinates()));
    }
}
