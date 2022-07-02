package Grid;

import java.util.ArrayList;
import java.util.List;

public class ColorGrid {
    private final int N;
    private final int X;
    private final int Y;
    private final int[][] grid;

    ColorGrid(int n, int x, int y) {
        N = n;
        X = x;
        Y = y;
        grid = new int[X][Y];
        createGrid();
    }

    private void createGrid() {
        for (int i = 0; i < X; ++i) {
            for (int j = 0; j < Y; ++j) {
                grid[i][j] = (int) (Math.random() * N + 1);
            }
        }
    }

    public int findMaxCount() {
        int[][] flag = new int[X][Y];
        int maxCount = 0;
        List<List<Integer>> maxBlock = new ArrayList<>();
        for (int i = 0; i < X; ++i) {
            for (int j = 0; j < Y; ++j) {
                if (flag[i][j] == 0) {
                    List<List<Integer>> curBlock = new ArrayList<>();
                    int index=0;
                    flag[i][j] = 1;
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    tmp.add(j);
                    curBlock.add(tmp);
                    while (index < curBlock.size()) {
                        int r = curBlock.get(index).get(0);
                        int c = curBlock.get(index).get(1);
                        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                        for (int[] direction : directions) {
                            int newr = r + direction[0], newc = c + direction[1];
                            if (newr >= 0 && newr < X && newc >= 0 && newc < Y
                                    && flag[newr][newc] == 0 && grid[newr][newc] == grid[r][c]) {
                                flag[newr][newc] = 1;
                                List<Integer> tmp2 = new ArrayList<>();
                                tmp2.add(newr);
                                tmp2.add(newc);
                                curBlock.add(tmp2);
                            }
                        }
                        index++;
                    }
                    if(curBlock.size() > maxCount) {
                        maxCount = curBlock.size();
                        maxBlock = curBlock;
                    }
                }
            }
        }
        for (List<Integer> item: maxBlock) {
            grid[item.get(0)][item.get(1)] = 0;
        }
        return maxCount;
    }

    public void printGrid() {
        for (int i = 0; i < X; ++i) {
            String line = "";
            for (int j = 0; j < Y; ++j) {
                line += String.valueOf(grid[i][j]);
                if (j < Y - 1)
                    line += ", ";
            }
            System.out.println(line);
        }
    }
}