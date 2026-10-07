class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;

        int maxPointsOnLine = 1;

        for (int i = 0; i < n; i++) {
            Map<String, Integer> slopeMap = new HashMap<>();
            int duplicate = 1; // Count anchor point itself
            int currentMax = 0;

            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                // Reduce slope fraction using GCD
                int gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;

                // Normalize sign so (-1, -2) and (1, 2) produce identical key "2/1"
                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                } else if (dx == 0) {
                    dy = Math.abs(dy); // Vertical lines always have dx = 0, dy = 1
                }

                String key = dy + "/" + dx;
                slopeMap.put(key, slopeMap.getOrDefault(key, 0) + 1);
                currentMax = Math.max(currentMax, slopeMap.get(key));
            }

            maxPointsOnLine = Math.max(maxPointsOnLine, currentMax + duplicate);
        }

        return maxPointsOnLine;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}