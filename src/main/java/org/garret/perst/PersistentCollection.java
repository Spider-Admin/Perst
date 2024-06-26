package org.garret.perst;
import  org.garret.perst.*;
import  org.garret.perst.impl.QueryImpl;
import  java.util.*;

public abstract class PersistentCollection<T> extends PersistentResource implements ITable<T>
{
    public IterableIterator<T> select(Class cls, String predicate) { 
        Query<T> query = new QueryImpl<T>(getStorage());
        return query.select(cls, iterator(), predicate);
    }

    /**
     * Returns <code>true</code> if this collection contains all of the elements
     * in the specified collection. <p>
     *
     * This implementation iterates over the specified collection, checking
     * each element returned by the iterator in turn to see if it's
     * contained in this collection.  If all elements are so contained
     * <code>true</code> is returned, otherwise <code>false</code>.
     *
     * @param c collection to be checked for containment in this collection.
     * @return <code>true</code> if this collection contains all of the elements
     * 	       in the specified collection.
     * @throws NullPointerException if the specified collection is null.
     * 
     * @see #contains(Object)
     */
    public boolean containsAll(Collection<?> c) {
	Iterator<?> e = c.iterator();
	while (e.hasNext())
	    if(!contains(e.next()))
		return false;
	return true;
    }

    /**
     * Adds all of the elements in the specified collection to this collection
     * (optional operation).  The behavior of this operation is undefined if
     * the specified collection is modified while the operation is in
     * progress.  (This implies that the behavior of this call is undefined if
     * the specified collection is this collection, and this collection is
     * nonempty.) <p>
     *
     * This implementation iterates over the specified collection, and adds
     * each object returned by the iterator to this collection, in turn.<p>
     *
     * Note that this implementation will throw an
     * <code>UnsupportedOperationException</code> unless <code>add</code> is
     * overridden (assuming the specified collection is non-empty).
     *
     * @param c collection whose elements are to be added to this collection.
     * @return <code>true</code> if this collection changed as a result of the
     *         call.
     * @throws UnsupportedOperationException if this collection does not
     *         support the <code>addAll</code> method.
     * @throws NullPointerException if the specified collection is null.
     * 
     * @see #add(Object)
     */
    public boolean addAll(Collection<? extends T> c) {
	boolean modified = false;
	Iterator<? extends T> e = c.iterator();
	while (e.hasNext()) {
	    if (add(e.next()))
		modified = true;
	}
	return modified;
    }

    /**
     * Removes from this collection all of its elements that are contained in
     * the specified collection (optional operation). <p>
     *
     * This implementation iterates over this collection, checking each
     * element returned by the iterator in turn to see if it's contained
     * in the specified collection.  If it's so contained, it's removed from
     * this collection with the iterator's <code>remove</code> method.<p>
     *
     * Note that this implementation will throw an
     * <code>UnsupportedOperationException</code> if the iterator returned by the
     * <code>iterator</code> method does not implement the <code>remove</code> method
     * and this collection contains one or more elements in common with the
     * specified collection.
     *
     * @param c elements to be removed from this collection.
     * @return <code>true</code> if this collection changed as a result of the
     *         call.
     * @throws UnsupportedOperationException if the <code>removeAll</code> method
     * 	       is not supported by this collection.
     * @throws NullPointerException if the specified collection is null.
     *
     * @see #remove(Object)
     * @see #contains(Object)
     */
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        Iterator<?> i = c.iterator();
        while (i.hasNext()) {
            modified |= remove(i.next());
        }
        return modified;
    }

    /**
     * Retains only the elements in this collection that are contained in the
     * specified collection (optional operation).  In other words, removes
     * from this collection all of its elements that are not contained in the
     * specified collection. <p>
     *
     * This implementation iterates over this collection, checking each
     * element returned by the iterator in turn to see if it's contained
     * in the specified collection.  If it's not so contained, it's removed
     * from this collection with the iterator's <code>remove</code> method.<p>
     *
     * Note that this implementation will throw an
     * <code>UnsupportedOperationException</code> if the iterator returned by the
     * <code>iterator</code> method does not implement the <code>remove</code> method
     * and this collection contains one or more elements not present in the
     * specified collection.
     *
     * @param c elements to be retained in this collection.
     * @return <code>true</code> if this collection changed as a result of the
     *         call.
     * @throws UnsupportedOperationException if the <code>retainAll</code> method
     * 	       is not supported by this Collection.
     * @throws NullPointerException if the specified collection is null.
     *
     * @see #remove(Object)
     * @see #contains(Object)
     */
    public boolean retainAll(Collection<?> c) {
        ArrayList<T> toBeRemoved = new ArrayList<T>();
        Iterator<T> i = iterator();
        while (i.hasNext()) {
            T o = i.next();
            if (!c.contains(o)) {
                toBeRemoved.add(o);
            }
        }
        int n = toBeRemoved.size();
        for (int j = 0; j < n; j++) { 
            remove(toBeRemoved.get(j));
        }
        return n != 0;         
    }

    /**
     * Returns <code>true</code> if this collection contains the specified
     * element.  More formally, returns <code>true</code> if and only if this
     * collection contains at least one element <code>e</code> such that
     * <code>(o==null ? e==null : o.equals(e))</code>.<p>
     *
     * This implementation iterates over the elements in the collection,
     * checking each element in turn for equality with the specified element.
     *
     * @param o object to be checked for containment in this collection.
     * @return <code>true</code> if this collection contains the specified element.
     */
    public boolean contains(Object o) {
	Iterator<T> e = iterator();
	if (o==null) {
	    while (e.hasNext())
		if (e.next()==null)
		    return true;
	} else {
	    while (e.hasNext())
		if (o.equals(e.next()))
		    return true;
	}
	return false;
    }

    /**
     * Removes a single instance of the specified element from this
     * collection, if it is present (optional operation).  More formally,
     * removes an element <code>e</code> such that <code>(o==null ? e==null :
     * o.equals(e))</code>, if the collection contains one or more such
     * elements.  Returns <code>true</code> if the collection contained the
     * specified element (or equivalently, if the collection changed as a
     * result of the call).<p>
     *
     * This implementation iterates over the collection looking for the
     * specified element.  If it finds the element, it removes the element
     * from the collection using the iterator's remove method.<p>
     *
     * Note that this implementation throws an
     * <code>UnsupportedOperationException</code> if the iterator returned by this
     * collection's iterator method does not implement the <code>remove</code>
     * method and this collection contains the specified object.
     *
     * @param o element to be removed from this collection, if present.
     * @return <code>true</code> if the collection contained the specified
     *         element.
     * @throws UnsupportedOperationException if the <code>remove</code> method is
     * 		  not supported by this collection.
     */
    public boolean remove(Object o) {
	Iterator<T> e = iterator();
	if (o==null) {
	    while (e.hasNext()) {
		if (e.next()==null) {
		    e.remove();
		    return true;
		}
	    }
	} else {
	    while (e.hasNext()) {
		if (o.equals(e.next())) {
		    e.remove();
		    return true;
		}
	    }
	}
	return false;
    }

    /**
     * Ensures that this collection contains the specified element (optional
     * operation).  Returns <code>true</code> if the collection changed as a
     * result of the call.  (Returns <code>false</code> if this collection does
     * not permit duplicates and already contains the specified element.)
     * Collections that support this operation may place limitations on what
     * elements may be added to the collection.  In particular, some
     * collections will refuse to add <code>null</code> elements, and others will
     * impose restrictions on the type of elements that may be added.
     * Collection classes should clearly specify in their documentation any
     * restrictions on what elements may be added.<p>
     *
     * This implementation always throws an
     * <code>UnsupportedOperationException</code>.
     *
     * @param o element whose presence in this collection is to be ensured.
     * @return <code>true</code> if the collection changed as a result of the call.
     * 
     * @throws UnsupportedOperationException if the <code>add</code> method is not
     *		  supported by this collection.
     * 
     * @throws NullPointerException if this collection does not permit
     * 		  <code>null</code> elements, and the specified element is
     * 		  <code>null</code>.
     * 
     * @throws ClassCastException if the class of the specified element
     * 		  prevents it from being added to this collection.
     * 
     * @throws IllegalArgumentException if some aspect of this element
     *            prevents it from being added to this collection.
     */
    public boolean add(T o) {
	throw new UnsupportedOperationException();
    }

    /**
     * Returns <code>true</code> if this collection contains no elements.<p>
     *
     * This implementation returns <code>size() == 0</code>.
     *
     * @return <code>true</code> if this collection contains no elements.
     */
    public boolean isEmpty() {
	return size() == 0;
    }

    public void deallocateMembers() {
        Iterator<T> i = iterator();
        while (i.hasNext()) { 
            storage.deallocate(i.next());
        }
        clear();
    }



    /**
     * Default constructor
     */
    public PersistentCollection() {}

    /**
     * Constructor of the collection associated with the specified storage
     * @param storage storage associated with the collection
     */
    public PersistentCollection(Storage storage) { 
        super(storage);
    }
}    
