import java.rmi.Naming;

import java.util.Scanner;
import javax.crypto.SecretKey;
import javax.crypto.SealedObject;
import java.io.FileInputStream;

import javax.crypto.Cipher;


public class AuctionClient {
    public static void main(String[] args) 
    {
        try {
            Auction auction= (Auction) Naming.lookup("//localhost/Auction");
            Scanner scanner =new Scanner(System.in);


                    System.out.print("  enter the item ID: ");
                 int itemID = scanner.nextInt();

            
            SealedObject sealedObject = auction.getSpec(itemID);
            
            
            SecretKey aesKey = loadKey();

            if(sealedObject !=null ) {
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.DECRYPT_MODE, aesKey);



                        AuctionItem item = (AuctionItem) sealedObject.getObject(cipher);

                
                System.out.println("\nitem :");
                System.out.println("item ID: " + item.itemID);





                        System.out.println("name: " +item.name);
                        System.out.println("description: " + item.description );



                            System.out.println("highest Bid: " + item.highestBid );
            } else 
            {

                System.out.println("Error ");
            }

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    private static SecretKey loadKey() { //key
        try {


            FileInputStream fis = new FileInputStream("keys/testKey.aes");
            byte[] keyBytes = new byte[16];
            fis.read(keyBytes);
            fis.close();

                            return new javax.crypto.spec.SecretKeySpec(keyBytes, "AES");



        } catch (Exception e )
        
        {
            e.printStackTrace();
        }
        return null;
    }
}