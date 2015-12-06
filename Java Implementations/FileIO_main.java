/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
/**
 *
 * @author SHAILEEJAIN
 */
public class FileIO_main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String file_name="test.txt";
        try{
            FileIO_class file=new FileIO_class(file_name);
            String[] aryLines=file.OpenFile();
            int i;
            for(i=0;i<aryLines.length;i++){
                System.out.println(aryLines[i]);
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
}
