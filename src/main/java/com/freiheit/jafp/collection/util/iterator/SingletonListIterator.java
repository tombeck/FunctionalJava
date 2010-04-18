/**
 * $Id$
 *
 * Copyright (c) 2007 Thomas Beckmann 
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
package com.freiheit.jafp.collection.util.iterator;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 20.05.2007
 */
public class SingletonListIterator<E> implements ListIterator<E> {

    private final E element;
    private final int size;
    
    private int index;
    
    public SingletonListIterator(E element, int size) {

        this.element = element;
        this.size = size;
        this.index = 0;
    }

    public SingletonListIterator(E element) {

        this(element, 1);
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.ListIterator#hasNext()
     * @author Thomas
     * @since 20.05.2007
     */
    public boolean hasNext() {

        return this.index < this.size;
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.ListIterator#next()
     * @author Thomas
     * @since 20.05.2007
     */
    public E next() {

        if (this.index >= this.size) throw new NoSuchElementException();
        
        ++this.index;
        
        return this.element;
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.ListIterator#hasPrevious()
     * @author Thomas
     * @since 20.05.2007
     */
    public boolean hasPrevious() {

        return this.index > 0;
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.ListIterator#previous()
     * @author Thomas
     * @since 20.05.2007
     */
    public E previous() {

        if (this.index <= 0) throw new NoSuchElementException();
        
        --this.index;
        
        return this.element;
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.ListIterator#nextIndex()
     * @author Thomas
     * @since 20.05.2007
     */
    public int nextIndex() {

        return this.index;
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.ListIterator#previousIndex()
     * @author Thomas
     * @since 20.05.2007
     */
    public int previousIndex() {

        return this.index - 1;
    }

    /**
     * TODO Method documentation
     * 
     * @see java.util.ListIterator#remove()
     * @author Thomas
     * @since 20.05.2007
     */
    public void remove() {

        throw new UnsupportedOperationException();
    }

    /**
     * TODO Method documentation
     * 
     * @param o
     * @see java.util.ListIterator#set(E)
     * @author Thomas
     * @since 20.05.2007
     */
    public void set(E o) {

        throw new UnsupportedOperationException();
    }

    /**
     * TODO Method documentation
     * 
     * @param o
     * @see java.util.ListIterator#add(E)
     * @author Thomas
     * @since 20.05.2007
     */
    public void add(E o) {

        throw new UnsupportedOperationException();
    }

}
