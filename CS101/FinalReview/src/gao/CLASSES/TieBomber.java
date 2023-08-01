package gao.CLASSES;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import gao.ENUMS.TiePilot;

public class TieBomber extends TieFighter {
	
	private String tieType = "Bomber";

	public TieBomber(String id, TiePilot pilot) {
		super(id, pilot);
	}

	public String getTieType() {
		return tieType;
	}

	public void setTieType(String tieType) {
		this.tieType = tieType;
	}

	@Override
	public void serializeMe(String filepath) {
		try {
			ObjectOutputStream Sout = new ObjectOutputStream(new FileOutputStream(filepath));
			Sout.writeObject(this);
			Sout.flush();
			Sout.close();
			System.out.println("Stromtrooper Stored");
		} catch (FileNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}

	}

	@Override
	public TieFighter deserializeMe(String filepath) {

		TieFighter TF = null;
		try {
			ObjectInputStream Sin = new ObjectInputStream(new FileInputStream(filepath));
			TF = (TieFighter) Sin.readObject();
			Sin.close();
		}catch(Exception e){
			System.out.println(e);	
			
		}
		return TF;
	}

}
