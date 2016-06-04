package com.nts.cleancode.collections;

public class Map {
	protected List keys = new List();
	protected List values = new List();
	private int size = 0;
	private int indexWhereKeyFound;
	private boolean readOnly;

	public boolean isEmpty() {
		return size == 0;
	}

	public void add(Object key, Object value) {
		if (readOnly)
			return;

		if (containsKey(key)) {
			setValue(indexWhereKeyFound, value);
			return;
		}
		
		keys.add(key);
		values.add(value);
		size++;

	}
	
	private void setKey(int i, Object object)
	{
		keys.set(i, object);
	}
	private void setValue(int i,Object value)
	{
		values.set(i, value);
	}

	public int size() {
		return size;
	}

	public boolean remove(Object key) {
		if (readOnly)
			return false;
		if(containsKey(key)){
			setKey(indexWhereKeyFound, null);
			setValue(indexWhereKeyFound, null);
			size--;
			return true;
		}
		return false;
	}

	public boolean contains(Object value) {
		for (int i = 0; i < size; i++)
			if ((value == null && values.get(i) == null) || (values.get(i) != null && values.get(i).equals(value)))
				return true;
		return false;
	}

	public boolean containsKey(Object key) {
		for (int i = 0; i < size; i++)
			if (keys.get(i) != null && keys.get(i).equals(key)) {
				indexWhereKeyFound = i;
				return true;
			}
		return false;
	}

	public Object get(Object key) {
		if (!containsKey(key))
			return null;
		return values.get(indexWhereKeyFound);
	}

	public int capacity() {
		return keys.capacity();
	}

	public void setReadOnly(boolean b) {
		readOnly = b;
	}

	public void addAll(Map m) {
		for (int i = 0; i < m.size(); i++)
			add(m.keys.get(i), m.values.get(i));
	}
}
