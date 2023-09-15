public class Composite extends ColumnProperties {
    private Concrete concrete = new Concrete();
    private Steel steel = new Steel();
    public double nu;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        Composite clone = (Composite) super.clone();
        clone.setConcrete( (Concrete) clone.getConcrete().clone());
        clone.setSteel( (Steel) clone.getSteel().clone());
        return clone;
    }

    public void setConcrete(Concrete concrete){
        this.concrete = concrete;
        nu = steel.getE()/concrete.getE();
        this.setE(concrete.getE());
    }
    public void setSteel(Steel steel){
        this.steel = steel;
    }

    public void UpdateProperties(){
        this.setArea(concrete.getArea()+nu* steel.getArea());
        this.setXc((concrete.getXc()*concrete.getArea()+nu* steel.getXc()* steel.getArea())/this.getArea());
        this.setYc((concrete.getYc()*concrete.getArea()+nu* steel.getYc()* steel.getArea())/this.getArea());
        this.setIxx(concrete.getIxx()+nu* steel.getIxx());
        this.setIyy(concrete.getIyy()+nu* steel.getIyy());
    }

    public void Rotate(double angle) {
        concrete.Rotate(angle);
        steel.Rotate(angle);
    }

    public Concrete getConcrete(){
        return concrete;
    }
    public Steel getSteel(){
        return steel;
    }
}
