public class Steel extends ColumnGeometry {
    Steel(){
        super.setE(29000);//default E to 29000ksi
    }
    double[] rebarArea;
    public void setRebarArea(double[] rebar) {
        rebarArea = rebar;
    }
    public void updateProperties(){
        double[] properties = Properties.steelProperties(this.getCoordinates(),this.rebarArea);
        this.setArea(properties[0]);
        this.setXc(properties[1]);
        this.setYc(properties[2]);
        this.setIxx(properties[3]);
        this.setIyy(properties[4]);
    }
}
