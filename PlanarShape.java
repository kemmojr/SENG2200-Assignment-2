
abstract class PlanarShape implements Comparable<PlanarShape> {

    public abstract double area();

    public abstract double originDistance();

    @Override
    public int compareTo(PlanarShape o) {
        boolean out;
        if (this.area()<o.area()){
            return -1;
        } else if (this.area()>o.area()){
            return 1;
        }else if (this.area()==o.area()){
            if (this.originDistance()<o.originDistance()){
                return -1;
            } else if (this.originDistance()>o.originDistance()){
                return 1;
            }
        }
        return -2;
    }

    @Override
    public abstract String toString();
}
