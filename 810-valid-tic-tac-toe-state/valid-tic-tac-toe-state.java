class Solution {
    public boolean validTicTacToe(String[] board) {
        int x = 0;
        int y = 0;
        for(int i=0;i<3;i++){
            for(char j:board[i].toCharArray()){
                if(j=='X') x++;
                else if(j=='O') y++;
            }
        }
        if(x<y) return false;
        if(x>y+1) return false;
        if(isGame(board,'X') && x==y) return false;
        if(isGame(board,'O') && x>y) return false;
        return true;
    }
    public boolean isGame(String[]board,char ch){
        String str;
        if(ch=='X') str = "XXX";
        else str = "OOO";
        for(int i=0;i<board.length;i++){
            if(board[i].equals(str)) return true;
        }
        if(board[0].charAt(0)== ch && board[1].charAt(0)==ch && board[2].charAt(0)==ch) return true;
        if(board[0].charAt(1)==ch && board[1].charAt(1)==ch && board[2].charAt(1)==ch) return true;
        if(board[0].charAt(2)==ch && board[1].charAt(2)==ch && board[2].charAt(2)==ch) return true;
        if(board[0].charAt(0)==ch && board[1].charAt(1)==ch && board[2].charAt(2)==ch) return true;
        if(board[0].charAt(2)==ch && board[1].charAt(1)==ch && board[2].charAt(0)==ch) return true;
        return false;
    }
}