public class Composite extends Column{
    private Concrete concrete = new Concrete();
    private Reinforcement rebar = new Reinforcement();
    public double nu;

    public void DefineConcrete(double fc, double[][] coords){
        concrete.setFc(fc);
        concrete.setCoords(coords);
        nu = rebar.getE()/concrete.getE();
        super.setE(concrete.getE());
    }
    public void DefineSteel(double[][] coords){// steel = (x,y,area)
        rebar.setCoords(coords);
    }

    public void UpdateProperties(){
        super.setArea(concrete.getArea()+nu*rebar.getArea());
        super.setXc((concrete.getXc()*concrete.getArea()+nu*rebar.getXc()*rebar.getArea())/super.getArea());
        super.setYc((concrete.getYc()*concrete.getArea()+nu*rebar.getYc()*rebar.getArea())/super.getArea());
        super.setIxx(concrete.getIxx()+nu*rebar.getIxx());
        super.setIyy(concrete.getIyy()+nu*rebar.getIyy());
    }

}
