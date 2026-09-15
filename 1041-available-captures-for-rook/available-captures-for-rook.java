class Solution {
    public int numRookCaptures(char[][] board) {

        int row = -1, col = -1;

        // First rook position find chestham
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    row = i;
                    col = j;
                    break;
                }
            }
        }

        int count = 0;

        // Up direction
        for (int i = row - 1; i >= 0; i--) {

            // Bishop vaste stop
            if (board[i][col] == 'B')
                break;

            // Pawn dorikithe count chesi stop
            if (board[i][col] == 'p') {
                count++;
                break;
            }
        }

        // Down direction
        for (int i = row + 1; i < 8; i++) {

            if (board[i][col] == 'B')
                break;

            if (board[i][col] == 'p') {
                count++;
                break;
            }
        }

        // Left direction
        for (int j = col - 1; j >= 0; j--) {

            if (board[row][j] == 'B')
                break;

            if (board[row][j] == 'p') {
                count++;
                break;
            }
        }

        // Right direction
        for (int j = col + 1; j < 8; j++) {

            if (board[row][j] == 'B')
                break;

            if (board[row][j] == 'p') {
                count++;
                break;
            }
        }

        return count;
    }
}