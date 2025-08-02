import java.rmi.Naming;
import java.rmi.RemoteException;


import java.io.FileOutputStream;


import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;


import java.io.FileInputStream;










public class AuctionServer extends UnicastRemoteObject implements Auction {
    private static final long serialVersionUID = 1L;
    
    private HashMap<Integer, AuctionItem> auctionItems;
    private SecretKey aesKey;

    public AuctionServer() throws RemoteException {
        super();
        auctionItems = new HashMap<>();
        
        
                AuctionItem item1 = new AuctionItem();

         item1.itemID = 1;
             item1.name = "iphone";
        item1.description = "iphone 15 pro max";
        item1.highestBid = 999;

        AuctionItem item2 = new AuctionItem();


            item2.itemID = 2;
        item2.name = "laptop";
        item2.description = "newest laptop";

         item2.highestBid = 1700;

        AuctionItem item3 = new AuctionItem();

            item3.itemID = 3;
            
        item3.name = "XBOX";
        item3.description = "XBOX ONE";
        item3.highestBid = 1200;

        auctionItems.put(1, item1);



        auctionItems.put(2, item2);

                auctionItems.put(3, item3);






        geneKey();  
    }

    @Override
    public SealedObject getSpec(int itemID) throws RemoteException {
        try {
            AuctionItem item = auctionItems.get(itemID);
            if (item == null) {
                return null;
            }

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);

            SealedObject sealedObject = new SealedObject(item, cipher);
            return sealedObject;


            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void geneKey() {
        try {
            FileInputStream fis = new FileInputStream("keys/testKey.aes"  );
            byte[] keyBytes = new byte[16];  
            fis.read(keyBytes);
            fis.close();
            
            aesKey = new javax.crypto.spec.SecretKeySpec(keyBytes, "AES");
        } catch (Exception e) {
            try {
                KeyGenerator keyGen = KeyGenerator.getInstance("AES");
                keyGen.init(128);
                aesKey = keyGen.generateKey();

                byte[] keyBytes = aesKey.getEncoded();
                FileOutputStream fos = new FileOutputStream("keys/testKey.aes");
                fos.write(keyBytes);
                fos.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        try
        
        {
            AuctionServer server = new AuctionServer();

            Naming.rebind("Auction", server);
            System.out.println("auction server encryption ready");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}