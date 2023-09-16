public class ColumnProperties implements Cloneable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private double E = 0;//ksi
    private double area = 0;//in^2
    private double xc = 0;//in
    private double yc = 0;//in
    private double Ix = 0;//in^3
    private double Iy = 0;//in^3
    private double Ixx = 0;//in^4
    private double Iyy = 0;//in^4
    private double Ixy = 0;//in^4
    public void setArea(double area){
        this.area = area;
    }
    public double getArea(){
        return area;
    }
    public void setXc(double xc){
        this.xc = xc;
    }
    public double getXc(){
        return xc;
    }
    public void setYc(double yc){
        this.yc = yc;
    }
    public double getYc(){
        return yc;
    }
    public void setIxx(double Ixx){
        this.Ixx = Ixx;
    }
    public double getIxx(){
        return Ixx;
    }
    public void setIyy(double Iyy){
        this.Iyy = Iyy;
    }
    public double getIyy(){
        return Iyy;
    }
    public void setIxy(double Ixy){
        this.Ixy = Ixy;
    }

    public double getIxy() {
        return Ixy;
    }

    public void setE(double E){
        this.E = E;
    }
    public double getE(){
        return E;
    }
}
