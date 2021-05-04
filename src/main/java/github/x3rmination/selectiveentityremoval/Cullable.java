package github.x3rmination.selectiveentityremoval;

public interface Cullable {

	public void setTimeout();
	public boolean isForcedVisible();
	
	public void setCulled(boolean value);
	public boolean isCulled();
	
}
