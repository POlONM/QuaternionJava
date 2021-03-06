package org.spbstu.polonskij.task1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QuaternionTest {


    private Quaternion quaternion;

    @Test
    public void createEmpty() {
        quaternion = new Quaternion();
        assertEquals("0.0 + 0.0 * i + 0.0 * j + 0.0 * k", quaternion.toString());
    }

    @Test
    public void getConjugation() throws Exception {
        quaternion = new Quaternion(0.4, 0.1, 0.7, 1.5);
        assertEquals(new Quaternion(0.4, -0.1, -0.7, -1.5), quaternion.conjugation());
        quaternion = new Quaternion(1, 2, 3, 4);
        assertEquals(new Quaternion(1, -2, -3, -4), quaternion.conjugation());
        quaternion = new Quaternion(32.3, -56.789, 147.23, 37.5673);
        assertEquals(new Quaternion(32.3, 56.789, -147.23, -37.5673), quaternion.conjugation());
    }

    @Test
    public void getAbs() throws Exception {
        quaternion = new Quaternion(3, 1, -2, -4);
        assertEquals(5.477225575051661, quaternion.abs(), 1e-10);
        quaternion = new Quaternion(2.3, 4.1, 5.7, -1);
        assertEquals(7.455870170543476, quaternion.abs(), 1e-10);
        quaternion = new Quaternion(1.456, 0, 0, -4.2341);
        assertEquals(4.477447800924093, quaternion.abs(), 1e-10);
    }

    @Test
    public void getNormalize() throws Exception {
        quaternion = new Quaternion(1, 2, 3, 4);
        assertEquals(new Quaternion(0.18257418583505536, 0.3651483716701107,
                0.5477225575051661, 0.7302967433402214), quaternion.normalize());
        quaternion = new Quaternion(2.4, -6.7, 4, 9.2);
        assertEquals(new Quaternion(0.19512195121951223, -0.5447154471544716,
                0.3252032520325204, 0.7479674796747968), quaternion.normalize());
        quaternion = new Quaternion(26.45, -63.196, -19.3, -56.56);
        assertEquals(new Quaternion(0.29094299964127757, -0.6951392743035983,
                -0.21229489198777532, -0.6221450306128794), quaternion.normalize());
    }

    @Test
    public void getSum() throws Exception {
        assertEquals(new Quaternion(5, 5, 5, 5),
                new Quaternion(3, -1, 4, 2).sum(new Quaternion(2, 6, 1, 3)));
        assertEquals(new Quaternion(5.4, 5, 6.7, 5.6),
                new Quaternion(3.1, -1.2, 4.9, 2.5).sum(new Quaternion(2.3, 6.2, 1.8, 3.1)));
        assertEquals(new Quaternion(8.7731, 856.2336, 84.745805, 143.31),
                new Quaternion(45.3413, 189.567, 57.346805, 200)
                        .sum(new Quaternion(-36.5682, 666.6666, 27.399, -56.69)));
    }

    @Test
    public void getSub() throws Exception {
        assertEquals(new Quaternion(1, -11, 2, 7),
                new Quaternion(2, -5, 6, 4).sub(new Quaternion(1, 6, 4, -3)));
        assertEquals(new Quaternion(35.96, -120.19999999999999, 6.000000000000001, -1.3000000000000043),
                new Quaternion(23.56, -56.8, 10.3, 33.3)
                        .sub(new Quaternion(-12.4, 63.4, 4.3, 34.6)));
        assertEquals(new Quaternion(181.8475, 124.9618, 42.3334, -45.96),
                new Quaternion(25.4675, 189.34, 65.7894, -49.52)
                        .sub(new Quaternion(-156.38, 64.3782, 23.456, -3.56)));
    }

    @Test
    public void getMultNum() throws Exception {
        assertEquals(new Quaternion(4, -10, 12, 8),
                new Quaternion(2, -5, 6, 4).multNum(2));
        assertEquals(new Quaternion(9, -20.52, 21.96, 12.96),
                new Quaternion(2.5, -5.7, 6.1, 3.6).multNum(3.6));
        assertEquals(new Quaternion(698.4631499999999, 523.947347, 1985.4065, -930.14152),
                new Quaternion(24.45, 18.341, 69.5, -32.56).multNum(28.567));
    }

    @Test
    public void getMult() throws Exception {
        assertEquals(new Quaternion(-28, 4, 6, 8),
                new Quaternion(1, 2, 3, 4).mult(new Quaternion(1, 2, 3, 4)));
        assertEquals(new Quaternion(-539.21, -364.78000000000003, 132.76, -834.27),
                new Quaternion(14.8, -44.6, 22.6, 5.3)
                        .mult(new Quaternion(2.5, -3.6, 19.4, -4.3)));
        assertEquals(new Quaternion(-5487.588562, 623.7615599999999, 198.04689199999996, 375.5940453999995),
                new Quaternion(13.564, 78.2918, 22.4, -5.64)
                        .mult(new Quaternion(-3.4, 62.59, 23.153, -4)));
    }

    @Test
    public void getDivideNum() throws Exception {
        assertEquals(new Quaternion(1, 1, 1, 1),
                new Quaternion(7, 7, 7, 7).divideNum(7));
        assertEquals(new Quaternion(50, -37, 98, 49),
                new Quaternion(200, -148, 392, 196).divideNum(4));
        try {
            new Quaternion(30, 19, 2, 7).divideNum(0);
            assertTrue(false);
        } catch (ArithmeticException e) {
            assertTrue(true);
        }
    }

    @Test
    public void divide() throws Exception {
        assertEquals(new Quaternion(0.625, 0.125, 0, 0.25), new Quaternion(1, 2, 3, 4).divide(
                new Quaternion(4, 4, 4, 4)));
        assertEquals(new Quaternion(0.19321971621152229, -0.1102014468514016, 0.22508819448766892, 0.04558907091097829),
                new Quaternion(12.3, 25.6, 9.4, 11.1).divide(
                        new Quaternion(21.3, 41.4, -32.7, 82)));
        try {
            new Quaternion(23.65, 104, 36.3, 9.054).divide(new Quaternion());
            assertTrue(false);
        } catch (ArithmeticException e) {
            assertTrue(true);
        }
    }

    @Test
    public void getScalarPart() throws Exception {
        quaternion = new Quaternion(1, 2, 3, 4);
        assertEquals(1, quaternion.scalarPart(), -10);
        quaternion = new Quaternion(1.5, -2.378, 3.56, 4.894);
        assertEquals(1.5, quaternion.scalarPart(), -10);
        quaternion = new Quaternion(23.563, -286.3571, 356.0586, -4.58493);
        assertEquals(23.563, quaternion.scalarPart(), -10);
    }

    @Test
    public void getVectorPart() throws Exception {
        quaternion = new Quaternion(1, 2, 3, 4);
        assertEquals(new Vector(2, 3, 4), quaternion.vectorPart());
        quaternion = new Quaternion(1.5, -2.378, 3.56, 4.894);
        assertEquals(new Vector(-2.378, 3.56, 4.894), quaternion.vectorPart());
        quaternion = new Quaternion(23.563, -286.3571, 356.0586, -4.58493);
        assertEquals(new Vector(-286.3571, 356.0586, -4.58493), quaternion.vectorPart());
    }

    @Test
    public void getQuaternion() throws Exception {
        Vector vector;
        Double angle;
        vector = new Vector(1, 0, 0);
        angle = 0.0;
        assertEquals(new Quaternion(1, 0, 0, 0),
                Quaternion.getQuaternion(vector, angle));
        vector = new Vector(2, -3, 7);
        angle = 0.5;
        assertEquals(new Quaternion(0.9689124217106447, 0.06284066849134874,
                        -0.0942610027370231, 0.21994233971972058),
                Quaternion.getQuaternion(vector, angle));
    }

    @Test
    public void getAngle() throws Exception {
        assertEquals(new Vector(131.76029970389789, -90, 157.7965214679426),
                Quaternion.angle(new Quaternion(1, 2, 3, 4)));
        assertEquals(new Vector(166.25557557839016, 90, -173.29737717552186),
                Quaternion.angle(new Quaternion(2.574, -3.34, 21, 5.67)));
        assertEquals(new Vector(-164.83060350780724, 90, -109.32262466557886),
                Quaternion.angle(new Quaternion(156.45671, -563.5, 200.0004, -43.8543)));
    }

    @Test
    public void getAxis() throws Exception {
        assertEquals(new Vector(2, 3, 4),
                Quaternion.axis(new Quaternion(1, 2, 3, 4)));
        assertEquals(new Vector(-3.34, 21, 5.67),
                Quaternion.axis(new Quaternion(2.574, -3.34, 21, 5.67)));
        assertEquals(new Vector(-563.5, 200.0004, -43.8543),
                Quaternion.axis(new Quaternion(156.45671, -563.5, 200.0004, -43.8543)));
    }
}