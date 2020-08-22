package mainPackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Functions {
	public void FileReader(String FileName,ArrayList<String> MyArrayList) throws IOException {
		FileReader R = new FileReader(FileName);
		BufferedReader Reader = new BufferedReader(R);
		while(true) {
			String df = Reader.readLine();
			if(df==null) {break;}
			MyArrayList.add(df);
		}
		 Reader.close();}
		 public void startup(Map<String,Integer> InstructionsMap,Map<String,Integer> Directive) {
			 InstructionsMap.put("rmo",2);
			 InstructionsMap.put("ldr",3);
			 InstructionsMap.put("+ldr",4);
			 InstructionsMap.put("str",3);
			 InstructionsMap.put("+str",4);
			 InstructionsMap.put("ldch",3);
			 InstructionsMap.put("+ldch",4);
			 InstructionsMap.put("stch",3);
			 InstructionsMap.put("+stch",4);
			 InstructionsMap.put("add",3);
			 InstructionsMap.put("+add",4);
			 InstructionsMap.put("sub",3);
			 InstructionsMap.put("+sub",4);
			 InstructionsMap.put("addr",3);
			 InstructionsMap.put("+addr",4);
			 InstructionsMap.put("subr",2);
			 InstructionsMap.put("comp",3);
			 InstructionsMap.put("+comp",4);
			 InstructionsMap.put("comr",2);
			 InstructionsMap.put("j",3);
			 InstructionsMap.put("+j",4);
			 InstructionsMap.put("jeq",3);
			 InstructionsMap.put("+jeq",4);
			 InstructionsMap.put("jlt",3);
			 InstructionsMap.put("+jlt",4);
			 InstructionsMap.put("jgt",3);
			 InstructionsMap.put("+jgt",4);
			 InstructionsMap.put("tix",3);
			 InstructionsMap.put("+tix",4);
			 InstructionsMap.put("tixr",2);
			 Directive.put("start",1);
			 Directive.put("end",2);
			 Directive.put("byte",3);
			 Directive.put("word",4);
			 Directive.put("resw",5);
			 Directive.put("resb",6);
			 Directive.put("equ",7);
			 Directive.put("org",8);
			 Directive.put("base",9);
			 
		 }
		 public ArrayList<String> test(ArrayList<String> Outputs,String Line) {
			String label,instruction,operand1,operand2;
			int range=34;
			if(Line.startsWith(".")) {
				return Outputs;
			}
			
			 label = Line.substring(0,7);
			 label = label.trim();
			 label = label.toLowerCase();
			 ////////////////////
			 instruction = Line.substring(9,14);
			 instruction = instruction.trim();
             instruction = instruction.toLowerCase();
             ////////////////////
             if(Line.contains("*")==false || Line.length()<34) {range=Line.length();}
             operand1 = Line.substring(17,range);
             String [] operands= operand1.split(",");
             operand1 = operands[0];
             operand1= operand1.trim();
             operand1 = operand1.toLowerCase();
             ////////////////////
             if(operands.length==1) {operand2=null;}
             else {
             operand2 = operands[1];
             operand2=operand2.trim();
             operand2=operand2.toLowerCase();}
             ///////////////////
             Outputs.add(label);
             Outputs.add(instruction);
             Outputs.add(operand1);
             Outputs.add(operand2);		 
			 return Outputs;
		 }
		 
		 public boolean checkinstructionvalidity(String Instruction,String Operand2) {
			if(Instruction.equals("rmo")==true && Operand2==null) {return false;}
			else if(Instruction.equals("ldr")==true && Operand2!=null) {return false;}
			else if(Instruction.equals("str")==true && Operand2!=null) {return false;}
			else if(Instruction.equals("ldch")==true && Operand2!=null) {return false;}
			else if(Instruction.equals("stch")==true && Operand2!=null) {return false;} 
			else if(Instruction.equals("add")==true && Operand2!=null) {return false;}
			else if(Instruction.equals("sub")==true && Operand2!=null) {return false;}
			else if(Instruction.equals("addr")==true && Operand2==null) {return false;}
			else if(Instruction.equals("subr")==true && Operand2==null) {return false;}
			else if(Instruction.equals("comp")==true && Operand2!=null) {return false;}
			else if(Instruction.equals("compr")==true && Operand2==null) {return false;}
			else if(Instruction.equals("j")==true && Operand2!=null) {return false;}
			else if(Instruction.equals("jeq")==true && Operand2!=null) {return false;}
			else if(Instruction.equals("jlt")==true && Operand2!=null) {return false;}
			else if(Instruction.equals("jgt")==true && Operand2!=null) {return false;}
			else if(Instruction.equals("tix")==true && Operand2!=null) {return false;}
			else if(Instruction.equals("tixr")==true && Operand2!=null) {return false;}
			else return true;}
		 public int getformatnumber(Map<String,Integer> InstructionsMap,Map<String,Integer> SymbolList,String Instruction,Map<String,Integer> Directive,String Operand1) {
			 
			if(InstructionsMap.get(Instruction)==null) {
				if(Directive.get(Instruction)!=null) {return directivesdisplacment(Operand1,Instruction,Directive.get(Instruction), SymbolList);
					}
				else {
				return 0;}
				
			}
			else return InstructionsMap.get(Instruction);
//			return 0;
		 }
		 public int directivesdisplacment(String Operand,String Instruction,int directivenumber,Map<String,Integer> SymbolList) {
			 String Passer = null;
			 if(directivenumber==1) {return Integer.parseInt(Operand);}
				 if(directivenumber==2) {
					 for(Map.Entry<String, Integer> entry:SymbolList.entrySet()) { Passer=entry.getKey();break;}
				if(Passer.equals(Operand)==true) {System.out.println(" s u c c e s s f u l    a s s e m b l y\r\n" + 
							"e  n  d      o  f      p  r  o  g  r  a  m");System.exit(0);} else{System.out.println(" u n s u c c e s s f u l    a s s e m b l y\r\n" + 
									"e  n  d      o  f      p  r  o  g  r  a  m");System.exit(0);}
				 }
				 
				if(directivenumber==3) { return Integer.parseInt(Operand);}
						 if(directivenumber==4)
							 if(directivenumber==5)
								 if(directivenumber==6)
									 if(directivenumber==7)
										 if(directivenumber==8)
											 if(directivenumber==9) {}
			 
			 return 0;
		 }
}
