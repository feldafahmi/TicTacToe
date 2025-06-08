public class Board {
    private int[][] data;   // menyimpan nilai 0 / 1 / -1
    private int turn;       // menyimpan nilai 1 / -1
    
    /*
    constructor
    inisialisasi board dengan nilai 0
    dan turn dengan 1 atau -1 sesuai input user
    */
    public Board(int turn){
        this.data = new int[3][3];
        this.turn = turn;
    }
    
    // cetak board di layar
    public void disp(){
        System.out.println("\nCurrent board:");
        System.out.println("y/x  0    1    2");
        for(int i=0; i<3; i++){
            System.out.print(i+" ");
            for(int j=0;j<3;j++){
                switch(this.data[i][j]){
                    case 0  -> System.out.print("  -  ");
                    case -1 -> System.out.print("  X  ");
                    case 1  -> System.out.print("  O  ");
                }
            }
            System.out.println();
        }
        System.out.println("Current turn: " + (turn == -1 ? "X" : "O"));
        System.out.println();
    }
    
    /*
    setting board pada baris dan kolom yang telah ditentukan
    dengan nilai 1 atau -1 sesuai dengan giliran/ turn
    */
    public boolean setBoard(int brs, int kol){
        if(this.data[brs][kol]==0){
            this.data[brs][kol] = turn;
            turn = -turn;
            return true;
        }
        else
            return false;
    }
    
    public int winner(){
        // Cek baris
        for(int i = 0; i < 3; i++) {
            int sum = data[i][0] + data[i][1] + data[i][2];
            if(sum == 3) return 1;   // Player O menang
            if(sum == -3) return -1; // Player X menang
        }

        // Cek kolom
        for(int j = 0; j < 3; j++) {
            int sum = data[0][j] + data[1][j] + data[2][j];
            if(sum == 3) return 1;   // Player O menang
            if(sum == -3) return -1; // Player X menang
        }

        // Cek diagonal utama (kiri atas ke kanan bawah)
        int sum1 = data[0][0] + data[1][1] + data[2][2];
        if(sum1 == 3) return 1;   // Player O menang
        if(sum1 == -3) return -1; // Player X menang

        // Cek diagonal kedua (kanan atas ke kiri bawah)
        int sum2 = data[0][2] + data[1][1] + data[2][0];
        if(sum2 == 3) return 1;   // Player O menang
        if(sum2 == -3) return -1; // Player X menang

        // Tidak ada pemenang
        return 0;
    }
    
    public boolean gameOver() {
        return winner() != 0 || isBoardFull();
    }
    
    public boolean isBoardFull(){
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(data[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public void resetBoard(){
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                this.data[i][j] = 0;
        // Keep the current turn after reset
    }
    
    public int getTurn() {
        return turn;
    }
}

