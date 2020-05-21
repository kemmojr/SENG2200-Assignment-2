
abstract class PlanarShape implements Comparable<PlanarShape> {

    public abstract double area();//area method

    public abstract double originDistance();//origin distance method

    @Override
    public int compareTo(PlanarShape o) {//A compareTo method that compares two planarShapes
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
    public abstract String toString();//toString method
}
