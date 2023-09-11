public class Reinforcement extends Column{

    Reinforcement(){
        super.setE(29000);//default E to 29000ksi
    }
    private double[][] coords; //(x,y, area )

    public void setCoords(double [][] coords){
        this.coords = coords; // (x,y,Area)
        double[] properties = Properties.steelProperties(coords);
        super.setArea(properties[0]);
        super.setXc(properties[1]);
        super.setYc(properties[2]);
        super.setIxx(properties[3]);
        super.setIyy(properties[4]);
    }

}
