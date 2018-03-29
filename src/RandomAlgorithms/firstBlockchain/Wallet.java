package RandomAlgorithms.firstBlockchain;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.ECGenParameterSpec;
import java.util.ArrayList;
import java.util.HashMap;

import org.openqa.selenium.interactions.InputSource;

import com.gargoylesoftware.htmlunit.javascript.host.Map;

public class Wallet {
	public PrivateKey privateKey;
	public PublicKey publicKey;
	
	public HashMap<String, TransactionOutput> UTXOs = new HashMap<String, TransactionOutput>();
	
	public Wallet() {
		generateKeyPair();
	}
	
	public void generateKeyPair() {
		try {
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA","BC");
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");
			
			keyGen.initialize(ecSpec,random);
			KeyPair keyPair = keyGen.generateKeyPair();
			
			privateKey = keyPair.getPrivate();
			publicKey = keyPair.getPublic();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	public float getBalance() {
		float total = 0;

		for (HashMap.Entry<String, TransactionOutput> item : NoobChain.UTXOs.entrySet()) {
			TransactionOutput UTXO = item.getValue();
			if (UTXO.isMine(publicKey)) {
				UTXOs.put(UTXO.id, UTXO);
				total += UTXO.value;
			}
		}
		return total;
	}
	
	public Transaction sendFunds(PublicKey _recipient, float value) {
		if(getBalance() < value) {
			System.out.println("#Not enough funds to sends transaction. Transaction discarded.");
			return null;
		}
		
		ArrayList<TransactionInput> inputs = new ArrayList<>();
		float total = 0;
		
		for(HashMap.Entry<String, TransactionOutput> item : UTXOs.entrySet()) {
			TransactionOutput UTXO = item.getValue();
			total += UTXO.value;
			inputs.add(new TransactionInput(UTXO.id));
			if(total > value) break;
		}
		
		Transaction newTransaction = new Transaction(publicKey, _recipient, value, inputs);
		newTransaction.generateSignature(privateKey);
		
		for(TransactionInput input : inputs) {
			UTXOs.remove(input.transactionOutputId);
		}
		
		return newTransaction;
	}
}

