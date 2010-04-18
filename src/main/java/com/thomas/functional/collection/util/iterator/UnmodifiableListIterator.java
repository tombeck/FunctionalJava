/**
 * $Id$
 *
 * Copyright (c) 2008 Thomas Beckmann 
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.thomas.functional.collection.util.iterator;

import java.util.ListIterator;

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 15.05.2008
 */
public class UnmodifiableListIterator<E> implements ListIterator<E> {

    private final ListIterator<? extends E> base;

    public UnmodifiableListIterator(ListIterator<? extends E> base) {

        if (base == null) throw new NullPointerException();
        
        this.base = base;
    }

    /**
     * TODO Method documentation
     * 
     * @param e
     * @see java.util.ListIterator#add(java.lang.Object)
     * @author Thomas
     * @since 15.05.2008
     */
    public void add(E e) {

        throw new UnsupportedOperationException();
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.ListIterator#hasNext()
     * @author Thomas
     * @since 15.05.2008
     */
    public boolean hasNext() {

        return this.base.hasNext();
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.ListIterator#hasPrevious()
     * @author Thomas
     * @since 15.05.2008
     */
    public boolean hasPrevious() {

        return this.base.hasPrevious();
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.ListIterator#next()
     * @author Thomas
     * @since 15.05.2008
     */
    public E next() {

        return this.base.next();
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.ListIterator#nextIndex()
     * @author Thomas
     * @since 15.05.2008
     */
    public int nextIndex() {

        return this.base.nextIndex();
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.ListIterator#previous()
     * @author Thomas
     * @since 15.05.2008
     */
    public E previous() {

        return this.base.previous();
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.ListIterator#previousIndex()
     * @author Thomas
     * @since 15.05.2008
     */
    public int previousIndex() {

        return this.base.previousIndex();
    }

    /**
     * TODO Method documentation
     * 
     * @see java.util.ListIterator#remove()
     * @author Thomas
     * @since 15.05.2008
     */
    public void remove() {

        throw new UnsupportedOperationException();
    }

    /**
     * TODO Method documentation
     * 
     * @param e
     * @see java.util.ListIterator#set(java.lang.Object)
     * @author Thomas
     * @since 15.05.2008
     */
    public void set(E e) {

        throw new UnsupportedOperationException();
    }
    
    
}
