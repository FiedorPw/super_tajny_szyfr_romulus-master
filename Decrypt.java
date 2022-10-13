public class Decrypt {
    int[][] mainArray = {
            {1,2,3,4},     //[wiersz][kolumna]
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16} };
    int[][] constants ={         //próbne fest
            {7,7,7,7},
            {7,7,7,7},
            {7,7,7,7},
            {7,7,7,7} };
    int[][] binaryMatrix ={
            {0,1,0,0},
            {0,1,1,-1},
            {0,-1,0,1},
            {1,0,0,-1} };

    int [] substititutionBoxInv = {
            //
            0xac ,0xe8 ,0x68 ,0x3c ,0x6c ,0x38 ,0xa8 ,0xec ,0xaa ,0xae ,0x3a ,0x3e ,0x6a ,0x6e ,0xea ,0xee ,
            0xa6 ,0xa3 ,0x33 ,0x36 ,0x66 ,0x63 ,0xe3 ,0xe6 ,0xe1 ,0xa4 ,0x61 ,0x34 ,0x31 ,0x64 ,0xa1 ,0xe4 ,
            0x8d ,0xc9 ,0x49 ,0x1d ,0x4d ,0x19 ,0x89 ,0xcd ,0x8b ,0x8f ,0x1b ,0x1f ,0x4b ,0x4f ,0xcb ,0xcf ,
            0x85 ,0xc0 ,0x40 ,0x15 ,0x45 ,0x10 ,0x80 ,0xc5 ,0x82 ,0x87 ,0x12 ,0x17 ,0x42 ,0x47 ,0xc2 ,0xc7 ,
            0x96 ,0x93 ,0x03 ,0x06 ,0x56 ,0x53 ,0xd3 ,0xd6 ,0xd1 ,0x94 ,0x51 ,0x04 ,0x01 ,0x54 ,0x91 ,0xd4 ,
            0x9c ,0xd8 ,0x58 ,0x0c ,0x5c ,0x08 ,0x98 ,0xdc ,0x9a ,0x9e ,0x0a ,0x0e ,0x5a ,0x5e ,0xda ,0xde ,
            0x95 ,0xd0 ,0x50 ,0x05 ,0x55 ,0x00 ,0x90 ,0xd5 ,0x92 ,0x97 ,0x02 ,0x07 ,0x52 ,0x57 ,0xd2 ,0xd7 ,
            0x9d ,0xd9 ,0x59 ,0x0d ,0x5d ,0x09 ,0x99 ,0xdd ,0x9b ,0x9f ,0x0b ,0x0f ,0x5b ,0x5f ,0xdb ,0xdf ,
            0x16 ,0x13 ,0x83 ,0x86 ,0x46 ,0x43 ,0xc3 ,0xc6 ,0x41 ,0x14 ,0xc1 ,0x84 ,0x11 ,0x44 ,0x81 ,0xc4 ,
            0x1c ,0x48 ,0xc8 ,0x8c ,0x4c ,0x18 ,0x88 ,0xcc ,0x1a ,0x1e ,0x8a ,0x8e ,0x4a ,0x4e ,0xca ,0xce ,
            0x35 ,0x60 ,0xe0 ,0xa5 ,0x65 ,0x30 ,0xa0 ,0xe5 ,0x32 ,0x37 ,0xa2 ,0xa7 ,0x62 ,0x67 ,0xe2 ,0xe7 ,
            0x3d ,0x69 ,0xe9 ,0xad ,0x6d ,0x39 ,0xa9 ,0xed ,0x3b ,0x3f ,0xab ,0xaf ,0x6b ,0x6f ,0xeb ,0xef ,
            0x26 ,0x23 ,0xb3 ,0xb6 ,0x76 ,0x73 ,0xf3 ,0xf6 ,0x71 ,0x24 ,0xf1 ,0xb4 ,0x21 ,0x74 ,0xb1 ,0xf4 ,
            0x2c ,0x78 ,0xf8 ,0xbc ,0x7c ,0x28 ,0xb8 ,0xfc ,0x2a ,0x2e ,0xba ,0xbe ,0x7a ,0x7e ,0xfa ,0xfe ,
            0x25 ,0x70 ,0xf0 ,0xb5 ,0x75 ,0x20 ,0xb0 ,0xf5 ,0x22 ,0x27 ,0xb2 ,0xb7 ,0x72 ,0x77 ,0xf2 ,0xf7 ,
            0x2d ,0x79 ,0xf9 ,0xbd ,0x7d ,0x29 ,0xb9 ,0xfd ,0x2b ,0x2f ,0xbb ,0xbf ,0x7b ,0x7f ,0xfb ,0xff
    } ;
    int key =2 ;
    public int[][] decrypt(){ //int [][] mainArray
        //this. mainArray= mainArray;

        System.out.println("Początkowa tablica: \n");
        printArray(mainArray);



        mixColumnsD();
        System.out.println("mix c");
        printArray(this.mainArray);
        ShiftRowsD();
        System.out.println("shift rows");
        printArray(this.mainArray);
        addConstantsD();
        System.out.println("addconstans");
        printArray(this.mainArray);

        subCellsD();
        System.out.println("sub cells");
        printArray(this.mainArray);


        System.out.println("Krok drugi, add constants: \n");

        System.out.println("Krok trzeci, shift rows: \n");



        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(mainArray[i][j] + " ");
                if(mainArray[i][j] < 10) System.out.print(" ");
            }

        }
        System.out.println("");

        return mainArray;
    }
    // działa deszyfruje
    public void subCellsD(){

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String tmpBinary = Integer.toBinaryString(mainArray[i][j]);;
                tmpBinary = String.format("%8s", tmpBinary).replaceAll(" ", "0");
                //pozyskanie 8 bitowego formatu do uzycia w s-box
                String stringW = ""; //string kolumn
                String stringK = ""; //string wierszy
                StringBuilder stringBuilder = new StringBuilder();
                for (int k = 0; k < 4; k++) {
                    stringW = String.valueOf(stringBuilder.append(tmpBinary.charAt(k))); // pierwsze 4 bity
                }
                StringBuilder stringBuilder1 = new StringBuilder();
                for (int k = 4; k < 8; k++) {
                    stringK = String.valueOf(stringBuilder1.append(tmpBinary.charAt(k))); // ostatnie 4 bity
                }
                //System.out.println(tmpBinary + " " + stringW + " " + stringK);
                int intW = Integer.parseInt(stringW,2);
                int intK = Integer.parseInt(stringK,2);
                //System.out.println(stringW + "-" + intW + " "+ stringK+ "-"+  intK);
                mainArray[i][j] = (int) substititutionBoxInv[intW*16+intK];
            }
        }
    }

    public void addConstantsD(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(i<2){
                    mainArray[i][j] -= constants[i][j];
                }else{
                    mainArray[i][j] -= constants[i][j] ^ key ;
                }
            }
        }
    }
    //działa cofa
    public void ShiftRowsD(){
        int[] tmpArray = new int[4];

        for (int i = 1; i < 4; i++) {//iteruje po rzędach
            for (int j = 0; j < 4; j++) {//po elementach
                //int[] tmpArray = mainArray[i];
                int placeInArray = (4+(j+i)) % 4;
                tmpArray[j] = mainArray[i][placeInArray];
            }
            for (int j = 0; j < 4; j++) {
                mainArray[i][j] = tmpArray[j];
            }
        }
    }
    public void mixColumnsD(){
        int [][] tmparray = new int[4][4];
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                for (int k=0; k<4; k++){
                    tmparray[i][j]+=mainArray[i][k]*binaryMatrix[k][j];
                }
            }
        }
        mainArray=tmparray;
    }
    public void printArray(int[][] mainArray){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(mainArray[i][j] + " ");
                if(mainArray[i][j] < 10) System.out.print(" ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public void setMainArray(int[][] mainArray) {
        this.mainArray = mainArray;
    }
}
