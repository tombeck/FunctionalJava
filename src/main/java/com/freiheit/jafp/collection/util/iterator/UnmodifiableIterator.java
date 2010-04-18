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
package com.freiheit.jafp.collection.util.iterator;

import java.util.Iterator;

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 15.05.2008
 */
public class UnmodifiableIterator<E> implements Iterator<E> {

    private final Iterator<? extends E> base;

    public UnmodifiableIterator(Iterator<? extends E> base) {

        if (base == null) throw new NullPointerException();
        
        this.base = base;
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.Iterator#hasNext()
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
     * @see java.util.Iterator#next()
     * @author Thomas
     * @since 15.05.2008
     */
    public E next() {

        return this.base.next();
    }

    /**
     * TODO Method documentation
     * 
     * @see java.util.Iterator#remove()
     * @author Thomas
     * @since 15.05.2008
     */
    public void remove() {

        throw new UnsupportedOperationException();
    }
    
}
