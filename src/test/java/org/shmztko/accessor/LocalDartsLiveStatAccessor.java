package org.shmztko.accessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.shmztko.accessor.DartsLivePageAccessor;
import org.shmztko.model.User;

public class LocalDartsLiveStatAccessor extends DartsLivePageAccessor {

	public LocalDartsLiveStatAccessor(User user) {
		super(user);
	}

	@Override
	public String getPlayDataPage() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(".\\src\\test\\resources\\testhtml\\playdata.htm"))));
			StringBuffer sb = new StringBuffer();
			int c;
			while ((c = br.read()) != -1) {
				sb.append((char) c);
			}
			return sb.toString();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (br != null) {
				try { br.close();} catch(IOException e) {}
			}
		}
	}

}