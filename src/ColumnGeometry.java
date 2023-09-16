public class ColumnGeometry extends ColumnProperties{
    private double[][] coordinates;

    public void setCoordinates(double[][] coords) {
        coordinates = coords;
    }

    public double[][] getCoordinates() {
        return coordinates;
    }
    public void rotate(double angle){
        this.setCoordinates(Transform.RotateCoords(angle, this.getCoordinates()));
    }
    public void translate(double deltaX, double deltaY){
        this.setCoordinates(Transform.TranslateCoords(deltaX, deltaY, this.getCoordinates()));
    }
}

