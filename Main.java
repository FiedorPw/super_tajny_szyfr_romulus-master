

public class Main {

    public static void main(String[] args) {
        int[][] mainArray = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16} };
        int[][] doRozszyfrowania ={
                {147, 247, 143, 164},     //[wiersz][kolumna]
                {143 ,255, 66, 58},
                { 245, 10, 129, 154},
                {  96, 128, 58, 120} };
        SkinnyCypher skinnyCypher = new SkinnyCypher();
        //skinnyCypher.encrypt(mainArray);
//        TestVectors testVectors = new TestVectors();
//        testVectors.test();

        Decrypt decrypt = new Decrypt();
       // decrypt.decrypt(doRozszyfrowania);


//
//        System.out.println("test shift rows"); // passed
//
//        System.out.println("pierwotna");
//        skinnyCypher.printArray(skinnyCypher.mainArray);
//        skinnyCypher.shiftRows();
//        System.out.println("zaszyforwana");
//        skinnyCypher.printArray(skinnyCypher.mainArray);
//        decrypt.setMainArray(skinnyCypher.mainArray);
//        decrypt.ShiftRowsD();
//        System.out.println("odszyfrowana");
//        decrypt.printArray(decrypt.mainArray);


//        System.out.println("test s-box"); //passed
//
//        System.out.println("pierwotna");
//        skinnyCypher.printArray(skinnyCypher.mainArray);
//        skinnyCypher.subCells();
//        System.out.println("zaszyforwana");
//        skinnyCypher.printArray(skinnyCypher.mainArray);
//        decrypt.setMainArray(skinnyCypher.mainArray);
//        decrypt.subCellsD();
//        System.out.println("odszyfrowana");
//        decrypt.printArray(decrypt.mainArray);

//        System.out.println("test mix columns"); //passed
//
//        System.out.println("pierwotna");
//        skinnyCypher.printArray(skinnyCypher.mainArray);
//        skinnyCypher.mixColumns();
//        System.out.println("zaszyforwana");
//        skinnyCypher.printArray(skinnyCypher.mainArray);
//        decrypt.setMainArray(skinnyCypher.mainArray);
//        decrypt.mixColumnsD();
//        System.out.println("odszyfrowana");
//        decrypt.printArray(decrypt.mainArray);

//        System.out.println("test addConstants"); // passed
//
//        System.out.println("pierwotna");
//        skinnyCypher.printArray(skinnyCypher.mainArray);
//        skinnyCypher.addConstants();
//        System.out.println("zaszyforwana");
//        skinnyCypher.printArray(skinnyCypher.mainArray);
//        decrypt.setMainArray(skinnyCypher.mainArray);
//        decrypt.addConstantsD();
//        System.out.println("odszyfrowana");
//        decrypt.printArray(decrypt.mainArray);

        System.out.println("test całego");

        System.out.println("pierwotna");
        skinnyCypher.printArray(skinnyCypher.mainArray);
        System.out.println("------------------------------------"); //zeby pokazac etapy tego testu reszta to procesy wewnętrzne
        skinnyCypher.encrypt(skinnyCypher.mainArray);
        System.out.println("zaszyforwana");
        skinnyCypher.printArray(skinnyCypher.mainArray);
        System.out.println("------------------------------------");
        decrypt.setMainArray(skinnyCypher.mainArray);
        decrypt.decrypt();
        System.out.println("odszyfrowana");
        decrypt.printArray(decrypt.mainArray);
        System.out.println("-------------------------------------");



    }
}
