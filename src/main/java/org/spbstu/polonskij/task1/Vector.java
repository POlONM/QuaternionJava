package org.spbstu.polonskij.task1;

public class Vector {
    double x, y, z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    /**
     * @return length of a vector
     */
    private double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    /**
     * @return a vector in the same direction with only one length
     */
    public Vector normalize() {
        double length = length();
        return new Vector(x / length, y / length, z / length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vector vector = (Vector) o;

        if (Double.compare(vector.getX(), getX()) != 0) return false;
        if (Double.compare(vector.getY(), getY()) != 0) return false;
        return Double.compare(vector.getZ(), getZ()) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getX());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getY());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getZ());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "(" + ((x < 0) ? "- " : "") + Math.abs(x) + ", " + ((y < 0) ? "- " : "") +
                Math.abs(y) + ", " + ((z < 0) ? "- " : "") + Math.abs(z) + ")";
    }
}
