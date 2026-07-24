class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int rowLength = triangle.size();

        int[] row = new int[rowLength];

        // Copy the last row
        for(int i = 0; i < rowLength; i++){
            row[i] = triangle.get(rowLength - 1).get(i);
        }

        // Process from bottom to top
        for(int r = rowLength - 2; r >= 0; r--){

            for(int c = 0; c <= r; c++){

                row[c] = Math.min(row[c], row[c + 1])
                        + triangle.get(r).get(c);

            }
        }

        return row[0];
    }
}