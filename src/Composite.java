public class Composite extends ColumnProperties {
    private Concrete concrete = new Concrete();
    private Reinforcement rebar = new Reinforcement();
    public double nu;

    public void DefineConcrete(double fc, double[][] coords){
        concrete.setFc(fc);
        concrete.setCoordinates(coords);
        nu = rebar.getE()/concrete.getE();
        this.setE(concrete.getE());
        concrete.updateProperties();
    }
    public void DefineSteel(double[][] coords,double[] rebarArea){
        rebar.setCoordinates(coords);
        rebar.setRebarArea(rebarArea);
        rebar.updateProperties();
    }

    public void UpdateProperties(){
        this.setArea(concrete.getArea()+nu*rebar.getArea());
        this.setXc((concrete.getXc()*concrete.getArea()+nu*rebar.getXc()*rebar.getArea())/this.getArea());
        this.setYc((concrete.getYc()*concrete.getArea()+nu*rebar.getYc()*rebar.getArea())/this.getArea());
        this.setIxx(concrete.getIxx()+nu*rebar.getIxx());
        this.setIyy(concrete.getIyy()+nu*rebar.getIyy());
    }

    public void Rotate(double angle) {
        concrete.Rotate(angle);
        rebar.Rotate(angle);
    }
}
