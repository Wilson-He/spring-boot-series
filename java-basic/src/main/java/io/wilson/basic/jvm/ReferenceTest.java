package io.wilson.basic.jvm;

/**
 * @author Wilson-He
 * @date 2020/7/30
 */
public class ReferenceTest {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        ReferenceTest referenceTestA = new ReferenceTest();
        ReferenceTest referenceTestB = new ReferenceTest();
        referenceTestA.instance = referenceTestB;
        referenceTestB.instance = referenceTestA;
        referenceTestA = null;
        referenceTestB = null;
        System.gc();
    }
}
