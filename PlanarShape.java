
abstract class PlanarShape implements Comparable<PlanarShape> {

    public abstract double area();

    public abstract double originDistance();

    @Override
    public int compareTo(PlanarShape o) {//implement
        return 0;
    }

    @Override
    public abstract String toString();
}
