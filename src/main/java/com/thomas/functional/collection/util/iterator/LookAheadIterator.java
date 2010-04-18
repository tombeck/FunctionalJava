/**
 * $Id$
 *
 * Copyright (c) 2006 Thomas Beckmann 
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

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.thomas.functional.util.Optional;

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 09.09.2006
 */
public class LookAheadIterator<E> implements Iterator<E> {

    private final Iterator<? extends E> base;
    private final Optional<E> lookAhead;
    
    /**
     * TODO Ctor documentation
     * 
     * @param base
     * @author Thomas
     * @since 19.10.2005
     */
    public LookAheadIterator(Iterator<? extends E> base) {

        if (base == null) throw new NullPointerException();

        this.base = base;
        this.lookAhead = new Optional<E>();
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.Iterator#hasNext()
     * @author Thomas
     * @since 19.10.2005
     */
    @Override
    public boolean hasNext() {

        return this.lookAhead.isDefined() || this.base.hasNext();
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.Iterator#next()
     * @author Thomas
     * @since 19.10.2005
     */
    @Override
    public E next() {

        if (this.lookAhead.isEmpty()) return this.base.next();
        
        return this.lookAhead.remove();
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @throws NoSuchElementException iteration has no more elements
     * @author Thomas
     * @since 19.10.2005
     */
    public E peekNext() {

        if (this.lookAhead.isEmpty()) {
            this.lookAhead.set(this.base.next());
        }
        
        return this.lookAhead.get();
    }

    /**
     * It's illegal to call remove() after calling peekNext() since this would
     * not remove the last element returned by next() but the next element.
     * 
     * @see java.util.Iterator#remove()
     * @author Thomas
     * @since 19.10.2005
     */
    @Override
    public void remove() {

        if (this.lookAhead.isEmpty()) this.base.remove();
        
        throw new IllegalStateException();
    }

}
