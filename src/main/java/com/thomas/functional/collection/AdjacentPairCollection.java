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
package com.thomas.functional.collection;

import static java.lang.Math.max;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

import com.thomas.functional.function.Function2;

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 16.10.2006
 */
final class AdjacentPairCollection<E, T> extends AbstractCollection<E> {

    final Collection<T> delegee;
    final Function2<? extends E, ? super T, ? super T> func;

    /**
     * TODO Ctor documentation
     * 
     * @param base
     * @author Thomas
     * @since 16.10.2006
     */
    public AdjacentPairCollection(
            Function2<? extends E, ? super T, ? super T> func,
            Collection<T> base) {

        if (base == null) throw new NullPointerException();
        if (func == null) throw new NullPointerException();

        this.delegee = base;
        this.func = func;
    }
    
    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.Collection#isEmpty()
     * @author Thomas
     * @since 21.05.2006
     */
    @Override
    public boolean isEmpty() {

        return this.delegee.size() <= 1;
    }

    class _Iterator implements Iterator<E> {
        
        private final Iterator<T> iter = AdjacentPairCollection.this.delegee.iterator();
        
        private T next = this.iter.hasNext() ? this.iter.next() : null;
        
        public boolean hasNext() {
            
            return this.iter.hasNext();
        }
        
        public E next() {
            
            final T prev = this.next;
            
            this.next = this.iter.next();
            
            return AdjacentPairCollection.this.func.call(prev, this.next);
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
     * @since 13.05.2006
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
     * @since 13.05.2006
     */
    @Override
    public int size() {

        return max(0, this.delegee.size() - 1);
    }

}
