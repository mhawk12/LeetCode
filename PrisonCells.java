public class PrisonCells {
    public int[] prisonAfterNDays(int[] cells, int N) {

        int[][] result = new int[2 * (cells.length - 1) + 1][cells.length];


        for (int i = 0; i < cells.length; i++)
            result[0][i] = cells[i];


        for (int i = 0; i < cells.length; i++) {

            if (i - 1 < 0 || i + 1 > cells.length - 1) {
                cells[i] = 0;
                continue;
            }

            result[1][i] = result[0][i - 1] == result[0][i + 1] ? 1 : 0;

        }


        for (int j = 2; j < result.length; j++) {

            for (int i = 0; i < cells.length; i++) {

                if (i - 1 < 0 || i + 1 > cells.length - 1) {
                    result[j][i] = 0;
                    continue;
                }
                result[j][i] = result[j - 1][i - 1] == result[j - 1][i + 1] ? 1 : 0;

            }
        }


        if (N < result.length)
            return result[N];
        else if (N % (result.length - 1) == 0)
            return result[result.length - 1];
        else
            return (result[N % (result.length - 1)]);


    }
}
