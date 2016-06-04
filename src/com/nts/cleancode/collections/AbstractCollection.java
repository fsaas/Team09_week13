package com.nts.cleancode.collections;

public abstract class AbstractCollection{
	protected Object[] elements = new Object[10];

	public void addAll(AbstractCollection c) {
		for(int i = 0; i<c.size(); i++)
		{
			if(!contains(c.get(i)))
				add(c.get(i));
		}
		
		
	}
	public boolean isEmpty();
	public void add(Object element);
	public boolean remove(Object element);
	public boolean contains(Object element);
	public int size();
	
	public void add(Object key, Object value) {
	}

	public Object get(int i) {
		return elements[i];
	}
}
