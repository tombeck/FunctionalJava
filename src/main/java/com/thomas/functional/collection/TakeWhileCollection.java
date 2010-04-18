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

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static com.thomas.functional.collection.util.iterator.Iterators.*;

import com.thomas.functional.collection.util.iterator.LookAheadIterator;
import com.thomas.functional.function.Function1;

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 11.10.2009
 */
final class TakeWhileCollection<E> extends AbstractCollection<E> {

    final Collection<? extends E> delegee;
    final Function1<? extends Boolean, ? super E> pred;

    public TakeWhileCollection(
            Function1<? extends Boolean, ? super E> pred,
            Collection<? extends E> base) {

        if (pred == null) throw new NullPointerException();
        if (base == null) throw new NullPointerException();
        
        this.delegee = base;
        this.pred = pred;
    }

    class _Iterator implements Iterator<E> {

        private final LookAheadIterator<E> iter = lookAheadIterator(TakeWhileCollection.this.delegee.iterator());
        
        @Override
        public boolean hasNext() {

            return this.iter.hasNext() && TakeWhileCollection.this.pred.call(this.iter.peekNext());
        }

        @Override
        public E next() {

            if (TakeWhileCollection.this.pred.call(this.iter.peekNext())){
                
                return this.iter.next();
            }
            
            throw new NoSuchElementException();
        }

        @Override
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
     * @since 11.10.2009
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
     * @since 11.10.2009
     */
    @Override
    public int size() {

        int ret = 0;

        for (E element : this.delegee) {
            if (this.pred.call(element)) ++ret;
            else break;
        }

        return ret;
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.AbstractCollection#isEmpty()
     * @author Thomas
     * @since 11.10.2009
     */
    @Override
    public boolean isEmpty() {
    
        return !iterator().hasNext();
    }
}
