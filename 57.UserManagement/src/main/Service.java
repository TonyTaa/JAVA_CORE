package main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Service {

	private final String FILE_NAME = "user.dat";

	// ================= LOAD USERS =================
	private List<Account> loadAccounts() throws Exception {
		List<Account> list = new ArrayList<>();

		File file = new File(FILE_NAME);
		if (!file.exists()) {
			return list;
		}

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		try {
			while (true) {
				Account acc = (Account) ois.readObject();
				list.add(acc);
			}
		} catch (EOFException e) {
			// end file
		}
		ois.close();
		return list;
	}

	// ================= SAVE ACCOUNT =================
	private void saveAccount(Account acc) throws Exception {
		File file = new File(FILE_NAME);

		ObjectOutputStream oos;

		if (file.exists()) {
			oos = new AppendObjectOutputStream(new FileOutputStream(file, true));
		} else {
			oos = new ObjectOutputStream(new FileOutputStream(file));
		}

		oos.writeObject(acc);
		oos.close();
	}

	// ================= ADD ACCOUNT =================
	public void addAccount(Account acc) throws Exception {
		List<Account> list = loadAccounts();

		for (Account a : list) {
			if (a.getUsername().equals(acc.getUsername())) {
				throw new Exception("Username already exists.");
			}
		}

		saveAccount(acc);
	}

	// ================= LOGIN =================
	public Account find(Account acc) throws Exception {
		List<Account> list = loadAccounts();

		for (Account a : list) {
			if (a.getUsername().equals(acc.getUsername())
					&& a.getPassword().equals(acc.getPassword())) {
				return a;
			}
		}
		return null;
	}

	// ================= SUPPORT CLASS =================
	static class AppendObjectOutputStream extends ObjectOutputStream {
		public AppendObjectOutputStream(OutputStream out) throws IOException {
			super(out);
		}

		@Override
		protected void writeStreamHeader() throws IOException {
			reset();
		}
	}
}
