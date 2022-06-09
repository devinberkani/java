class ArrayOperations {

    public static int[][][] createCube() {
        // write your code here
        int[][][] createCube = new int[3][3][3];

        // {
        // {{}, {}, {}},
        // {{}, {}, {}},
        // {{}, {}, {}}
        // }

        int numCount = 0;
        for (int i = 0; i < createCube.length; i++) {
            for (int j = 0; j < createCube[i].length; j++) {
                for (int k = 0; k < createCube[i][j].length; k++) {
                    createCube[i][j][k] = numCount;
                    numCount++;
                }
            }
            numCount = 0;
        }
        return createCube;
    }
}