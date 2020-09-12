package edu.Company.Vivo;

import org.junit.Test;

/**
 * 现有一个 3x3 规格的 Android 智能手机锁屏程序和两个正整数 m 和 n ，请计算出使用最少m 个键和最多 n个键可以解锁该屏幕的所有有效模式总数。
 * 其中有效模式是指：
 * 1、每个模式必须连接至少m个键和最多n个键；
 * 2、所有的键都必须是不同的；
 * 3、如果在模式中连接两个连续键的行通过任何其他键，则其他键必须在模式中选择，不允许跳过非选择键（如图）；
 * 4、顺序相关，单键有效（这里可能跟部分手机不同）。
 *
 * 输入：m,n
 * 代表允许解锁的最少m个键和最多n个键
 * 输出：
 * 满足m和n个键数的所有有效模式的总数
 */
public class LockMode {
    private boolean[][] visited = new boolean[3][3];
    private int[][] dirs1 = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, -1}, {1, 1}, {-1, 1}, {-1, -1}};
    private int[][] dirs2 = new int[][]{{0, 2}, {0, -2}, {2, 0}, {-2, 0}, {2, -2}, {2, 2}, {-2, 2}, {-2, -2}};
    private int[][] dirs3 = new int[][]{{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};
    private int count = 0;
    int m, n;

    public int solution (int m, int n) {
        this.m = m;
        this.n = n;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                dfs(i, j, 1);
            }
        }
        return count;
    }

    private void dfs(int i, int j, int step) {
        if (m <= step && step <= n) count++;
        if (step == n) return;

        visited[i][j] = true;
        for (int[] dir : dirs1) {
            int x = i + dir[0], y = j + dir[1];
            if (0 <= x && x < 3 && 0 <= y && y < 3 && !visited[x][y]) {
                dfs(x, y, step + 1);
            }
        }

        for (int[] dir : dirs2) {
            int x = i + dir[0], y = j + dir[1];
            if (0 <= x && x < 3 && 0 <= y && y < 3 && !visited[x][y]) {
                int midX = i + dir[0] / 2, midY = j + dir[1] / 2;
                if (visited[midX][midY])
                    dfs(x, y, step + 1);
            }
        }

        for (int[] dir : dirs3) {
            int x = i + dir[0], y = j + dir[1];
            if (0 <= x && x < 3 && 0 <= y && y < 3 && !visited[x][y]) {
                dfs(x, y, step + 1);
            }
        }
        visited[i][j] = false;
    }

    @Test
    public void test() {
        System.out.println(solution(3,7));
    }
}
