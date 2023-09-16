public class Concrete extends ColumnGeometry{
    private double fc = 5.5; //default to 5.5ksi
    public Concrete(){
        this.setE(GeometricProperties.E(fc));
    }
    public void setFc(double fc){
        this.fc = fc;
        this.setE(GeometricProperties.E(fc));
    }
    public double getFc(){
        return fc;
    }
    public void ReduceSection(){
        this.setCoordinates(Transform.ReduceSection(this.getCoordinates()));
        this.updateProperties();
    }
    public void updateProperties(){
        this.setArea(GeometricProperties.Area(this.getCoordinates()));
        this.setXc(GeometricProperties.Xc(this.getCoordinates(),this.getArea()));
        this.setYc(GeometricProperties.Yc(this.getCoordinates(),this.getArea()));
        this.setIxx(GeometricProperties.Ixx(this.getCoordinates()));
        this.setIyy(GeometricProperties.Iyy(this.getCoordinates()));
    }
}
