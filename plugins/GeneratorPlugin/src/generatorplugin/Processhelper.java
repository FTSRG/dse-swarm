package generatorplugin;

import infrastructure.Machine;

public class Processhelper {
	private Machine start;
	private String name;
	private String startport;
	private Integer size;		

	private Machine end;
	private String endport;
	
	boolean found = false;
	
	public Machine getstart(){
		return start;
	}
	
	public Machine getend(){
		return end;
	}
	
	public String getendIp(){
		return end.getIp();
	}
	public String getStartPort(){
		return this.startport;
	}
	
	public String getStartIP(){
		return this.start.getIp();
	}
	public String getID(){
		return startport+start.getIp();
	}
	
	public Processhelper(Machine start, String name, String startport, Integer size){
		this.start = start;
		this.name= name;
		this.startport= startport;
		this.size =size;
		
		this.end = null;
		this.endport = "";
		
	}
	
	public boolean checkfound(){
		return found;
	}
	
	public void setend(Machine end, String endport){
		this.end=end;
		this.endport=endport;
		this.found = true;
	}
	
	public boolean isEndproc(Machine end, infrastructure.Process endproc){
		if (endproc.getMemory()==this.size && this.found==false){
			setend(end, String.valueOf(endproc.getPort()));
			return true;
		}
		return false;
	}
	
	public boolean isequal(Machine end, infrastructure.Process endproc){
		if (this.found==false && endproc.getMemory()==this.size && this.startport.equals( String.valueOf(endproc.getPort()))){
			setend(end, String.valueOf(endproc.getPort()));
			return true;
		}
		return false;
	}
}
