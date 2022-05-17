public class PaintJob {
    public static int getBucketCount (double width, double height, double areaPerBucket, int extraBuckets) {
        if (width <= 0 || height <= 0 || areaPerBucket <= 0 || extraBuckets < 0) {
            return -1;
        }
        double areaNeedsCovered = (width * height);
        int totalBucketsNeeded = (int) (Math.ceil(areaNeedsCovered / areaPerBucket));
        totalBucketsNeeded = totalBucketsNeeded - extraBuckets;
        System.out.println(totalBucketsNeeded);
        return totalBucketsNeeded;
    }

    public static int getBucketCount(double width, double height, double areaPerBucket) {
        if (width <= 0 || height <= 0 || areaPerBucket <= 0) {
            return -1;
        }
        double areaNeedsCovered = (width * height);
        int totalBucketsNeeded = (int) (Math.ceil(areaNeedsCovered / areaPerBucket));
        System.out.println(totalBucketsNeeded);
        return totalBucketsNeeded;
    }

    public static int getBucketCount (double area, double areaPerBucket) {
        if (area <= 0 || areaPerBucket <= 0) {
            return -1;
        }
        int totalBucketsNeeded = (int) (Math.ceil(area / areaPerBucket));
        System.out.println(totalBucketsNeeded);
        return totalBucketsNeeded;
    }
}
