/**
 * $Id$
 *
 * Copyright (c) 2009 Thomas Beckmann 
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
package com.thomas.functional.util;

import static com.thomas.functional.collection.util.iterator.Iterators.emptyIterator;
import static com.thomas.functional.collection.util.iterator.Iterators.singletonIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 10.10.2009
 */
public final class Optional<E> implements Iterable<E> {

    private E element;
    private boolean empty;
    
    public Optional() {
    
        this.element = null;
        this.empty = true;
    }
    
    public Optional(E element) {
        
        set(element);
    }
    
    public E get() {
    
        if (this.empty) throw new NoSuchElementException();
        
        return this.element;
    }
    
    public void set(E element) {
    
        this.element = element;
        this.empty = false;
    }
    
    public void clear() {
        
        clear(true);
    }
    
    public void clear(boolean clear) {
        
        this.empty |= clear;
    }
    
    public E remove() {
        
        final E ret = get();
        
        clear();
        
        return ret;
    }
    
    public boolean isEmpty() {
    
        return this.empty;
    }

    public boolean isDefined() {
        
        return !this.empty;
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.lang.Iterable#iterator()
     * @author Thomas
     * @since 10.10.2009
     */
    @Override
    public Iterator<E> iterator() {

        if (this.empty) return emptyIterator();

        return singletonIterator(this.element);
    }
    
}
