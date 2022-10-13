public class TestVectors {
    public void test(){
        int error = 0;
        SkinnyCypher skinnyCypher = new SkinnyCypher();
        int[][] anticipatedArray = {
                { 247, 247, 239, 66},     //[wiersz][kolumna]
                {92 ,106 ,74, 114},
                { 245, 10, 129, 154},
                {96, 128, 58, 120} };

        int[][] anticipatedArray2 = {
                {147, 247, 143, 164},     //[wiersz][kolumna]
                {143 ,255, 66, 58},
                { 245, 10, 129, 154},
                {  96, 128, 58, 120} };


        int[][] mainArray = {
                {45,45,34,23},     //[wiersz][kolumna]
                {5,6,7,8},
                {91,24,45,56},
                {13,14,15,16} };
        int[][] mainArray2 = {
                {17,45,65,78},     //[wiersz][kolumna]
                {43,23,21,65},
                {91,24,45,56},
                {13,14,15,16} };
        int[][] outputarray =skinnyCypher.encrypt(mainArray);
        int[][] outputarray2 =skinnyCypher.encrypt(mainArray2);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(outputarray[i][j] == anticipatedArray[i][j] ){

                }else{
                    error = 1;
                }
            }
        }
        if(error == 1) System.out.println("error");
        else System.out.println("cypher works properly");


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(outputarray2[i][j] == anticipatedArray2[i][j] ){

                }else{
                    error = 1;
                }
            }
        }
        if(error == 1) System.out.println("error");
        else System.out.println("cypher works properly");


    }

}
