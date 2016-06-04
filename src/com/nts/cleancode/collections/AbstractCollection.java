package com.nts.cleancode.collections;

public abstract class AbstractCollection implements Collection {
	protected Object[] elements = new Object[10];

	public void addAll(AbstractCollection c) {
		for(int i = 0; i<c.size(); i++)
		{
			if(!contains(c.get(i)))
				add(c.get(i));
		}
	}
	
	public void add(Object key, Object value) {
	}

	public Object get(int i) {
		return elements[i];
	}
}
