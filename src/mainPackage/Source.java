package mainPackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

public class Source {
	
	
	   
	public static void main(String[] args) throws IOException {
		ArrayList<String> MyArrayList = new ArrayList<String>();
		ArrayList<String> FourOutputs = new ArrayList<String>();
		Functions F = new Functions();
		int PC=0;
		int CurrentFormatNumber=0;
		Map<String,Integer> Myinstructions = new HashMap<String, Integer>();
		Map<String,Integer> MyDirectives = new HashMap<String, Integer>();
		Map<String,Integer> Mysymboltable = new HashMap<String, Integer>();

		F.FileReader("src.txt",MyArrayList);
		F.startup(Myinstructions, MyDirectives);
		for(int i=0;i<MyArrayList.size();i++) {
		F.test(FourOutputs,MyArrayList.get(i));
		if(FourOutputs.size()==0) {continue;}
		if(FourOutputs.get(1).equals("start")==true) {PC = Integer.parseInt(FourOutputs.get(2));}
		if(F.checkinstructionvalidity(FourOutputs.get(1),FourOutputs.get(3))==true) {
			CurrentFormatNumber=F.getformatnumber(Myinstructions, Mysymboltable,FourOutputs.get(1),MyDirectives,FourOutputs.get(2));
			PC = PC + CurrentFormatNumber;
		}
		if(FourOutputs.get(0).equals("")==false) {Mysymboltable.put(FourOutputs.get(0),PC);}
		
		System.out.println(FourOutputs.get(0)+"<-- Label");
		System.out.println(FourOutputs.get(1)+"<-- Instruction");
		System.out.println(FourOutputs.get(2)+"<-- Operand1");
		System.out.println(FourOutputs.get(3)+"<-- Operand2");
		System.out.println(PC+"<---PC");
		System.out.println("___________________________________");
		FourOutputs.clear();
		}
		for(Map.Entry<String, Integer> entry:Mysymboltable.entrySet()) {
			System.out.println("Key=  "+ entry.getKey()+", "+"Value=  "+entry.getValue());
		}
	}

}
