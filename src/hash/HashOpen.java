package hash;

public class HashOpen<Key, Value> {

	private final int M = 20;
	private Key[] keys = (Key[]) new Object[M];
	private Value[] values =(Value[]) new Object[M];
	
	public void put(Key key, Value val){
		int i;
		for(i=hashCode(key); keys[i]!=null; i=(i+1)%M){
			if(key.equals(keys[i])){
				break;
			}
		}
		keys[i] = key;
		values[i] = val;
	}
	
	public Value get(Key key){
		for(int i=hashCode(key); keys[i]!=null; i=(i+1)%M){
			if(key.equals(keys[i])){
				return values[i];
			}
		}
		return null;
	}
	
	public Value delete(Key key){
		int i;
		for( i=hashCode(key); keys[i]!=null; i=(i+1)%M){
			if(key.equals(keys[i])){
				break;
			}
		}
		Value val = values[i];
		for( int k = i; keys[k]!=null; k=(k+1)%M){
			keys[k] = keys[k+1];
			values[k] = values[k+1];
		}
		return val;
	}
	
	private int hashCode(Key key){
		return (int) key % M;
	}
}
