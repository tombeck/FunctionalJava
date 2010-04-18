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
package com.thomas.functional.collection;

import static java.lang.Math.min;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * TODO Type documentation
 *
 * @author Thomas
 * @since 19.07.2009
 */
final class TakeCollection<E> extends AbstractCollection<E> {

    final Collection<? extends E> base;
    final int maxSize;

    public TakeCollection(Collection<? extends E> base, int size) {

        if (base == null) throw new NullPointerException();
        if (size < 0) throw new IllegalArgumentException();
        
        this.base = base;
        this.maxSize = size;
    }

    class _Iterator implements Iterator<E> {

        private final Iterator<? extends E> iter = TakeCollection.this.base.iterator();
        
        private int count = TakeCollection.this.maxSize;
        
        public boolean hasNext() {

            return this.count > 0 && this.iter.hasNext();
        }

        public E next() {

            if (this.count == 0) throw new NoSuchElementException();

            final E ret = this.iter.next();
            
            --this.count;
            
            return ret;
        }

        public void remove() {

            throw new UnsupportedOperationException();
        }
        
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.AbstractCollection#iterator()
     * @author Thomas
     * @since 19.07.2009
     */
    @Override
    public Iterator<E> iterator() {

        return new _Iterator();
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.AbstractCollection#size()
     * @author Thomas
     * @since 19.07.2009
     */
    @Override
    public int size() {

        return min(this.maxSize, this.base.size());
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.Collection#isEmpty()
     * @author Thomas
     * @since 19.07.2009
     */
    @Override
    public boolean isEmpty() {

        return this.maxSize == 0 || this.base.isEmpty();
    }

}
