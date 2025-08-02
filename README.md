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
