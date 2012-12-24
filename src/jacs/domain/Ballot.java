package jacs.domain;


public class Ballot {
	
	private String user;
	private StringBuilder voteResult ;
	
	public Ballot(String user){
		this.voteResult = new StringBuilder();
		this.user = user;
		voteResult = new StringBuilder();
	}
	
	public void setVoteResult(String voteResult) {
		this.voteResult.append(voteResult);
	}
	
	public String getResult(){
		return voteResult.toString();
	}
}
