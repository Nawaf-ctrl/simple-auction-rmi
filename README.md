# 🛡️ Java RMI Auction System (Part A – SCC.311 Coursework)

This project is a simple **client-server application** built using **Java RMI** as part of the SCC.311 Distributed Systems coursework at Lancaster University. It represents the initial stage of an **online auction system** where clients can retrieve details about auctioned items from a remote server.

---

## 🧠 Project Goals

- Practice remote method invocation using Java RMI
- Learn object serialization and encrypted object transfer
- Build a foundation for a secure, distributed auction platform

---

## 📜 Coursework Levels

### ✅ Level 1 – Basic Invocation (6 marks)
- Implements an `Auction` RMI interface:
  ```java
  public interface Auction extends Remote {
      public AuctionItem getSpec(int itemID) throws RemoteException;
  }
The AuctionItem class contains:

java
Copy
Edit
public class AuctionItem implements java.io.Serializable {
    int itemID;
    String name;
    String description;
    int highestBid;
}
The server uses hardcoded auction items.

The client allows users to input itemID and receive item details.

✅ Level 2 – Encrypted Communication (Additional 9 marks)
Replaces the interface with an encrypted version:

java
Copy
Edit
public interface Auction extends Remote {
    public SealedObject getSpec(int itemID) throws RemoteException;
}
Uses AES encryption with javax.crypto.SealedObject.

Shared AES key (testKey.aes) is generated and saved to a /keys directory accessible to both client and server.

🛠️ Technologies Used
Java RMI

Java Serialization

Java Cryptography Architecture (JCA)

AES encryption

Command-line Interface (CLI)

🚀 Getting Started
Prerequisites
Java 8 or above installed

RMI registry running (rmiregistry)

Unix-like shell environment (for server.sh script)

Running the Server
bash
Copy
Edit
./server.sh
This script:

Starts the RMI registry (if needed)

Compiles Java files

Launches the RMI server

Running the Client
bash
Copy
Edit
java Client
Enter an itemID when prompted to receive auction item details (or decrypted object, if using Level 2).

🔐 Encryption Setup (Level 2 Only)
AES key generated using KeyGenerator

Stored in: ./keys/testKey.aes

Both server and client read this key to encrypt and decrypt SealedObject responses

📁 File Structure
arduino
Copy
Edit
/ (root)
├── server.sh
├── Auction.java
├── AuctionItem.java
├── Client.java
├── Server.java
├── keys/
│   └── testKey.aes
🧪 Testing
You can test the solution by uploading the zipped root directory (not a subfolder) to:

🔗 Course Test System

⚠️ Your server must start within 5 seconds of running server.sh.

📚 Author
Name: Your Name

Course: SCC.311 Distributed Systems

University: Lancaster University

Year: 2025

📄 License
This project is intended for academic use only.

yaml
Copy
Edit

---

Let me know if you want to personalize this with your name, GitHub link, or comments inside the code files too.







You said:
dont mention that it is a coursework just keep it clean 


ChatGPT said:
Got it. Here's a clean, professional README.md with all coursework references removed:

markdown
Copy
Edit
# 🛡️ Java RMI Auction System

A simple Java-based client-server auction system using Remote Method Invocation (RMI) and optional AES encryption for secure communication.

---

## 🧠 Features

- Java RMI server that allows clients to request auction item details
- Two modes:
  - **Basic Mode** – returns plain `AuctionItem` objects
  - **Secure Mode** – returns encrypted `SealedObject` using AES
- Hardcoded item database
- Lightweight command-line client
- AES key generation and usage

---

## 🛠️ Technologies Used

- Java RMI
- Java Serialization
- Java Cryptography (AES, `SealedObject`)
- CLI (Command Line Interface)

---

## 🚀 Getting Started

### Prerequisites

- Java 8 or higher
- RMI registry
- Unix-like shell environment

### Running the Server

```bash
./server.sh
This will:

Start the RMI registry (if not already running)

Compile and run the server

Running the Client
bash
Copy
Edit
java Client
You’ll be prompted to enter an itemID to retrieve its auction details.

🔐 AES Encryption (Secure Mode)
Uses javax.crypto.SealedObject for encrypting objects

AES key is pre-generated and saved in the /keys directory as testKey.aes

Both client and server access this key for encryption/decryption
